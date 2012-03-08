package org.springframework.webflow.issues.form;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.issues.entity.House;
import org.springframework.webflow.issues.service.HouseService;
import org.springframework.webflow.issues.service.HouseServiceImpl;

public class HouseForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private HouseService houseService;
	
	public House loadHouse() {
		House house = houseService.findHouseById(1L);
		
		house.getWindows().size();
		
		return house;
	}
}
