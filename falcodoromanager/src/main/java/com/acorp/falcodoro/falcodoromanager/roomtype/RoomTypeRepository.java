package com.acorp.falcodoro.falcodoromanager.roomtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeModel, Long> {

    @Query("SELECT r from RoomTypeModel r WHERE r.typeName=?1")
    Optional<RoomTypeModel> findByType(String type);
}
