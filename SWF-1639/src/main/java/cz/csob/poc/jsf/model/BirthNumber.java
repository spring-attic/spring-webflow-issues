package cz.csob.poc.jsf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.binding.convert.converters.InvalidFormatException;

@SuppressWarnings("serial")
public class BirthNumber implements Serializable {
	
	public static BirthNumber copy(BirthNumber birthNumber) {
		if (birthNumber == null) {
			return null;
		}
		return new BirthNumber(birthNumber.getFirstPart(), birthNumber.getSecondPart());
	}
	
	/**
	 * First part of birth date
	 */
	private int firstPart;
	
	/**
	 * Second part of birth date
	 */
	private int secondPart;
	
	/*
	 * Constructors
	 */
	public BirthNumber(Date birthDate, Gender gender) {
        //FIXME: public metoda by se z konstruktoru nikdy volat nemela
		setByDateAndGender(birthDate, gender);
	}

	public BirthNumber(final String birthDate) {
		parseBirthNumber(birthDate);
	}

	public BirthNumber(int firstPart, int secondPart) {
		this.firstPart = firstPart;
		this.secondPart = secondPart;
	}
	
	public BirthNumber() {
		
	}
	
	/*
	 * Getters & Setters
	 */
	public int getFirstPart() {
		return firstPart;
	}
	
	public void setFirstPart(int firstPart) {
		this.firstPart = firstPart;
	}

	public int getSecondPart() {
		return secondPart;
	}
	
	public void setSecondPart(int secondPart) {
		this.secondPart = secondPart;
	}
	
	/*
	 * Business methods
	 */
	public String getBirthNumber() {
		return firstPart + "/" + secondPart;
	}

	public void setByParts(int firstPart, int secondPart) {
		this.firstPart = firstPart;
		this.secondPart = secondPart;
	}
	
	public void setByString(final String birthNumber) {
		parseBirthNumber(birthNumber);
	}
	
	private void parseBirthNumber(String birthNumber) {
		
		Pattern pattern = Pattern.compile("^[0-9]{6}/[0-9]{3,4}$");
		Matcher matcher = pattern.matcher(birthNumber);
		
		if (!matcher.find()) {
		
			throw new InvalidFormatException(birthNumber, "XXXXXX/XXX(X)");
		}
		
		String[] birthDataParts = birthNumber.split("/");
		
		firstPart = Integer.parseInt(birthDataParts[0]);
		
		if (birthDataParts.length == 2) {
			secondPart = Integer.parseInt(birthDataParts[1]);
		}
	}
	
	
	public void setByDateAndGender(final Date getBirthDate, final Gender gender) {
		throw new UnsupportedOperationException("setByString(final String birthDate) not implemented yet");
	}
	
	public String toString() {
		return this.getBirthNumber();
	}
	
	public boolean isEmpty() {
		return firstPart == 0 && secondPart == 0;
	}
}