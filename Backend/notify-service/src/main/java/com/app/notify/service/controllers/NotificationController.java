package com.app.notify.service.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.notify.service.models.entity.NotificationRequest;
import com.app.notify.service.models.entity.Category;
import com.app.notify.service.models.entity.Notification;
import com.app.notify.service.models.service.ICategoryService;
import com.app.notify.service.models.service.INotificationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/notifications")
@Slf4j
public class NotificationController {
	
	@Autowired
	private INotificationService notificationService;
	
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	@Autowired
	private ICategoryService categoryService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Notification> all() {
		return notificationService.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/single/id")
	public Notification detail(@PathVariable Long id) {
		return notificationService.findById(id);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/add")
	public Notification detail(@RequestBody NotificationRequest notificationRequest) throws InterruptedException {
		
		Date date = Date.from(Instant.now());
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		
		Category category = categoryService.findById(notificationRequest.getCategory_id());
		Notification notification = new Notification();
		notification.setTitle(notificationRequest.getTitle());
		notification.setUser_id(notificationRequest.getUser_id());
		notification.setMessage(notificationRequest.getMessage());
		notification.setIcon_img(notificationRequest.getIcon_img());
		notification.setBig_img(notificationRequest.getBig_img());
		notification.setLink_to_lunch(notificationRequest.getLink_to_lunch());
		notification.setEnabled(true);
		notification.setReaded(false);
		notification.setCategory(category);
		notification.setCreadtedAt(timestamp);
		
		notification = notificationService.save(notification);

		Thread.sleep(1000);
		webSocket.convertAndSend("/pusher/webnotify", notification);
				
		return notification;
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) throws InterruptedException {

        Long isRemoved = notificationService.deleteOne(id);


        return new ResponseEntity<>(id, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/readed/{id}")
	public void setReaded(@PathVariable Long id) throws InterruptedException {
		Notification notification = notificationService.findById(id);
		notification.setReaded(true);
		notificationService.save(notification);
	}

}
