/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.repository;

import com.apt.project4.model.Booking;
import com.apt.project4.model.BookingDetail;
import com.apt.project4.model.ScPitch;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author toanngo92
 */
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("SELECT a.id, a.bookingDate, b.firstName, b.lastName, b.phoneNumber FROM Booking a INNER JOIN User b ON a.userId = b.id where a.bookingDate between :date1 and :date2")
    List<Booking> findByBookingDate(Date date1, Date date2);
    
    @Query("SELECT a.id, a.bookingDate, b.firstName, b.lastName, b.phoneNumber FROM Booking a INNER JOIN User b ON a.userId = b.id where a.userId = :uid")
    List<Booking> findByBookingUserId(int uid);
    
    @Query("SELECT a.id, a.bookingDate, b.firstName, b.lastName, b.phoneNumber FROM Booking a INNER JOIN User b ON a.userId = b.id")
    List<Booking> findAllBooking();
}
