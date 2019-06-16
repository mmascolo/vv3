package com.example.vv3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.app.Activity;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button btnOpenPopup = (Button) findViewById(R.id.openpopup);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater)getBaseContext()
                                .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.popup, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                btnOpenPopup.setEnabled(false);
                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);

        btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        btnOpenPopup.setEnabled(true);
                    }});

                popupWindow.showAsDropDown(btnOpenPopup,Integer.valueOf(btnOpenPopup.getWidth()/2)-100, 0);
            }

        });
    }

}