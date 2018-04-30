package edu.uncc.ssdi.model;
import javax.persistence.*;

import java.io.Serializable;


@Entity
public class Trip implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4472178902037464962L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column 
    private long id;
	
	
   // @ManyToMany(mappedBy = "trips")
   // private Set<User> users;
	
	
    
	@Column
    private String departLocation;
	
	@Column
    private String arriveLocation;
	
	
	@Column
    private String departTime;
	
	
	@Column
    private String arriveTime;
	
	
	@Column
    int miniNumber;
	
	
	@Column
    private String busType;
	

    public Trip(){
    		this(0L, null, null, null, null, 0, null);
    }

    
    public Trip(long id, String departLocation, String arriveLocation, String departTime,
			String arriveTime, int miniNumber, String busType) {
		super();
		this.id = id;
		this.departLocation = departLocation;
		this.arriveLocation = arriveLocation;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.miniNumber = miniNumber;
		this.busType = busType;
		//this.users = new HashSet<>();
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getDepartLocation() {
        return departLocation;
    }

    public void setDepartLocation(String departLocation) {
        this.departLocation = departLocation;
    }
    
    public String getArriveLocation() {
        return arriveLocation;
    }

    public void setArriveLocation(String arriveLocation) {
        this.arriveLocation = arriveLocation;
    }
    
    
    
    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }
    
    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }
    
    public long getMiniNumber() {
        return miniNumber;
    }

    public void setMiniNumber(int miniNumber) {
        this.miniNumber = miniNumber;
    }
    
    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }


    /*public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/
}
