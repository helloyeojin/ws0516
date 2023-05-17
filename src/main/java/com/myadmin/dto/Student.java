package com.myadmin.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String pwd;
    private String name;
    private String detail;
    private String email;
    private String contact;
    private String img;

    private MultipartFile imgfile;

    public Student(String id, String pwd, String name, String email, String contact) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }
}
