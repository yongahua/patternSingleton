package gupao.vip.pattern.singleton.test.hungry;


import gupao.vip.pattern.singleton.hungry.HungrySeriableSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HungrySeriableSingletonTest {
    public static void main(String[] args) {
        HungrySeriableSingleton s1 = null;
        HungrySeriableSingleton s2 = HungrySeriableSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("HungrySeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();


            FileInputStream fis = new FileInputStream("HungrySeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (HungrySeriableSingleton)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
