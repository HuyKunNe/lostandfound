package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findItemByStatus(int status);

    @Modifying
    @Query("update Item set status = ?1 where id = ?2")
    boolean updateStatusById(int status, int id);
}
