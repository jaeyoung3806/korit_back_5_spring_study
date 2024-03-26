package com.study.library.service;

import com.study.library.dto.RegisterBookReqDto;
import com.study.library.dto.SearchBookReqDto;
import com.study.library.dto.SearchBooksRespDto;
import com.study.library.entity.Book;
import com.study.library.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public void saveBook(RegisterBookReqDto registerBookReqDto) {
        bookMapper.saveBook(registerBookReqDto.toEntity());
    }
    public List<SearchBooksRespDto> searchBooks(SearchBookReqDto searchBookReqDto) {
        int startIndex = (searchBookReqDto.getPage() -1) * searchBookReqDto.getCount();

        List<Book> books = bookMapper.findBooks(
                startIndex,
                searchBookReqDto.getCount(),
                searchBookReqDto.getBookTypeId(),
                searchBookReqDto.getCategoryId(),
                searchBookReqDto.getSearchTypeId(),
                searchBookReqDto.getSearchText()
        );
        return books.stream().map(Book::toSearchBooksRespDto).collect(Collectors.toList());
    }
}
