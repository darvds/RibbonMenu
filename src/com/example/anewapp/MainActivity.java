package com.example.anewapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity 
{
	private ListView list;
	private ArrayAdapter<String> adapter;
	private RibbonMenuView rbmView;
	private Button test;
	private ListView rbmListView;
	private ListView rbmListView2;
	private ArrayAdapter<String> adapt;
	private ArrayAdapter<String> adapter2;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/** Menu **/
		rbmView = (RibbonMenuView) findViewById(R.id.ribbonMenuView1);

		/** Main ListView **/
		list = (ListView) findViewById(R.id.listView1);

		/** 
		 * This is an exmaple button 
		 * it calls "hideMenu()" after each click similiar to the Facebook or Google+ apps 
		 * **/
		test = (Button) findViewById(R.id.button);
		test.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				rbmView.hideMenu();
			}
		});

		/** This is the most important ListView, updating the main list in the Activity **/
		final String[] items_list = { "List1", "List2", "List3", "List4" };
		adapt = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items_list);
		rbmListView = (ListView) findViewById(R.id.rbm_listview);
		rbmListView.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
			{
				switch (position)
				{
				case 0:
					final String[] items = { "A", "B", "C", "D" };
					adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);
					list.setAdapter(adapter);
					break;

				case 1:
					final String[] items1 = { "1", "2", "3", "4" };
					adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items1);
					list.setAdapter(adapter);
					break;

				case 2:
					final String[] items2 = { "z", "x", "c", "v" };
					adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items2);
					list.setAdapter(adapter);
					break;

				case 3:
					final String[] items3 = { "Test1", "Test2", "Test3", "Test4" };
					adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items3);
					list.setAdapter(adapter);
					break;

				default:
					final String[] itemsd = { "A", "B", "C", "D" };
					adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, itemsd);
					list.setAdapter(adapter);
					break;
				}
				rbmView.hideMenu();
			}
		});
		rbmListView.setAdapter(adapt);


		/** This is the second ListView on the menu **/
		final String[] items_list2 = { "Notification1", "Notification2", "Notification3", "Notification4" };
		adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items_list2);
		rbmListView2 = (ListView) findViewById(R.id.rbm_listview2);
		rbmListView2.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
			{
				Toast.makeText(MainActivity.this, items_list2[position], Toast.LENGTH_SHORT).show();
				rbmView.hideMenu();
			}
		});
		rbmListView2.setAdapter(adapter2);
	}

	/**
	 * Allows users, even API < 5, to use the back button
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_BACK:
			rbmView.hideMenu();
			break;
		default:
			return super.onKeyDown(keyCode, event);
		}
		return true;
	}

	/**
	 * Options Menu<br>
	 * example toggle
	 */
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) 
		{
		case R.id.test:
			rbmView.toggleMenu();
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
}