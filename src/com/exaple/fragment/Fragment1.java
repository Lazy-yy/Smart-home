package com.exaple.fragment;





import com.exaple.allnative.DcmotorNative;
import com.exaple.zyy.R;
import com.exaple.zyy.R.id;
import com.exaple.zyy.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {
	
	
	Button btn1, btn2, btn3;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		
		View view = inflater.inflate(R.layout.fragment1, container, false);
		Button btn =(Button)view.findViewById(R.id.button4);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getActivity(), "点击了第2个fragemnt的按钮,我只是试试的！", Toast.LENGTH_SHORT).show();
				
			}
		});
		return view;
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		DcmotorNative.openDcMotorDev();
		btn1 = (Button)getActivity().findViewById(R.id.Koff);
		btn2 = (Button)getActivity().findViewById(R.id.Kzhileng);
		btn3 = (Button)getActivity().findViewById(R.id.Kchushi);
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DcmotorNative.opDcMotorDev(0);
			}
		});

		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DcmotorNative.opDcMotorDev(1);
			}
		});

		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DcmotorNative.opDcMotorDev(4);
			}
		});

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		DcmotorNative.closeDcMotorDev();
	}

}
