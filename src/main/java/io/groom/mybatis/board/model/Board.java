package io.groom.mybatis.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long seq;
    private String title;
    private String contents;
    private String regUser;
    private LocalDateTime regDate;
}
