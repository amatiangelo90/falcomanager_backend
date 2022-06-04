package com.acorp.falcodoro.falcodoromanager.reservation;

import com.acorp.falcodoro.falcodoromanager.room.RoomModel;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "BookingModel")
@Table(name = "BOOKING")
public class BookingModel {

        @Id
        @SequenceGenerator(
                name = "booking_id",
                sequenceName = "booking_id",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "booking_id"
        )
        @Column(
                name = "booking_id",
                updatable = false
        )
        private long bookingId;
        private String customerName;

        @ManyToOne
        private RoomModel roomModel;
        private Date bdate;

        public BookingModel() {}

        public BookingModel(String customerName, RoomModel roomModel, Date bdate) {
                this.customerName = customerName;
                this.roomModel = roomModel;
                this.bdate = bdate;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }

        public RoomModel getRoomModel() {
                return roomModel;
        }

        public void setRoomModel(RoomModel roomModel) {
                this.roomModel = roomModel;
        }

        public Date getBdate() {
                return bdate;
        }

        public void setBdate(Date bdate) {
                this.bdate = bdate;
        }

        public long getBookingId() {
                return bookingId;
        }

        public void setBookingId(long bookingId) {
                this.bookingId = bookingId;
        }
}
