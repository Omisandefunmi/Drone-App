package com.olufunmi.drone.controller;

import com.olufunmi.drone.dto.request.LoadDroneRequest;
import com.olufunmi.drone.dto.response.*;
import com.olufunmi.drone.dto.request.DroneRegistrationRequest;
import com.olufunmi.drone.exceptions.DroneException;
import com.olufunmi.drone.model.Drone;
import com.olufunmi.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drone")
public class DroneController {
    @Autowired
    private  DroneService droneService;



    @PostMapping("/register")
    public ResponseEntity<?> registerDrone(@RequestBody DroneRegistrationRequest droneRegistrationRequest) throws DroneException {
        DroneResponse droneResponse = droneService.registerDrone(droneRegistrationRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(200)
                .data(droneResponse)
                .successful(true)
                .build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PostMapping("/load")
    public  ResponseEntity<?>loadDroneWithMedication(@RequestBody LoadDroneRequest loadDroneRequest) throws DroneException {
        LoadDroneResponse loadDroneResponse = droneService.loadDrone(loadDroneRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(200)
                .data(loadDroneResponse)
                .successful(true)
                .build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @GetMapping("/view")
    public ResponseEntity <?> checkLoadedMedications(@RequestParam String serialNumber) throws DroneException {
        List<MedicationResponse> response = droneService.checkLoadedMedications(serialNumber);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(302)
                .data(response)
                .successful(true)
                .build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.FOUND);

    }

    @GetMapping("/view_available")
    public ResponseEntity <?> viewAvailableDrone(){
        List<DroneResponse> response = droneService.viewAvailableDrone();
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(302)
                .data(response)
                .successful(true)
                .build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.FOUND);

    }

    @GetMapping("/battery")
    public ResponseEntity<?> batteryCheck(@RequestParam String serialNumber) throws DroneException {
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(302)
                .data(droneService.batteryCheck(serialNumber))
                .successful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.FOUND);
    }

}