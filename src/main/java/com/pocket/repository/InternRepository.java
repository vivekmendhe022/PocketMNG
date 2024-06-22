package com.pocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pocket.entity.Intern;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long>{

}
