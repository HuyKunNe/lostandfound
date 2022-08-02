package com.swp391.lostandfound.serviceImp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.MediaAddDTO;
import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.DTO.responseDTO.GetPostByIDResponse;
import com.swp391.lostandfound.DTO.responseDTO.LostPostReponseDTO;
import com.swp391.lostandfound.DTO.responseDTO.PostResponseDTO;
import com.swp391.lostandfound.entity.Chest;
import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.entity.Item;
import com.swp391.lostandfound.entity.Media;
import com.swp391.lostandfound.entity.Post;
import com.swp391.lostandfound.entity.User;
import com.swp391.lostandfound.entity.UserActivity;
import com.swp391.lostandfound.repository.ChestItemRepository;
import com.swp391.lostandfound.repository.ChestRepository;
import com.swp391.lostandfound.repository.ItemRepository;
import com.swp391.lostandfound.repository.MediaRepository;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.repository.TypeRepository;
import com.swp391.lostandfound.repository.UserActivityRepository;
import com.swp391.lostandfound.repository.UserRepository;
import com.swp391.lostandfound.service.ChestItemService;
import com.swp391.lostandfound.service.ChestService;
import com.swp391.lostandfound.service.MediaService;
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
    private MediaService mediaService;
    private UserActivityRepository userActivityRepository;
    private ChestService chestService;
    private ChestItemRepository chestItemRepository;
    private ChestRepository chestRepository;
    private ChestItemService chestItemService;

    public PostServiceImp(PostRepository postRepository, UserRepository userRepository,
            MediaRepository mediaRepository, TypeRepository typeRepository, ItemRepository itemRepository,
            MediaService mediaService, UserActivityRepository userActivityRepository, ChestService chestService,
            ChestItemRepository chestItemRepository, ChestItemService chestItemService,
            ChestRepository chestRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mediaRepository = mediaRepository;
        this.typeRepository = typeRepository;
        this.itemRepository = itemRepository;
        this.mediaService = mediaService;
        this.userActivityRepository = userActivityRepository;
        this.chestService = chestService;
        this.chestItemRepository = chestItemRepository;
        this.chestItemService = chestItemService;
        this.chestRepository = chestRepository;

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
    public LostPostReponseDTO addLostPost(PostAddDTO postAddDTO, List<ItemAddDTO> listItemAddDTO, int chestId) {

        Post post = new Post();
        post.setName(postAddDTO.getName());
        post.setDescription(postAddDTO.getDescription());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        post.setDateCreate(dtf.format(now.plusHours(7)));
        post.setLocation(postAddDTO.getLocation());
        post.setType(1);
        post.setStatus(0);

        Chest chestResult = chestRepository.findById(chestId).get();

        if (userRepository.existsById(postAddDTO.getUserId())) {
            post.setUserReturn(userRepository.findById(postAddDTO.getUserId()));
            Post postResult = postRepository.save(post);

            LostPostReponseDTO result = new LostPostReponseDTO();

            if (listItemAddDTO.size() > 0) {
                List<Item> listItem = new ArrayList<>();
                int slot = 1;
                for (ItemAddDTO itemAddDTO : listItemAddDTO) {

                    Item itemDTO = new Item();
                    itemDTO.setDescription(itemAddDTO.getDescription());
                    itemDTO.setLocation(itemAddDTO.getLocation());
                    itemDTO.setName(itemAddDTO.getName());
                    itemDTO.setReceivedDate(dtf.format(now.plusHours(7)));
                    if (typeRepository.existsById(itemAddDTO.getTypeId())) {
                        itemDTO.setType(typeRepository.findById(itemAddDTO.getTypeId()).get());
                        itemDTO.setPost(postResult);
                        Item itemResult = itemRepository.save(itemDTO);

                        chestItemService.addChestItem(chestResult, itemResult, slot);
                        slot++;
                        listItem.add(itemResult);
                    }
                }

                result.setListItem(listItem);
                result.setPost(postResult);

                if (result != null) {
                    UserActivity activity = new UserActivity();
                    activity.setUser(userRepository.findById(postAddDTO.getUserId()));
                    activity.setDate(dtf.format(now.plusHours(7)));
                    activity.setStatus(0);
                    activity.setType(1);
                    activity.setPost(postResult);
                    userActivityRepository.save(activity);
                    chestService.updateStatusById(chestId, 2);

                    return result;
                } else
                    return null;
            } else {
                return null;
            }
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
        post.setDateCreate(dtf.format(now.plusHours(7)));
        post.setType(0);
        post.setStatus(0);
        if (userRepository.existsById(postAddDTO.getUserId())) {
            post.setUserCreate(userRepository.findById(postAddDTO.getUserId()));
            Post postResult = postRepository.save(post);
            User user = userRepository.findById(postAddDTO.getUserId());
            UserActivity activity = new UserActivity();
            activity.setUser(user);
            activity.setDate(dtf.format(now));
            activity.setStatus(0);
            activity.setType(0);
            activity.setPost(postResult);
            userActivityRepository.save(activity);
            return postResult;
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
    public Post confirmFoundedPostByAdmin(int id, int returnUserId, MediaAddDTO media) {
        if (postRepository.existsById(id)) {
            Post post = postRepository.findById(id).get();
            if (userRepository.existsById(returnUserId)) {
                post.setUserReturn(userRepository.findById(returnUserId));
                post.setStatus(1);
                mediaService.addMedia(media);
                Post postResult = postRepository.save(post);
                UserActivity activity = new UserActivity();
                activity.setUser(userRepository.findById(returnUserId));
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                activity.setDate(dtf.format(now.plusHours(7)));
                activity.setStatus(0);
                activity.setType(2);
                activity.setPost(postResult);
                userActivityRepository.save(activity);

                Item item = itemRepository.findFirstItemByPostId(post.getId());
                ChestItem chestItem = chestItemRepository.findChestItemByItem(item);
                chestService.updateStatusById(chestItem.getChest().getId(), 0);

                return postResult;
            } else {
                return null;
            }
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
    public GetPostByIDResponse findPostById(int id) {
        if (postRepository.existsById(id)) {
            Post postOptional = postRepository.findById(id).get();
            GetPostByIDResponse getPostByIDResponse = new GetPostByIDResponse(postOptional);
            System.out.println("ID request "+ id);
            String chestName = chestRepository.getChestNameByPostID(id);
            getPostByIDResponse.setChestName(chestName);

            return getPostByIDResponse;
        } else {
            return null;
        }
    }

    @Override
    public List<PostResponseDTO> getAllPost3DaysBefore() {
        List<Post> list = postRepository.findPostByStatus(0);
        List<Post> listPostResutl = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateCompare = now.minusDays(3);
        for (Post post : list) {
            LocalDateTime postCreateDate = LocalDateTime.parse(post.getDateCreate(), dtf);
            if (postCreateDate.isBefore(dateCompare)) {
                listPostResutl.add(post);
            }
        }
        List<PostResponseDTO> result = new ArrayList<>();
        for (Post post : listPostResutl) {
            Media media = mediaRepository.findFirstMediaByPostId(post.getId());
            result.add(new PostResponseDTO(post, media));
        }

        return result;
    }

}
