package com.jpmc.misc;

import com.jpmc.misc.accounts.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "accountsEntityManagerFactory",
        transactionManagerRef = "accountsTransactionManager",
        basePackages = {
                "com.jpmc.misc.accounts"
        }
)
public class AccountsConfiguration {

    @Bean(name = "accountsDataSource")
    @ConfigurationProperties(prefix = "account.datasource")
    public DataSource accountsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "accountsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(accountsDataSource())
                .packages(Account.class)
                .build();
    }

    @Bean(name = "accountsTransactionManager")
    public PlatformTransactionManager customerTransactionManager(
            @Qualifier("accountsEntityManagerFactory") EntityManagerFactory accountsEntityManagerFactory
    ) {
        return new JpaTransactionManager(accountsEntityManagerFactory);
    }
}