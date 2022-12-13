package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.boot.entity.WardenEntity;

public interface WardenRepository extends JpaRepository<WardenEntity, Integer> {

}
