package com.app.notify.service.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.notify.service.models.entity.Notification;

public interface NotificationDao extends CrudRepository<Notification, Long> {

}
