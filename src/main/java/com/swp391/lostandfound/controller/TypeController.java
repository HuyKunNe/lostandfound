package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.TypeAddDTO;
import com.swp391.lostandfound.DTO.TypeUpdateDTO;
import com.swp391.lostandfound.dataFormat.ListTypesData;
import com.swp391.lostandfound.dataFormat.TypeData;
import com.swp391.lostandfound.entity.Type;
import com.swp391.lostandfound.service.TypeService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class TypeController {

    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/type")
    public ListTypesData getAllTypes() {
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
    public TypeData findTypeById(@PathVariable int id) {
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
    public TypeData addType(@RequestBody TypeAddDTO typeAddDTO) {
        TypeData result = new TypeData();
        result.setType(typeService.addType(typeAddDTO));
        result.setMessage("Create successfully");
        result.setStatus("Success");
        return result;
    }

    @PutMapping("/type/{id}")
    public TypeData updateType(@PathVariable int id,@RequestBody  TypeUpdateDTO typeUpdateDTO) {
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
    public TypeData deleteTypeById(@PathVariable int id) {
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
