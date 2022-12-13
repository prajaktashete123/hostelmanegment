package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.AllocatedRoomEntity;



public interface AllocatedRoomRepository extends JpaRepository<AllocatedRoomEntity,Integer>  {

}
