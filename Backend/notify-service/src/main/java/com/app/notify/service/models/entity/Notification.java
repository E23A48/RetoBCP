package com.app.notify.service.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    
	@ManyToOne
	@JoinColumn(name="category_id", nullable=true)
    private Category category;
    
    private String title;
    private String message;
    private Long user_id;
    private String icon_img;
    private String big_img;
    private String link_to_lunch;
    private Boolean readed;
	private Boolean enabled;
    
    @Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creadtedAt;
   
    
    @Column(name="deleted_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
    
    public Long getId() {
		return id;
    }
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreadtedAt() {
		return creadtedAt;
	}
	public void setCreadtedAt(Date creadtedAt) {
		this.creadtedAt = creadtedAt;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
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

}
