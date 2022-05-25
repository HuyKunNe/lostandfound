package com.swp391.lostandfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import aj.org.objectweb.asm.Type;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Integer> {

}
