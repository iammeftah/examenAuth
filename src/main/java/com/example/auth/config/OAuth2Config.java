package com.example.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

@Configuration
public class OAuth2Config {
    @Bean
    public CustomOAuth2UserService customOAuth2UserService() {
        return new CustomOAuth2UserService();
    }

    public static class CustomOAuth2UserService extends DefaultOAuth2UserService {
        @Override
        public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
            OAuth2User user = super.loadUser(userRequest);
            Map<String, Object> attributes = user.getAttributes();
            Set<GrantedAuthority> authorities = new HashSet<>(user.getAuthorities());
            String email = (String) attributes.get("email");
            if (email != null) {
                if (email.endsWith("@manager.com")) {
                    authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
                } else if (email.endsWith("@techlead.com")) {
                    authorities.add(new SimpleGrantedAuthority("ROLE_TECHLEAD"));
                } else {
                    authorities.add(new SimpleGrantedAuthority("ROLE_DEV"));
                }
            }

            return new DefaultOAuth2User(authorities, attributes, "login");
        }
    }
}