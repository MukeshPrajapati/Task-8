package com.collectionagency.collectionagency;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.collectionagency.collectionagency.agent.CA_Agent_HomeScreen;
import com.collectionagency.collectionagency.company.CA_Company_HomeScreen;
import com.collectionagency.collectionagency.manager.CA_Manager_Screen;

public class CA_Login_MainActivity extends Fragment {

    private View view;
    private Button ca_btn_login;
    private Button ca_contact, ca_about;
    private EditText username, password;
    private TextView frgt_pwd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ca_login_sceen, container, false);

        //EditText
        username = (EditText)view.findViewById(R.id.ca_et_login);
        password = (EditText)view.findViewById(R.id.ca_et_password);

        //Buttons
        ca_btn_login = (Button)view.findViewById(R.id.ca_btn_login);
        ca_about = (Button)view.findViewById(R.id.ca_about_us);
        ca_contact = (Button)view.findViewById(R.id.ca_contact_us);

        //Login
        ca_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().toString().equals("manager") && password.getText().toString().equals("manager")) {
                    Intent intent = new Intent(CA_Login_MainActivity.this.getActivity(), CA_Manager_Screen.class);
                    startActivity(intent);
                }

                else if(username.getText().toString().equals("company") && password.getText().toString().equals("company")) {
                    Intent intent = new Intent(CA_Login_MainActivity.this.getActivity(), CA_Company_HomeScreen.class);
                    startActivity(intent);
                }

                else if(username.getText().toString().equals("agent") && password.getText().toString().equals("agent")) {
                    Intent intent = new Intent(CA_Login_MainActivity.this.getActivity(),CA_Agent_HomeScreen.class);
                    startActivity(intent);
                }
            }
        });

        //About Us
        ca_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CA_AboutUs.class);
                startActivity(intent);
            }
        });

        //Contact Us
        ca_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CA_Contact.class);
                startActivity(intent);
            }
        });

        //Forgot Password Textview
        frgt_pwd = (TextView)view.findViewById(R.id.ca_tv_frgt_pwd);
        frgt_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CA_ForgotPassword.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
