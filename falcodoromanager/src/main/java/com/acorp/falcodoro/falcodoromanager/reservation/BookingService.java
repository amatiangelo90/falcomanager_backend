package com.acorp.falcodoro.falcodoromanager.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


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
