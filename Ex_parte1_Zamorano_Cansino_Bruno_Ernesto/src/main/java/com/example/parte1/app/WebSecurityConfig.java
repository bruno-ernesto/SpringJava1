package com.example.parte1.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.example.parte1.app.util.LoginSuccessMessage;

/**
 * Clase de configuración, dentro de la cual definiremos la autorizaciones a las URL 
 * de las paginas de nuestra Aplicación
 * 
 * @author Usuario
 *
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration//Anotación encargada de definir que la clase es una clase de configuración para el framework
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;

	@Autowired
	private LoginSuccessMessage successMsg;
	
	//Autorizaciones de las slicitudes de acceso a las url de acuerdo a su rol
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/h2-console/**").permitAll().and() .csrf().ignoringAntMatchers("/h2-console/**") .and() .headers().frameOptions().sameOrigin();
		
		http.authorizeRequests()
		.antMatchers("/index","/home","/","/css/**","/js/**","/images/**")
		.permitAll()
		.antMatchers("/views/clientes")
		.hasAnyRole("USER")/*Ya no es necesario poner el "ROLE_" ya que el hasAnyRole lo inserta automaticamente*/
		/*.antMatchers("/views/clientes/create").hasAnyRole("ADMIN")*/
		.antMatchers("/views/clientes/save").hasAnyRole("ADMIN")
		.antMatchers("/views/clientes/edit/**").hasAnyRole("ADMIN")
		.antMatchers("/views/clientes/delete/**").hasAnyRole("ADMIN")
		.antMatchers("/views/clientes/creauser").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.successHandler(successMsg)
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}

	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.dataSource(datasource)
		.passwordEncoder(NoOpPasswordEncoder.getInstance())//Debemos gregar nuestro objeto de la clase Pbkdf2PasswordEncoder para validar las contraseñas
		.usersByUsernameQuery("SELECT username, password, enabled FROM users where username=?")
		.authoritiesByUsernameQuery("SELECT u.username, u.rol FROM users u WHERE u.username=? and u.enabled = '1'");
	}
	

}
