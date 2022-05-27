package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.entity.Media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {

    List<Media> findMediaByStatus(int status);

    @Transactional
    @Modifying
    @Query("update Media set Status = ?1 where Id = ?2")
    Media updateStatusById(Integer status, Integer id);
}
