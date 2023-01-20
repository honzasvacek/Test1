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

    }
    public static String outprint(ArrayList<Student> arr){
        int znamkaRound = 0;
        int citac = 1;
        boolean equals = false;
        String s = "";
        for (int i = 0; i < arr.size() - 1; i++) {
            while((arr.get(i).jmeno).compareTo(arr.get(i + 1).jmeno) == 0){
                znamkaRound += arr.get(i).znamka + arr.get(i+1).znamka;
                citac ++;
                equals = true;
                i++;
            }
            if (equals) {
                znamkaRound /= citac;
                znamkaRound = Math.round(znamkaRound);
                s += arr.get(i).jmeno + " " + Integer.toString(znamkaRound);
                s += "";
                znamkaRound = 0;
                citac = 1;
                equals = false;
            }
            else {
                s += arr.get(i).jmeno + " " + Integer.toString(arr.get(i).znamka);
                s += "";
            }

        }
        return s;
    }
}