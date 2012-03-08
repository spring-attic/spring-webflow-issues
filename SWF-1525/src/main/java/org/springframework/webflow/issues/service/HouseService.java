package org.springframework.webflow.issues.service;

import org.springframework.webflow.issues.entity.House;

public interface HouseService {
	House findHouseById(Long id);
}
