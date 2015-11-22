package vn.quanghuy.cinemaschedulev1.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	private FragmentTabHost fragmentTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

		View newMovieTab = createTab(this, R.layout.tab_bg, R.drawable.new_movie_32);

	}

	private View createTab(Context context, int idLayout, int idImage) {
		View view = LayoutInflater.from(context).inflate(idLayout, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.tabsImage);
		imageView.setImageResource(idImage);
		return view;
	}

}
