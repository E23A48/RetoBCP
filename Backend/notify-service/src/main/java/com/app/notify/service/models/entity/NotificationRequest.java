package com.app.notify.service.models.entity;

public class NotificationRequest {
	
	private String title;
	private String message;
	private Long category_id;
	private Long user_id;
	private String icon_img;
    private String big_img;
    private String link_to_lunch;
    private Boolean readed;
	private Boolean enabled;

	
	public String getIcon_img() {
		return icon_img;
	}
	public void setIcon_img(String icon_img) {
		this.icon_img = icon_img;
	}
	public String getBig_img() {
		return big_img;
	}
	public void setBig_img(String big_img) {
		this.big_img = big_img;
	}
	public String getLink_to_lunch() {
		return link_to_lunch;
	}
	public void setLink_to_lunch(String link_to_lunch) {
		this.link_to_lunch = link_to_lunch;
	}
	public Boolean getReaded() {
		return readed;
	}
	public void setReaded(Boolean readed) {
		this.readed = readed;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

}
