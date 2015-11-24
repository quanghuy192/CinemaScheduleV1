package vn.quanghuy.cinemaschedulev1.utilities;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;
import vn.quanghuy.cinemaschedulev1.bean.Movie;

public class HtmlParser {

	// Link source
	private static final String CURRENT_MOVIE_URL = "http://lichphim.vn/fbapp/lichchieu";
	private static final String NEW_MOVIE_URL = "http://lichphim.vn/fbapp/sapchieu";
	private static final String CINEMA_URL = "http://lichphim.vn/fbapp/rapchieu";

	private Document document;
	private String url;

	// data list
	private List<Movie> movieList;

	public HtmlParser() {
		super();

		// Get default url to
		// load data current movie
		setUrlSource(CURRENT_MOVIE_URL);

	}

	void setUrlSource(String url) {
		this.url = url;
		try {
			Log.i("URL", url);
			document = Jsoup.parse(new URL(url).openStream(), "UTF-8", "/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return movie list get from link source
	 */
	public List<Movie> getMovieList() {
		movieList = new ArrayList<Movie>();
		Movie movie = null;
		Elements elementItems = document.select("div[class=center]");
		Log.i("SIZE", "" + elementItems.text());
		// Test by logcat
		Log.i("SIZE", "" + elementItems.size());
		for (Element e : elementItems) {
			movie = new Movie();
			Elements items = e.select("a");
			for (Element e1 : items) {
				String detailLink = e1.attr("href");
				Elements titleContents = e1.select("title > span");
				for (Element e11 : titleContents) {
					Log.i("DATA", "" + e11.attr("class"));
				}
			}

			movieList.add(movie);
		}
		return movieList;
	}

}
