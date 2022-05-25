package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.entity.Type;

public interface TypeService {
    List<Type> getAllTypes();

    Type addType(Type type);

    Type updateType(Type type);

    Type findTypeById(int id);

    boolean deleteTypeById(int id);
}
