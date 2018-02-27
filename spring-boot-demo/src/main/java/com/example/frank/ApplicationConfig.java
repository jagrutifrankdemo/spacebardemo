package com.example.frank;

import com.example.frank.controller.GameUserController;
import com.example.frank.controller.impl.GameUserControllerImpl;
import com.example.frank.service.GameUserService;
import com.example.frank.service.impl.GameUserServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySources({
        @PropertySource("redis.properties"),
        @PropertySource("mysql.properties")
}
)
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.db}")
    private Integer redisDB;


    @Value("${mysql.host}")
    private String mysqlHost;

    @Value("${mysql.port}")
    private String mysqlPort;

    @Value("${mysql.username}")
    private String mysqlUsername;

    @Value("${mysql.password}")
    private String mysqlPassword;

    @Value("${mysql.database}")
    private String mysqlDatabase;
    // REDIS
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisHost);
        factory.setPort(redisPort);
        factory.setDatabase(redisDB);
        return factory;
    }

    @Bean
    StringRedisSerializer stringKeySerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    RedisTemplate<String,Object> redisTemplate() {
        final RedisTemplate<String,Object> template = new RedisTemplate<String,Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(stringKeySerializer());
        return template;
    }



    // MYSQL
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://"+mysqlHost+":"+mysqlPort+"/"+mysqlDatabase+"?useSSL=false");
        dataSource.setUsername(mysqlUsername);
        dataSource.setPassword(mysqlPassword);
        return dataSource;
    }

    Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hb2mddl.auto", "validate");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(new String[] { "com.example.frank.jpa.model"});
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactory().getObject());
        return jtm;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public GameUserController gameUser(){
        return new GameUserControllerImpl();
    }
    @Bean
    public GameUserService gameUserService(){
        return  new GameUserServiceImpl();
    }
}
