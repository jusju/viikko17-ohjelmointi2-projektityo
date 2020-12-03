package model;

public class ShoppingListItem {
	private int id;
	private String title;

	public ShoppingListItem() {
		super();
	}

	public ShoppingListItem(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public ShoppingListItem(String title) {
		super();
		this.title = title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ShoppingListItem [id=" + id + ", title=" + title + "]";
	}

	
	
}
