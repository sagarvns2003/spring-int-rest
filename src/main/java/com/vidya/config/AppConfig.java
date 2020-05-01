package com.vidya.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Vidya
 */
@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Value("${auth.ignore.path}")
	private String[] authIgnorePath;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(this.authIgnorePath);
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		super.configure(http);
	}
}