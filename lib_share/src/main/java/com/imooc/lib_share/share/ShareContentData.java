package com.imooc.lib_share.share;

public class ShareContentData {
	/**
	 * share relative
	 */
	private int mShareType; //指定分享类型
	private String mShareTitle; //指定分享内容标题
	private String mShareText; //指定分享内容文本
	private String mSharePhoto; //指定分享本地图片
	private String mShareTileUrl;
	private String mShareSiteUrl;
	private String mShareSite;
	private String mUrl;
	private String mResourceUrl;

	private ShareContentData(int mShareType, String mShareTitle, String mShareText, String mSharePhoto, String mShareTileUrl, String mShareSiteUrl, String mShareSite, String mUrl, String mResourceUrl) {
		this.mShareType = mShareType;
		this.mShareTitle = mShareTitle;
		this.mShareText = mShareText;
		this.mSharePhoto = mSharePhoto;
		this.mShareTileUrl = mShareTileUrl;
		this.mShareSiteUrl = mShareSiteUrl;
		this.mShareSite = mShareSite;
		this.mUrl = mUrl;
		this.mResourceUrl = mResourceUrl;
	}

	private ShareContentData() {
	}

	public int getShareType() {
		return mShareType;
	}

	public String getShareTitle() {
		return mShareTitle;
	}

	public String getShareText() {
		return mShareText;
	}

	public String getSharePhoto() {
		return mSharePhoto;
	}

	public String getShareTileUrl() {
		return mShareTileUrl;
	}

	public String getShareSiteUrl() {
		return mShareSiteUrl;
	}

	public String getShareSite() {
		return mShareSite;
	}

	public String getUrl() {
		return mUrl;
	}

	public String getResourceUrl() {
		return mResourceUrl;
	}

	public static ShareContentData Builder(){
		return new ShareContentData();
	}

	public ShareContentData shareType(int type){
		this.mShareType = type;
		return this;
	}

	public ShareContentData shareTitle(String title) {
		this.mShareTitle = title;
		return this;
	}

	public ShareContentData shareText(String address) {
		this.mShareText = address;
		return this;
	}

	public ShareContentData sharePhoto(String address) {
		this.mSharePhoto = address;
		return this;
	}

	public ShareContentData shareTileUrl(String address) {
		this.mShareTileUrl = address;
		return this;
	}

	public ShareContentData shareSiteUrl(String address) {
		this.mShareSiteUrl = address;
		return this;
	}

	public ShareContentData shareSite(String address) {
		this.mShareSite = address;
		return this;
	}

	public ShareContentData url(String address) {
		this.mUrl = address;
		return this;
	}

	public ShareContentData resourceUrl(String address) {
		this.mResourceUrl = address;
		return this;
	}

	public ShareContentData build(){
		return new ShareContentData(mShareType, mShareTitle, mShareText, mSharePhoto, mShareTileUrl, mShareSiteUrl, mShareSite, mUrl, mResourceUrl);
	}
}
