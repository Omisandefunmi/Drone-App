package asherflo.com.drone.repository;

import asherflo.com.drone.model.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    Optional <Drone> findBySerialNumber(String id);
//    List<Drone> findAllByState( DroneState droneState);
}
