/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akshay.newmaterialdesignlibrary;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Provides UI for the view with Tile.
 */
public class OtherContentFragment extends Fragment {
    TextInputLayout textInputLayout;
    TextInputLayout textInputLayoutpass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_other, container, false);
        final EditText email=(EditText)view.findViewById(R.id.edit_text_email);
        Button button=(Button) view.findViewById(R.id.button);
        textInputLayoutpass=(TextInputLayout) view.findViewById(R.id.textInputLayoutPass);
        textInputLayout=(TextInputLayout) view.findViewById(R.id.textInputLayout);



        //email.setError("Dont left the field blank");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString=email.getText().toString();
                if(emailString.equals("")){

                    textInputLayout.setError("Dont left the field blank");
                 }
                else {
                    textInputLayout.setErrorEnabled(false);
                }


            }
        });
        return view;
    }


}