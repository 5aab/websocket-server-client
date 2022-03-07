package com.pun.org.free.client.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class HelloMessage {

    private String name;
    private String vol;
}
