package com.joange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joange.model.People;

@Repository
@Transactional
public interface PeopleRepository extends JpaRepository<People, Long>{

}