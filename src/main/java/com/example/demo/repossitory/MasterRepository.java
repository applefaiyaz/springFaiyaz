package com.example.demo.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.master.Entity;


public interface MasterRepository extends JpaRepository<Entity, Integer> {
	

}
