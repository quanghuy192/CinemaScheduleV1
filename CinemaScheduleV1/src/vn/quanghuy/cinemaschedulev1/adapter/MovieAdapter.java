package vn.quanghuy.cinemaschedulev1.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import vn.quanghuy.cinemaschedulev1.bean.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {

	public MovieAdapter(Context context, int resource, List<Movie> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return super.getView(position, convertView, parent);
	}

}
