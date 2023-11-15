package com.samsung.sds.corporate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;
}
