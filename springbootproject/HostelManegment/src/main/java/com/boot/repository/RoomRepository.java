package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.RoomEntity;
import com.boot.payload.RoomDTO;



public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
	
	@Query(value = "select * from room_entity re where re.hid=:hostelId",nativeQuery = true)
	List<RoomEntity>   getAllRoomsByHostelId(@Param("hostelId") int hostelId);
}
