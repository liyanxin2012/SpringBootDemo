package com.lyx.demo.infrastructure.event;

import com.alibaba.fastjson.JSON;
import com.lyx.demo.domain.event.publisher.UserEventPublisher;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.infrastructure.event.enums.UserChangedTypes;
import com.lyx.demo.infrastructure.event.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 基于Kafka用户事件发布器
 *
 * @author Ryan
 */
@Service
public class KafkaUserEventPublisher implements UserEventPublisher {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletedUser(UserEntity userEntity) {
		UserDeletedEvent event = new UserDeletedEvent();
		event.setUserId(userEntity.getUserId());
		event.setStatus(userEntity.getStatus());
		event.setUserName(userEntity.getUserName());
		event.setCityCode(userEntity.getCityCode());
		event.setCreateTime(userEntity.getCreateTime());
		event.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO 模拟Kafka发布事件
		logger.info("Publisher deleted user event success,event={}", JSON.toJSONString(event));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disabledUser(UserEntity userEntity) {
		UserDisabledEvent event = new UserDisabledEvent();
		event.setUserId(userEntity.getUserId());
		event.setStatus(userEntity.getStatus());
		event.setUserName(userEntity.getUserName());
		event.setCityCode(userEntity.getCityCode());
		event.setCreateTime(userEntity.getCreateTime());
		event.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO 模拟Kafka发布事件
		logger.info("Publisher disable user event success,event={}", JSON.toJSONString(event));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activatedUser(UserEntity userEntity) {
		UserActivatedEvent event = new UserActivatedEvent();
		event.setUserId(userEntity.getUserId());
		event.setStatus(userEntity.getStatus());
		event.setUserName(userEntity.getUserName());
		event.setCityCode(userEntity.getCityCode());
		event.setCreateTime(userEntity.getCreateTime());
		event.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO 模拟Kafka发布事件
		logger.info("Publisher activate user event success,event={}", JSON.toJSONString(event));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registeredUser(UserEntity userEntity) {
		UserRegisteredEvent event = new UserRegisteredEvent();
		event.setUserId(userEntity.getUserId());
		event.setStatus(userEntity.getStatus());
		event.setUserName(userEntity.getUserName());
		event.setCityCode(userEntity.getCityCode());
		event.setCreateTime(userEntity.getCreateTime());
		event.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO 模拟Kafka发布事件
		logger.info("Publisher registered user event success,event={}", JSON.toJSONString(event));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changedUser(UserChangedTypes changedType, UserEntity userEntity) {
		UserChangedEvent userChangedEvent = new UserChangedEvent();
		userChangedEvent.setChangedType(changedType.getCode());
		userChangedEvent.setUserId(userEntity.getUserId());
		userChangedEvent.setStatus(userEntity.getStatus());
		userChangedEvent.setUserName(userEntity.getUserName());
		userChangedEvent.setCityCode(userEntity.getCityCode());
		userChangedEvent.setCreateTime(userEntity.getCreateTime());
		userChangedEvent.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO 模拟Kafka发布事件
		logger.info("Publisher changed user event success,event={}", JSON.toJSONString(userChangedEvent));
	}
}
