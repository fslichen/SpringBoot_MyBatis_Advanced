package evolution.dao;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration// Denote the current class as the configuration class. 
@MapperScan(basePackages = "evolution.dao.mapper")// Scan all the mappers under the mapper package.
@EnableTransactionManagement
public class DaoConfiguration {
	@Value("${dataSource.driver}")// See application.properties
	private String dataSourceDriver;

	@Value("${dataSource.url}")
	private String dataSourceUrl;

	@Value("${dataSource.username}")
	private String dataSourceUsername;

	@Value("${dataSource.password}")
	private String dataSourcePassword;

	@Bean// Inject DataSource
	public DataSource dataSource() {
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver(this.dataSourceDriver);
		dataSource.setUrl(this.dataSourceUrl);
		dataSource.setUsername(this.dataSourceUsername);
		dataSource.setPassword(this.dataSourcePassword);
		return dataSource;
	}

	@Bean// Inject SqlSessionFactoryBean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory;
	}

	@Bean// Inject DataSourceTransactionManager
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
