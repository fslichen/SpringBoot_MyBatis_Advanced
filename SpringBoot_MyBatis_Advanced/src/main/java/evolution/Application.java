package evolution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evolution.dao.mapper.AnyMapper;
import evolution.entity.AnyEntity;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private AnyMapper anyMapper;
	
	@Override
	public void run(String... arg0) throws Exception {
		List<AnyEntity> anyEntities = anyMapper.selectByName("Chen");// The SQL statement is written within @Select. 
		System.out.println(anyEntities);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
