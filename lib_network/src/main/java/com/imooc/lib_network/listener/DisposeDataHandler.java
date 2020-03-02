package com.imooc.lib_network.listener;

public class DisposeDataHandler {
	public DisposeDataListener mListener = null;
	public Class<?> mClass = null;
	public String mSource = null;

	public DisposeDataHandler(DisposeDataListener listener) {
		this.mListener = listener;
	}

	public DisposeDataHandler(DisposeDataListener listener, Class<?> clazz) {
		this.mListener = listener;
		this.mClass = clazz;
	}

	public DisposeDataHandler(DisposeDataListener listener, String source) {
		this.mListener = listener;
		this.mSource = source;
	}
}
