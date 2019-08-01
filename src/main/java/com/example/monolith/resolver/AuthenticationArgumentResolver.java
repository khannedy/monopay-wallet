package com.example.monolith.resolver;

import com.example.monolith.entity.Authentication;
import com.example.monolith.exception.AuthenticationException;
import com.example.monolith.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {

  public static final String API_KEY_HEADER = "API-KEY";

  @Autowired
  private AuthenticationRepository authenticationRepository;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return Authentication.class.equals(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    String apiKey = webRequest.getHeader(API_KEY_HEADER);
    Authentication authentication = authenticationRepository.findByApiKey(apiKey);

    if (authentication == null) {
      throw new AuthenticationException();
    } else {
      return authentication;
    }
  }
}
