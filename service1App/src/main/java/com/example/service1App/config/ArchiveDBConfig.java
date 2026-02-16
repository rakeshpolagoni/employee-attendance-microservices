package com.example.service1App.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;

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

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.service1App.archive.repository",
        entityManagerFactoryRef = "archiveEntityManagerFactory",
        transactionManagerRef = "archiveTransactionManager"
)
public class ArchiveDBConfig {

    // ✅ Archive DataSource
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.archive")
    public DataSource archiveDataSource() {
        return DataSourceBuilder.create().build();
    }

    // ✅ Entity Manager (VERY IMPORTANT PART)
    @Bean
    public LocalContainerEntityManagerFactoryBean archiveEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        Map<String, Object> properties = new HashMap<>();

        // ⭐ THIS enables auto table creation
        properties.put("hibernate.hbm2ddl.auto", "update");

        // ⭐ Always define dialect for safety
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        return builder
                .dataSource(archiveDataSource())
                .packages("com.example.service1App.archive.model")
                .properties(properties)
                .persistenceUnit("archive") // good practice
                .build();
    }

    // ✅ Transaction Manager
    @Bean
    public PlatformTransactionManager archiveTransactionManager(
            @Qualifier("archiveEntityManagerFactory")
            EntityManagerFactory factory) {

        return new JpaTransactionManager(factory);
    }
}
