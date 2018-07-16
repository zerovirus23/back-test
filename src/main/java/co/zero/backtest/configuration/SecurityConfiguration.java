package co.zero.backtest.configuration;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {


        http.sessionManagement()
//            .sessionCreationPolicy(STATELESS)
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .antMatchers(GET,"/api/transactions").permitAll()
            .antMatchers(GET,"/api/transactions/**").permitAll()
            .antMatchers(GET, "/api/transactions/*/count").hasRole("USER")
            .and()
            .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("123456").roles("USER");
    }

}