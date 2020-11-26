package com.app.notify.service.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="categories")
public class Category implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Getter @Setter private String Name;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter private Date creadtedAt;
	
	@OneToMany(mappedBy="category")
	private List<Notification> notifications;
	


}
