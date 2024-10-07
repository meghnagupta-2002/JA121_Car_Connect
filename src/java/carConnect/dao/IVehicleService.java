package carConnect.dao;

import carConnect.entity.Vehicle;
import java.util.List;

public interface IVehicleService {
	Vehicle getVehicleByID(int vehicleID);
    List<Vehicle> getAvailableVehicles();
    void addVehicle(Vehicle vehicleData);
    void updateVehicle(Vehicle vehicleData);
    void removeVehicle(int vehicleID);
}
