package com.study.mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StudentRepository")
public class StudentRepositoryImpl implements StudentRepository{

    private List<String> studnetsList = List.of("전주환", "서창현", "예홍렬");

    @Override
    public List<String> getStudentListAll() {
        return studnetsList;
    }

    @Override
    public String findStudentNameByIndex(int index) {
        return studnetsList.get(index);
    }


}
