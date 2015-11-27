package vn.quanghuy.cinemaschedulev1.adapter;

import java.util.List;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import vn.quanghuy.cinemaschedulev1.activity.R;
import vn.quanghuy.cinemaschedulev1.bean.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {
	private List<Movie> movieList;
	private Context context;
	private int resource;

	public MovieAdapter(Context context, int resource, List<Movie> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.movieList = objects;
		this.context = context;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		// sign view = convertView
		// if convertView == null => create new view

		View view = convertView;
		ViewHolder holder;
		if (convertView == null) {
			view = View.inflate(context, resource, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) view.findViewById(R.id.itemIcon);
			holder.title = (TextView) view.findViewById(R.id.itemTitle);
			holder.type = (TextView) view.findViewById(R.id.itemType);
			holder.day = (TextView) view.findViewById(R.id.itemDay);

			// set tag to save ViewHolder
			view.setTag(holder);
		} else {

			// if view exist => get ViewHolder to sign
			holder = (ViewHolder) view.getTag();
		}

		holder.imageView.setImageBitmap(movieList.get(position).getIcon());
		holder.title.setText(movieList.get(position).getTitle());
		holder.type.setText(movieList.get(position).getType());
		holder.day.setText("Ngày công chiếu : " + movieList.get(position).getDayStart());
		return view;
	}

	// ViewHolder pattern
	private class ViewHolder {
		ImageView imageView;
		TextView title;
		TextView type;
		TextView day;
	}

}
