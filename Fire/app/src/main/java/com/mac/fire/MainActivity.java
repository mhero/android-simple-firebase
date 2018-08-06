package com.mac.fire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity {


    private String userId;
    private FirebaseHandler firebaseHandler;
    private EditText inputName, inputEmail;
    private Button btnSave;
    private UserRepository userRepository;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkElements();

        firebaseHandler = new FirebaseHandler("users", "db");
        userRepository = new UserRepository(firebaseHandler);

        btnSave.setOnClickListener(buttonSave());

    }

    private View.OnClickListener buttonSave() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();

                userRepository.createUser(name, email);
            }
        };

    }

    private void linkElements() {
        inputName = (EditText) findViewById(R.id.inputName);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        btnSave = (Button) findViewById(R.id.btnSave);
    }


}
