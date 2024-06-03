package com.guru.kafkasample;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkasampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkasampleApplication.class, args);
	}

	@KafkaListener(id = "myId", topics = "my-topic")
	public void listen(String in) {
		System.out.println(in);
	}

	@Bean
	public ApplicationRunner runner(KafkaTemplate<String, String> template) {
		return args -> {
			template.send("my-topic", "test");
		};
	}
}
