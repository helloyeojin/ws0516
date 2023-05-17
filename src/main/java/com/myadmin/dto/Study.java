package com.myadmin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Study {
    private int id;
    private String startTime;
    private String endTime;
    private String contents;

}
