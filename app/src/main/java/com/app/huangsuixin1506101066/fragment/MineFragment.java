package com.app.huangsuixin1506101066.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.huangsuixin1506101066.R;
import com.app.huangsuixin1506101066.activity.LoginActivity;


/**
 * @author Silence
 */
public class MineFragment extends Fragment {

	private Button btnLogin;

	public MineFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_mine, container, false);

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initViews();

		final Intent intent = new Intent(getContext(), LoginActivity.class);

		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (intent != null){
					startActivity(intent);
				}
			}
		});
	}

	private void initViews() {

		btnLogin = getActivity().findViewById(R.id.btn_login);
	}

}
