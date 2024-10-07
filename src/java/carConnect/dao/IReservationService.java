package carConnect.dao;

import carConnect.entity.Reservation;
import java.util.List;

public interface IReservationService {
	Reservation getReservationByID(int reservationID);
    List<Reservation> getReservationsByCustomerID(int customerID);
    void createReservation(Reservation reservationData);
    void updateReservation(Reservation reservationData);
    void cancelReservation(int reservationID);
}
