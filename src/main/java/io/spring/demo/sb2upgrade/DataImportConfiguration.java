package io.spring.demo.sb2upgrade;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

@Configuration
public class DataImportConfiguration {

	@Bean
	public CommandLineRunner initData(MongoOperations mongo) {
		return (String... args) -> {
			mongo.dropCollection(TeamMember.class);
			mongo.createCollection(TeamMember.class);
			getTeamMembers().forEach(mongo::save);
		};
	}

	private List<TeamMember> getTeamMembers() {
		return Arrays.asList(
				new TeamMember("Andy Wilkinson", "wilkinsona"),
				new TeamMember("Stephane Nicoll", "snicoll"),
				new TeamMember("Madhura Bhave", "mbhave"),
				new TeamMember("Phil Webb", "philwebb"),
				new TeamMember("Brian Clozel", "bclozel")
		);
	}
}
