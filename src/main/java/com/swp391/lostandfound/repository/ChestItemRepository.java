package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChestItemRepository extends JpaRepository<ChestItem, Integer> {

    List<ChestItem> findChestItemByStatus(int status);

    @Modifying
    @Query("update ChestItem set Status = ?1 where Id = ?2")
    boolean updateStatusById(Integer status, Integer id);

    ChestItem findChestItemByItem(Item item);
}
