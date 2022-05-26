package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.TypeAddDTO;
import com.swp391.lostandfound.DTO.TypeUpdateDTO;
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
        return typeRepository.findTypeByStatus(0);
    }

    @Override
    public Type addType(TypeAddDTO typeAddDTO) {
        Type type = new Type();
        type.setName(typeAddDTO.getName());
        type.setStatus(0);
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(int id, TypeUpdateDTO typeAddDTO) {
        if (typeRepository.existsById(id)) {
            Type type = typeRepository.findById(id).get();
            type.setName(typeAddDTO.getName());
            type.setStatus(typeAddDTO.getStatus());
            return typeRepository.save(type);
        } else
            return null;
    }

    @Override
    public Type findTypeById(int id) {
        if (typeRepository.existsById(id)) {
            return typeRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean deleteTypeById(int id) {
        if (typeRepository.existsById(id)) {
            typeRepository.setFixedStatusFor(1, id);
            return true;
        } else
            return false;
    }

}
