package burrows.apps.example.ribbonmenu.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import burrows.apps.example.ribbonmenu.R;

public class RibbonMenuView extends LinearLayout {
    private LinearLayout menu;

    /**
     * Constructor to create menu
     *
     * @param context Context
     * @param attrs   Other Attributes
     */
    public RibbonMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.rbm_menu, this, true);
        menu = (LinearLayout) findViewById(R.id.menu);
    }

    /**
     * Show our Menu
     */
    public void showMenu() {
        if (menu != null) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    menu.setVisibility(View.VISIBLE);
                    menu.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rbm_in_from_left));
                }
            }, 50);
        }
    }

    /**
     * Hide our Menu
     */
    public void hideMenu() {
        if (menu != null) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    menu.setVisibility(View.GONE);
                    menu.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rbm_out_to_left));
                }
            }, 50);
        }
    }

    /**
     * Toggle the Menu open/close
     */
    public void toggleMenu() {
        if (menu != null) {
            if (menu.getVisibility() == View.GONE) {
                showMenu();
            } else {
                hideMenu();
            }
        }
    }

    /**
     * Check to see if the menu is visible
     *
     * @return Visible
     */
    public boolean isMenuShowing() {
        if (menu != null) {
            return menu.getVisibility() == View.VISIBLE;
        }

        return false;
    }
}
