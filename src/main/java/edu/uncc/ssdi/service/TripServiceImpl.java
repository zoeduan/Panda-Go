package edu.uncc.ssdi.service;

import java.util.List;

import edu.uncc.ssdi.model.Trip;
import edu.uncc.ssdi.repositories.TripRepository;
import edu.uncc.ssdi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private Trip trip;
	

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
        
    }
	public Trip saveTrip(Trip trip) {

		return tripRepository.save(trip);
	}


	public List<Trip> findAllTrips() {
		return (List<Trip>) tripRepository.findAll();
	}

	@Override
	public Trip findById(Long id) {
		return tripRepository.findOne(id);
	}

	@Override
	public void updateTrip(Trip trip) {
		saveTrip(trip);
		
	}	
	

/*	public void save( long userID ,long tripID) {

		trip.setId(tripID);
		trip.getUsers().add(user);
		trip = tripRepository.save(trip);
		
		user.getTrips().add(trip);
	}*/
    //public void addUserToTrip(Long userID) {
        //User user = userRepository.findOne(userID); 
        //tripRepositoy.getUsers().add(user);
   // }
	
}
