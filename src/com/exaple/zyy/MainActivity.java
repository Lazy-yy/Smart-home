package com.exaple.zyy;


import com.exaple.zyy.R;
import com.exaple.zyy.R.id;
import com.exaple.zyy.R.layout;
import com.exaple.zyy.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText usernameEditText, passwordEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//�ҵ��û�������������EditText�ؼ�
		usernameEditText = (EditText) findViewById(R.id.editText1);
		passwordEditText = (EditText) findViewById(R.id.editText2);
	}
	
	//��¼��ť�ĵ���¼�
	public void login(View view) {
		//��ȡ�û�������������EditText�ϵ��ı�
		String username = usernameEditText.getText().toString().trim();
		String password = passwordEditText.getText().toString().trim();
		//�ж������ı�����
		if (username.equals("aaa") && password.equals("111")) {
			//��ת
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			startActivity(intent);
		}
	}
	
	//���ð�ť�ĵ���¼�
	public void reset(View view) {
		usernameEditText.setText("");
		passwordEditText.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
