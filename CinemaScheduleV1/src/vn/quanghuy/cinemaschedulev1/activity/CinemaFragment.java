package vn.quanghuy.cinemaschedulev1.activity;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

public class CinemaFragment extends Fragment implements OnClickListener {

	private Button btnMap, btnMovie, btnInfor;
	private Calendar cal;
	 private int day;
	 private int month;
	 private int year;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.cinema_layout, null);
		btnMap = (Button) view.findViewById(R.id.btMap);
		btnMovie = (Button) view.findViewById(R.id.btMovie);
		btnInfor = (Button) view.findViewById(R.id.btInfor);

		btnMap.setOnClickListener(this);
		btnMovie.setOnClickListener(this);
		btnInfor.setOnClickListener(this);

		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		return view;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub

	}



}
