package com.example.lecture11exer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EncryptFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_encrypt, container, false);

        TextView textView_for_encrypted_text=view.findViewById(R.id.encrypted_text);
        String message = EncryptFragmentArgs.fromBundle(requireArguments()).getMessage();
        textView_for_encrypted_text.setText(message);
        System.out.println(message);
        // Inflate the layout for this fragment
        return view;
    }
}