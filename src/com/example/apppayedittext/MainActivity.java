package com.example.apppayedittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);
		final ItemPasswordLayout itemPasswordLayout = (ItemPasswordLayout) findViewById(R.id.item);
		 itemPasswordLayout.setInputCompleteListener(new ItemPasswordLayout.InputCompleteListener() {
		  @Override
		  public void inputComplete() {
		   Toast.makeText(MainActivity.this, "�����ǣ�"+itemPasswordLayout.getStrPassword(), Toast.LENGTH_SHORT).show();
		  }
		 });

	}

	
}
