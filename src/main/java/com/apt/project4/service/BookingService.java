/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.service;

import com.apt.project4.model.Booking;
import com.apt.project4.model.ScPitch;
import com.apt.project4.payload.BookingAddNewRequest;
import com.apt.project4.payload.ScPtichAddNewRequest;
import com.apt.project4.payload.UserRegisteringRequest;
import com.apt.project4.repository.BookingDetailRepository;
import com.apt.project4.repository.BookingRepository;
import com.apt.project4.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.lang.Integer.parseInt;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author toanngo92
 */

@Service
@Transactional
public class BookingService {
    private final static Logger LOGGER = LoggerFactory.getLogger(BookingService.class);
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    public List<Booking> findAllBookingystt(Date date1,Date date2) {
        return bookingRepository.findByBookingDate(date1, date2);
    }
    
    public List<Booking> findBookingByUserId(int uid) {
        return bookingRepository.findByBookingUserId(uid);
    }
    
    public List<Booking> findAllBooking() {
        return bookingRepository.findAllBooking();
    }
    
    public Booking addNewBooking(BookingAddNewRequest bkrequest){
        Booking booking = new Booking();
        booking.setBookingDate(bkrequest.getBooking_date());
        booking.setUserId(bkrequest.getUser_id());
        //booking.setTotalPrice(bkrequest.getTotal_price());
        //Booking booking = objectMapper.convertValue(bkrequest, Booking.class);
        return bookingRepository.save(booking);
    }
    
}
