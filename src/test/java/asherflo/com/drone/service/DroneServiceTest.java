package asherflo.com.drone.service;

import asherflo.com.drone.dto.response.LoadDroneResponse;
import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.response.DroneResponse;
import asherflo.com.drone.dto.request.LoadDroneRequest;
import asherflo.com.drone.model.enums.DroneModel;
import asherflo.com.drone.model.enums.DroneState;
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
    void testThatADroneCanBeRegister(){
        DroneRegistrationRequest droneRegistrationRequest = new DroneRegistrationRequest();
        droneRegistrationRequest.setSerialNumber("BIG023");
        droneRegistrationRequest.setDroneModel(DroneModel.LIGHTWEIGHT);
        droneRegistrationRequest.setWeightLimit(386);
        droneRegistrationRequest.setBatteryCapacity("95%");
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