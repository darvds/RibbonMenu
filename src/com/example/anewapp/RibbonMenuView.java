package com.example.anewapp;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class RibbonMenuView extends LinearLayout 
{
	private LinearLayout menu;

	public RibbonMenuView(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		try
		{
			LayoutInflater.from(getContext()).inflate(R.layout.rbm_menu, this, true);
		} catch(Exception e) {}		
		menu = (LinearLayout) findViewById(R.id.menu);
	}

	public void showMenu()
	{
		menu.setVisibility(View.VISIBLE);	
		menu.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rbm_in_from_left));
	}

	public void hideMenu()
	{
		menu.setVisibility(View.GONE);
		menu.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rbm_out_to_left));
	}

	public void toggleMenu()
	{
		if (menu.getVisibility() == View.GONE)
		{
			showMenu();
		} 
		else 
		{
			hideMenu();
		}
	}
}