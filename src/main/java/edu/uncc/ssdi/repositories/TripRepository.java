package edu.uncc.ssdi.repositories;



import edu.uncc.ssdi.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TripRepository extends CrudRepository<Trip, Long> {


}


