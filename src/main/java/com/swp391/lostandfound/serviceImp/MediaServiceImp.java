package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.MediaAddDTO;
import com.swp391.lostandfound.DTO.MediaUpdateDTO;
import com.swp391.lostandfound.entity.Media;
import com.swp391.lostandfound.entity.Post;
import com.swp391.lostandfound.repository.MediaRepository;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.service.MediaService;

import org.springframework.stereotype.Service;

@Service
public class MediaServiceImp implements MediaService {

    private MediaRepository mediaRepository;
    private PostRepository postRepository;

    public MediaServiceImp(MediaRepository mediaRepository, PostRepository postRepository) {
        this.mediaRepository = mediaRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Media> getAllMedias() {
        return mediaRepository.findMediaByStatus(0);
    }

    @Override
    public Media addMedia(MediaAddDTO mediaAddDTO) {
        Media media = new Media();
        media.setLink(mediaAddDTO.getLink());
        media.setStatus(0);
        if (postRepository.existsById(mediaAddDTO.getPostId())) {
            Post post = postRepository.findById(mediaAddDTO.getPostId()).get();
            media.setPost(post);
            return mediaRepository.save(media);
        } else {
            return null;
        }
    }

    @Override
    public Media updateMedia(int id, MediaUpdateDTO mediaUpdateDTO) {
        if (mediaRepository.existsById(id)) {
            Media media = mediaRepository.findById(id).get();
            media.setLink(mediaUpdateDTO.getLink());
            media.setStatus(mediaUpdateDTO.getStatus());
            if (postRepository.existsById(mediaUpdateDTO.getPostId())) {
                Post post = postRepository.findById(mediaUpdateDTO.getPostId()).get();
                media.setPost(post);
                return mediaRepository.save(media);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Media findMediaById(int id) {
        if (mediaRepository.existsById(id)) {
            return mediaRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean deleteMediaById(int id) {
        if (mediaRepository.existsById(id)) {
            mediaRepository.updateStatusById(1, id);
            return true;
        }
        return false;
    }

}
