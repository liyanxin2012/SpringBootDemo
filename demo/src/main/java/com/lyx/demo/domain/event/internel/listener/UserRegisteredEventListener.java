package com.lyx.demo.domain.event.internel.listener;

import com.alibaba.fastjson.JSON;
import com.lyx.demo.domain.event.internel.model.UserRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * 用户已注册监听器
 *
 * @author Ryan
 */
@Component
@EnableAsync
public class UserRegisteredEventListener {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 监听用户已注册事件
	 *
	 * @param event
	 */
	@EventListener
	public void onListen(UserRegisteredEvent event) {
		// TODO 监听用户已创建事件，执行下一步操作

		logger.info("Listen registered user event,event={}", JSON.toJSONString(event));
	}

}
