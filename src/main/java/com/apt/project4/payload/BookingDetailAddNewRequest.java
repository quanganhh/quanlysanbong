/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.payload;

import static com.apt.project4.constant.MessageKeys.REQUIRED_MSG;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author toanngo92
 */
public class BookingDetailAddNewRequest {
    @NotBlank(message = REQUIRED_MSG)
    
    private String sf_duration_id;
    private String booking_date;
    private String booking_id;
    private String sf_id;
    private String status;
    
    public String getSf_duration_id() {
        return sf_duration_id;
    }

    public void setSf_duration_id(String sf_duration_id) {
        this.sf_duration_id = sf_duration_id;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getSf_id() {
        return sf_id;
    }

    public void setSf_id(String sf_id) {
        this.sf_id = sf_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
