package com.jianzhennet.simplecloudsso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAuthorizationServer //提供/oauth/authorize,/oauth/token,/oauth/check_token,/oauth/confirm_access,/oauth/error
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()") //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
                .checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
                .allowFormAuthenticationForClients();
    }

    /**
     * 注入authenticationManager
     * 来支持 password grant type
     */


    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        SecurityConfig securityConfig = new SecurityConfig();
        endpoints.authenticationManager(authenticationManager).userDetailsService(securityConfig.userDetailsService())
                .accessTokenConverter(accessTokenConverter());
    }

    //
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                String username = authentication.getUserAuthentication().getName();
                final Map<String, Object> additionalInformation = new HashMap<>();
                additionalInformation.put("username", username);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken token = super.enhance(accessToken, authentication);
                return token;
            }
        };
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("cert.jks"), "jianzhennet.com".toCharArray()).getKeyPair("jzn");
        converter.setKeyPair(keyPair);
        return converter;
    }

    /*数据库验证client_id,client_secret,scope获取token，最终目的为了获取范围*/
    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);

    }
}