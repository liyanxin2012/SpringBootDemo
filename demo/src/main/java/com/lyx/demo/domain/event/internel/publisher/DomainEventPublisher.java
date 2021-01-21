package com.lyx.demo.domain.event.internel.publisher;

/**
 * 领域事件发布器
 *
 * @author Ryan
 */
public interface DomainEventPublisher {

	/**
	 * 发布事件
	 *
	 * @param domainEvent
	 */
	void publishEvent(Object domainEvent);
}
