package com.acorp.falcodoro.falcodoromanager.service;

import com.acorp.falcodoro.falcodoromanager.models.BookingModel;
import com.acorp.falcodoro.falcodoromanager.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepository;


    @Transactional
    public void addNewBooking(BookingModel bookingModel) {
        try {
            bookingRepository.save(new BookingModel(
                    bookingModel.getCustomerName(),
                    bookingModel.getCode(),
                    bookingModel.getRoomId(),
                    bookingModel.getNightNumbers(),
                    sdf.format(sdf.parse(bookingModel.getBookingDate())),
                    bookingModel.getSourceBooking(),
                    bookingModel.getDetails(),
                    bookingModel.getPaid(),
                    bookingModel.getDeposit()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void delete(BookingModel bookingModel){
        bookingRepository.deleteById(bookingModel.getBookingId());
    }

    public void deleteById(long id){
        bookingRepository.deleteById(id);
    }

    @Transactional
    public void deleteByCode(String code){
        bookingRepository.deleteByCode(code);
    }

    public List<BookingModel> findByCode(String code) {
        return bookingRepository.findByCode(code);
    }


    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public List<BookingModel> findAll() {
        return bookingRepository.findAll();
    }

    @Transactional
    public void addDay(long bookid, int roomid, String reservationdate, int nights) {
        try {
            Date date = addDays(sdf.parse(reservationdate), nights + 1);

            List<BookingModel> bookingModels = bookingRepository.selectBookingByRoomIdAndDate(roomid, sdf.format(date));

            if(bookingModels.isEmpty()){
                BookingModel retrievedBooking = bookingRepository.getById(bookid);
                retrievedBooking.setNightNumbers(nights + 1);
            }else{
                throw new IllegalStateException("Errore. Non puoi aggiungere notti alla prenotazione");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
