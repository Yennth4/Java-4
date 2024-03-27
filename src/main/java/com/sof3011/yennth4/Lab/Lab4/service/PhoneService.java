package com.sof3011.yennth4.Lab.Lab4.service;

import com.sof3011.yennth4.Lab.Lab4.entity.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneService {

    List<Phone> listPhone;

    public PhoneService() {
        listPhone = new ArrayList<>();

        listPhone.add(new com.sof3011.yennth4.Lab.Lab4.entity.Phone(1, "Iphone15" , " 213000000" , "Apple" , "Xanh"));
        listPhone.add(new com.sof3011.yennth4.Lab.Lab4.entity.Phone(2, "Galaxy S23" , " 105000000" , "Samsung" , "Do"));
        listPhone.add(new com.sof3011.yennth4.Lab.Lab4.entity.Phone(3 ,"Nokia E6" , " 35000000" , "Nokia" , "Xanh"));
    }

    public List<Phone> getAll() {
        return listPhone;
    }

    public void addPhone(Phone phone) {
        listPhone.add(phone);
    }

    public void updatePhone(Phone phone) {
        for (int i = 0; i < listPhone.size(); i++) {
            if (listPhone.get(i).getId() == phone.getId()) {
                listPhone.set(i , phone);
            }
        }
    }

    public void deletePhone(int id) {
        for (int i = 0; i < listPhone.size(); i++) {
            if (listPhone.get(i).getId() == id) {
                listPhone.remove(i);
            }
        }
    }

    public Phone detailPhone(int id) {
        for(Phone phone : listPhone) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }

}
