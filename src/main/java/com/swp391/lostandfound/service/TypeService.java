package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.TypeAddDTO;
import com.swp391.lostandfound.DTO.TypeUpdateDTO;
import com.swp391.lostandfound.entity.Type;

public interface TypeService {
    List<Type> getAllTypes();

    Type addType(TypeAddDTO typeAddDTO);

    Type updateType(int id, TypeUpdateDTO typeUpdateDTO);

    Type findTypeById(int id);

    boolean deleteTypeById(int id);
}
