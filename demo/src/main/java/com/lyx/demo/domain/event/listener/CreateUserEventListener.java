package com.lyx.demo.domain.event.listener;

import com.lyx.demo.domain.event.model.CreateUserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author Ryan
 */
@Component
@EnableAsync
public class CreateUserEventListener {

	@EventListener
	public void createUserEvent(CreateUserEvent event){
		// TODO
	}

}
