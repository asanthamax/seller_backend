package com.spring.demo.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.spring.demo.repository")
@EnableTransactionManagement
public class DatabaseConfig {


}
