package com.myadmin.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Marker {
    private int id;
    private String title;
    private Double lat;
    private Double lng;
    private String img;
    private int star;
    private String detail;

    public Marker(int id, String title, Double lat, Double lng, String img, int star, String detail) {
        this.id = id;
        this.title = title;
        this.lat = lat;
        this.lng = lng;
        this.img = img;
        this.star = star;
        this.detail = detail;
    }

    private MultipartFile imgfile;
}
