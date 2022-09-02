package com.pubaoyou.website.config;

import com.pubaoyou.website.security.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected CustomerUserDetailsService userDetailsService;

    /**
     * 指定加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 验证方式，从数据库中读取用户名密码并验证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/index","/pubaoyou/echi/v1/toIndex","/pubaoyou/echi/v1/logout").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //登录页面的方法，及所有需要拦截的且未登录的都会触发跳转
                .loginPage("/pubaoyou/echi/v1/toLogin")
                //配置登录动作，会被拦截触发loadUserByUsername，所以以下需要配置登录的方法名
                .loginProcessingUrl("/pubaoyou/echi/v1/doLogin")
                //登录成功后触发的方法
                .successForwardUrl("/pubaoyou/echi/v1/toMain")
                .usernameParameter("userName")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/pubaoyou/echi/v1/logout")
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/fonts/**","/img/**","/favicon.ico");
    }

}
