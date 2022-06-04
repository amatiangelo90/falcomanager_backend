package com.acorp.falcodoro.falcodoromanager.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {
    @Query("SELECT room FROM RoomModel room WHERE room.roomNumber = ?1")
    Optional<RoomModel> findByRoomNumber(long roomId);
}
