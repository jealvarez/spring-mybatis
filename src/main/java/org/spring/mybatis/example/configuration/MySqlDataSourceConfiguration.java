package org.spring.mybatis.example.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "org.spring.mybatis.example.repository")
@EnableTransactionManagement
public class MySqlDataSourceConfiguration {

    @Value("${org.spring.mybatis.example.datasource.database:example}")
    private String database;

    @Bean(destroyMethod = "close")
    public DataSource dataSource(@Value("${spring.datasource.driverClassName:com.mysql.jdbc.Driver}") final String driverClassName,
                                 @Value("${org.spring.mybatis.example.datasource.host:127.0.0.1}") final String host,
                                 @Value("${org.spring.mybatis.example.datasource.port:3306}") final String port,
                                 @Value("${org.spring.mybatis.example.datasource.username:root}") final String username,
                                 @Value("${org.spring.mybatis.example.datasource.password:P@ssw0rd}") final String password) {

        final String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/" + database + "?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(final DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("org.spring.mybatis.example.domain");

        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(final SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean
    public PlatformTransactionManager transactionManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
