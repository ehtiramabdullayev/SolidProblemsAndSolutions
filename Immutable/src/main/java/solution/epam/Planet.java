package solution.epam;

import java.util.Date;
import java.util.List;

public final class Planet {

	private final String name;

	//Date is mutable
	private final Date dateOfDiscovery;

	private final List<Moon> moons;

	public Planet(String name, Date dateOfDiscovery, List<Moon> moons) {
		this.name = name;
		this.dateOfDiscovery = new Date(dateOfDiscovery.getTime());
		this.moons = moons;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfDiscovery() {
		return new Date(dateOfDiscovery.getTime());
	}

	public List<Moon> getMoons() {
		return moons;
	}


}
