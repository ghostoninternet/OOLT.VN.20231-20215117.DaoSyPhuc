package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Media) {			
			Media that = (Media) obj;
			if (this.title != that.title) return false;
			return true;
		} else return false;
	}
}
