package com.imooc.lib_common_ui.recycler;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

public class MultipleItemEntity implements MultiItemEntity, Serializable {


    private final ReferenceQueue<LinkedHashMap<Object, Object>> ITEM_QUENE = new ReferenceQueue<>();
    private final LinkedHashMap<Object, Object> MUTIPLE_FIELDS = new LinkedHashMap<>();
    private final SoftReference<LinkedHashMap<Object, Object>> FIELDS_REFERENCE =
            new SoftReference<LinkedHashMap<Object, Object>>(MUTIPLE_FIELDS,ITEM_QUENE);

    protected MultipleItemEntity(LinkedHashMap<Object, Object> fields) {
        FIELDS_REFERENCE.get().putAll(fields);
    }
    public static MultipleEntityBuilder builder(){
        return new MultipleEntityBuilder();
    }


    @Override
    public int getItemType() {
        return (int) FIELDS_REFERENCE.get().get(MultipleFields.ITEM_TYPE);
    }

    public final <T> T getField(Object key){
        return (T) FIELDS_REFERENCE.get().get(key);
    }

    public final LinkedHashMap<?,?> getFields(){
        return FIELDS_REFERENCE.get();
    }

    public final MultiItemEntity setField(Object key, Object value){
        FIELDS_REFERENCE.get().put(key, value);
        return this;
    }

}
