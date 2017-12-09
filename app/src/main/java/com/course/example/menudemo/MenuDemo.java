/*
 * Putting it all together ......
 * This example uses a <ListView>, a Context Menu, and an Options Menu.
 * The Options Menu will be connected to the <ListView> widget.
 * Both menus will do the same thing.
 * Notice that the <ListView> responds differently to a click vs.
 * tap-and-hold.
 */

package com.course.example.menudemo;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuDemo extends ListActivity  {
	private TextView selection;

	public final String[] items = { "one", "two", "three", "four", "five",
			"six", "seven", "eight", "nine", "ten" };
	
	public static final int ONE_ID 			= Menu.FIRST + 1;
	public static final int TWO_ID 			= Menu.FIRST + 2;
	public static final int EIGHT_ID 		= Menu.FIRST + 3;
	public static final int SIXTEEN_ID 		= Menu.FIRST + 4;
	public static final int TWENTY_FOUR_ID 	= Menu.FIRST + 5;
	public static final int THIRTY_TWO_ID 	= Menu.FIRST + 6;
	public static final int FORTY_ID 		= Menu.FIRST + 7;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        selection = (TextView)findViewById(R.id.selection);
       
		ArrayAdapter<String> aa = new ArrayAdapter<String>(
								this,
								android.R.layout.simple_list_item_1, 
								items);
		setListAdapter(aa);    //connect ArrayAdapter to <ListView>

		//attach a ContextMenu to <ListView> 
		registerForContextMenu(getListView());
    }
    
    //listener for <ListView> click
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String text = " position:" + position + "  " + items[position];
		selection.setText(text);
	}

    // create context menu
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenu.ContextMenuInfo menuInfo) {	
			super.onCreateContextMenu(menu, v, menuInfo);
			populateMenu(menu);		
	}
	
	// create option menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		populateMenu(menu);
		return (super.onCreateOptionsMenu(menu));
	}

	// we will react to the events: either a click on the Menu button
	//to trigger an Options Menu
	// or a long tap-and-hold to trigger a Context Menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {	
		super.onOptionsItemSelected(item);
		return (applyMenuChoice(item) );
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		return (applyMenuChoice(item) );
	}

	////////////////////////////////////////////////////////////////////////
	
	private void populateMenu(Menu menu) {

		menu.add(Menu.NONE, ONE_ID, Menu.NONE, "1 Pixel");
		menu.add(Menu.NONE, TWO_ID, Menu.NONE, "2 Pixels");
		menu.add(Menu.NONE, EIGHT_ID, Menu.NONE, "8 Pixels");
		menu.add(Menu.NONE, SIXTEEN_ID, Menu.NONE, "16 Pixels");
		menu.add(Menu.NONE, TWENTY_FOUR_ID, Menu.NONE, "24 Pixels");
		menu.add(Menu.NONE, THIRTY_TWO_ID, Menu.NONE, "32 Pixels");
		menu.add(Menu.NONE, FORTY_ID, Menu.NONE, "40 Pixels");
		}

	/////////////////////////////////////////////////////////////////////////
	
	private boolean applyMenuChoice(MenuItem item) {

		switch (item.getItemId()) {
		case ONE_ID:
			getListView().setDividerHeight(1);
			return true;

		case EIGHT_ID:
			getListView().setDividerHeight(8);
			return true;

		case SIXTEEN_ID:
			getListView().setDividerHeight(16);
			return true;

		case TWENTY_FOUR_ID:
			getListView().setDividerHeight(24);
			return true;
		case TWO_ID:
			getListView().setDividerHeight(2);
			return true;

		case THIRTY_TWO_ID:
			getListView().setDividerHeight(32);
			return true;

		case FORTY_ID:
			getListView().setDividerHeight(40);
			return true;
		}

		return false;

	}// applyMenuChoice
	
}