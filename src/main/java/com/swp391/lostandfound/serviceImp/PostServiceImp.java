package com.swp391.lostandfound.serviceImp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.DTO.responseDTO.LostPostReponseDTO;
import com.swp391.lostandfound.DTO.responseDTO.PostResponseDTO;
import com.swp391.lostandfound.entity.Item;
import com.swp391.lostandfound.entity.Media;
import com.swp391.lostandfound.entity.Post;
import com.swp391.lostandfound.repository.ItemRepository;
import com.swp391.lostandfound.repository.MediaRepository;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.repository.TypeRepository;
import com.swp391.lostandfound.repository.UserRepository;
import com.swp391.lostandfound.service.PostService;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

    // type = 1 -> lost post
    // type = 0 -> find post
    // status = 0 -> not found
    // status = 1 -> found
    // status = 2 -> is delete

    private PostRepository postRepository;
    private UserRepository userRepository;
    private MediaRepository mediaRepository;
    private TypeRepository typeRepository;
    private ItemRepository itemRepository;

    public PostServiceImp(PostRepository postRepository, UserRepository userRepository,
            MediaRepository mediaRepository, TypeRepository typeRepository, ItemRepository itemRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mediaRepository = mediaRepository;
        this.typeRepository = typeRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        List<Post> list = postRepository.findPostByStatusLessThan(2);
        List<PostResponseDTO> result = new ArrayList<>();
        for (Post post : list) {
            Media media = mediaRepository.findFirstMediaByPostId(post.getId());
            result.add(new PostResponseDTO(post, media));
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
        List<Post> list = postRepository.findPostByStatus(1);
        List<PostResponseDTO> result = new ArrayList<>();
        for (Post post : list) {
            Media media = mediaRepository.findFirstMediaByPostId(post.getId());
            result.add(new PostResponseDTO(post, media));
        }
        return result;
    }

    public List<PostResponseDTO> getAllLostPosts() {
        List<Post> list = postRepository.findPostByTypeAndStatus(1, 0);
        List<PostResponseDTO> result = new ArrayList<>();
        for (Post post : list) {
            Media media = mediaRepository.findFirstMediaByPostId(post.getId());
            result.add(new PostResponseDTO(post, media));
        }
        return result;
    }

    @Override
    public List<PostResponseDTO> getAllFindPost() {
        List<Post> list = postRepository.findPostByTypeAndStatus(0, 0);
        List<PostResponseDTO> result = new ArrayList<>();
        for (Post post : list) {
            Media media = mediaRepository.findFirstMediaByPostId(post.getId());
            result.add(new PostResponseDTO(post, media));
        }
        return result;
    }

    @Override
    public List<PostResponseDTO> getALLNotConfirmedPosts() {
        List<Post> list = postRepository.findPostByStatus(0);
        List<PostResponseDTO> result = new ArrayList<>();
        for (Post post : list) {
            Media media = mediaRepository.findFirstMediaByPostId(post.getId());
            result.add(new PostResponseDTO(post, media));
        }
        return result;
    }

    @Override
    public LostPostReponseDTO addLostPost(PostAddDTO postAddDTO, ItemAddDTO itemAddDTO) {
        Post post = new Post();
        post.setName(postAddDTO.getName());
        post.setDescription(postAddDTO.getDescription());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        post.setDateCreate(dtf.format(now));
        post.setLocation(postAddDTO.getLocation());
        post.setType(1);
        post.setStatus(0);

        if (userRepository.existsById(postAddDTO.getUserId())) {
            post.setUserReturn(userRepository.findById(postAddDTO.getUserId()));
            Post postResult = postRepository.save(post);

            Item itemDTO = new Item();
            itemDTO.setDescription(itemAddDTO.getDescription());
            itemDTO.setLocation(itemAddDTO.getLocation());
            itemDTO.setName(itemAddDTO.getName());
            itemDTO.setReceivedDate(dtf.format(now));
            if (typeRepository.existsById(itemAddDTO.getTypeId())) {
                itemDTO.setType(typeRepository.findById(itemAddDTO.getTypeId()).get());
                itemDTO.setPost(postResult);
                Item itemResult = itemRepository.save(itemDTO);
                return new LostPostReponseDTO(postResult, itemResult);
            } else
                return null;
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        post.setDateCreate(dtf.format(now));
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
