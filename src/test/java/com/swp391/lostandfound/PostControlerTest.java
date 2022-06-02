//package com.swp391.lostandfound;
//
//import com.swp391.lostandfound.DTO.UserAddDTO;
//import com.swp391.lostandfound.DTO.UserUpdateDTO;
//import com.swp391.lostandfound.controller.PostController;
//import com.swp391.lostandfound.controller.UserController;
//import com.swp391.lostandfound.dataFormat.PostData;
//import com.swp391.lostandfound.dataFormat.UserData;
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
//public class PostControlerTest {
//    @Autowired
//    private PostController postController;
//    @Autowired
//    private UserController userController;
//
//    private static UserData userData1;
//    private static UserData userData2;
//
//    private static PostData findPostData;
//    private static PostData lostPostData;
//
//
//    @Test
//    @Order(1)
//    void getAllPost1(){
//        var allPosts = postController.getAllPosts();
//        assertThat(allPosts.getMessage()).isEqualTo("List is empty");
//        assertThat(allPosts.getStatus()).isEqualTo("success");
//    }
//
//    @Test
//    @Order(2)
//    void addUser1(){
//        var userAddDTO = new UserAddDTO();
//        userAddDTO.setFirstName("User 1 First Name");
//        userAddDTO.setLastName("User 1 Last Name");
//        userAddDTO.setBirthday("User 1 Birth Day");
//        userAddDTO.setGender("User 1 Gender");
//        userAddDTO.setStudentCode("User 1 Student Code");
//        userAddDTO.setEmail("User 1 Email");
//        userAddDTO.setPhoneNumber("User 1 Phone Number");
//        userData1 = userController.createUser(userAddDTO);
//        assertThat(userData1.getUser().getFirstName()).isEqualTo(userAddDTO.getFirstName());
//        assertThat(userData1.getUser().getLastName()).isEqualTo(userAddDTO.getLastName());
//        assertThat(userData1.getUser().getBirthday()).isEqualTo(userAddDTO.getBirthday());
//        assertThat(userData1.getUser().getGender()).isEqualTo(userAddDTO.getGender());
//        assertThat(userData1.getUser().getStudentCode()).isEqualTo(userAddDTO.getStudentCode());
//        assertThat(userData1.getUser().getEmail()).isEqualTo(userAddDTO.getEmail());
//        assertThat(userData1.getUser().getPhoneNumber()).isEqualTo(userAddDTO.getPhoneNumber());
//        assertThat(userData1.getMessage()).isEqualTo("Create User Successfully");
//        assertThat(userData1.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(3)
//    void addUser2(){
//        var userAddDTO = new UserAddDTO();
//        userAddDTO.setFirstName("User 2 First Name");
//        userAddDTO.setLastName("User 2 Last Name");
//        userAddDTO.setBirthday("User 2 Birth Day");
//        userAddDTO.setGender("User 2 Gender");
//        userAddDTO.setStudentCode("User 2 Student Code");
//        userAddDTO.setEmail("User 2 Email");
//        userAddDTO.setPhoneNumber("User 2 Phone Number");
//        userData2 = userController.createUser(userAddDTO);
//        assertThat(userData2.getUser().getFirstName()).isEqualTo(userAddDTO.getFirstName());
//        assertThat(userData2.getUser().getLastName()).isEqualTo(userAddDTO.getLastName());
//        assertThat(userData2.getUser().getBirthday()).isEqualTo(userAddDTO.getBirthday());
//        assertThat(userData2.getUser().getGender()).isEqualTo(userAddDTO.getGender());
//        assertThat(userData2.getUser().getStudentCode()).isEqualTo(userAddDTO.getStudentCode());
//        assertThat(userData2.getUser().getEmail()).isEqualTo(userAddDTO.getEmail());
//        assertThat(userData2.getUser().getPhoneNumber()).isEqualTo(userAddDTO.getPhoneNumber());
//        assertThat(userData2.getMessage()).isEqualTo("Create User Successfully");
//        assertThat(userData2.getStatus()).isEqualTo("Success");
//    }
//
//
//
//    @Test
//    @Order(4)
//    void getUserByID1(){
//        var userDataReturn = postController.getUserById(userData1.getUser().getId());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData1.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData1.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData1.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData1.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData1.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData1.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData1.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData1.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User Successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(5)
//    void getUserByID2(){
//        var userDataReturn = postController.getUserById(userData2.getUser().getId());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData2.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData2.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData2.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData2.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData2.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData2.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData2.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData2.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User Successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(6)
//    void getUserByID3(){
//        var chestDataReturn = postController.getUserById(10000);
//        assertThat(chestDataReturn.getMessage()).isEqualTo("User is not exist");
//        assertThat(chestDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(7)
//    void getUserByPhone1(){
//        var userDataReturn = postController.findUserByPhone(userData1.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData1.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData1.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData1.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData1.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData1.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData1.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData1.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData1.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(8)
//    void getUserByPhone2(){
//        var userDataReturn = postController.findUserByPhone(userData2.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData2.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData2.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData2.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData2.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData2.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData2.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData2.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData2.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(9)
//    void getUserByPhone3(){
//        var userDataReturn = postController.findUserByPhone("10000");
//        assertThat(userDataReturn.getMessage()).isEqualTo("User is not exist");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(10)
//    void getUserByEmail1(){
//        var userDataReturn = postController.findUserByEmail(userData1.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData1.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData1.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData1.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData1.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData1.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData1.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData1.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData1.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(11)
//    void getUserByEmail2(){
//        var userDataReturn = postController.findUserByEmail(userData2.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData2.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData2.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData2.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData2.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData2.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData2.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData2.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData2.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(12)
//    void getUserByEmail3(){
//        var userDataReturn = postController.findUserByEmail("10000");
//        assertThat(userDataReturn.getMessage()).isEqualTo("User is not exist");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(13)
//    void getUserByStudentCode1(){
//        var userDataReturn = postController.findUserByStudentCode(userData1.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData1.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData1.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData1.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData1.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData1.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData1.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData1.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData1.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(14)
//    void getUserByStudentCode2(){
//        var userDataReturn = postController.findUserByStudentCode(userData2.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getId()).isEqualTo(userData2.getUser().getId());
//        assertThat(userDataReturn.getUser().getFirstName()).isEqualTo(userData2.getUser().getFirstName());
//        assertThat(userDataReturn.getUser().getLastName()).isEqualTo(userData2.getUser().getLastName());
//        assertThat(userDataReturn.getUser().getBirthday()).isEqualTo(userData2.getUser().getBirthday());
//        assertThat(userDataReturn.getUser().getGender()).isEqualTo(userData2.getUser().getGender());
//        assertThat(userDataReturn.getUser().getStudentCode()).isEqualTo(userData2.getUser().getStudentCode());
//        assertThat(userDataReturn.getUser().getEmail()).isEqualTo(userData2.getUser().getEmail());
//        assertThat(userDataReturn.getUser().getPhoneNumber()).isEqualTo(userData2.getUser().getPhoneNumber());
//        assertThat(userDataReturn.getMessage()).isEqualTo("Find User successfully");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(15)
//    void getUserByStudentCode3(){
//        var userDataReturn = postController.findUserByStudentCode("10000");
//        assertThat(userDataReturn.getMessage()).isEqualTo("User is not exist");
//        assertThat(userDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(16)
//    void editUser1(){
//        var userUpdateDTO = new UserUpdateDTO();
//        userUpdateDTO.setFirstName("User 1 First Name Edited");
//        userUpdateDTO.setLastName("User 1 Last Name Edited");
//        userUpdateDTO.setBirthday("User 1 Birth Day Edited");
//        userUpdateDTO.setGender("User 1 Gender Edited");
//        userUpdateDTO.setStudentCode("User 1 Student Code Edited");
//        userUpdateDTO.setEmail("User 1 Email Edited");
//        userUpdateDTO.setPhoneNumber("User 1 Phone Number Edited");
//        userData1 = postController.updateUser(userData1.getUser().getId(),userUpdateDTO);
//        assertThat(userData1.getUser().getFirstName()).isEqualTo(userUpdateDTO.getFirstName());
//        assertThat(userData1.getUser().getLastName()).isEqualTo(userUpdateDTO.getLastName());
//        assertThat(userData1.getUser().getBirthday()).isEqualTo(userUpdateDTO.getBirthday());
//        assertThat(userData1.getUser().getGender()).isEqualTo(userUpdateDTO.getGender());
//        assertThat(userData1.getUser().getStudentCode()).isEqualTo(userUpdateDTO.getStudentCode());
//        assertThat(userData1.getUser().getEmail()).isEqualTo(userUpdateDTO.getEmail());
//        assertThat(userData1.getUser().getPhoneNumber()).isEqualTo(userUpdateDTO.getPhoneNumber());
//        assertThat(userData1.getMessage()).isEqualTo("Update User Successfully");
//        assertThat(userData1.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(17)
//    void editUser2(){
//        var userUpdateDTO = new UserUpdateDTO();
//        userUpdateDTO.setFirstName("User 2 First Name Edited");
//        userUpdateDTO.setLastName("User 2 Last Name Edited");
//        userUpdateDTO.setBirthday("User 2 Birth Day Edited");
//        userUpdateDTO.setGender("User 2 Gender Edited");
//        userUpdateDTO.setStudentCode("User 2 Student Code Edited");
//        userUpdateDTO.setEmail("User 2 Email Edited");
//        userUpdateDTO.setPhoneNumber("User 2 Phone Number Edited");
//        userData2 = postController.updateUser(userData2.getUser().getId(),userUpdateDTO);
//        assertThat(userData2.getUser().getFirstName()).isEqualTo(userUpdateDTO.getFirstName());
//        assertThat(userData2.getUser().getLastName()).isEqualTo(userUpdateDTO.getLastName());
//        assertThat(userData2.getUser().getBirthday()).isEqualTo(userUpdateDTO.getBirthday());
//        assertThat(userData2.getUser().getGender()).isEqualTo(userUpdateDTO.getGender());
//        assertThat(userData2.getUser().getStudentCode()).isEqualTo(userUpdateDTO.getStudentCode());
//        assertThat(userData2.getUser().getEmail()).isEqualTo(userUpdateDTO.getEmail());
//        assertThat(userData2.getUser().getPhoneNumber()).isEqualTo(userUpdateDTO.getPhoneNumber());
//        assertThat(userData2.getMessage()).isEqualTo("Update User Successfully");
//        assertThat(userData2.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(18)
//    void editUser3(){
//        var userUpdateDTO = new UserUpdateDTO();
//        userUpdateDTO.setFirstName("User 3 First Name Edited");
//        userUpdateDTO.setLastName("User 3 Last Name Edited");
//        userUpdateDTO.setBirthday("User 3 Birth Day Edited");
//        userUpdateDTO.setGender("User 3 Gender Edited");
//        userUpdateDTO.setStudentCode("User 3 Student Code Edited");
//        userUpdateDTO.setEmail("User 3 Email Edited");
//        userUpdateDTO.setPhoneNumber("User 3 Phone Number Edited");
//        var chestDataReturn = postController.updateUser(100000,userUpdateDTO);
//        assertThat(chestDataReturn.getMessage()).isEqualTo("User is not exist");
//        assertThat(chestDataReturn.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(19)
//    void getAllUser2(){
//        var listUsersData = postController.getAllUsers();
//        assertThat(listUsersData.getMessage()).isEqualTo("get all enable users successfully");
//        assertThat(listUsersData.getStatus()).isEqualTo("success");
//
//        assertThat(listUsersData.getData().get(0).getId()).isEqualTo(userData1.getUser().getId());
//        assertThat(listUsersData.getData().get(0).getFirstName()).isEqualTo(userData1.getUser().getFirstName());
//        assertThat(listUsersData.getData().get(0).getLastName()).isEqualTo(userData1.getUser().getLastName());
//        assertThat(listUsersData.getData().get(0).getBirthday()).isEqualTo(userData1.getUser().getBirthday());
//        assertThat(listUsersData.getData().get(0).getGender()).isEqualTo(userData1.getUser().getGender());
//        assertThat(listUsersData.getData().get(0).getStudentCode()).isEqualTo(userData1.getUser().getStudentCode());
//        assertThat(listUsersData.getData().get(0).getEmail()).isEqualTo(userData1.getUser().getEmail());
//        assertThat(listUsersData.getData().get(0).getPhoneNumber()).isEqualTo(userData1.getUser().getPhoneNumber());
//
//        assertThat(listUsersData.getData().get(1).getId()).isEqualTo(userData2.getUser().getId());
//        assertThat(listUsersData.getData().get(1).getFirstName()).isEqualTo(userData2.getUser().getFirstName());
//        assertThat(listUsersData.getData().get(1).getLastName()).isEqualTo(userData2.getUser().getLastName());
//        assertThat(listUsersData.getData().get(1).getBirthday()).isEqualTo(userData2.getUser().getBirthday());
//        assertThat(listUsersData.getData().get(1).getGender()).isEqualTo(userData2.getUser().getGender());
//        assertThat(listUsersData.getData().get(1).getStudentCode()).isEqualTo(userData2.getUser().getStudentCode());
//        assertThat(listUsersData.getData().get(1).getEmail()).isEqualTo(userData2.getUser().getEmail());
//        assertThat(listUsersData.getData().get(1).getPhoneNumber()).isEqualTo(userData2.getUser().getPhoneNumber());
//    }
//
//    @Test
//    @Order(20)
//    void deleteUser1(){
//        userData1 = postController.deleteUserById(userData1.getUser().getId());
//        assertThat(userData1.getMessage()).isEqualTo("Delete User Successfully");
//        assertThat(userData1.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(21)
//    void deleteUser2(){
//        userData2 = postController.deleteUserById(userData2.getUser().getId());
//        assertThat(userData2.getMessage()).isEqualTo("Delete User Successfully");
//        assertThat(userData2.getStatus()).isEqualTo("Success");
//    }
//
//    @Test
//    @Order(22)
//    void deleteUser3(){
//        var userData = postController.deleteUserById(10000);
//        assertThat(userData.getMessage()).isEqualTo("User is not exist");
//        assertThat(userData.getStatus()).isEqualTo("Fail");
//    }
//
//    @Test
//    @Order(23)
//    void getAllChest3(){
//        var listChests = postController.getAllUsers();
//        assertThat(listChests.getMessage()).isEqualTo("List is empty");
//        assertThat(listChests.getStatus()).isEqualTo("success");
//    }
//}
