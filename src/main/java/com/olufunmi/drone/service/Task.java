package com.olufunmi.drone.service;

import com.olufunmi.drone.dto.response.BatteryResponse;
import com.olufunmi.drone.model.Drone;
import com.olufunmi.drone.repository.DroneRepository;
import com.olufunmi.drone.service.mailService.MailSender;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
//@Slf4j
public class Task {

    private final DroneRepository droneRepository;
    private final MailSender mailSenderImpl;
    private static final Logger log = LoggerFactory.getLogger(Task.class);

    @Scheduled(fixedRate = 100000)
    public void cronTask(){
        checkDronesBatteries();
        log.info("about to send mail");
        mailSenderImpl.sendEmail();
        log.info("mail sent");
    }

    public List<BatteryResponse> checkDronesBatteries(){
        log.info("Checking all drones batteries");
        List<Drone> allDrones = droneRepository.findAll();
        return allDrones.stream().map(this::createAuditResponse).toList();
    }

    private BatteryResponse createAuditResponse(Drone drone){
        log.info("Creating audit response");
        return BatteryResponse.builder()
                .droneModel(drone.getDroneModel().toString())
                .serialNumber(drone.getSerialNumber())
                .batteryLevel(drone.getBatteryLevel())
                .build();
    }
}
