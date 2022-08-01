package com.human.pet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {

    private long seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate;
    private Long cnt;
}