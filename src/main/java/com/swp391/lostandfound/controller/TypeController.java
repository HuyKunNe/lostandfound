package com.swp391.lostandfound.controller;

import java.util.List;

import com.swp391.lostandfound.DTO.TypeAddDTO;
import com.swp391.lostandfound.DTO.TypeUpdateDTO;
import com.swp391.lostandfound.dataFormat.ListTypesData;
import com.swp391.lostandfound.dataFormat.TypeData;
import com.swp391.lostandfound.entity.Type;
import com.swp391.lostandfound.service.TypeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeController {

    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/type")
    ListTypesData getAllTypes() {
        ListTypesData types = new ListTypesData();
        types.setData(typeService.getAllTypes());
        if (types.getData().isEmpty()) {
            types.setMessage("List is empty");
        } else {
            types.setMessage("get all enable types successfully");
        }
        types.setStatus("Success");
        return types;
    }

    @GetMapping("/type/{id}")
    TypeData findTypeById(int id) {
        TypeData result = new TypeData();
        result.setType(typeService.findTypeById(id));
        if (result.getType() != null) {
            result.setMessage("Find Type successfully");
            result.setStatus("Success");
        } else {
            result.setMessage("Type is not found");
            result.setStatus("Fail");
        }
        return result;
    }

    @PostMapping("/type")
    TypeData addType(TypeAddDTO typeAddDTO) {
        TypeData result = new TypeData();
        result.setType(typeService.addType(typeAddDTO));
        result.setMessage("Create successfully");
        result.setStatus("Success");
        return result;
    }

    @PutMapping("/type/{id}")
    TypeData updateType(int id, TypeUpdateDTO typeUpdateDTO) {
        TypeData result = new TypeData();
        Type type = typeService.updateType(id, typeUpdateDTO);
        if (type != null) {
            result.setMessage("Update type successfully");
            result.setType(type);
            result.setStatus("Success");
        } else {
            result.setMessage("Type is not exist");
            result.setStatus("Fail");
        }
        return result;
    };

    @DeleteMapping("/type/{id}")
    TypeData deleteTypeById(int id) {
        TypeData result = new TypeData();
        if (typeService.deleteTypeById(id)) {
            result.setMessage("Delete Type successfully");
            result.setStatus("Success");
        } else {
            result.setMessage("Type is not exist");
            result.setStatus("Fail");
        }
        return result;
    }
}
