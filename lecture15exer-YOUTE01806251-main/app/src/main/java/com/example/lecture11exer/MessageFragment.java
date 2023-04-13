package com.example.lecture11exer;

/*
Mobile App Development I -- COMP.4630 Honor Statement
The practice of good ethical behavior is essential for
maintaining good order in the classroom, providing an
enriching learning experience for students, and
training as a practicing computing professional upon
graduation. This practice is manifested in the
University's Academic Integrity policy. Students are
expected to strictly avoid academic dishonesty and
adhere to the Academic Integrity policy as outlined in
the course catalog. Violations will be dealt with as
outlined therein. All programming assignments in this
class are to be done by the student alone unless
otherwise specified. No outside help is permitted
except the instructor and approved tutors.
I certify that the work submitted with this assignment
is mine and was generated in a manner consistent with
this document, the course academic policy on the
course website on Blackboard, and the UMass Lowell
academic code.
Date: Oct 18/2022
Name: John E Youte
*/

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MessageFragment extends Fragment {
    private Button encrypt_button;
    NavDirections action;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        EditText text_to_encrypt = view.findViewById(R.id.edit_message);
        encrypt_button = view.findViewById(R.id.encrypt_button);

        //here there is a try catch to try the method encrypt. and also send the message.
        try {
            action = MessageFragmentDirections.actionMessageFragmentToEncryptFragment(encrypt(text_to_encrypt.getText().toString(), getString(R.string.key)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //checking if editText is empty or not. with a conditional.
        encrypt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(action);
            }
        });
        return view;
    }


    //This is a text encryption that return a string.
    protected static String encrypt(String strClearText, String strKey) throws Exception {
        String strData = "";
        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted = cipher.doFinal(strClearText.getBytes());
            strData = new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }


}