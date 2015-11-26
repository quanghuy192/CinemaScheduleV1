package vn.quanghuy.cinemaschedulev1.bean;

import android.graphics.Bitmap;

public class Movie {

	private String title;
	private short id;
	private String type;
	private Bitmap icon;
	private String linkDetail;
	private String time;
	private String director;
	private String actors;
	private String imdbPoint;
	private String dayStart;
	private String content;
	
	// Not use
	private short likes;
	private short views;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getLinkDetail() {
		return linkDetail;
	}

	public void setLinkDetail(String linkDetail) {
		this.linkDetail = linkDetail;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getImdbPoint() {
		return imdbPoint;
	}

	public void setImdbPoint(String imdbPoint) {
		this.imdbPoint = imdbPoint;
	}

	public String getDayStart() {
		return dayStart;
	}

	public void setDayStart(String dayStart) {
		this.dayStart = dayStart;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public short getLikes() {
		return likes;
	}

	public void setLikes(short likes) {
		this.likes = likes;
	}

	public short getViews() {
		return views;
	}

	public void setViews(short views) {
		this.views = views;
	}

	public void setIcon(Bitmap icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", id=" + id + ", type=" + type + ", icon=" + icon + ", linkDetail="
				+ linkDetail + ", time=" + time + ", director=" + director + ", actors=" + actors + ", imdbPoint="
				+ imdbPoint + ", dayStart=" + dayStart + ", content=" + content + ", likes=" + likes + ", views="
				+ views + "]";
	}

}
