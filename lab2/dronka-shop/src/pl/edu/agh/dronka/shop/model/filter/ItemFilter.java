package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.items.Book;
import pl.edu.agh.dronka.shop.model.items.Electronics;
import pl.edu.agh.dronka.shop.model.items.Item;
import pl.edu.agh.dronka.shop.model.items.Music;

public class ItemFilter {

	private Item itemSpec = new Item();

	public Item getItemSpec() {
		return itemSpec;
	}

	public void setCategory(Category category) {
		itemSpec = switch (category) {
			case BOOKS -> new Book();
			case ELECTRONICS -> new Electronics();
			case MUSIC -> new Music();
			default -> itemSpec;
		};
		itemSpec.setCategory(category);
	}

	public void setItemSpec(Item itemSpec) {
		this.itemSpec = itemSpec;
	}

	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		switch (itemSpec.getCategory()) {
			case BOOKS -> {
				if (((Book)itemSpec).getHardCover() && !((Book)item).getHardCover())
					return false;
			}
			case ELECTRONICS -> {
				if (((Electronics)itemSpec).getMobile() && !((Electronics)item).getMobile())
					return false;
				if (((Electronics)itemSpec).getGuarantee() && !((Electronics)item).getGuarantee())
					return false;
			}
			case MUSIC -> {
				if (((Music)itemSpec).getVideoAttached() && !((Music)item).getVideoAttached())
					return false;
			}
		}

		return true;
	}

}