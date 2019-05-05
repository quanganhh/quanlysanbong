/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.repository;

import com.apt.project4.model.SfDuration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author toanngo92
 */
public interface TimeDurationRepository extends JpaRepository<SfDuration, Integer> {
    
}
