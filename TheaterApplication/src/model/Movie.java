package model;

public class Movie {
	
	private String name;
	private String genre;
	private String ageRating;
	
	public Movie(String name, String genre, String ageRating) {
		setName(name);
		setGenre(genre);
		setAgeRating(ageRating);
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s", name, genre, ageRating);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

}
