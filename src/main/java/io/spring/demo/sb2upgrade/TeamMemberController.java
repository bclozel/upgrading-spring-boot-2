package io.spring.demo.sb2upgrade;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamMemberController {

	private final TeamMemberRepository repository;

	public TeamMemberController(TeamMemberRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/team")
	public Team showTeam() {
		return new Team("Spring Boot team", this.repository.findAll());
	}

	@GetMapping("/team/{github}")
	public TeamMember showTeamMember(@PathVariable String github) {
		return this.repository.findByGithub(github);
	}
}
