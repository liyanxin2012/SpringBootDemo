package com.lyx.demo.domain.event.publisher;

import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.infrastructure.event.enums.UserChangedTypes;
import org.springframework.web.bind.annotation.PatchMapping;

/**
 * 用户事件发布器
 *
 * @author Ryan
 */
public interface UserEventPublisher {

	/**
	 * 已删除用户（模式1，已废弃 - Restful暂不支持单属性更新）
	 *
	 * @param userEntity
	 */
	@Deprecated
	void deletedUser(UserEntity userEntity);

	/**
	 * 已禁用用户（模式1，已废弃 - Restful暂不支持单属性更新）
	 *
	 * @param userEntity
	 */
	@Deprecated
	void disabledUser(UserEntity userEntity);

	/**
	 * 已激活用户（模式1，已废弃 - Restful暂不支持单属性更新）
	 *
	 * @param userEntity
	 */
	@Deprecated
	void activatedUser(UserEntity userEntity);

	/**
	 * 用户已注册
	 *
	 * @param userEntity
	 */
	void registeredUser(UserEntity userEntity);

	/**
	 * 用户已变更（模式2，推荐 - Restful推荐统一更新状态）
	 *
	 * @param changedType
	 * @param userEntity
	 */
	void changedUser(UserChangedTypes changedType, UserEntity userEntity);
}
