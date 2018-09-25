/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.springdata.jdbc.basics.aggregate;

import static java.util.Arrays.asList;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.lang.Nullable;

import example.springdata.jdbc.basics.simpleentity.Category;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jens Schauder
 */
@Configuration
@EnableJdbcRepositories
@Slf4j
public class AggregateConfiguration extends JdbcConfiguration {

	final AtomicInteger id = new AtomicInteger(0);

	@Bean
	public ApplicationListener<?> idSetting() {

		return (ApplicationListener<BeforeSaveEvent>) event -> {

			if (event.getEntity() instanceof LegoSet) {
				setIds((LegoSet) event.getEntity());
			}
		};
	}

	private void setIds(LegoSet legoSet) {

		if (legoSet.getId() == 0) {
			legoSet.setId(id.incrementAndGet());
		}

		Manual manual = legoSet.getManual();

		if (manual != null) {
			manual.setId((long) legoSet.getId());
		}
	}

	@Override
	public JdbcCustomConversions jdbcCustomConversions() {

		return new JdbcCustomConversions(asList(new Converter<Clob, String>() {

			@Nullable
			@Override
			public String convert(Clob clob) {

				try {
				    System.out.println("★converter");

					return Math.toIntExact(clob.length()) == 0 //
							? "" //
							: clob.getSubString(1, Math.toIntExact(clob.length()));

				} catch (SQLException e) {
					throw new IllegalStateException("Failed to convert CLOB to String.", e);
				}
			}
		}));
	}
	
	@Bean
    public ApplicationListener<BeforeSaveEvent> timeStampingSaveTime() {

        return event -> {

            Object entity = event.getEntity();
            log.info("★before save"+entity.toString());

            if (entity instanceof Category) {
                Category category = (Category) entity;
                category.timeStamp();
            }
        };
    }
	
	
	
  @Autowired
  DataSourceProperties dataSourceProperties;
  DataSource dataSource;
  @Bean
  DataSource dataSource() {
      System.out.println("★"+this.dataSourceProperties.getDriverClassName());
      
    DataSourceBuilder factory =
        DataSourceBuilder.create(this.dataSourceProperties.getClassLoader())
            .driverClassName(this.dataSourceProperties.getDriverClassName())
            .url(this.dataSourceProperties.getUrl())
            .username(this.dataSourceProperties.getUsername())
            .password(this.dataSourceProperties.getPassword());
    this.dataSource = factory.build();
    //return new Log4jdbcProxyDataSource(this.dataSource);
    return this.dataSource;
  }
}
