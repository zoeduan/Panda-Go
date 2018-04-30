package edu.uncc.ssdi.service;

import java.util.List;

import edu.uncc.ssdi.model.Permission;
import org.springframework.stereotype.Service;

@Service
public interface PermService {

	int grantPermission( Permission permObject);

	List<Permission> getAllRequests(Long id);
	
	
}
