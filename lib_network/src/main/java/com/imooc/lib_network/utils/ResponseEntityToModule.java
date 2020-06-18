package com.imooc.lib_network.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class ResponseEntityToModule {

	public static Object parseJsonToModule(String jsonContent, Class<?> clazz) {
		Object moduleObj = null;
		try {
			JSONObject jsonObj = new JSONObject(jsonContent);
			moduleObj = parseJsonObjectToModule(jsonObj, clazz);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return moduleObj;
	}

	public static Object parseJsonObjectToModule(JSONObject jsonObj, Class<?> clazz) {
		Object moduleObj = null;
		try {
			moduleObj = clazz.newInstance();
			setFieldValue(moduleObj, jsonObj, clazz);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moduleObj;
	}

	private static void setFieldValue(Object moduleObj, JSONObject jsonObj, Class<?> clazz)
			throws IllegalArgumentException, IllegalAccessException, JSONException,
			InstantiationException {
		if (clazz.getSuperclass() != null) {
			setFieldValue(moduleObj, jsonObj, clazz.getSuperclass());
		}
		Field[] fields = clazz.getDeclaredFields();
		Class<?> cls;
		String name;
		for (Field f : fields) {
			f.setAccessible(true);
			cls = f.getType();
			name = f.getName();
			if (!jsonObj.has(name) || jsonObj.isNull(name)) {
				continue;
			}
			if (cls.isPrimitive() || isWrappedPrimitive(
					cls)) {
				setPrimitiveFieldValue(f, moduleObj, jsonObj.get(name));
			} else {
				if (cls.isAssignableFrom(String.class)) {
					f.set(moduleObj, String.valueOf(jsonObj.get(name)));
				} else if (cls.isAssignableFrom(ArrayList.class)) {
					parseJsonArrayToList(f, name, moduleObj, jsonObj);
				} else {
					Object obj =
							parseJsonObjectToModule(jsonObj.getJSONObject(name), cls.newInstance().getClass());
					f.set(moduleObj, obj);
				}
			}
		}
	}

	private static ArrayList<Object> parseJsonArrayToList(Field field, String fieldName,
														  Object moduleObj, JSONObject jsonObj)
			throws JSONException, IllegalArgumentException, IllegalAccessException {
		ArrayList<Object> objList = new ArrayList<Object>();
		Type fc = field.getGenericType();
		if (fc instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) fc;
			if (pt.getActualTypeArguments()[0] instanceof Class) {
				Class<?> clss = (Class<?>) pt.getActualTypeArguments()[0];

				if (jsonObj.get(fieldName) instanceof JSONArray) {
					JSONArray array = jsonObj.getJSONArray(fieldName);
					for (int i = 0; i < array.length(); i++) {
						if (array.get(i) instanceof JSONObject) {
							objList.add(parseJsonObjectToModule(array.getJSONObject(i), clss));
						} else {
							if (clss.isAssignableFrom(array.get(i).getClass())) {
								objList.add(array.get(i));
							}
						}
					}
				}
				field.set(moduleObj, objList);
			}
		}
		return objList;
	}

	private static void setPrimitiveFieldValue(Field field, Object moduleObj, Object jsonObj)
			throws IllegalArgumentException, IllegalAccessException {
		if (field.getType().isAssignableFrom(jsonObj.getClass())) {
			field.set(moduleObj, jsonObj);
		} else {
			field.set(moduleObj, makeTypeSafeValue(field.getType(), jsonObj.toString()));
		}
	}

	private static final Object makeTypeSafeValue(Class<?> type, String value)
			throws NumberFormatException, IllegalArgumentException {
		if (int.class == type || Integer.class == type) {
			return Integer.parseInt(value);
		} else if (long.class == type || Long.class == type) {
			return Long.parseLong(value);
		} else if (short.class == type || Short.class == type) {
			return Short.parseShort(value);
		} else if (char.class == type || Character.class == type) {
			return value.charAt(0);
		} else if (byte.class == type || Byte.class == type) {
			return Byte.valueOf(value);
		} else if (float.class == type || Float.class == type) {
			return Float.parseFloat(value);
		} else if (double.class == type || Double.class == type) {
			return Double.parseDouble(value);
		} else if (boolean.class == type || Boolean.class == type) {
			return Boolean.valueOf(value);
		} else {
			return value;
		}
	}

	private static boolean isWrappedPrimitive(Class<?> type) {
		return type.getName().equals(Boolean.class.getName())
				|| type.getName()
				.equals(Byte.class.getName())
				|| type.getName().equals(Character.class.getName())
				|| type.getName().equals(Short.class.getName())
				|| type.getName().equals(Integer.class.getName())
				|| type.getName().equals(Long.class.getName())
				|| type.getName().equals(Float.class.getName())
				|| type.getName().equals(Double.class.getName());
	}
}