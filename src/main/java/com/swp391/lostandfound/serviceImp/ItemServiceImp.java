package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.ItemUpdateDTO;
import com.swp391.lostandfound.entity.Item;
import com.swp391.lostandfound.repository.ItemRepository;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.repository.TypeRepository;
import com.swp391.lostandfound.service.ItemService;

import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemService {

    private ItemRepository itemRepository;
    private PostRepository postRepository;
    private TypeRepository typeRepository;

    public ItemServiceImp(ItemRepository itemRepository, PostRepository postRepository, TypeRepository typeRepository) {
        this.itemRepository = itemRepository;
        this.postRepository = postRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findItemByStatus(0);
    }

    @Override
    public Item updateItem(int id, ItemUpdateDTO itemUpdateDTO) {
        if (itemRepository.existsById(id)) {
            Item item = itemRepository.findById(id).get();
            item.setName(itemUpdateDTO.getName());
            item.setDescription(itemUpdateDTO.getDescription());
            item.setLocation(itemUpdateDTO.getLocation());
            item.setStatus(itemUpdateDTO.getStatus());
            item.setReceivedDate(itemUpdateDTO.getReceivedDate());
            item.setReturnedDate(itemUpdateDTO.getReturnedDate());
            if (postRepository.existsById(itemUpdateDTO.getPostId())) {
                item.setPost(postRepository.findById(itemUpdateDTO.getPostId()).get());
                if (typeRepository.existsById(itemUpdateDTO.getTypeId())) {
                    item.setType(typeRepository.findById(itemUpdateDTO.getTypeId()).get());
                    return itemRepository.save(item);
                } else
                    return null;
            } else
                return null;
        } else {
            return null;
        }
    }

    @Override
    public Item findItemById(int id) {
        if (itemRepository.existsById(id)) {
            return itemRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteItemById(int id) {
        if (itemRepository.existsById(id)) {
            return itemRepository.updateStatusById(1, id);
        } else {
            return false;
        }
    }

}
