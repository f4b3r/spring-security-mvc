package com.fp.demo.todolist.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   
	@Autowired
	private DataSource dataSource;
	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .withDefaultSchema()
	      .withUser(User.withUsername("user")
	        .password(passwordEncoder().encode("pass"))
	        .roles("USER"));
	}
	  @Override
	    protected void configure(HttpSecurity httpSecurity)
	      throws Exception {
	        httpSecurity.authorizeRequests()
	          .antMatchers("/h2-console/**", "/css/**")
	          .permitAll()
	          .anyRequest()
	          .authenticated()
	          .and().csrf().disable()
	          .formLogin().successForwardUrl("/tasks");
	         
	       
	        httpSecurity.headers()
	          .frameOptions()
	          .sameOrigin().and().csrf().disable();
	    }
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
 
}