package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.MediaAddDTO;
import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.DTO.responseDTO.GetPostByIDResponse;
import com.swp391.lostandfound.DTO.responseDTO.LostPostReponseDTO;
import com.swp391.lostandfound.DTO.responseDTO.PostResponseDTO;
import com.swp391.lostandfound.entity.Post;

public interface PostService {
    List<PostResponseDTO> getAllPosts();

    LostPostReponseDTO addLostPost(PostAddDTO postAddDTO, List<ItemAddDTO> itemAddDTO, int chestId);

    Post addFindPost(PostAddDTO postAddDTO);

    Post updatePostByUser(int id, PostUpdateByUserDTO postUpdateDTO);

    Post confirmFoundedPostByAdmin(int id, int returnUserId, MediaAddDTO media);

    GetPostByIDResponse findPostById(int id);

    boolean deletePostById(int id);

    List<PostResponseDTO> getAllLostPosts();

    List<PostResponseDTO> getAllFindPost();

    List<PostResponseDTO> getALLNotConfirmedPosts();

    List<PostResponseDTO> getAllConfirmedPosts();

    List<PostResponseDTO> getAllPost3DaysBefore();

    Post confirmFoundedPostByLostUser(int id, int lostUserId);
}
