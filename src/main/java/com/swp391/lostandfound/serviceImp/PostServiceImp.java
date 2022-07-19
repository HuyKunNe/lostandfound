package com.swp391.lostandfound.serviceImp;

import java.util.ArrayList;
import java.util.List;

import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.DTO.responseDTO.IPostReponseDTO;
import com.swp391.lostandfound.DTO.responseDTO.PostResponseDTO;
import com.swp391.lostandfound.entity.Media;
import com.swp391.lostandfound.entity.Post;
import com.swp391.lostandfound.repository.MediaRepository;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.repository.UserRepository;
import com.swp391.lostandfound.service.PostService;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

    // type = 0 -> lost post
    // type = 1 -> find post
    // status = 0 -> not found
    // status = 1 -> found
    // status = 2 -> is delete

    private PostRepository postRepository;
    private UserRepository userRepository;
    private MediaRepository mediaRepository;

    public PostServiceImp(PostRepository postRepository, UserRepository userRepository,
            MediaRepository mediaRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mediaRepository = mediaRepository;
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        List<IPostReponseDTO> list = postRepository.getAllPostByStatusLessThan(2);
        List<PostResponseDTO> result = new ArrayList<>();
        for (IPostReponseDTO post : list) {
            Post dto = new Post();
            dto.setId(post.getId());
            dto.setDescription(post.getDescription());
            dto.setLocation(post.getLocation());
            dto.setType(post.getType());
            dto.setStatus(post.getStatus());
            if (post.getCreateUserID() != null) {
                dto.setUserCreate(userRepository.findById(post.getCreateUserID()).get());
            }
            if (post.getReturnUserID() != null) {
                dto.setUserReturn(userRepository.findById(post.getReturnUserID()).get());
            }
            dto.setName(post.getName());
            Media media = mediaRepository.findById(post.getPostId()).get();
            result.add(new PostResponseDTO(dto, media));
        }
        return result;
    }

    @Override
    public boolean deletePostById(int id) {
        if (postRepository.existsById(id)) {
            postRepository.UpdateStatusById(2, id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<PostResponseDTO> getAllConfirmedPosts() {
        List<IPostReponseDTO> list = postRepository.getAllPostByStatus(1);
        List<PostResponseDTO> result = new ArrayList<>();
        for (IPostReponseDTO post : list) {
            Post dto = new Post();
            dto.setId(post.getId());
            dto.setDescription(post.getDescription());
            dto.setLocation(post.getLocation());
            dto.setType(post.getType());
            dto.setStatus(post.getStatus());
            if (post.getCreateUserID() != null) {
                dto.setUserCreate(userRepository.findById(post.getCreateUserID()).get());
            }
            if (post.getReturnUserID() != null) {
                dto.setUserReturn(userRepository.findById(post.getReturnUserID()).get());
            }
            dto.setName(post.getName());
            Media media = mediaRepository.findById(post.getPostId()).get();
            result.add(new PostResponseDTO(dto, media));
        }
        return result;
    }

    public List<PostResponseDTO> getAllLostPosts() {
        List<IPostReponseDTO> list = postRepository.getAllPostByTypeWithMedia(0, 0);
        List<PostResponseDTO> result = new ArrayList<>();
        for (IPostReponseDTO post : list) {
            Post dto = new Post();
            dto.setId(post.getId());
            dto.setDescription(post.getDescription());
            dto.setLocation(post.getLocation());
            dto.setType(post.getType());
            dto.setStatus(post.getStatus());
            if (post.getCreateUserID() != null) {
                dto.setUserCreate(userRepository.findById(post.getCreateUserID()).get());
            }
            if (post.getReturnUserID() != null) {
                dto.setUserReturn(userRepository.findById(post.getReturnUserID()).get());
            }
            dto.setName(post.getName());
            Media media = mediaRepository.findById(post.getPostId()).get();
            result.add(new PostResponseDTO(dto, media));
        }
        return result;
    }

    @Override
    public List<PostResponseDTO> getAllFindPost() {
        List<IPostReponseDTO> list = postRepository.getAllPostByTypeWithMedia(1, 0);
        List<PostResponseDTO> result = new ArrayList<>();
        for (IPostReponseDTO post : list) {
            Post dto = new Post();
            dto.setId(post.getId());
            dto.setDescription(post.getDescription());
            dto.setLocation(post.getLocation());
            dto.setType(post.getType());
            dto.setStatus(post.getStatus());
            if (post.getCreateUserID() != null) {
                dto.setUserCreate(userRepository.findById(post.getCreateUserID()).get());
            }
            if (post.getReturnUserID() != null) {
                dto.setUserReturn(userRepository.findById(post.getReturnUserID()).get());
            }
            dto.setName(post.getName());
            Media media = mediaRepository.findById(post.getPostId()).get();
            result.add(new PostResponseDTO(dto, media));
        }
        return result;
    }

    @Override
    public List<PostResponseDTO> getALLNotConfirmedPosts() {
        List<IPostReponseDTO> list = postRepository.getAllPostByStatus(0);
        List<PostResponseDTO> result = new ArrayList<>();
        for (IPostReponseDTO post : list) {
            Post dto = new Post();
            dto.setId(post.getId());
            dto.setDescription(post.getDescription());
            dto.setLocation(post.getLocation());
            dto.setType(post.getType());
            dto.setStatus(post.getStatus());
            if (post.getCreateUserID() != null) {
                dto.setUserCreate(userRepository.findById(post.getCreateUserID()).get());
            }
            if (post.getReturnUserID() != null) {
                dto.setUserReturn(userRepository.findById(post.getReturnUserID()).get());
            }
            dto.setName(post.getName());
            Media media = mediaRepository.findById(post.getPostId()).get();
            result.add(new PostResponseDTO(dto, media));
        }
        return result;
    }

    @Override
    public Post addLostPost(PostAddDTO postAddDTO) {
        Post post = new Post();
        post.setName(postAddDTO.getName());
        post.setDescription(postAddDTO.getDescription());
        post.setLocation(postAddDTO.getLocation());
        post.setType(1);
        post.setStatus(0);
        if (userRepository.existsById(postAddDTO.getUserId())) {
            post.setUserReturn(userRepository.findById(postAddDTO.getUserId()));
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post addFindPost(PostAddDTO postAddDTO) {
        Post post = new Post();
        post.setName(postAddDTO.getName());
        post.setDescription(postAddDTO.getDescription());
        post.setLocation(postAddDTO.getLocation());
        post.setType(0);
        post.setStatus(0);
        if (userRepository.existsById(postAddDTO.getUserId())) {
            post.setUserCreate(userRepository.findById(postAddDTO.getUserId()));
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post updatePostByUser(int id, PostUpdateByUserDTO postUpdateDTO) {
        if (postRepository.existsById(id)) {
            Post post = postRepository.findById(id).get();
            post.setName(postUpdateDTO.getName());
            post.setDescription(postUpdateDTO.getDescription());
            post.setLocation(postUpdateDTO.getLocation());
            post.setStatus(postUpdateDTO.getStatus());
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post confirmFoundedPostByAdmin(int id, int returnUserId) {
        if (postRepository.existsById(id)) {
            Post post = postRepository.findById(id).get();
            post.setUserReturn(userRepository.findById(returnUserId));
            post.setStatus(1);
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post confirmFoundedPostByLostUser(int id, int lostUserId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Post findPostById(int id) {
        if (postRepository.existsById(id)) {
            return postRepository.findById(id).get();
        } else {
            return null;
        }
    }

}
