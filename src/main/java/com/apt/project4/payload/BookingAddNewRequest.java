/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.payload;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author toanngo92
 */
public class BookingAddNewRequest {
    
    // booking fields
    
    private Integer user_id;
    
    // booking detail fields
    
    private Integer[] sf_duration_ids;
    private Date booking_date;
    private Integer booking_id;
    private Integer sf_id;
    private Integer detail_price;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public Integer getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Integer booking_id) {
        this.booking_id = booking_id;
    }

    public Integer getSf_id() {
        return sf_id;
    }

    public void setSf_id(Integer sf_id) {
        this.sf_id = sf_id;
    }
    
    public Integer[] getSf_duration_ids() {
        return sf_duration_ids;
    }

    public void setSf_duration_ids(Integer[] sf_duration_ids) {
        this.sf_duration_ids = sf_duration_ids;
    }

    public Integer getDetail_price() {
        return detail_price;
    }

    public void setDetail_price(Integer detail_price) {
        this.detail_price = detail_price;
    }
    

}
