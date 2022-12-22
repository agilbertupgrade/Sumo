package org.stapledon.sumo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SumoParseApplication implements CommandLineRunner {

	private final ParseSumoBackup parseSumoBackup;


	public static void main(String[] args) {
		SpringApplication.run(SumoParseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		parseSumoBackup.parse();

	}
}
