package com.example.securitylife.Fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class login extends Fragment {

    private static final String FILE_NAME = "data.txt";
    private Button login;
    private EditText password;
    private EditText chiave;

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

    //metodo per salvare su file
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void save() {
        String text = password.getText().toString();//prende la password
        FileOutputStream fos = null;//creo un FileoutputStream
        try {
            //gli dico che deve prendere il file nella memoria privata
            fos = requireContext().openFileOutput(FILE_NAME, requireContext().MODE_PRIVATE);
            fos.write(text.getBytes());//e scrivere
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //metodo per leggere da file
    private void load() {
        FileInputStream fis = null;//creo il file imput stream
        try {
            fis = requireContext().openFileInput(FILE_NAME);//prendo il file
            InputStreamReader isr = new InputStreamReader(fis);//creo lo stream reader
            BufferedReader br = new BufferedReader(isr);//prendo il buffer
            StringBuilder sb = new StringBuilder();//lo string builder
            String text;//creo una stringa
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");//appiccico tutto insieme
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}