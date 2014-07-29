package cz.csob.poc.jsf.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Client implements Serializable {
	
	private static final long serialVersionUID = 207557104795531624L;
	
	public static Client create() {
		
		Client client = new Client();
		client.setBirthNumber(new BirthNumber());
//		client.setWarranter(new Client());
		
		return client;
	}
	
	public static Client copy(Client client) {
		if (client == null) {
			return null;
		}
		return new Client(client);
	}
	
	private int id;
	
	private Gender gender;

	// TODO: constrains: lenghth 50
	private String firstName;

	private String surName;

	private BirthNumber birthNumber;
	
	private Date birthDate;

	// TODO: constraints
	private BigDecimal salary;

	private boolean vipFlag;

	private Client warranter;

	/*
	 * Constructor
	 */
	
	public Client() {
		super();
	}

	public Client(int id, Gender gender, String firstName, String surName, BirthNumber birthNumber, BigDecimal salary, boolean vipFlag, Client warranter) {
		this();
		this.id = id;
		this.gender = gender;
		this.firstName = firstName;
		this.surName = surName;
		this.birthNumber = birthNumber;
		this.salary = salary;
		this.vipFlag = vipFlag;
		this.warranter = warranter;
	}
	
	private Client(Client client) {
		this(client, new HashMap<Integer, Client>());
	}
	
	private Client(Client client, Map<Integer, Client> copies) {
		this(client.getId(), client.getGender(), client.getFirstName(), client.getSurName(), BirthNumber.copy(client.getBirthNumber()), client.getSalary(), client.isVipFlag(), null);
		copies.put(Integer.valueOf(getId()), this);
		setWarranter(copyWarranter(client.getWarranter(), copies));
	}
	
	private Client copyWarranter(Client warranter, Map<Integer, Client> copies) {
		if (warranter == null) {
			return null;
		}
		if (copies.containsKey(Integer.valueOf(warranter.getId()))) {
			return copies.get(Integer.valueOf(warranter.getId()));
		}
		return new Client(warranter, copies);
	}
	
	/*
	 * Getters & Setters
	 */
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public BirthNumber getBirthNumber() {
		return birthNumber;
	}

	public void setBirthNumber(BirthNumber birthNumber) {
		this.birthNumber = birthNumber;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public boolean isVipFlag() {
		return vipFlag;
	}

	public void setVipFlag(boolean vipFlag) {
		this.vipFlag = vipFlag;
	}

	public Client getWarranter() {
		return warranter;
	}

	public void setWarranter(Client warranter) {
		this.warranter = warranter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
