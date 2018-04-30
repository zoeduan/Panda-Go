

package edu.uncc.ssdi.service;

import java.util.List;

import edu.uncc.ssdi.model.Trip;
import org.springframework.stereotype.Service;


@Service
public interface TripService {

	Trip findById(Long id);

	Trip saveTrip(Trip trip);

	void updateTrip(Trip trip);

	List<Trip> findAllTrips();

}
