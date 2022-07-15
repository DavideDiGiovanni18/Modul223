package ch.zli.m223.ksh19a.dd.CRM.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zli.m223.ksh19a.dd.CRM.roles.AppRoles;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	UserDetailsService userDetailService;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityConfiguration(UserDetailsService userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailService = userDetailService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		configureWeb(http);
		configureRest(http);
		super.configure(http);
	}

	private void configureRest(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().sessionManagement().disable().httpBasic().and().authorizeRequests()
				.antMatchers("/api/v1/admin/**").hasAnyAuthority(AppRoles.ADMIN).antMatchers("/api/v3/flughafen")
				.hasAnyAuthority(AppRoles.PASSAGIER).antMatchers("/api/v3/flughafen/**").hasAnyAuthority(AppRoles.ADMIN)
				// dürfen
				// zugreifen
				.and().logout().permitAll();

	}

	private void configureWeb(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin/**").hasAuthority(AppRoles.ADMIN)
				.antMatchers("/user/**").hasAuthority(AppRoles.PASSAGIER).antMatchers("/flughafen/**")
				.hasAnyAuthority(AppRoles.ADMIN).antMatchers("/userlist/**").hasAuthority(AppRoles.ADMIN)
				.antMatchers("/flughafenList/**").hasAuthority(AppRoles.ADMIN).antMatchers("/flughafenList/**")
				.hasAuthority(AppRoles.PASSAGIER).antMatchers("/logedin").authenticated().and().formLogin().permitAll()// Alle
				// //
				// zugreifen
				.and().logout().permitAll();
	}

}
