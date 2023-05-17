package com.myadmin.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {
    private int id;
    private String title;
    private String teacher;
    private String topic;
    private String target;
    private String rdate;
    private String time;
    private int price;
    private String img;

    public Lecture(int id, String title, String teacher, String topic, String target, String rdate, String time, int price, String img) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.topic = topic;
        this.target = target;
        this.rdate = rdate;
        this.time = time;
        this.price = price;
        this.img = img;
    }

    private MultipartFile imgfile;
}
