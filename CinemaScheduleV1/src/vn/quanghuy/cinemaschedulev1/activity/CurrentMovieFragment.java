package vn.quanghuy.cinemaschedulev1.activity;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import vn.quanghuy.cinemaschedulev1.bean.Movie;
import vn.quanghuy.cinemaschedulev1.utilities.HtmlParser;

public class CurrentMovieFragment extends Fragment {

	private List<Movie> movieList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.current_movie_layout, null);
		new CinemaAsynTask().execute();
		return view;
	}

	class CinemaAsynTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			HtmlParser htmlParser = new HtmlParser();
			movieList = htmlParser.getMovieList();
			return null;
		}

	}

}
