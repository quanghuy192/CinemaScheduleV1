package vn.quanghuy.cinemaschedulev1.activity;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import vn.quanghuy.cinemaschedulev1.adapter.MovieAdapter;
import vn.quanghuy.cinemaschedulev1.bean.Movie;
import vn.quanghuy.cinemaschedulev1.utilities.HtmlParser;

public class CurrentMovieFragment extends Fragment {

	private List<Movie> movieList;
	private ListView lvCurrent;
	private ArrayAdapter<Movie> adapter;
	private ProgressBar progressBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.current_movie_layout, null);
		lvCurrent = (ListView) view.findViewById(R.id.lvCurrent);
		progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
		new CinemaAsynTask().execute();
		return view;
	}

	class CinemaAsynTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar.setVisibility(View.VISIBLE);
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			HtmlParser htmlParser = new HtmlParser();
			movieList = htmlParser.getMovieList();

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progressBar.setVisibility(View.GONE);
			adapter = new MovieAdapter(getActivity(), R.layout.item_cinema, movieList);
			lvCurrent.setAdapter(adapter);
		}

	}

}
