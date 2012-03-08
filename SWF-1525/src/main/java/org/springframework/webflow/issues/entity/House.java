package org.springframework.webflow.issues.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class House implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Set<Window> windows;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany
	public Set<Window> getWindows() {
		return windows;
	}

	public void setWindows(Set<Window> windows) {
		this.windows = windows;
	}
}
