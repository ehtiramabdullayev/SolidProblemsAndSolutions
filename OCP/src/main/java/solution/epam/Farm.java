package solution.epam;

import java.util.Arrays;
import java.util.List;

public class Farm {

	private List<Animal> animals = Arrays.asList(Animal.DOG, Animal.DOG,
			Animal.DOG, Animal.CAT, Animal.DUCK);

	public void sing() {
		for (Animal animal : animals) {
			speak(animal);
		}
	}

	private void speak(Animal animal) {
		animal.speak();
	}

}
