package com.sami.springboot;

import com.sami.config.CustomProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@Slf4j
@Data
@EnableConfigurationProperties(CustomProperties.class)
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
	private CustomProperties props;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
