package evolution.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import evolution.entity.AnyEntity;

@Mapper// Scanned by @MapperScan in DaoConfiguration.
public interface AnyMapper {
	@Select("SELECT * FROM any_table WHERE NAME = #{name}")
	public AnyEntity select(@Param("name") String name);
}
