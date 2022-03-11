package com.pun.org.free.client.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String access_token;
    private String refresh_token;
    private Integer expires_in;
    private Integer refresh_expires_in;
    private String token_type;
    private String scope;
    private String session_state;

}
