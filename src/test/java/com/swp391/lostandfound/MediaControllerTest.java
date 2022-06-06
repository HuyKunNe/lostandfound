//package com.swp391.lostandfound;
//
//import com.swp391.lostandfound.DTO.ChestAddDTO;
//import com.swp391.lostandfound.DTO.ChestUpdateDTO;
//import com.swp391.lostandfound.DTO.MediaAddDTO;
//import com.swp391.lostandfound.controller.MediaController;
//import com.swp391.lostandfound.dataFormat.ChestData;
//import com.swp391.lostandfound.dataFormat.ListChests;
//import com.swp391.lostandfound.dataFormat.MediaData;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class MediaControlerTest {
//    @Autowired
//    private MediaController mediaController;
//
//    private static MediaData mediaData1;
//    private static MediaData mediaData2;
//
//    @Test
//    @Order(1)
//    void getAllMedia1(){
//        var allMedias = mediaController.getAllMedias();
//        assertThat(allMedias.getMessage()).isEqualTo("List is empty");
//        assertThat(allMedias.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(2)
//    void addChest1(){
//        var mediaAddDTO = new MediaAddDTO();
//        mediaAddDTO.setLink("Media 1 link");
//        mediaAddDTO.setDescription("Chest 1 Description");
//        mediaAddDTO.setLocation("Chest 1 Location");
//        chestData1 = mediaController.addChest(mediaAddDTO);
//        assertThat(chestData1.getChest().getName()).isEqualTo(mediaAddDTO.getName());
//        assertThat(chestData1.getChest().getDescription()).isEqualTo(mediaAddDTO.getDescription());
//        assertThat(chestData1.getChest().getLocation()).isEqualTo(mediaAddDTO.getLocation());
//        assertThat(chestData1.getMessage()).isEqualTo("Create successfully");
//        assertThat(chestData1.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(3)
//    void addChest2(){
//        ChestAddDTO chestAddDTO = new ChestAddDTO();
//        chestAddDTO.setName("Chest 2 Name");
//        chestAddDTO.setDescription("Chest 2 Description");
//        chestAddDTO.setLocation("Chest 2 Location");
//        chestData2 = mediaController.addChest(chestAddDTO);
//        assertThat(chestData2.getChest().getName()).isEqualTo(chestAddDTO.getName());
//        assertThat(chestData2.getChest().getDescription()).isEqualTo(chestAddDTO.getDescription());
//        assertThat(chestData2.getChest().getLocation()).isEqualTo(chestAddDTO.getLocation());
//        assertThat(chestData2.getMessage()).isEqualTo("Create successfully");
//        assertThat(chestData2.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(4)
//    void getChestByID1(){
//        ChestData chestDataReturn = mediaController.getChestById(chestData1.getChest().getId());
//        assertThat(chestDataReturn.getChest().getName()).isEqualTo(chestData1.getChest().getName());
//        assertThat(chestDataReturn.getChest().getDescription()).isEqualTo(chestData1.getChest().getDescription());
//        assertThat(chestDataReturn.getChest().getLocation()).isEqualTo(chestData1.getChest().getLocation());
//        assertThat(chestDataReturn.getMessage()).isEqualTo("Find chest successfully");
//        assertThat(chestDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(5)
//    void getChestByID2(){
//        ChestData chestDataReturn = mediaController.getChestById(chestData2.getChest().getId());
//        assertThat(chestDataReturn.getChest().getName()).isEqualTo(chestData2.getChest().getName());
//        assertThat(chestDataReturn.getChest().getDescription()).isEqualTo(chestData2.getChest().getDescription());
//        assertThat(chestDataReturn.getChest().getLocation()).isEqualTo(chestData2.getChest().getLocation());
//        assertThat(chestDataReturn.getMessage()).isEqualTo("Find chest successfully");
//        assertThat(chestDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(6)
//    void getChestByID3(){
//        ChestData chestDataReturn = mediaController.getChestById(10000);
//        assertThat(chestDataReturn.getMessage()).isEqualTo("Chest is not found");
//        assertThat(chestDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(7)
//    void editChest1(){
//        ChestUpdateDTO chestUpdateDTO = new ChestUpdateDTO();
//        chestUpdateDTO.setName("Chest 1 Name Edited");
//        chestUpdateDTO.setDescription("Chest 1 Description Edited");
//        chestUpdateDTO.setLocation("Chest 1 Location Edited");
//        chestData1 = mediaController.editChestById(chestData1.getChest().getId(),chestUpdateDTO);
//        assertThat(chestData1.getChest().getName()).isEqualTo(chestUpdateDTO.getName());
//        assertThat(chestData1.getChest().getDescription()).isEqualTo(chestUpdateDTO.getDescription());
//        assertThat(chestData1.getChest().getLocation()).isEqualTo(chestUpdateDTO.getLocation());
//        assertThat(chestData1.getMessage()).isEqualTo("Update chest successfully");
//        assertThat(chestData1.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(8)
//    void editChest2(){
//        ChestUpdateDTO chestUpdateDTO = new ChestUpdateDTO();
//        chestUpdateDTO.setName("Chest 1 Name Edited");
//        chestUpdateDTO.setDescription("Chest 1 Description Edited");
//        chestUpdateDTO.setLocation("Chest 1 Location Edited");
//        chestData2 = mediaController.editChestById(chestData2.getChest().getId(),chestUpdateDTO);
//        assertThat(chestData2.getChest().getName()).isEqualTo(chestUpdateDTO.getName());
//        assertThat(chestData2.getChest().getDescription()).isEqualTo(chestUpdateDTO.getDescription());
//        assertThat(chestData2.getChest().getLocation()).isEqualTo(chestUpdateDTO.getLocation());
//        assertThat(chestData2.getMessage()).isEqualTo("Update chest successfully");
//        assertThat(chestData2.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(9)
//    void editChest3(){
//        ChestUpdateDTO chestUpdateDTO = new ChestUpdateDTO();
//        chestUpdateDTO.setName("Chest 3 Name Edited");
//        chestUpdateDTO.setDescription("Chest 3 Description Edited");
//        chestUpdateDTO.setLocation("Chest 3 Location Edited");
//        ChestData chestDataReturn = mediaController.editChestById(10000,chestUpdateDTO);
//        assertThat(chestDataReturn.getMessage()).isEqualTo("Chest is not exist");
//        assertThat(chestDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(10)
//    void getAllChest2(){
//        ListChests listChests = mediaController.getAllChests();
//        assertThat(listChests.getMessage()).isEqualTo("Get all enable chests successfully");
//        assertThat(listChests.getStatus()).isEqualTo("Success");
//
//        assertThat(listChests.getData().get(0).getId()).isEqualTo(chestData1.getChest().getId());
//        assertThat(listChests.getData().get(0).getName()).isEqualTo(chestData1.getChest().getName());
//        assertThat(listChests.getData().get(0).getDescription()).isEqualTo(chestData1.getChest().getDescription());
//        assertThat(listChests.getData().get(0).getLocation()).isEqualTo(chestData1.getChest().getLocation());
//        assertThat(listChests.getData().get(0).getStatus()).isEqualTo(chestData1.getChest().getStatus());
//
//        assertThat(listChests.getData().get(1).getId()).isEqualTo(chestData2.getChest().getId());
//        assertThat(listChests.getData().get(1).getName()).isEqualTo(chestData2.getChest().getName());
//        assertThat(listChests.getData().get(1).getDescription()).isEqualTo(chestData2.getChest().getDescription());
//        assertThat(listChests.getData().get(1).getLocation()).isEqualTo(chestData2.getChest().getLocation());
//        assertThat(listChests.getData().get(1).getStatus()).isEqualTo(chestData2.getChest().getStatus());
//    }
//
//    @Test
//    @Order(11)
//    void deleteChest1(){
//        chestData1 = mediaController.deleteChestById(chestData1.getChest().getId());
//        assertThat(chestData1.getMessage()).isEqualTo("Delete Chest successfully");
//        assertThat(chestData1.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(12)
//    void deleteChest2(){
//        chestData2 = mediaController.deleteChestById(chestData2.getChest().getId());
//        assertThat(chestData2.getMessage()).isEqualTo("Delete Chest successfully");
//        assertThat(chestData2.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(13)
//    void deleteChest3(){
//        ChestData chestDataReturn = mediaController.deleteChestById(10000);
//        assertThat(chestDataReturn.getMessage()).isEqualTo("Chest is not exist");
//        assertThat(chestDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(14)
//    void getAllChest3(){
//        ListChests listChests = mediaController.getAllChests();
//        assertThat(listChests.getMessage()).isEqualTo("List is empty");
//        assertThat(listChests.getStatus()).isEqualTo("Success");
//    }
//}
