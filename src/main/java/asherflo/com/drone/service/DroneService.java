package asherflo.com.drone.service;

import asherflo.com.drone.dto.response.AvailableDroneResponse;
import asherflo.com.drone.dto.response.LoadDroneResponse;
import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.response.DroneResponse;
import asherflo.com.drone.dto.request.LoadDroneRequest;
import asherflo.com.drone.dto.response.MedicationResponse;
import asherflo.com.drone.exceptions.DroneException;
import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.Medication;

import java.util.List;

public interface DroneService {
    DroneResponse registerDrone (DroneRegistrationRequest droneRegistrationRequest) throws DroneException;
    LoadDroneResponse loadDrone(LoadDroneRequest loadRequest) throws DroneException;

    List <MedicationResponse> checkLoadedMedications(String serialNumber) throws DroneException;
}




