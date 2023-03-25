package com.olufunmi.drone.service;

import com.olufunmi.drone.dto.request.AddMedicationRequest;
import com.olufunmi.drone.dto.request.DroneRegistrationRequest;
import com.olufunmi.drone.dto.request.LoadDroneRequest;
import com.olufunmi.drone.dto.response.BatteryResponse;
import com.olufunmi.drone.exceptions.DroneException;
import com.olufunmi.drone.exceptions.LowBatteryException;
import com.olufunmi.drone.model.Drone;
import com.olufunmi.drone.model.Medication;
import com.olufunmi.drone.model.enums.DroneState;
import com.olufunmi.drone.repository.DroneRepository;
import com.olufunmi.drone.dto.response.DroneResponse;
import com.olufunmi.drone.dto.response.LoadDroneResponse;
import com.olufunmi.drone.dto.response.MedicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService{

    private final DroneRepository droneRepository;
    private final MedicationService medicationService;
    @Override
    public DroneResponse registerDrone(DroneRegistrationRequest droneRegistrationRequest) throws DroneException {
        Optional<Drone> exists = droneRepository.findBySerialNumber(droneRegistrationRequest.getSerialNumber());
        if(exists.isPresent()){
            throw new DroneException("Drone specified already exists");
        }

        Drone drone = Drone.builder()
                .droneState(DroneState.IDLE)
                .batteryLevel(droneRegistrationRequest.getBatteryLevel())
                .serialNumber(droneRegistrationRequest.getSerialNumber())
                .droneModel(droneRegistrationRequest.getDroneModel())
                .batteryLevel(80.0)
                .build();
        Drone savedDrone = droneRepository.save(drone);

        return buildDroneResponse(savedDrone);
    }

    @Override
    public LoadDroneResponse loadDrone(LoadDroneRequest loadRequest) throws DroneException {
        Optional <Drone> savedDrone = droneRepository.findBySerialNumber(loadRequest.getSerialNumber());
        if (savedDrone.isEmpty()) {
            throw new DroneException("Drone specified does not exist");
        }
        Drone drone = savedDrone.get();
        if (drone.cumulateLoadedWeight() >= drone.getWEIGHTLIMIT() || (drone.cumulateLoadedWeight() + loadRequest.getWeight()) > drone.getWEIGHTLIMIT()) {
            throw new DroneException("The Drone cannot load more than the weight limit");
        }
        if(drone.getBatteryLevel() < 25.0){
            throw new LowBatteryException("""
                    Drone battery is below 25
                    
                    Drone's battery too low for loading or flight
                    """);
        }
        AddMedicationRequest request = buildMedicalRequest(loadRequest);
        Medication medication = medicationService.addMedication(request);

        drone.getMedications().add(medication);
        changeDroneStatus(drone);
        droneRepository.save(drone);

        LoadDroneResponse loadDroneResponse = new LoadDroneResponse();
        loadDroneResponse.setMessage("Drone loaded successfully");
        loadDroneResponse.setMedication(medication);
        return loadDroneResponse;
    }

    private void changeDroneStatus(Drone drone) {
        if(drone.cumulateLoadedWeight() < drone.getWEIGHTLIMIT()){
            drone.setDroneState(DroneState.LOADING);
        }
        if(drone.cumulateLoadedWeight() == drone.getWEIGHTLIMIT()){
            drone.setDroneState(DroneState.LOADED);
        }
    }

    @Override
    public List<MedicationResponse> checkLoadedMedications(String serialNumber) throws DroneException {
        Optional <Drone> savedDrone = droneRepository.findBySerialNumber(serialNumber);
        if (savedDrone.isEmpty()) {
            throw new DroneException("Drone specified does not exist");
        }
        Drone drone = savedDrone.get();
        return drone.getMedications().stream().map(this:: buildMedicalResponse).toList();
    }

    @Override
    public List<DroneResponse> viewAvailableDrone() {
        var drones =  droneRepository.findByAvailableDroneByState();
        return drones.stream().map(this::buildDroneResponse).toList();
    }

    @Override
    public BatteryResponse batteryCheck(String serialNumber) throws DroneException {
        Optional <Drone> found = droneRepository.findBySerialNumber(serialNumber);
        if(found.isEmpty()){
            throw new DroneException("Not found");
        }
        Drone drone = found.get();
        return BatteryResponse.builder()
                .batteryLevel(drone.getBatteryLevel())
                .serialNumber(drone.getSerialNumber())
                .droneModel(drone.getDroneModel().toString())
                .build();
    }

    private AddMedicationRequest buildMedicalRequest(LoadDroneRequest request){
        return AddMedicationRequest.builder()
                .name(request.getName())
                .code(request.getCode())
                .imageUrl(request.getImage())
                .weight(request.getWeight())
                .build();
    }

    private MedicationResponse buildMedicalResponse(Medication medication){
        return MedicationResponse.builder()
                .name(medication.getName())
                .code(medication.getCode())
                .image(medication.getImage())
                .weight(medication.getWeight())
                .build();
    }

    private DroneResponse buildDroneResponse(Drone drone){
        return DroneResponse.builder()
                .batteryLevel(drone.getBatteryLevel())
                .droneModel(drone.getDroneModel().toString())
                .droneState(drone.getDroneState().toString())
                .loadedWeight(drone.getLoadedWeight())
                .medications(drone.getMedications())
                .weightLimit(drone.getWEIGHTLIMIT())
                .serialNumber(drone.getSerialNumber())
                .build();
    }



}
