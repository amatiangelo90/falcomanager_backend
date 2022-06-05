package com.acorp.falcodoro.falcodoromanager.controller;

import com.acorp.falcodoro.falcodoromanager.models.BookingModel;
import com.acorp.falcodoro.falcodoromanager.service.BookingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
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
    public void save(BookingModel bookingModel) { bookingService.addNewBooking(bookingModel); }
    @DeleteMapping(path = "/delete")
    public void delete(BookingModel bookingModel){
        bookingService.delete(bookingModel);
    }

    @GetMapping(path = "/deletebyid/{id}")
    public void deleteRoomTypeById(@PathVariable("id") long id){
        bookingService.deleteById(id);
    }
}
