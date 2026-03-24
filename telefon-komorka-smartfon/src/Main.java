import exceptions.WrongNumberFormatException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Phone> phoneList = new ArrayList<>();
        Phone phone = new Phone("communication interface 1", Color.RED);
        MobilePhone mobilePhone= new MobilePhone("communication interface 2", Color.WHITE);
        Smartphone smartphone= new Smartphone("communication interface 3", Color.GREEN);
        smartphone.addFriend(new Person("firstname1", "lastname1", "111-111-111"));
        smartphone.addFriend(new Person("firstname2", "lastname2", "222-222-222"));
        smartphone.addFriend(new Person("firstname3", "lastname3", "333-333-333"));
        smartphone.addFriend(new Person("firstname4", "lastname4", "444-444-444"));
        smartphone.addFriend(new Person("firstname5", "lastname5", "555-555-555"));
        phoneList.add(phone);
        phoneList.add(mobilePhone);
        phoneList.add(smartphone);
        try {
            phone.call("111-111-111");
            phone.call("111-113-111");
            phone.call("111-111-111");
            phone.call("111-141-111");
            phone.call("222-222-222");
            phone.call("000-444-000");
            phone.call("333-333-333");
            phone.call("111-171-111");
            phone.call("333-333-333");
            phone.call("111-110-111");
        } catch (WrongNumberFormatException e) {
            System.out.println(e.getMessage());
        }
        try {
            mobilePhone.call("111-222-333");
            mobilePhone.call("111-111-111");
            mobilePhone.call("901-761-888");
            mobilePhone.call("222-222-222");
            mobilePhone.call("945-761-131");
            mobilePhone.call("555-555-555");
            mobilePhone.call("945-761-131");
            mobilePhone.call("555-555-555");
            mobilePhone.call("945-761-131");
            mobilePhone.call("444-444-444");
            mobilePhone.call("111-222-3333");
        } catch (WrongNumberFormatException e) {
            System.out.println(e.getMessage());
        }
        try {
            smartphone.call("111-222-333");
            smartphone.call("333-333-333");
            smartphone.call("111-222-333");
            smartphone.call("333-333-333");
            smartphone.call("111-222-333");
            smartphone.call("222-222-222");
            smartphone.call("111-222-333");
            smartphone.call("111-111-111");
            smartphone.call("111-222-333");
            smartphone.call("555-555-555");
            smartphone.call("111-222-3333");
        } catch (WrongNumberFormatException e) {
            System.out.println(e.getMessage());
        }
        for (Phone p : phoneList) {
            p.showCallHistory();
        }
        try {
            mobilePhone.call("945-761-131");
        } catch (WrongNumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
