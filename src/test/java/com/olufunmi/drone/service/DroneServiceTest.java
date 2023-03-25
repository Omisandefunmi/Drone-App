package com.olufunmi.drone.service;

import com.olufunmi.drone.dto.request.DroneRegistrationRequest;
import com.olufunmi.drone.dto.response.DroneResponse;
import com.olufunmi.drone.exceptions.DroneException;
import com.olufunmi.drone.model.enums.DroneModel;
import com.olufunmi.drone.model.enums.DroneState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DroneServiceTest {
    @Autowired
    private DroneService droneService;

    @Test
    @DisplayName("Register a drone")
    void testThatADroneCanBeRegister() throws DroneException {
        DroneRegistrationRequest droneRegistrationRequest = new DroneRegistrationRequest();
        droneRegistrationRequest.setSerialNumber("BIG023");
        droneRegistrationRequest.setDroneModel(DroneModel.LIGHTWEIGHT);
//        droneRegistrationRequest.s(386);
        droneRegistrationRequest.setBatteryLevel("95%");
        droneRegistrationRequest.setDroneState(DroneState.LOADING);
        DroneResponse response = droneService.registerDrone(droneRegistrationRequest);
        assertNotNull(response);
    }
//    @Test
//    @DisplayName("To load a drone")
//    void testThatADroneCanLoadedWithMedication(){
//       LoadDroneRequest loadDroneRequest = new LoadDroneRequest();
//       loadDroneRequest.setSerialNumber("QWRTYU567");
//       loadDroneRequest.setName("Plaza");
//       loadDroneRequest.setImage("IMG234");
//       loadDroneRequest.setWeight(354);
//      LoadDroneResponse response = droneService.loadDrone(loadDroneRequest);
//      assertNotNull(response);



//   }

}