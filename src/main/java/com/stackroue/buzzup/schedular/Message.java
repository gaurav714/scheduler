package com.stackroue.buzzup.schedular;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;



public class Message implements Job {

	private String BOOT_TOPIC = "booking";
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	public Message(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void execute(JobExecutionContext context)
		throws JobExecutionException {
	
		try {
		kafkaTemplate.send(BOOT_TOPIC, "booking closed");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("booking closed");
	}
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

}