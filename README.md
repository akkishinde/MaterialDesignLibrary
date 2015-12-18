# **Android Support Design Library**
<br>
<br>

#### Import

```
compile 'com.android.support:design:23.1.1'
```
---

#### SnackBar

```
Snackbar.make(mDrawerLayout, "Your message", Snackbar.LENGTH_SHORT)
    .setAction(getString(R.string.text_undo), this)
    .show();
```
---

#### Floating Action Buttons

```
<android.support.design.widget.FloatingActionButton
     android:id=”@+id/fab_normal”
     android:layout_width=”wrap_content”
     android:layout_height=”wrap_content”
     android:src=”@drawable/ic_plus”
     app:fabSize=”normal” />
```
_By default floating action button will use the default theme color. But you can
easily change the attributes by using,_
* fabSize - normal/mini
* backgroundTint - use to set background
* rippleColor - to set the ripple effect on button.
* src - use to display the icon in the middle.
* borderWidth - used to give the button a border

---

#### EditText floating labels

```
<android.support.design.widget.TextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <EditText
        android:id="@+id/edit_text_email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textEmailAddress"
        android:hint="@string/hint_email" />

</android.support.design.widget.TextInputLayout>
```

_Error messages are also supported which we can write in our class,_

```
setErrorEnabled(true);
setError(getString(R.string.text_error_message));
```
---

#### Navigation View

```
<android.support.v4.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true">

    <FrameLayout
        android:id="@+id/main_content_frame"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <android.support.design.widget.NavigationView
        android:id="@+id/navigation_view"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        app:headerLayout="@layout/navigation_header"
        app:menu="@menu/drawer" />

</android.support.v4.widget.DrawerLayout>
```

_Now there are two approaches to display the navigation items._

**First** : There will be a list of selectable items. No sub items.

```
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".MainActivity">
    <group android:checkableBehavior="single">
        <item
            android:id="@+id/navigation_item_1"
            android:checked="true"
            android:icon="@drawable/ic_android"
            android:title="@string/navigation_item_1" />
        <item
            android:id="@+id/navigation_item_2"
            android:icon="@drawable/ic_android"
            android:title="@string/navigation_item_2" />
    </group>
</menu>
```

**Second** : There is list of items contains sub items.

```
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".MainActivity">
    <group android:checkableBehavior="single">
        <item
            android:id="@+id/navigation_subheader"
            android:title="@string/nav_header">
            <menu>
                <!-- Menu items go here -->
            </menu>
         </item>
    </group>
</menu>
```
Also we can add menu items programmatically, we just have to call _getMenu()_.
_OnNavigationItemSelectedListener_ will allow us to react to any touch events that take place on our menu.

---

#### Tab Layout

```
<android.support.design.widget.TabLayout
    android:id="@+id/sliding_tabs"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:tabMode="fixed"
    app:tabGravity="fill" />
```

There are some attributes which we can set for tabLayout

* tabMode - fixed / scrollable
* tabGravity - fill / centre
* setText() - To set text displayed on the tab.
* setIcon() - To set the icon on the tabs.

**Listeners**
* OnTabSelectedListener()
* TabLayoutOnPageChangeListener()
* ViewPagerOnTabSelectedListener()

**Attaching tabLayout to ViewPager**
```
ViewPager pager = (ViewPager)
rootView.findViewById(R.id.viewPager);
pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));

TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.sliding_tabs);
tabLayout.addTab(tabLayout.newTab().setText("Tab One"));
tabLayout.addTab(tabLayout.newTab().setText("Tab Two"));
tabLayout.addTab(tabLayout.newTab().setText("Tab Three"));
tabLayout.setupWithViewPager(pager);
```

---

#### App Bar

The CoordinatorLayout lets us adapt our layouts based on different scroll events that may take place, allowing us to alter the appearance of our views (such as the Toolbar) when the user scrolls the content on the screen.

Scroll Properties:

* enterAlways
* enterAlwaysCollapsed

```
<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior=
        "@string/appbar_scrolling_view_behavior" />

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <android.support.v7.widget.Toolbar
            ...
            app:layout_scrollFlags="scroll|enterAlways" />

        <android.support.design.widget.TabLayout
            ...
            />
    </android.support.design.widget.AppBarLayout>
</android.support.design.widget.CoordinatorLayout>

```

#### ToolBars

You can now wrap a Toolbar component with the new CollapsingToolbarLayout, which allows the layout to collapse as the user scrolls the screens content:

```
<android.support.design.widget.AppBarLayout
        android:layout_height="192dp"
        android:layout_width="match_parent">
    <android.support.design.widget.CollapsingToolbarLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_scrollFlags="scroll|exitUntilCollapsed">
        <android.support.v7.widget.Toolbar
                android:layout_height="?attr/actionBarSize"
                android:layout_width="match_parent"
                app:layout_collapseMode="pin" />
        </android.support.design.widget.CollapsingToolbarLayout>
</android.support.design.widget.AppBarLayout>

```
