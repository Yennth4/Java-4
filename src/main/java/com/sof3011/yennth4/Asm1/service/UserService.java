package com.sof3011.yennth4.Asm1.service;
import com.sof3011.yennth4.Asm1.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> listUser;

    public UserService() {
        listUser = new ArrayList<>();
        listUser.add(new User("nva", "123", "nva@gmail.com", "Nguyen Van A", true));
        listUser.add(new User("nvb", "456", "nvb@gmail.com", "Nguyen Van B", false));
    }

    public List<User> getAllUser() {
        return listUser;
    }

    public void addUser(User user) {
        listUser.add(user);
    }

    public void updateUser(User user) {
        for (int i = 0; i < listUser.size() ; i++) {
            if (listUser.get(i).getId().equalsIgnoreCase(user.getId())) {
                listUser.set(i , user);
            }
        }
    }

    public User detailUser(String id) {
        for (User user : listUser) {
                if (user.getId().equalsIgnoreCase(id)) {
                    return user;
                }
        }
        return null;
    }

    public void deleteUser (String id) {
        for (int i = 0; i < listUser.size() ; i++) {
            if (listUser.get(i).getId().equalsIgnoreCase(id)) {
                listUser.remove(i);
            }
        }
    }

}