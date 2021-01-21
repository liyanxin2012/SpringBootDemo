package com.lyx.demo.domain.event.internel.publisher.impl;

import com.lyx.demo.domain.event.internel.publisher.DomainEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 基于Spring领域事件发布者
 *
 * @author Ryan
 */
@Service
public class SpringDomainEventPublisher implements DomainEventPublisher {

	/**
	 * Spring容器上下文
	 */
	@Resource
	private ApplicationContext applicationContext;

	@Override
	public void publishEvent(Object domainEvent) {
		applicationContext.publishEvent(domainEvent);
	}
}
