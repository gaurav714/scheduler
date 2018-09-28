package com.stackroue.buzzup.schedular;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.CronScheduleBuilder.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchedularApplication {

	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(SchedularApplication.class, args);

		JobKey jobKeyA = new JobKey("jobA", "group1");
		JobDetail jobA = JobBuilder.newJob(Message.class).withIdentity(jobKeyA).build();

		JobKey jobKeyB = new JobKey("jobB", "group2");
		JobDetail jobB = JobBuilder.newJob(Message.class).withIdentity(jobKeyB).build();

		JobKey jobKeyC = new JobKey("jobC", "group3");
		JobDetail jobC = JobBuilder.newJob(Message.class).withIdentity(jobKeyC).build();

		JobKey jobKeyD = new JobKey("jobB", "group4");
		JobDetail jobD = JobBuilder.newJob(Message.class).withIdentity(jobKeyD).build();

		JobKey jobKeyE = new JobKey("jobC", "group5");
		JobDetail jobE = JobBuilder.newJob(Message.class).withIdentity(jobKeyE).build();

		JobKey jobKeyF = new JobKey("jobD", "group6");
		JobDetail jobF = JobBuilder.newJob(Message.class).withIdentity(jobKeyF).build();
		
		JobKey jobKeyG = new JobKey("jobG", "group7");
		JobDetail jobG = JobBuilder.newJob(Message.class).withIdentity(jobKeyG).build();
		
		
		
		

		Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName1", "group1")
				.withSchedule(dailyAtHourAndMinute(14, 53)).build();

		Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName1", "group2")
				.withSchedule(dailyAtHourAndMinute(14, 54)).build();

		Trigger trigger3 = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName1", "group3")
				.withSchedule(dailyAtHourAndMinute(14, 55)).build();

		Trigger trigger4 = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName1", "group4")
				.withSchedule(dailyAtHourAndMinute(14, 56)).build();

		Trigger trigger5 = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName1", "group5")
				.withSchedule(dailyAtHourAndMinute(14, 57)).build();

		Trigger trigger6 = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName1", "group6")
				.withSchedule(dailyAtHourAndMinute(14, 58)).build();
		
		Trigger trigger7 = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName1", "group7")
				.withSchedule(cronSchedule("0/5 * * * * ?")).build();

		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();

		scheduler.start();

		scheduler.scheduleJob(jobA, trigger1);
		scheduler.scheduleJob(jobB, trigger2);
		scheduler.scheduleJob(jobC, trigger3);
		scheduler.scheduleJob(jobD, trigger4);
		scheduler.scheduleJob(jobE, trigger5);
		scheduler.scheduleJob(jobF, trigger6);

		scheduler.scheduleJob(jobG, trigger7);
	


	}

}
