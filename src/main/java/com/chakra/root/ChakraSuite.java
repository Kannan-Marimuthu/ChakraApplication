package com.chakra.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.chakra.root.common.configuration.ChakraJpaConfig;

@Import(ChakraJpaConfig.class)
@SpringBootApplication(scanBasePackages = { "com.chakra.root" })
public class ChakraSuite {

	public static void main(String[] args) {
		SpringApplication.run(ChakraSuite.class, args);
	}
}
