package evolution.dao.template;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnyTemplate<T> {
	@Autowired
	private SqlSessionTemplate template;
	
	public T selectOne(String sql, Class<T> clazz) {
		return this.template.selectOne(sql, clazz);
	}
	
	public List<T> selectList(String sql, Class<T> clazz) {
		return this.template.selectList(sql, clazz);
	}
}
