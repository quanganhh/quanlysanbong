/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.controller;

import com.apt.project4.payload.BookingDetailRequest;
import com.apt.project4.payload.DataListResponse;
import com.apt.project4.service.BookingDetailService;
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
@RequestMapping("/bookingdetail")
public class BookingDetailController {
    @Autowired
    private BookingDetailService bookingDetailService;
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> getbookingDetailForCheck(@Valid @RequestBody BookingDetailRequest bookingDetailRequest) {
        DataListResponse response = new DataListResponse(bookingDetailService.findAllbookingDetailbystt(bookingDetailRequest.getBookingdate(),bookingDetailRequest.getSf_id()));
        return ok(response);
    }
    
    @RequestMapping(value = "report", method = RequestMethod.POST)
    public ResponseEntity<Object> getbookingDetailForReport(@Valid @RequestBody BookingDetailRequest bookingDetailRequest) {
        DataListResponse response = new DataListResponse(bookingDetailService.findAllbookingDetailByBookingId(bookingDetailRequest.getBooking_id()));
        return ok(response);
    }
}
