/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.controller;

import com.apt.project4.constant.MessageKeys;
import com.apt.project4.model.Booking;
import com.apt.project4.model.BookingDetail;
import com.apt.project4.model.SfDuration;
import com.apt.project4.payload.BookingAddNewRequest;
import com.apt.project4.payload.BookingRequest;
import com.apt.project4.payload.DataListResponse;
import com.apt.project4.payload.SingleDataResponse;
import com.apt.project4.service.BookingDetailService;
import com.apt.project4.service.BookingService;
import com.apt.project4.service.TimeDurationService;
import java.util.ArrayList;
import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author toanngo92
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingDetailService bd_sv;
    @Autowired
    private TimeDurationService timedur_sv;
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<Object> getBookingForCheck(@Valid @RequestBody BookingRequest bookingRequest) {
        DataListResponse response = new DataListResponse(bookingService.findAllBookingystt(bookingRequest.getDate1(),bookingRequest.getDate2()));
        return ok(response);
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBooking() {
        DataListResponse response = new DataListResponse(bookingService.findAllBooking());
        return ok(response);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> getBookingByUserId(@Valid @RequestBody BookingRequest bookingRequest) {
        DataListResponse response = new DataListResponse(bookingService.findBookingByUserId(bookingRequest.getUserId()));
        return ok(response);
    }
    
    
    
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    
    public ResponseEntity addNewBooking(@Valid @RequestBody BookingAddNewRequest requestobj){
        System.out.println(requestobj.getBooking_date());
        System.out.println(requestobj.getUser_id());
        
        
        
        Booking bk = bookingService.addNewBooking(requestobj);
        
        Integer booking_id = bk.getId();
        
        Integer[] duration_ids = requestobj.getSf_duration_ids();
        ArrayList sf_duration_ids = new ArrayList(Arrays.asList(duration_ids));	
        
        
        // set booking id for booking detail
        requestobj.setBooking_id(booking_id);
        // loop sf_duration_ids
        
        for (int i = 0; i < sf_duration_ids.size(); i++) {

            Integer sf_duration_id = Integer.parseInt(sf_duration_ids.get(i).toString());
            // get detail price for booking detail
            SfDuration sf_dur = timedur_sv.findById(sf_duration_id);
            Integer detail_price = sf_dur.getPrice();
            requestobj.setDetail_price(detail_price);
            BookingDetail bd_dt = bd_sv.addNewBookingDetail(requestobj, sf_duration_id);
	}  
        
        return ok(new SingleDataResponse<>(MessageKeys.REGISTER_SUCCESS));
    }
}
