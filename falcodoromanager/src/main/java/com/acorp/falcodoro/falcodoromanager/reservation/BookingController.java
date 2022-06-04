package com.acorp.falcodoro.falcodoromanager.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(path = "/findall")
    public List<BookingModel> retrieveAll(){
        return bookingService.retrieveAll();
    }

    @PostMapping(path = "/save")
    public void save(BookingModel bookingModel){
        bookingService.addNewBooking(bookingModel);

    }

    @DeleteMapping(path = "/delete")
    public void delete(BookingModel bookingModel){
        bookingService.delete(bookingModel);
    }

    @GetMapping(path = "/deletebyid/{id}")
    public void deleteRoomTypeById(@PathVariable("id") long id){
        bookingService.deleteById(id);
    }
}
