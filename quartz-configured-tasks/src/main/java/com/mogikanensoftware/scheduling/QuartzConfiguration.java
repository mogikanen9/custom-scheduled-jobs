package com.mogikanensoftware.scheduling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfiguration {

	@Bean
	public MethodInvokingJobDetailFactoryBean getMyTimeMethodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("myTimeBean");
		obj.setTargetMethod("printMyTime");
		return obj;
	}
	
	@Bean
	public MethodInvokingJobDetailFactoryBean getSayHelloMethodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("sayHelloBean");
		obj.setTargetMethod("sayHello");
		return obj;
	}
	
		//Job  is scheduled for 10+1 times with the interval of 3 seconds
		@Bean
		public SimpleTriggerFactoryBean myTimeSimpleTriggerFactoryBean(){
			SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
			stFactory.setJobDetail(getMyTimeMethodInvokingJobDetailFactoryBean().getObject());
			stFactory.setStartDelay(3000);
			stFactory.setRepeatInterval(3000);
			stFactory.setRepeatCount(10);
			return stFactory;
		}
		
		@Bean
		public SimpleTriggerFactoryBean sayHelloSimpleTriggerFactoryBean(){
			SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
			stFactory.setJobDetail(getSayHelloMethodInvokingJobDetailFactoryBean().getObject());
			stFactory.setStartDelay(3000);
			stFactory.setRepeatInterval(3000);
			stFactory.setRepeatCount(10);
			return stFactory;
		}
		
		//scheduler
		@Bean
		public SchedulerFactoryBean schedulerFactoryBean() {
			SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
			scheduler.setTriggers(myTimeSimpleTriggerFactoryBean().getObject(),sayHelloSimpleTriggerFactoryBean().getObject());
			return scheduler;
		}
}
