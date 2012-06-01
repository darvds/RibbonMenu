package com.darvds.ribbonmenu.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.darvds.ribbonmenu.R;
import com.darvds.ribbonmenu.RibbonMenuView;
import com.darvds.ribbonmenu.iRibbonMenuCallback;

public class RibbonsampleActivity extends Activity implements iRibbonMenuCallback {
    /** Called when the activity is first created. */
	  
	private RibbonMenuView rbmView;
		
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        
	        rbmView = (RibbonMenuView) findViewById(R.id.ribbonMenuView1);
	        rbmView.setMenuClickCallback(this);
	        rbmView.setMenuItems(R.menu.ribbon_menu);
	        
	         getActionBar().setDisplayHomeAsUpEnabled(true);
	         
	        
	    }
	    
	    
	    

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			int id = item.getItemId();

			if (id == android.R.id.home) {
				
				rbmView.toggleMenu();
				
				return true;
			
			} else {
				return super.onOptionsItemSelected(item);
			}
		}




		@Override
		public void RibbonMenuItemClick(int itemId) {
			
			
			
			
		}
}