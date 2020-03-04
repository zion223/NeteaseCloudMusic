package com.imooc.imooc_voice.model;

public enum SquareCHANNEL {

	HUAYU("华语", 0x01),
	JIQING("经典老歌", 0x02),
	ANJING("安静", 0x03),
	GUFENG("古风", 0x04),
	QINGCHUN("青春", 0x05),
	QINGYINYUE("轻音乐", 0x06),
	YAOGUN("摇滚", 0x07),
	MINYAO("民谣", 0x08),
	DIANZI("电子", 0x09);

	//所有类型标识
	public static final int HUAYU_ID = 0x01;
	public static final int TUIJIAN_ID = 0x02;
	public static final int LIUXING_ID = 0x03;
	public static final int JINGDIAN_ID = 0x04;
	public static final int GUANFANG_ID = 0x05;
	public static final int JINGPIN_ID = 0x06;
	public static final int YAOGUN_ID = 0x07;
	public static final int MINYAO_ID = 0x08;
	public static final int DIANZI_ID = 0x09;


	private final String key;
	private final int value;

	SquareCHANNEL(String key, int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}
}
