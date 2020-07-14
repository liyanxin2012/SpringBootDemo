package com.lyx.demo.domain.event.publisher;

/**
 * 领域事件发布器
 *
 * @author Ryan
 */
public interface DomainEventPublisher {

	void publishEvent(Object domainEvent);
}
