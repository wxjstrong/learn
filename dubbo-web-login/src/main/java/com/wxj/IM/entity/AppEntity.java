package com.wxj.IM.entity;

public class AppEntity {
	private String paasId;//paas应用帐号(英文字母、下划线组成)调用之间检查是否有重复如果重复调用接口会调用
	private String paasName;// paas应用名
	private String description;// paas应用详细描述
	private String appRootPath;// 应用站点地址
	private String appIconUrl;// 应用图标
	private String appSecret;// 应用密钥(调用api接口使用,不传或为空，系统会返回默认)
	private int appType;//应用类型(16企业应用,4回话应用)
	private int appOpenMode;//应用打开方式(0:内置浏览器打开且不带认证信息,1:内置浏览器打开且带认证信息,2:外部浏览器打开且不
	//带认证信息,3:外部浏览器打开且带认证信息),默认是1;2 和3 仅对企业应用有效且layout_pc=4
	private String msgCallbackUrl;// paas被动消息回复(应用绑定腾讯企业通帐号,用户提交信息后会调用该地址,应用在这里作逻辑响应用户)
	private String smsGateUrl;// 企业短信网关地址(paas短信发送接口,需将短信转发至该地址)
	private String mailGateUrl;// 企业邮件网关地址(paas邮件发送接口,需将邮件转发至该地址)
	private String[] mailSender;// 邮件发送人登记(限定paas邮件发送人,指定的发送人只能是配置中的一个
	
	private int layout_pc;// 应用pc端展示位置(4右下角显示,2窗口上方工具栏,默认0,不显示)
	private int layout_mac;// 应用mac端展示位置(4右下角显示,2窗口上方工具栏,默认0,不显示)
	private int layout_mobile;// 应用移动端展示(默认4, 0不显示)
	private boolean openToAll;

	public boolean isOpenToAll() {
		return openToAll;
	}
	public void setOpenToAll(boolean openToAll) {
		this.openToAll = openToAll;
	}
	public String getPaasId() {
		return paasId;
	}
	public void setPaasId(String paasId) {
		this.paasId = paasId;
	}
	public String getPaasName() {
		return paasName;
	}
	public void setPaasName(String paasName) {
		this.paasName = paasName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAppRootPath() {
		return appRootPath;
	}
	public void setAppRootPath(String appRootPath) {
		this.appRootPath = appRootPath;
	}
	public String getAppIconUrl() {
		return appIconUrl;
	}
	public void setAppIconUrl(String appIconUrl) {
		this.appIconUrl = appIconUrl;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public int getAppType() {
		return appType;
	}
	public void setAppType(int appType) {
		this.appType = appType;
	}
	public int getAppOpenMode() {
		return appOpenMode;
	}
	public void setAppOpenMode(int appOpenMode) {
		this.appOpenMode = appOpenMode;
	}
	public String getMsgCallbackUrl() {
		return msgCallbackUrl;
	}
	public void setMsgCallbackUrl(String msgCallbackUrl) {
		this.msgCallbackUrl = msgCallbackUrl;
	}
	public String getSmsGateUrl() {
		return smsGateUrl;
	}
	public void setSmsGateUrl(String smsGateUrl) {
		this.smsGateUrl = smsGateUrl;
	}
	public String getMailGateUrl() {
		return mailGateUrl;
	}
	public void setMailGateUrl(String mailGateUrl) {
		this.mailGateUrl = mailGateUrl;
	}
	public String[] getMailSender() {
		return mailSender;
	}
	public void setMailSender(String[] mailSender) {
		this.mailSender = mailSender;
	}
	public int getLayout_pc() {
		return layout_pc;
	}
	public void setLayout_pc(int layout_pc) {
		this.layout_pc = layout_pc;
	}
	public int getLayout_mac() {
		return layout_mac;
	}
	public void setLayout_mac(int layout_mac) {
		this.layout_mac = layout_mac;
	}
	public int getLayout_mobile() {
		return layout_mobile;
	}
	public void setLayout_mobile(int layout_mobile) {
		this.layout_mobile = layout_mobile;
	}


}

