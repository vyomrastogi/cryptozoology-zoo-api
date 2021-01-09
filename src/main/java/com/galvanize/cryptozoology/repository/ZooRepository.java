package com.galvanize.cryptozoology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galvanize.cryptozoology.model.Animal;

@Repository
public interface ZooRepository extends JpaRepository<Animal, String>{

}
