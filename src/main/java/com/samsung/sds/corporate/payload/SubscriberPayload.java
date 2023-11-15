package com.samsung.sds.corporate.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class SubscriberPayload {
    private String email;
}
