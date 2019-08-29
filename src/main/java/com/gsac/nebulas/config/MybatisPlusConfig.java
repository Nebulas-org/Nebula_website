package com.gsac.nebulas.config;

import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wang
 */
@EnableTransactionManagement
@Configuration
@MapperScan("src.main.resources.mybatis.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page= new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
    @Bean
    public LogicSqlInjector logicSqlInjector(){return new LogicSqlInjector();}
}
