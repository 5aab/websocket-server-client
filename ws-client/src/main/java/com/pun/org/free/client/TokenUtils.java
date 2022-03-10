package com.pun.org.free.client;

import com.pun.org.free.client.message.TokenDto;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@UtilityClass
public class TokenUtils {

    public static TokenDto getToken() {
        final String uri = "http://localhost:8083/auth/realms/wsauth/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("client_id", "wsauth-client");
        requestBody.add("username", "wsauth-user");
        requestBody.add("password", "wsauth-password");
        requestBody.add("grant_type", "password");
        HttpEntity<String> request = new HttpEntity(requestBody, headers);
        RestTemplate restTemplate = restTemplate();
        TokenDto tokenDto = restTemplate.exchange(uri, HttpMethod.POST, request, TokenDto.class).getBody();
        return tokenDto;
    }

    public static RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}
