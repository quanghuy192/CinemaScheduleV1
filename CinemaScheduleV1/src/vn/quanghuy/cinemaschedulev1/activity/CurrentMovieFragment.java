package vn.quanghuy.cinemaschedulev1.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import vn.quanghuy.cinemaschedulev1.utilities.HtmlParser;

public class CurrentMovieFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.current_movie_layout, null);
		new CinemaAsynTask().execute();
		return view;
	}
	
	class CinemaAsynTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			HtmlParser htmlParser = new HtmlParser();
			htmlParser.setUrlSource("http://lichphim.vn/fbapp/lichchieu");
			htmlParser.getMovieList();
			return null;
		}
		
	}

}
