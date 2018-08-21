package br.com.projeto;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import oracle.jdbc.pool.OracleDataSource;

	public class DataSource {
		  @Bean
		   OracleDataSource dataSource() throws SQLException{
		        OracleDataSource dataSource = new OracleDataSource();
		        dataSource.setUser("SYSTEM");
		        dataSource.setPassword("naruto11");
		        dataSource.setURL("jdbc:oracle//localhost:1521/xe");
		        dataSource.setImplicitCachingEnabled(true);
		        dataSource.setFastConnectionFailoverEnabled(true); 
		        return dataSource;
	 }
	
}
