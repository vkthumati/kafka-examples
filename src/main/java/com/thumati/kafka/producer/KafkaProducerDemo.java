package com.thumati.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerDemo {
	public static void main(String[] args) {
		Properties properties = new Properties();
		
		//kafka bootstrap servers
		properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		
		//producer acks
		properties.setProperty("acks", "1");
		properties.setProperty("retries", "3");
		
		//flush data to kafka every ms
		properties.setProperty("linger.ms", "1");
		
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		/*ProducerRecord<String, String> producerRecord1 = new ProducerRecord<String, String>("vasanth_topic", 2, "1", "one");
		ProducerRecord<String, String> producerRecord2 = new ProducerRecord<String, String>("vasanth_topic", 2, "2", "two");
		ProducerRecord<String, String> producerRecord3 = new ProducerRecord<String, String>("vasanth_topic", 2, "3", "three");
		
		ProducerRecord<String, String> producerRecord4 = new ProducerRecord<String, String>("vasanth_topic", "4", "four");
		ProducerRecord<String, String> producerRecord5 = new ProducerRecord<String, String>("vasanth_topic", "5", "five");
		ProducerRecord<String, String> producerRecord6 = new ProducerRecord<String, String>("vasanth_topic", "6", "six");
		
		producer.send(producerRecord1);
		producer.send(producerRecord2);
		producer.send(producerRecord3);
		producer.send(producerRecord4);
		producer.send(producerRecord5);
		producer.send(producerRecord6);*/
		
		
		for(int i=21; i<30; ++i) {
			String key = Integer.toString(i);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("vasanth_topic", key, "message-"+key);
			producer.send(producerRecord);
		}
		
		//producer.flush();
		
		producer.close();
	}

}
