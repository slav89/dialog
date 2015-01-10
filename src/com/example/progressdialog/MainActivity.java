package com.example.progressdialog;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button btn;
	private ProgressDialogFragment pdf;
	private final static String DIALOG_FRAG_TAG = "DialogFrag";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {

		pdf = new ProgressDialogFragment();
		pdf.show(getFragmentManager(), DIALOG_FRAG_TAG);
	}


}
