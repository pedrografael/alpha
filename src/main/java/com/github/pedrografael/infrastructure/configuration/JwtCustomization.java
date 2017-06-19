package com.github.pedrografael.infrastructure.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

@Component
public class JwtCustomization implements JwtAccessTokenConverterConfigurer {

  @Override
  public void configure(JwtAccessTokenConverter converter) {
    DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
    defaultAccessTokenConverter.setUserTokenConverter(new CustomUserAuthenticationConverter());
    converter.setAccessTokenConverter(defaultAccessTokenConverter);
  }

}