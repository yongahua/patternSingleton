package gupao.vip.pattern.singleton.test.lazy;

import gupao.vip.pattern.singleton.lazy.LazySeriableSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LazySeriableSingletonTest {
    public static void main(String[] args) {
        LazySeriableSingleton s1 = null;
        LazySeriableSingleton s2 = LazySeriableSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("LazySeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();


            FileInputStream fis = new FileInputStream("LazySeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (LazySeriableSingleton)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
