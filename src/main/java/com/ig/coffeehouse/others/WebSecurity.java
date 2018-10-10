package com.riskblock.theinstitutes.security;

import com.riskblock.theinstitutes.security.jwt.CustomAccessDeniedHandler;
import com.riskblock.theinstitutes.security.jwt.JWTAuthenticationFilter;
import com.riskblock.theinstitutes.security.jwt.JWTLoginFilter;
import com.riskblock.theinstitutes.service.impl.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailService appUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().cacheControl();
        http.cors();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/vaultStates", "/v2/api-docs",
                        "/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/ui",
                        "/swagger-resources/configuration/security", "/configuration/security",
                        "/swagger-ui.html", "/webjars/**").permitAll()
                .antMatchers(HttpMethod.POST,
                        "/addMember", "/authenticateMember").permitAll()
                .anyRequest().authenticated()
//               .anyRequest().access("hasIpAddress('0:0:0:0:0:0:0:1')")
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).and()
                .addFilterBefore(new JWTLoginFilter("/authenticateMember", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    private AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailService);
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "content-type"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}