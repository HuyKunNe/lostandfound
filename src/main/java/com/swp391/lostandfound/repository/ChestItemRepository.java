package com.swp391.lostandfound.repository;

import com.swp391.lostandfound.entity.ChestItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChestItemRepository extends JpaRepository<ChestItem, Integer> {

}
