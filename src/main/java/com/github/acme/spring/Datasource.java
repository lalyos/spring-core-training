package com.github.acme.spring;

import lombok.Data;

@Data
public class Datasource {
    private String url;
    private String driver;
    private String username;
    private String password;
}
