import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // braní parametrů ze vstupu

        Scanner sc = new Scanner(System.in);
        String jmeno = "";
        int znamka = 0;
        try {
            jmeno = sc.next();
        } catch (InputMismatchException err) {
            System.out.println(err);
            System.out.println("Zadejte prosím validní jméno typu char");
        }
        try {
            znamka = sc.nextInt();
        } catch (InputMismatchException err) {
            System.out.println(err);
            System.out.println("Zadejte prosím validní známku typu celé číslo");
        }

        //Vytvoření a přečtení ze souboru data.dat

        File file = new File("data.dat");

        ArrayList<Student> arr;

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            arr = (ArrayList<Student>) ois.readObject();
            ois.close();
        } else {
            arr = new ArrayList<Student>();
        }

        //vytvoření studenta z již ziskaneho vstupu z klavesnice

        Student student = new Student(jmeno, znamka);

        arr.add(student);

        //zapsání studenta do souboru

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(arr);
        ous.close();

        Collections.sort(arr);

        System.out.println(arr);

        /* vystup
        String s = "";
        int znamka2= 0;
        int pocetZnamek = 1;

        for (int i = 1; i < arr.size(); i++){
            while(arr.get(i-1).jmeno == arr.get(i).jmeno){
                s = arr.get(i-1).jmeno;
                znamka2 += arr.get(i-1).znamka;
                pocetZnamek ++;
            }
            znamka /= pocetZnamek;
            znamka = Math.round(znamka);
            pocetZnamek = 1;
            System.out.println(s);
            System.out.println(znamka2);
        }*/

    }
}