package com.lyx.demo.infrastructure.event;

import com.lyx.demo.domain.event.publisher.UserEventPublisher;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.infrastructure.event.model.ActivatedUserEvent;
import com.lyx.demo.infrastructure.event.model.DisabledUserEvent;
import com.lyx.demo.infrastructure.event.model.RegisteredUserEvent;
import org.springframework.stereotype.Service;

/**
 * @author Ryan
 */
@Service
public class KafkaUserEventPublisher implements UserEventPublisher {

	@Override
	public void activeUser(UserEntity userEntity) {
		ActivatedUserEvent event = new ActivatedUserEvent();
		event.setUserId(userEntity.getUserId());
		event.setStatus(userEntity.getStatus());
		event.setUserName(userEntity.getUserName());
		event.setCityCode(userEntity.getCityCode());
		event.setCreateTime(userEntity.getCreateTime());
		event.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO
	}

	@Override
	public void disableUser(UserEntity userEntity) {
		DisabledUserEvent event = new DisabledUserEvent();
		event.setUserId(userEntity.getUserId());
		event.setStatus(userEntity.getStatus());
		event.setUserName(userEntity.getUserName());
		event.setCityCode(userEntity.getCityCode());
		event.setCreateTime(userEntity.getCreateTime());
		event.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO
	}

	@Override
	public void registeredUser(UserEntity userEntity) {
		RegisteredUserEvent event = new RegisteredUserEvent();
		event.setUserId(userEntity.getUserId());
		event.setStatus(userEntity.getStatus());
		event.setUserName(userEntity.getUserName());
		event.setCityCode(userEntity.getCityCode());
		event.setCreateTime(userEntity.getCreateTime());
		event.setUpdateTime(userEntity.getUpdateTime());

		// 发布事件
		// TODO
	}


}
