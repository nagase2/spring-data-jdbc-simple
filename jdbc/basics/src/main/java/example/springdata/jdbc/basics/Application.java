package example.springdata.jdbc.basics;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
// @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
// DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");
    }

//    @Bean
//    // @ConfigurationProperties("my.datasource")
//    public DataSource dataSource() {
//         return  DataSourceBuilder.create().url("jdbc:hsqldb:mem:mydb").username("sa").password("").driverClassName("org.hsqldb.jdbcDriver").build();

//        return new EmbeddedDatabaseBuilder().generateUniqueName(true)
//                .setType(EmbeddedDatabaseType.HSQL).url("jdbc:hsqldb:mem:mydb").username("sa")
//                .password("").driverClassName("org.hsqldb.jdbcDriver").build();
        // .addScript("create-customer-schema.sql")
        // .build();
//    }


}
