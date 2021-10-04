package com.jpmc.misc;

import com.jpmc.misc.persons.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "personsEntityManagerFactory",
        transactionManagerRef = "personsTransactionManager",
        basePackages = {
                "com.jpmc.misc.persons"
        }
)
public class PersonsConfiguration {


    @Primary
    @Bean(name = "personsDataSource")
    @ConfigurationProperties(prefix = "person.datasource")
    public DataSource personsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "personsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(personsDataSource())
                .packages(Person.class)
                .build();
    }

   @Primary
    @Bean(name = "personsTransactionManager")
    public PlatformTransactionManager personsTransactionManager(
        @Qualifier("personsEntityManagerFactory") EntityManagerFactory personsEntityManagerFactory) {
        return new JpaTransactionManager(personsEntityManagerFactory);
    }
}