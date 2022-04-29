package com.modulo.spa.controller;

import com.modulo.spa.service.BathService;
import com.modulo.spa.service.model.BathRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.modulo.spa.controller.ControllerConsts.*;

@Controller
@CrossOrigin
@RequestMapping(CONTROLLER_PATH)
public class SpaController {

    @Autowired
    BathService bathService;

    @PostMapping(POST_REGISTER)
    public ResponseEntity<Object> registerBath(@RequestBody BathRequest bathRequest){
    return bathService.register(bathRequest);
    }

    @PutMapping(PARAM_ID)
	public ResponseEntity<Object> updateStatus(@RequestBody BathRequest bathRequest, @PathVariable(name = "id") String id){
        return bathService.updateStatus(bathRequest, id);
    }


    @PutMapping(PUT_ALLERGIES)
    public ResponseEntity<Object> addAllergies(@RequestBody BathRequest bathRequest, @PathVariable(name = "id") String id){
        return bathService.addAllergies(bathRequest,id);
    }

    @PutMapping(PUT_SPECIFICATIONS)
    public ResponseEntity<Object> addSpecifications(@RequestBody BathRequest bathRequest, @PathVariable(name = "id") String id){
        return bathService.addSpecifications(bathRequest, id);
    }

    @PutMapping(PUT_FINDINGS)
    public ResponseEntity<Object> addFindings(@RequestBody BathRequest bathRequest, @PathVariable(name = "id") String id){
        return bathService.addFindings(bathRequest,id);
    }


}
