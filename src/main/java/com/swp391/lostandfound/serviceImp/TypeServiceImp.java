package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.Type;
import com.swp391.lostandfound.repository.TypeRepository;
import com.swp391.lostandfound.service.TypeService;

import org.springframework.stereotype.Service;

@Service
public class TypeServiceImp implements TypeService {

    private TypeRepository typeRepository;

    public TypeServiceImp(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> getAllTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Type addType(Type type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Type updateType(Type type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Type findTypeById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteTypeById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
