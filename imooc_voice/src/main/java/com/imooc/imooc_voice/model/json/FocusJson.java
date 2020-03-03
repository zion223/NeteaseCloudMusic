package com.imooc.imooc_voice.model.json;

import java.util.ArrayList;

public class FocusJson {


	ArrayList<Focus> pic = new ArrayList<>();

	public ArrayList<Focus> getPic() {
		return pic;
	}

	public static class Focus{
		private int type;
		private int moType;
		private String code;
		private String randpic;
		private String randpicIos5;
		private String randpicDesc;
		private String randpicIpad;
		private String randpicQq;
		private String randpic2;
		private String randpicIphone6;
		private int specialType;
		private String ipadDesc;
		private String isPublish;
		public void setType(int type) {
			this.type = type;
		}
		public int getType() {
			return type;
		}

		public void setMoType(int moType) {
			this.moType = moType;
		}
		public int getMoType() {
			return moType;
		}

		public void setCode(String code) {
			this.code = code;
		}
		public String getCode() {
			return code;
		}

		public void setRandpic(String randpic) {
			this.randpic = randpic;
		}
		public String getRandpic() {
			return randpic;
		}

		public void setRandpicIos5(String randpicIos5) {
			this.randpicIos5 = randpicIos5;
		}
		public String getRandpicIos5() {
			return randpicIos5;
		}

		public void setRandpicDesc(String randpicDesc) {
			this.randpicDesc = randpicDesc;
		}
		public String getRandpicDesc() {
			return randpicDesc;
		}

		public void setRandpicIpad(String randpicIpad) {
			this.randpicIpad = randpicIpad;
		}
		public String getRandpicIpad() {
			return randpicIpad;
		}

		public void setRandpicQq(String randpicQq) {
			this.randpicQq = randpicQq;
		}
		public String getRandpicQq() {
			return randpicQq;
		}

		public void setRandpic2(String randpic2) {
			this.randpic2 = randpic2;
		}
		public String getRandpic2() {
			return randpic2;
		}

		public void setRandpicIphone6(String randpicIphone6) {
			this.randpicIphone6 = randpicIphone6;
		}
		public String getRandpicIphone6() {
			return randpicIphone6;
		}

		public void setSpecialType(int specialType) {
			this.specialType = specialType;
		}
		public int getSpecialType() {
			return specialType;
		}

		public void setIpadDesc(String ipadDesc) {
			this.ipadDesc = ipadDesc;
		}
		public String getIpadDesc() {
			return ipadDesc;
		}

		public void setIsPublish(String isPublish) {
			this.isPublish = isPublish;
		}
		public String getIsPublish() {
			return isPublish;
		}


	}
}
