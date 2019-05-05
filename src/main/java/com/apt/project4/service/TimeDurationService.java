/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.service;

import com.apt.project4.model.ScPitch;
import com.apt.project4.model.SfDuration;
import com.apt.project4.payload.ScPtichAddNewRequest;
import com.apt.project4.payload.TimeDurationAddNewRequest;
import com.apt.project4.repository.TimeDurationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.lang.Integer.parseInt;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author toanngo92
 */

@Service
@Transactional
public class TimeDurationService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ScPitchService.class);
    @Autowired
    private TimeDurationRepository timeDurationRepository;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    
    public List<SfDuration> findAll() {
        return timeDurationRepository.findAll();
    } 
    
    public SfDuration findById(Integer sfDuration_Id){
        return timeDurationRepository.findById(sfDuration_Id).orElse(null);
    }
    
    public SfDuration addNewTimeDuration(TimeDurationAddNewRequest timeRequest){
        SfDuration sp = objectMapper.convertValue(timeRequest, SfDuration.class);
        return timeDurationRepository.save(sp);
    }
    
    public SfDuration updateTimeDuration(TimeDurationAddNewRequest timeRequest){
        SfDuration time_update = timeDurationRepository.getOne(parseInt(timeRequest.getId()));
        SfDuration sp = objectMapper.convertValue(timeRequest, SfDuration.class);
        return timeDurationRepository.save(sp);
    }
    
    public void delete(String id){
        SfDuration sf_delete = timeDurationRepository.getOne(parseInt(id));
        timeDurationRepository.delete(sf_delete);
    }
    
}
