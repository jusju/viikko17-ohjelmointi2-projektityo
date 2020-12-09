package model;

public class Artist {

    private long id;
    private String name;

    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(String name) {
        this.name = name;
    }

    
    

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " / " + this.id;
    }
}