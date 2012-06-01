RibbonMenu
==========

Navigation menu for Android (based on Google+ app).


Usage
=====

Menus are created in xml as normal, adding text and an icon.

In the layout you want to show the menu, add a FrameLayout as the root layout and add the RibbonMenuView set with width and height to match_parent.

In your class you need to implement the iRibbonMenuCallback interface. This is called when you click a menu item and it passes the menu item id from the xml. You then make a reference to the RibbonMenuView and set the callback, set the menu items and add toggleMenu() to your android.R.id.home in your onOptionsItemSelected

The sample activity shows how it should all work.