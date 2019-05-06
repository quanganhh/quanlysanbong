/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.repository;
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
public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer> {
    @Query("select a from BookingDetail a where a.bookingDate = :ngay and a.spId =:id_san")
    List<BookingDetail> findByNgayvaSan(Date ngay, Integer id_san);
    
    @Query("select a.id, b.name, c.name, a.bookingDate, a.price, a.status from BookingDetail a inner join SfDuration b ON a.sfDurationId = b.id inner join ScPitch c ON a.spId = c.id where a.bookingId = :id_booking")
    List<BookingDetail> findByBookingId(Integer id_booking);
}
