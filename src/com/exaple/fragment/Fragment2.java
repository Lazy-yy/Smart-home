package com.exaple.fragment;




import com.exaple.allnative.CurtainNative;
import com.exaple.zyy.R;
import com.exaple.zyy.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment{
	
	
	EditText dt;

	TextView tv;

	Button btn1, btn2;

	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance){
		
		
		View view = inflater.inflate(R.layout.fragment2, container, false);
		return view;
		
		
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		
		
	    CurtainNative.openCurtainDev();
		
		tv = (TextView) getActivity().findViewById(R.id.sure1);
		dt = (EditText)getActivity().findViewById(R.id.input1);
		

		btn1 = (Button) getActivity().findViewById(R.id.shun);
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
					Toast.makeText(getActivity(), "点击了第2个fragemnt的按钮,我只是试试的！", Toast.LENGTH_SHORT).show();
					
				
				String s = dt.getText().toString();
				final int num = Integer.parseInt(s);
				CurtainNative.changeCurtainDev(1, num);
				tv.setText(num + "");
			}
		});

		btn2 = (Button) getActivity().findViewById(R.id.ni);
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s = dt.getText().toString();
				final int num = Integer.parseInt(s);
				CurtainNative.changeCurtainDev(3, num);
				tv.setText(num + "");
			}
		});
	}


   public void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	CurtainNative.closeCurtainDev();
}
	
	
	
	
	
}