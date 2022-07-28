package elbatech.bookshop.security.authentication;

import elbatech.bookshop.security.authentication.filters.TokenFilter;
import elbatech.bookshop.security.authentication.filters.UsernamePasswordFilter;
import elbatech.bookshop.security.authentication.providers.TokenProvider;
import elbatech.bookshop.security.authentication.providers.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalAuthentication
@EnableWebSecurity
public class AuthenticationConfig1 {
    @Autowired
    @Lazy
    UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Autowired
    @Lazy
    TokenProvider tokenProvider;

    @Autowired
    @Lazy
    UsernamePasswordFilter usernamePasswordFilter;

    @Autowired
    @Lazy
    TokenFilter tokenFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(usernamePasswordAuthenticationProvider)
                .authenticationProvider(tokenProvider);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.addFilterAt(usernamePasswordFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(tokenFilter, BasicAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/addUser").permitAll()
                .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
