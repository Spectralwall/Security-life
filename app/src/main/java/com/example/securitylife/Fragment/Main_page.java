package com.example.securitylife.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.securitylife.Model.Data;
import com.example.securitylife.R;

public class Main_page extends Fragment {

    Button stampa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        stampa = (Button) view.findViewById(R.id.stampa);

        stampa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.seeKey();
            }
        });

        return view;
    }


}