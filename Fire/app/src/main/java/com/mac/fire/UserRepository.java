package com.mac.fire;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private FirebaseHandler firebaseHandler;
    private Map<String, User> localUserRepo;

    public UserRepository(FirebaseHandler firebaseHandler) {
        this.firebaseHandler = firebaseHandler;
        this.localUserRepo = new HashMap<>();
    }

    public void createUser(String name, String email) {
        User user;
        if (!localUserRepo.containsKey(name)) {
            String userId = firebaseHandler.getmFirebaseDatabase().push().getKey();
            user = new User(userId, name, email);
            localUserRepo.put(name, user);
            firebaseHandler.getmFirebaseDatabase().child(userId).setValue(user);
        } else {
            user = localUserRepo.get(name);
            user.setEmail(email);
            firebaseHandler.getmFirebaseDatabase().child(localUserRepo.get(name).getId()).setValue(user);
        }

    }
}
