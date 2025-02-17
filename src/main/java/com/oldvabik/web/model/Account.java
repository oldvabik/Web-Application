package com.oldvabik.web.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String name;
    private String email;
    private int age;
    private String role;
}
