package com.acorp.falcodoro.falcodoromanager.repository;

import com.acorp.falcodoro.falcodoromanager.models.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {
}
