package com.jpmc.misc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "accountsEntityManagerFactory",
        basePackages = {
                "com.jpmc.misc"
        }
)
public class AccountsConfiguration {

    @Bean(name = "accountsDataSource")
    @ConfigurationProperties(prefix = "second.datasource")
    public DataSource accountsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "accountsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("accountsDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.jpmc.misc")
                .persistenceUnit("second")
                .build();
    }

//    @Primary
//    @Bean(name = "customerTransactionManager")
//    public PlatformTransactionManager customerTransactionManager(
//            @Qualifier("customerEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory
//    ) {
//        return new JpaTransactionManager(customerEntityManagerFactory);
//    }
}