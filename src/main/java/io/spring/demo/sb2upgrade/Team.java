package io.spring.demo.sb2upgrade;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "team")
public class Team {

	private String name;

	@JacksonXmlProperty(localName = "member")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<TeamMember> members;

	public Team() {
	}

	public Team(String name, List<TeamMember> members) {
		this.name = name;
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TeamMember> getMembers() {
		return members;
	}

	public void setMembers(List<TeamMember> members) {
		this.members = members;
	}
}
