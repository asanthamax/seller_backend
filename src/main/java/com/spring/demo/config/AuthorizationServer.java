package com.spring.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(ServerSecurityConfig.class)
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    private final DataSource dataSource;

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder oauthClientPasswordEncoder;

    @Autowired
    public AuthorizationServer(@Qualifier("dataSource") DataSource dataSource, AuthenticationManager authenticationManager,
                               @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
                               PasswordEncoder oauthClientPasswordEncoder) {
        this.dataSource = dataSource;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.oauthClientPasswordEncoder = oauthClientPasswordEncoder;
    }

    @Bean
    public TokenStore tokenStore(){

        return new JdbcTokenStore(dataSource);
    }

    @Bean
    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler(){

        return new OAuth2AccessDeniedHandler();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security){

        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated").passwordEncoder(oauthClientPasswordEncoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints){

        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).userDetailsService(userDetailsService);
    }
}
