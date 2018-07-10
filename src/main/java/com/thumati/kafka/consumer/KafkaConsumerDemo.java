package com.thumati.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerDemo {

	public static void main(String[] args) {
		Properties properties = new Properties();
		
		properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		properties.setProperty("key.deserializer", StringDeserializer.class.getName());
		properties.setProperty("value.deserializer", StringDeserializer.class.getName());
		
		properties.setProperty("group.id", "test2");
		properties.setProperty("enable.auto.commit", "true");
		properties.setProperty("auto.commit.interval.ms", "1000");
		properties.setProperty("auto.offset.reset", "earliest");
		
		Consumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		consumer.subscribe(Arrays.asList("vasanth_topic"));
		
		while(true) {
			ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
			for(ConsumerRecord<String, String> consumerRecord : consumerRecords) {
				System.out.printf("Topic:%S  Partition:%S  Offset:%S  Key:%S  Value:%S  TimeStamp:%S \n",consumerRecord.topic(), consumerRecord.partition(), consumerRecord.offset(), consumerRecord.key(), consumerRecord.value(), consumerRecord.timestamp());
			}
		}
	}

}
