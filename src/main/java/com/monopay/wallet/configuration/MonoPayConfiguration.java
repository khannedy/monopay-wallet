package com.monopay.wallet.configuration;

import com.monopay.wallet.resolver.AuthenticationArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MonoPayConfiguration implements WebMvcConfigurer {

  @Autowired
  private AuthenticationArgumentResolver authenticationArgumentResolver;

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(authenticationArgumentResolver);
  }
}
