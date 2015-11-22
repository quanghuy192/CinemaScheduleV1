package vn.quanghuy.cinemaschedulev1.bean;

import android.graphics.Bitmap;

public class Movie {

	private String title;
	private String id;
	private String type;
	private Bitmap icon;

	public Movie(String title, String id, String type, Bitmap icon) {
		super();
		this.title = title;
		this.id = id;
		this.type = type;
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Bitmap getIcon() {
		return icon;
	}

	public void setIcon(Bitmap icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", id=" + id + ", type=" + type + ", icon=" + icon + "]";
	}

}
