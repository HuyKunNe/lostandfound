package com.swp391.lostandfound;

import com.swp391.lostandfound.DTO.TypeAddDTO;
import com.swp391.lostandfound.DTO.TypeUpdateDTO;
import com.swp391.lostandfound.controller.TypeController;
import com.swp391.lostandfound.dataFormat.ListTypesData;
import com.swp391.lostandfound.dataFormat.TypeData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TypeControlerTest {
    @Autowired
    private TypeController typeController;

    private static TypeData typeData1;
    private static TypeData typeData2;

    @Test
    @Order(1)
    void getAllType1(){
        var listType = typeController.getAllTypes();
        assertThat(listType.getMessage()).isEqualTo("List is empty");
        assertThat(listType.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(2)
    void addType1(){
        var typeAddDTO = new TypeAddDTO();
        typeAddDTO.setName("Type 1 Name");
        typeData1 = typeController.addType(typeAddDTO);
        assertThat(typeData1.getType().getName()).isEqualTo(typeAddDTO.getName());
        assertThat(typeData1.getMessage()).isEqualTo("Create successfully");
        assertThat(typeData1.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(3)
    void addType2(){
        var typeAddDTO = new TypeAddDTO();
        typeAddDTO.setName("Type 2 Name");
        typeData2 = typeController.addType(typeAddDTO);
        assertThat(typeData2.getType().getName()).isEqualTo(typeAddDTO.getName());
        assertThat(typeData2.getMessage()).isEqualTo("Create successfully");
        assertThat(typeData2.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(4)
    void getTypeByID1(){
        var typeDataReturn = typeController.findTypeById(typeData1.getType().getId());
        assertThat(typeDataReturn.getType().getId()).isEqualTo(typeData1.getType().getId());
        assertThat(typeDataReturn.getType().getName()).isEqualTo(typeData1.getType().getName());
        assertThat(typeDataReturn.getMessage()).isEqualTo("Find Type successfully");
        assertThat(typeDataReturn.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(5)
    void getTypeByID2(){
        var typeDataReturn = typeController.findTypeById(typeData2.getType().getId());
        assertThat(typeDataReturn.getType().getId()).isEqualTo(typeData2.getType().getId());
        assertThat(typeDataReturn.getType().getName()).isEqualTo(typeData2.getType().getName());
        assertThat(typeDataReturn.getMessage()).isEqualTo("Find Type successfully");
        assertThat(typeDataReturn.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(6)
    void getTypeByID3(){
        var typeDataReturn = typeController.findTypeById(10000);
        assertThat(typeDataReturn.getMessage()).isEqualTo("Type is not found");
        assertThat(typeDataReturn.getStatus()).isEqualTo("Fail");
    }

    @Test
    @Order(7)
    void editType1(){
        var typeUpdateDTO = new TypeUpdateDTO();
        typeUpdateDTO.setName("Type 1 Name Edited");
        typeData1 = typeController.updateType(typeData1.getType().getId(),typeUpdateDTO);
        assertThat(typeData1.getType().getName()).isEqualTo(typeUpdateDTO.getName());
        assertThat(typeData1.getMessage()).isEqualTo("Update type successfully");
        assertThat(typeData1.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(8)
    void editType2(){
        var typeUpdateDTO = new TypeUpdateDTO();
        typeUpdateDTO.setName("Type 2 Name Edited");
        typeData2 = typeController.updateType(typeData2.getType().getId(),typeUpdateDTO);
        assertThat(typeData2.getType().getName()).isEqualTo(typeUpdateDTO.getName());
        assertThat(typeData2.getMessage()).isEqualTo("Update type successfully");
        assertThat(typeData2.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(9)
    void editType3(){
        var chestUpdateDTO = new TypeUpdateDTO();
        chestUpdateDTO.setName("Chest 3 Name Edited");
        var chestDataReturn = typeController.updateType(10000,chestUpdateDTO);
        assertThat(chestDataReturn.getMessage()).isEqualTo("Type is not exist");
        assertThat(chestDataReturn.getStatus()).isEqualTo("Fail");
    }

    @Test
    @Order(10)
    void getAllType2(){
        var listType = typeController.getAllTypes();
        assertThat(listType.getMessage()).isEqualTo("get all enable types successfully");
        assertThat(listType.getStatus()).isEqualTo("Success");

        assertThat(listType.getData().get(0).getId()).isEqualTo(typeData1.getType().getId());
        assertThat(listType.getData().get(0).getName()).isEqualTo(typeData1.getType().getName());
        assertThat(listType.getData().get(0).getStatus()).isEqualTo(typeData1.getType().getStatus());

        assertThat(listType.getData().get(1).getId()).isEqualTo(typeData2.getType().getId());
        assertThat(listType.getData().get(1).getName()).isEqualTo(typeData2.getType().getName());
        assertThat(listType.getData().get(1).getStatus()).isEqualTo(typeData2.getType().getStatus());
    }

    @Test
    @Order(11)
    void deleteType1(){
        typeData1 = typeController.deleteTypeById(typeData1.getType().getId());
        assertThat(typeData1.getMessage()).isEqualTo("Delete Type successfully");
        assertThat(typeData1.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(12)
    void deleteType2(){
        typeData2 = typeController.deleteTypeById(typeData2.getType().getId());
        assertThat(typeData2.getMessage()).isEqualTo("Delete Type successfully");
        assertThat(typeData2.getStatus()).isEqualTo("Success");
    }

    @Test
    @Order(13)
    void deleteType3(){
        var typeData = typeController.deleteTypeById(10000);
        assertThat(typeData.getMessage()).isEqualTo("Type is not exist");
        assertThat(typeData.getStatus()).isEqualTo("Fail");
    }

    @Test
    @Order(14)
    void getAllType3(){
        var listType = typeController.getAllTypes();
        assertThat(listType.getMessage()).isEqualTo("List is empty");
        assertThat(listType.getStatus()).isEqualTo("Success");
    }
}
