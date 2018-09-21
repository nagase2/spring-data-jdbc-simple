package hello;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;

@Configuration
@EnableJdbcRepositories 
@Import(JdbcConfiguration.class)
public class CustomerConfig extends JdbcConfiguration { 

//    @Bean
//    NamedParameterJdbcOperations operations() { 
//        return new NamedParameterJdbcTemplate(datasource());
//    }
//
//    @Bean
//    PlatformTransactionManager transactionManager() { 
//        return new DataSourceTransactionManager(datasource());
//	}

//    @Bean
//    DataSource dataSource(){ 
//        return new EmbeddedDatabaseBuilder()
//               // .generateUniqueName(true)
//                //.setType(EmbeddedDatabaseType.HSQL)
//                //.addScript("create-customer-schema.sql")
//                .build();
//    }
    
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    
//    @Autowired
//    DataSourceProperties dataSourceProperties;
//
//    DataSource dataSource;

//    @Bean
//    DataSource dataSource() {
//        System.out.println("★"+this.dataSourceProperties.getDriverClassName());
//        
//      DataSourceBuilder factory =
//          DataSourceBuilder.create(this.dataSourceProperties.getClassLoader())
//              .driverClassName(this.dataSourceProperties.getDriverClassName())
//              .url(this.dataSourceProperties.getUrl())
//              .username(this.dataSourceProperties.getUsername())
//              .password(this.dataSourceProperties.getPassword());
//      this.dataSource = factory.build();
//      //return new Log4jdbcProxyDataSource(this.dataSource);
//      return this.dataSource;
//    }

//    @Bean
//    public AuditorAwareImpl auditorProvider() {
//      return new AuditorAwareImpl();
//    }
}


