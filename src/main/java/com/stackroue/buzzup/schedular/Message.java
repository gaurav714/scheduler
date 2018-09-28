package com.stackroue.buzzup.schedular;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;




public class Message implements Job {

	private String BOOT_TOPIC = "booking";


	
	public void execute(JobExecutionContext context)
		throws JobExecutionException {
		Properties props = new Properties();
		 props.put("bootstrap.servers", "127.0.0.1:9092");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		 Producer<String, String> producer = new KafkaProducer<>(props);
		 producer.send(new ProducerRecord<String, String>(BOOT_TOPIC,"booking closed"));
		
	
		
		System.out.println("booking closed");
	}
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

}