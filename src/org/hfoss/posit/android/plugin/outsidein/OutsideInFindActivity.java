/**
 * 
 */
package org.hfoss.posit.android.plugin.outsidein;

import org.hfoss.posit.android.R;
import org.hfoss.posit.android.api.Find;
import org.hfoss.posit.android.api.activity.FindActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Button;

/**
 * FindActivity subclass for Outside In plugin.
 * 
 */
public class OutsideInFindActivity extends FindActivity {

	private static final String TAG = "OutsideInFindActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate()");
		//savedInstanceState.putString(FindPluginManager., value)
		super.onCreate(savedInstanceState);
		
		

		setContentView(R.layout.outsidein_add_find);
		initializeListeners();

	}

	@Override
	protected void initializeListeners() {
		super.initializeListeners();
	}

	@Override
	protected Find retrieveContentFromView() {
		OutsideInFind find =  (OutsideInFind)super.retrieveContentFromView();
	
		EditText eText = (EditText) findViewById(R.id.syringesInEditText);
		String value = eText.getText().toString();
		find.setSyringesIn(Integer.parseInt(value));

		eText = (EditText) findViewById(R.id.syringesOutEditText);
		value = eText.getText().toString();
		find.setSyringesOut(Integer.parseInt(value));

		CheckBox checkBox = (CheckBox) findViewById(R.id.isNewCheckBox);
		find.setNew(checkBox.isChecked());

		return find;
	}

	@Override
	protected void displayContentInView(Find find) {
		OutsideInFind oiFind = (OutsideInFind)find;
		EditText et = (EditText)findViewById(R.id.guidEditText);
		et.setText(oiFind.getGuid());
		
		et = (EditText)findViewById(R.id.syringesInEditText);
		et.setText(oiFind.getSyringesIn());
		
		et = (EditText)findViewById(R.id.syringesOutEditText);
		et.setText(oiFind.getSyringesOut());
		
		CheckBox cb = (CheckBox)findViewById(R.id.isNewCheckBox);
		cb.setChecked(oiFind.isNew());
		
	}

	public void onClick(View v) {
		super.onClick(v);
	}

}
