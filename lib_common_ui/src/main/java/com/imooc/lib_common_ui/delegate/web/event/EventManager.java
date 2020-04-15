package com.imooc.lib_common_ui.delegate.web.event;

import java.util.HashMap;

public class EventManager {

	//Latte Configurator中配置
	private static final HashMap<String,Event> EVENTS = new HashMap<>();
	//静态内部类实现单例模式
	private EventManager(){}
	private static class Holder{
		private static final EventManager INSTANCE = new EventManager();
	}
	public static EventManager getInstance(){
		return Holder.INSTANCE;
	}

	public EventManager addEvent(String param,Event event){
		EVENTS.put(param, event);
		return this;
	}

	/**
	 * 查询EVENTS中 已经配置的事件
	 * @param action
	 * @return event
	 */
	public Event queryEvent(String action){
		final Event event = EVENTS.get(action);
		if(event == null){
			//未定义的事件
			return new UndefinedEvent();
		}
		return event;
	}

}
