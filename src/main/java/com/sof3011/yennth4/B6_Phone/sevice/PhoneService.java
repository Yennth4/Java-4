package com.sof3011.yennth4.B6_Phone.sevice;
import com.sof3011.yennth4.B6_Phone.entity.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneService {

    List<Phone> listPhone;

    public PhoneService() {
        listPhone = new ArrayList<>();
        listPhone.add(new Phone("Iphone15" , " 213000000" , "Apple" , "Xanh"));
        listPhone.add(new Phone("Galaxy S23" , " 105000000" , "Samsung" , "Do"));
        listPhone.add(new Phone("Nokia E6" , " 35000000" , "Nokia" , "Xanh"));
    }

    public List<Phone> getAll() {
        return listPhone;
    }

    public void addPhone(Phone phone) {
        listPhone.add(phone);
    }

}
