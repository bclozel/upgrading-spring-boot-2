package io.spring.demo.sb2upgrade;


import java.util.List;

import org.springframework.data.repository.Repository;

public interface TeamMemberRepository extends Repository<TeamMember, String> {

	List<TeamMember> findAll();

	TeamMember findByGithub(String github);

}
