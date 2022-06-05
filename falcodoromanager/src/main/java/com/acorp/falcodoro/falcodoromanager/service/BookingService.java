package com.acorp.falcodoro.falcodoromanager.service;

import com.acorp.falcodoro.falcodoromanager.models.BookingModel;
import com.acorp.falcodoro.falcodoromanager.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    public List<BookingModel> retrieveAll() {
        return bookingRepository.findAll();
    }

    public void addNewBooking(BookingModel bookingModel) {
        bookingRepository.save(bookingModel);
    }

//    @Transactional
//    public void update(BookingModel bookingModel){
//        bookingRepository.update();
//    }

    public void delete(BookingModel bookingModel){
        bookingRepository.delete(bookingModel);
    }

    public void deleteById(long id){
        bookingRepository.deleteById(id);
    }
}
