package io.spring.demo.sb2upgrade;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTeamApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void showTeamShouldReturnAllMembers() {
		Team team = webTestClient.get().uri("/team")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Team.class)
				.returnResult().getResponseBody();

		assertThat(team.getName()).isEqualTo("Spring Boot team");
		assertThat(team.getMembers()).hasSize(5);
	}

}
