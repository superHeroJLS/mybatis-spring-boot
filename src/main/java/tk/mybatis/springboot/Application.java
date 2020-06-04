package tk.mybatis.springboot;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.simple.mapper.CountryMapper;
import tk.mybatis.simple.model.Country;

// spring启动时排除加载的bean
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
// 使用@MapperScan扫描Mapper接口，这种方式不仅可以扫描当前项目的Mapper接口，还可以扫描jar包中的Mapper接口
@MapperScan(value = {"tk.mybatis.springboot.mapper", "tk.mybatis.simple.mapper"})
public class Application implements CommandLineRunner{
	
	@Autowired
	private CountryMapper countryMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//spring boot项目启动运行此方法
		List<Country> countrys = countryMapper.selectAll();
		countrys.forEach(country -> System.out.println(country));
		
	}
	
	
}
