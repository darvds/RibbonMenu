RibbonMenu
==========

Navigation menu for Android (based on Google+ app).

![RibbonMenu](/darvds/RibbonMenu/rbm1.png "Screenshot")


Usage
=====

Menus are created in xml as normal, adding text and an icon.

In the layout you want to show the menu, add a FrameLayout as the root layout and add the RibbonMenuView set with width and height to match_parent.

In your class you need to implement the iRibbonMenuCallback interface. This is called when you click a menu item and it passes the menu item id from the xml. You then make a reference to the RibbonMenuView and set the callback, set the menu items and add toggleMenu() to your android.R.id.home in your onOptionsItemSelected

The sample activity shows how it should all work.


License
=======

Copyright 2012 David Scott

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.