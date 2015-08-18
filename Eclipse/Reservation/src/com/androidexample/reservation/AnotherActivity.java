package com.androidexample.reservation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends Activity {

	TextView error;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
		setContentView(R.layout.androidexample_broadcast_newsms);

		error = (TextView) findViewById(R.id.error);

		error.setText(getIntent().getStringExtra("error"));
	}
}
