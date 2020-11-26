package com.app.notify.service.models.service;

import java.util.List;

import com.app.notify.service.models.entity.Notification;

public interface INotificationService {
	public List<Notification> findAll();
	public Notification findById(Long Id);
	public Notification save(Notification notification);
	public Long deleteOne(Long id);
}
