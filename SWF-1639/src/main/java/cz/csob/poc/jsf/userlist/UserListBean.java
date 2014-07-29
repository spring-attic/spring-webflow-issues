package cz.csob.poc.jsf.userlist;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;

import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cz.csob.poc.jsf.model.Client;
import cz.csob.poc.jsf.service.IClientService;

@Named
@SessionScoped
//@Component
//need this, JSR-330 in Spring context is singleton by default
//@Scope("session")
//public class UserListBean implements InitializingBean {
public class UserListBean {

    private static final Logger logger = LoggerFactory.getLogger(UserListBean.class);

	private String firstName;

	private String lastName;

	private Date birthDate;

	@Autowired
	private IClientService clientService;
	
	/*
	 * Getters & Setters
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/*
	 * Business methods
	 */
	public String printMsgFromSpring() {
		return "Tak prvni message ze springu";
	}
	
	public void search() {
        logger.info("getFirstName(): " + getFirstName() + ", getLastName(): " + getLastName() + ", getBirthDate(): " + getBirthDate());
	}
	
	public List<Client> getClientList() {
		// TODO: Tohle reseni neni idealni. Pod volanim clientService ma byt schovane volani BE. Neni tak vhodne volat BE vzycky, kdy potrebujeme se seznamem klientu pracovat.
		// TODO: Vim o tom, budeme to tedy i pro nase vyvojove ucely delat poctive? :-)
		return select(clientService.getClientList(), having(on(Client.class).getFirstName(), Matchers.startsWith(getFirstName())));  
	}	
}