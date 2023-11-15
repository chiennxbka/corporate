package com.samsung.sds.corporate.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactPayload {

    private String name;

    private String email;

    private String telephone;

    private String subject;

    private String content;
}
