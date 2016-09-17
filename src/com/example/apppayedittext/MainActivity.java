package com.example.apppayedittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * git remote add origin git@github.com:wangzhan3429/xxx.git
   git push -u origin master
 * @author wangzhan
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);
		final ItemPasswordLayout itemPasswordLayout = (ItemPasswordLayout) findViewById(R.id.item);
		 itemPasswordLayout.setInputCompleteListener(new ItemPasswordLayout.InputCompleteListener() {
		  @Override
		  public void inputComplete() {
		   Toast.makeText(MainActivity.this, "√‹¬Î «£∫"+itemPasswordLayout.getStrPassword(), Toast.LENGTH_SHORT).show();
		  }
		 });

	}

	
}
