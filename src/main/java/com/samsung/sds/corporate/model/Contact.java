package com.samsung.sds.corporate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    private String telephone;

    private String subject;

    private String content;
}
