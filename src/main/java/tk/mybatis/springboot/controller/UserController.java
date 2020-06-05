package tk.mybatis.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.mybatis.simple.model.SysUser;
import tk.mybatis.springboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users/{id}")
	public SysUser user(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@RequestMapping("/users")
	public List<SysUser> users() {
		return userService.findAll();
	}
}
