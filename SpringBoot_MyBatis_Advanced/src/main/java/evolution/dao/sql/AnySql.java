package evolution.dao.sql;

public class AnySql {
	public String selectById() {
		return "SELECT * FROM any_table WHERE id = #{id}";
	}
}
