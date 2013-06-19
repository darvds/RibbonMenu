package com.example.anewapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
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
	private ListView rbmListView, rbmListView2;
	private ArrayAdapter<String> adapt, adapter2;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/** Init our views **/
		rbmView = (RibbonMenuView) findViewById(R.id.ribbonMenuView1);
		list = (ListView) findViewById(R.id.listView1);

		/** Calls "hideMenu()" after each click similiar to the Facebook or Google+ application **/
		test = (Button) findViewById(R.id.button);
		test.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				// shows how to hide the menu
				if (rbmView != null)
				{
					rbmView.hideMenu();
				}
			}
		});

		/** This is the most important ListView, updating the main list in the Activity **/
		final String[] items_list = { "List1", "List2", "List3", "List4" };
		adapt = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items_list);
		rbmListView = (ListView) findViewById(R.id.rbm_listview);
		if (rbmListView != null)
		{
			rbmListView.setOnItemClickListener(new OnItemClickListener() 
			{
				/*
				 * (non-Javadoc)
				 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
				 */
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
				{
					switch (position)
					{
					case 0:
						String[] items = { "A", "B", "C", "D" };
						adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);
						break;

					case 1:
						String[] items1 = { "1", "2", "3", "4" };
						adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items1);
						break;

					case 2:
						String[] items2 = { "z", "x", "c", "v" };
						adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items2);
						break;

					case 3:
						String[] items3 = { "Test1", "Test2", "Test3", "Test4" };
						adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items3);
						break;

					default:
						String[] itemsd = { "A", "B", "C", "D" };
						adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, itemsd);
						break;
					}

					// always update these
					if (list != null)
					{
						list.setAdapter(adapter);
					}

					if (rbmView != null)
					{
						rbmView.hideMenu();
					}
				}
			});
			rbmListView.setAdapter(adapt);
		}

		/** This is the second ListView on the menu **/
		final String[] items_list2 = { "Notification1", "Notification2", "Notification3", "Notification4" };
		adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items_list2);
		rbmListView2 = (ListView) findViewById(R.id.rbm_listview2);
		if (rbmListView2 != null)
		{
			rbmListView2.setOnItemClickListener(new OnItemClickListener() 
			{
				/*
				 * (non-Javadoc)
				 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
				 */
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
				{
					Toast.makeText(MainActivity.this, items_list2[position], Toast.LENGTH_SHORT).show();
					if (rbmView != null)
					{
						rbmView.hideMenu();
					}
				}
			});
			rbmListView2.setAdapter(adapter2);
		}
	}

	/**  Allows users, even API < 5, to use the back button **/
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_BACK:
			// if view is showing, close it
			// all other back button clicks are handled by the phone
			if (rbmView != null)
			{
				if (rbmView.isMenuShowing())
				{
					new Handler().postDelayed(new Runnable()
					{
						public void run()
						{
							rbmView.hideMenu();
						}
					}, 50);
				} 
				else
				{
					return super.onKeyDown(keyCode, event);
				}
			}
			break;
		default:
			return super.onKeyDown(keyCode, event);

		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) 
		{
		case R.id.test:
			// toggle our menu
			if (rbmView != null)
			{
				rbmView.toggleMenu();
			}
			break;

		default:
			return super.onOptionsItemSelected(item);

		}

		return true;
	}
}