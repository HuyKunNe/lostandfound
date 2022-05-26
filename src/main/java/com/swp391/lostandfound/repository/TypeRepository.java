package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.entity.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Integer> {

    List<Type> findTypeByStatus(int status);

    @Modifying
    @Query("update Type set status =?1 where id = ?2")
    void setFixedStatusFor(int status, int id);
}
