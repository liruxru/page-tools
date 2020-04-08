package com.mt.tlstools.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
//        http.httpBasic()              // HttpBasic
////        http.formLogin()              // 表单方式
//                .and()
//                .authorizeRequests()  // 授权配置
//                .anyRequest()         // 所有请求
//                .authenticated()// 都需要认证
        http.csrf().disable();// 禁用csrf
    }

}
