package tk.mybatis.springboot.service;

import java.util.List;

import tk.mybatis.simple.model.SysUser;

public interface UserService {
	SysUser findById(Long id);
	
	List<SysUser> findAll();
}
