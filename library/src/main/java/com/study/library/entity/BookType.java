package com.study.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookType {
    private int bookTypeId;
    private String bookTypeName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
