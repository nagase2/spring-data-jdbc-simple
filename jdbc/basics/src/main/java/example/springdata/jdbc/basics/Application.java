package example.springdata.jdbc.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@SpringBootTest(classes = AggregateConfiguration.class)
@EnableAutoConfiguration
@AutoConfigureJdbc
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
