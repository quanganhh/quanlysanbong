/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.controller;

import com.apt.project4.constant.MessageKeys;
import com.apt.project4.model.ScPitch;
import com.apt.project4.model.SfDuration;
import com.apt.project4.payload.DataListResponse;
import com.apt.project4.payload.ScPtichAddNewRequest;
import com.apt.project4.payload.SingleDataResponse;
import com.apt.project4.payload.TimeDurationAddNewRequest;
import com.apt.project4.service.TimeDurationService;
import static java.lang.Integer.parseInt;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author toanngo92
 */
@RestController
@RequestMapping("/timedur")
public class TimeDurationController {
    @Autowired
    private TimeDurationService timeDurationService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    
    public ResponseEntity<Object> getAllTimeDuration() {
        DataListResponse response = new DataListResponse(timeDurationService.findAll());
        return ok(response);
    }
    
    // Get time by id
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTimeDurationById(@PathVariable String id) {
        Integer timeId = parseInt(id);
        SingleDataResponse response = new SingleDataResponse(timeDurationService.findById(timeId));
        return ok(response);
    }
    
    //add new 
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addNewTimeDuration(@Valid @RequestBody TimeDurationAddNewRequest timeRequestobj){
        SfDuration time = timeDurationService.addNewTimeDuration(timeRequestobj);
         return ok(new SingleDataResponse<>(MessageKeys.REGISTER_SUCCESS));
    }
    
    //update 
    
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity updateScField(@RequestBody TimeDurationAddNewRequest timeRequestobj){
        SfDuration time = timeDurationService.updateTimeDuration(timeRequestobj);
         return ok(new SingleDataResponse<>(MessageKeys.UPDATE_SUCCESS));
    }
    
    // Delete 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteScField(@PathVariable String id){
        timeDurationService.delete(id);
    }
    
}
