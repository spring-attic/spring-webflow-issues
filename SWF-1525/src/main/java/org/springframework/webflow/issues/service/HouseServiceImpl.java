package org.springframework.webflow.issues.service;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.issues.entity.House;

@Service("houseService")
@Repository
public class HouseServiceImpl implements HouseService, Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
    public House findHouseById(Long id) {
		return em.find(House.class, id);
    }
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
    	this.em = em;
    }
}
