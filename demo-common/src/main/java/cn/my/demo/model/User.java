package cn.my.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private Date birthday;
    private boolean isActive;

    public void destroy(){}

}
