package com.example.securitylife.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.securitylife.Model.Data;
import com.example.securitylife.R;

public class login extends Fragment {

    Button login;
    EditText password;
    EditText chiave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        login = (Button) view.findViewById(R.id.button);
        password = (EditText) view.findViewById(R.id.password);
        chiave = (EditText) view.findViewById(R.id.chiave);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // se clicco il bottone vado nel fragment principale dell'applicazione
                // ma prima devo controllare la password e salvare la chiave di cifratura
                if(password.getText().toString().trim().length() != 0 && chiave.getText().toString().trim().length() != 0){
                    if (password.getText().toString().equals("1234")){
                        Data.setKey(Integer.parseInt(chiave.getText().toString()));
                        NavHostFragment.findNavController(login.this)
                                .navigate(R.id.action_navigationLogin_to_navigationMain);
                    }else{
                        Toast.makeText(getContext(),"password non corretta",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getContext(),"inserie la password e o la chiave",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}