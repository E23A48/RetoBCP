package com.app.notify.service.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.notify.service.models.dao.NotificationDao;
import com.app.notify.service.models.entity.Notification;

@Service
public class NotificationServiceImpl implements INotificationService {
	
	@Autowired
	private NotificationDao notificationDao;

	@Override
	@Transactional(readOnly = true)
	public List<Notification> findAll() {
		return (List<Notification>) notificationDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Notification findById(Long Id) {
		return notificationDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Notification save(Notification notification) {
		Notification noti = notificationDao.save(notification);
		return noti;
	}

	@Override
	public Long deleteOne(Long id) {
		notificationDao.delete(notificationDao.findById(id).orElse(null));
		return (long) 1;
	}

}
