package com.example.frank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable().authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/private/api/**")
                .permitAll()
				.and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);*/
		http.csrf().disable().authorizeRequests();
		http.authorizeRequests().antMatchers("/public/**").permitAll()
				.antMatchers("/api/**").hasRole("DEMOUSER")
				.anyRequest().authenticated()
				.and().formLogin().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("jagruti").password("demo").roles("DEMOUSER");
	}

}