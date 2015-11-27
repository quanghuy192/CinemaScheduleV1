package vn.quanghuy.cinemaschedulev1.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import vn.quanghuy.cinemaschedulev1.activity.MainActivity;
import vn.quanghuy.cinemaschedulev1.bean.Movie;

public class HtmlParser {

	// Link source
	private static final String CURRENT_MOVIE_URL = "http://lichphim.vn/fbapp/lichchieu";
	private static final String NEW_MOVIE_URL = "http://lichphim.vn/fbapp/sapchieu";
	private static final String CINEMA_URL = "http://lichphim.vn/fbapp/rapchieu";

	// to know the tab is selected
	private short CURRENT_MOVIE_ID = 0;

	// current index of tab
	private static int idCurrentTab;

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
			document = Jsoup.connect(url).userAgent("Mozilla").get();
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
		idCurrentTab = MainActivity.getIdTabSelected();
		if (idCurrentTab == CURRENT_MOVIE_ID) {
			setUrlSource(CURRENT_MOVIE_URL);
		} else {
			setUrlSource(NEW_MOVIE_URL);
		}

		Elements elementItems = document.select("div[class=img_item_phim]");

		// Test by logcat
		Log.i("SIZE", "" + elementItems.size());
		for (Element e : elementItems) {
			movie = new Movie();
			Elements items = e.select("a");
			for (Element e1 : items) {
				String detailLink = e1.attr("href");
				String titleContent = e1.attr("title");
				Elements imgSource = e1.select("img");
				Log.i("img", imgSource.attr("src"));
				Bitmap bitmap = null;
				try {
					// Create Bitmap icon from url source
					bitmap = BitmapFactory.decodeStream(new URL(imgSource.attr("src")).openStream());

				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				movie.setIcon(bitmap);
				movie.setLinkDetail(detailLink);
				solveTitleContent(titleContent, movie);
			}
			Log.i("ToString", movie.toString());

			movieList.add(movie);
		}
		return movieList;
	}

	/**
	 * @param titleContent:
	 *            get titleContent from title in html link
	 * @param movie:
	 *            set atttribute for movie object
	 */
	private void solveTitleContent(String titleContent, Movie movie) {
		// TODO Auto-generated method stub

		// Create document from string
		Document doc = Jsoup.parse(titleContent);

		// Filter span tag
		Elements elements = doc.select("span");
		int lenght = elements.size();

		if (idCurrentTab == CURRENT_MOVIE_ID) {
			for (int i = 0; i < lenght; i++) {
				movie.setTitle(elements.get(0).text());
				movie.setType(elements.get(2).text());
				movie.setTime(elements.get(4).text());
				movie.setDirector(elements.get(6).text());
				movie.setActors(elements.get(8).text());
				movie.setImdbPoint(elements.get(10).text());
				movie.setDayStart(convertDay(elements.get(12).text()));
				movie.setContent(elements.get(13).text());
			}
		} else {
			for (int i = 0; i < lenght; i++) {
				movie.setTitle(elements.get(0).text());
				movie.setType(elements.get(2).text());
				movie.setTime(elements.get(4).text());
				movie.setDirector(elements.get(6).text());
				movie.setActors(elements.get(8).text());
				movie.setDayStart(convertDay(elements.get(10).text()));
				movie.setContent(elements.get(11).text());
			}
		}

	}
	
	public void getCinemaList(){
		
	}

	// Convert day type yyyy-mm-dd to dd/mm/yyyy
	private String convertDay(String day) {
		StringBuilder builder = new StringBuilder();
		String[] partOfString = day.split("-");
		int size = partOfString.length;
		for (int i = size - 1; i >= 0; i--) {
			builder.append(partOfString[i]);
			builder.append("/");
		}
		String dayAfterConvert = new String(builder);
		dayAfterConvert = dayAfterConvert.substring(0, dayAfterConvert.length() - 1);
		return dayAfterConvert;
	}

}
