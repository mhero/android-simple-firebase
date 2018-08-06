package com.mac.fire;


import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FirebaseHandler {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private final String DB_NAME = "db";

    public FirebaseHandler(String node, String title) {
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to  node
        mFirebaseDatabase = mFirebaseInstance.getReference(node);

        // store app title to input title
        mFirebaseInstance.getReference(DB_NAME).setValue(title);

    }

    public DatabaseReference getmFirebaseDatabase() {
        return mFirebaseDatabase;
    }


    public FirebaseDatabase getmFirebaseInstance() {
        return mFirebaseInstance;
    }


}
