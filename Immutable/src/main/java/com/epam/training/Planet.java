package com.epam.training;

import java.util.Date;
import java.util.List;

public class Planet {

	String name;

	protected Date dateOfDiscovery;

	private List<Moon> moons;

	public Planet(String name, Date dateOfDiscovery, List<Moon> moons) {
		this.name = name;
		this.dateOfDiscovery = dateOfDiscovery;
		this.moons = moons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfDiscovery() {
		return dateOfDiscovery;
	}

	public void setDateOfDiscovery(Date dateOfDiscovery) {
		this.dateOfDiscovery = dateOfDiscovery;
	}

	public List<Moon> getMoons() {
		return moons;
	}

	public void setMoons(List<Moon> moons) {
		this.moons = moons;
	}

}
