package edu.uncc.ssdi.controllers;

import edu.uncc.ssdi.model.Trip;
import edu.uncc.ssdi.service.TripService;
import edu.uncc.ssdi.service.UserService;
import edu.uncc.ssdi.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uncc.ssdi.repositories.TripRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class TripController {
	@Autowired
	private TripRepository tripRepository;
	@Autowired
	private TripService tripService; // Service which will do all data retrieval/manipulation work
	
	@Autowired
	private UserService userService; // Service which will do all data retrieval/manipulation work

	
	@RequestMapping(value = "/addtrip/", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody
    Trip addNewTrip(@RequestParam String departTime, @RequestParam String arriveTime,
                    @RequestParam String departLocation, @RequestParam String arriveLocation,
                    @RequestParam String busType, @RequestParam int miniNumber ) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		// Add the trip to the database
		System.out.println("Reached here");
		//System.out.println(userid);
		Trip t = new Trip();
		t.setDepartLocation(departLocation);
		t.setDepartTime(departTime);
		//t.setDepartTime(departTime);
		t.setArriveTime(arriveTime);
		t.setArriveLocation(arriveLocation);
		t.setBusType(busType);
		t.setMiniNumber(miniNumber);
		
		//User user = userService.findById(userid);
		//t.getUsers().add(user);
		//user.getTrips().add(t);
		Trip newTrip = tripService.saveTrip(t);
		//newTrip.setUsers(null);
		return newTrip;
	}
	
	@RequestMapping(value = "/getTrips", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody List<Trip> getAllTrips() {
		System.out.println("test trip");
		//return (List<Trip>) tripService.findAllTrips();
		return (List<Trip>) tripRepository.findAll();
	}
	
	
	@RequestMapping(value = "/getTrip/{id}", method = RequestMethod.GET)
	public ResponseEntity<Trip> getTrip(@PathVariable("id") Long id) {
		Trip trip = tripService.findById(id);
		return new ResponseEntity<Trip>(trip, HttpStatus.OK);
	}
	
	
	// @Transactional
	@RequestMapping(value = "/updateTrip/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTrip(@PathVariable("id") long id, @RequestBody Trip trip) {
		System.out.println("Reached from UI");
		Trip currentTrip = tripService.findById(id);
		if (currentTrip == null) {
			return new ResponseEntity<Object>(
					new CustomErrorType("Unable to update. Trip with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		currentTrip.setDepartTime(trip.getDepartTime());
		currentTrip.setDepartLocation(trip.getDepartLocation());
		currentTrip.setArriveTime(trip.getArriveTime());
		currentTrip.setArriveLocation(trip.getArriveLocation());
		//currentTrip.setMiniNumber(trip.getMiniNumber());
		return new ResponseEntity<Trip>(currentTrip, HttpStatus.OK);
	}
} // end of class