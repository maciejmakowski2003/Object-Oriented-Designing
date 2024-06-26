package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.items.*;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import java.util.Map;

public enum Category {

	BOOKS("Książki"), ELECTRONICS("Elektronika"), FOOD("Żywność"), MUSIC("Muzyka"), SPORT("Sport");

	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	private Category(String displayName) {
		this.displayName = displayName;
	}
}
