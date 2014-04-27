package com.mage.sampleusesharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	CheckBox checkBox;
	EditText editTextName;
	EditText editTextEmail;
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		editTextName = (EditText) findViewById(R.id.editTextName);
		editTextEmail = (EditText) findViewById(R.id.editTextEmail);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		loadSavedPreferences();
	}

	private void loadSavedPreferences() {
		// Obtém a instância da SharedPreference  
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		// Recupera os valores
		boolean cbValue = sp.getBoolean("CHECKBOX", false);
		String name = sp.getString("NAME", "YourName");
		String email = sp.getString("EMAIL", "YourEmail");
		if (cbValue) {
			checkBox.setChecked(true);
		} else {
			checkBox.setChecked(false);
		}

		editTextName.setText(name);
		editTextEmail.setText(email);
	}

	private void savePreferences(String key, boolean value) {
		// Obtém a instância da SharedPreference  
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		// Salva valores nas preferências  
		Editor edit = sp.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	private void savePreferences(String key, String value) {
		// Obtém a instância da SharedPreference
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		// Salva valores nas preferências 
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		savePreferences("CHECKBOX", checkBox.isChecked());
		if (checkBox.isChecked())
			savePreferences("NAME", editTextName.getText().toString());
			savePreferences("EMAIL", editTextEmail.getText().toString());

		finish();
	}

}
