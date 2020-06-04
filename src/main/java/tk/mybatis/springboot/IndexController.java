package tk.mybatis.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}
}
