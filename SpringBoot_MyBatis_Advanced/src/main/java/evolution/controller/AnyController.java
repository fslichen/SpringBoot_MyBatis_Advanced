package evolution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {
	@GetMapping("/")
	public void anyMethod() {
		System.out.println("Hello World");
	}
}
