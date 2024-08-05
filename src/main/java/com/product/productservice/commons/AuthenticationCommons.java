package com.product.productservice.commons;

import com.product.productservice.dtos.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {

    private final RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) {
        UserDto userDto = restTemplate.getForObject("http://localhost:8081/authService/users/validateToken/"+token, UserDto.class);
        return userDto;
    }
}
