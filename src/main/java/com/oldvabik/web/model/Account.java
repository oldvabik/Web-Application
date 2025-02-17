package com.oldvabik.web.model;

import lombok.*;

@Data
@Builder
public class Account {
    private String name;
    private String email;
    private int age;
    private String role;
}
