package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.entity.Chest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChestRepository extends JpaRepository<Chest, Integer> {
    boolean existsById(int id);

    List<Chest> findChestByStatus(int status);

    @Modifying
    @Query("update Chest c set c.status=?1 where c.id=?2")
    void setFixedStatusFor(int status, int id);
}
