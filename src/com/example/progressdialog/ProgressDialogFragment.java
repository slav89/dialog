package com.example.progressdialog;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProgressDialogFragment extends DialogFragment {
	static ProgressDialog pd;
	static DownloadTask dt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setRetainInstance(true);

	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i("fff", "onCreateDialog");
		
		if (pd == null) {
			pd = new ProgressDialog(getActivity());
			pd.setIndeterminate(false);
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd.setProgress(0);
			pd.setTitle("Download Progress:");
			if (dt == null) {
				dt = new DownloadTask();
				dt.execute();
			}
		}
		return pd;

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

	}

	public static void incProgress() {
		pd.setProgress(pd.getProgress() + 1);
	}

	private static class DownloadTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			int sleepTime;
			for (int i = 0; i < 100; i++) {
				if (!isCancelled()) {
					sleepTime = new Random().nextInt(225);
					try {
						Thread.sleep(sleepTime + 25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					publishProgress();

				}
			}

			return null;
		}

		@Override
		protected void onProgressUpdate(Void... values) {

			incProgress();
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Void result) {
			pd.dismiss();
			dt = null;
			pd = null;
			super.onPostExecute(result);
		}

	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		//super.onDismiss(dialog);
		Log.i("fff", "onDismiss");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.i("fff", "onActivityCreated");

	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.i("fff", "onAttach");

	}

	@Override
	public void onCancel(DialogInterface dialog) {
		// TODO Auto-generated method stub
		super.onCancel(dialog);
		Log.i("fff", "onCancel");

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.i("fff", "onConfigurationChanged");

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("fff", "onCreateView");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.i("fff", "onDestroyView");

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("fff", "onDestroy");

	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();

		Log.i("fff", "onDetach");

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		Log.i("fff", "onPause");

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("fff", "onResume");

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i("fff", "onSaveInstanceState");

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub

		super.onStart();
		Log.i("fff", "onStart");

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("fff", "onStop");

	}

}
