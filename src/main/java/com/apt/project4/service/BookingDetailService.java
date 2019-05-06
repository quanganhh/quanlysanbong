/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.service;

import com.apt.project4.model.BookingDetail;
import com.apt.project4.model.ScPitch;
import com.apt.project4.model.SfDuration;
import com.apt.project4.payload.BookingAddNewRequest;
import com.apt.project4.payload.ScPtichAddNewRequest;
import com.apt.project4.payload.UserRegisteringRequest;
import com.apt.project4.repository.BookingDetailRepository;
import com.apt.project4.repository.TimeDurationRepository;
import com.apt.project4.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
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
public class BookingDetailService {
    private final static Logger LOGGER = LoggerFactory.getLogger(BookingDetailService.class);
    @Autowired
    private BookingDetailRepository bookingDetailRepository;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    public List<BookingDetail> findAllbookingDetailbystt(Date ngay,Integer id_san) {
        return bookingDetailRepository.findByNgayvaSan(ngay, id_san);
    }
    
    public List<BookingDetail> findAllbookingDetailByBookingId(Integer id_booking) {
        return bookingDetailRepository.findByBookingId(id_booking);
    }
    
    public BookingDetail addNewBookingDetail(BookingAddNewRequest requestobj, Integer sf_duration_id){
        BookingDetail bd = new BookingDetail();
        // time duration list
        bd.setBookingDate(requestobj.getBooking_date());
        bd.setBookingId(requestobj.getBooking_id());
        bd.setPrice(requestobj.getDetail_price());
        bd.setSpId(requestobj.getSf_id());
        bd.setSfDurationId(sf_duration_id);
        //BookingDetail bd = objectMapper.convertValue(bkdrequest, BookingDetail.class);
        return bookingDetailRepository.save(bd);
    }
}
