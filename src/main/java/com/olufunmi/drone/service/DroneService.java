package com.olufunmi.drone.service;

import com.olufunmi.drone.dto.response.BatteryResponse;
import com.olufunmi.drone.dto.response.LoadDroneResponse;
import com.olufunmi.drone.dto.request.DroneRegistrationRequest;
import com.olufunmi.drone.dto.response.DroneResponse;
import com.olufunmi.drone.dto.request.LoadDroneRequest;
import com.olufunmi.drone.dto.response.MedicationResponse;
import com.olufunmi.drone.exceptions.DroneException;
import com.olufunmi.drone.model.Drone;

import java.util.List;

public interface DroneService {
    DroneResponse registerDrone (DroneRegistrationRequest droneRegistrationRequest) throws DroneException;
    LoadDroneResponse loadDrone(LoadDroneRequest loadRequest) throws DroneException;

    List <MedicationResponse> checkLoadedMedications(String serialNumber) throws DroneException;
    List<DroneResponse> viewAvailableDrone();
    BatteryResponse batteryCheck(String serialNumber) throws DroneException;
}




