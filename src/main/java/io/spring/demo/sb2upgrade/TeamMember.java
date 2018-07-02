package io.spring.demo.sb2upgrade;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@JacksonXmlRootElement(localName = "member")
public class TeamMember {

	@Id
	private String id;

	private String name;

	@Indexed(unique = true)
	private String github;

	public TeamMember() {
	}

	public TeamMember(String name, String github) {
		this.name = name;
		this.github = github;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}
}
