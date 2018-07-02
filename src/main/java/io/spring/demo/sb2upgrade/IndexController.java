package io.spring.demo.sb2upgrade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
}
