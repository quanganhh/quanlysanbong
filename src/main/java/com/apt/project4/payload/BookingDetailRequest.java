/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.payload;

import java.util.Date;

/**
 *
 * @author toanngo92
 */
public class BookingDetailRequest {
    private Integer sf_id;
    private Date bookingdate;

    public Integer getSf_id() {
        return sf_id;
    }

    public void setSf_id(Integer sf_id) {
        this.sf_id = sf_id;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }
    
}
