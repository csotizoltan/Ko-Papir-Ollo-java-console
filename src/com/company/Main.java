package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;


public class Main {

    static String nev;
    static int gamer, computer;
    static int hpGamer = 0;
    static int hpComputer = 0;
    static int hpEqual = 0;
    static ArrayList<String> eredmenyek = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.print("Mi a neved? ");
        nev = sc.nextLine();

        do {
            System.out.println("\n" + "Mi a választásod? 0: Kő, 1: Papír, 2: Olló");

            while (!sc.hasNextInt()) {
                System.out.println("Nem számot adtál meg!");
                sc.next();
            }
            gamer = sc.nextInt();


            if (gamer == 0 || gamer == 1 || gamer == 2) {
                Sorsol();
            }

            else {
                System.out.println("Rossz számot adtál meg! (0: Kő, 1: Papír, 2: Olló)");
            }

        }
        while (!(hpGamer == 3 || hpComputer == 3));

        Vegeredmeny();
        Mentes();
    }


    private static void Sorsol() {

        computer = (int)(Math.random() * 3);

        if (computer == 0) {
            System.out.println("A gép választása: Kő");
        }

        else if (computer == 1) {
            System.out.println("A gép választása: Papír");
        }

        else {
            System.out.println("A gép választása: Olló");
        }


        System.out.print("Ebben a fordulóban ");

        System.out.println(gamer == 0 && computer == 2 || gamer == 1 && computer == 0 || gamer == 2 && computer == 1
                ? "nyertél." : computer == gamer ? "döntetlen." : "vesztettél.");

        Kiertekel();
    }


    private static void Kiertekel() {

        if (gamer == 0 && computer == 2 || gamer == 1 && computer == 0 || gamer == 2 && computer == 1) {
            hpGamer++;
            eredmenyek.add(nev + " nyert.");
        }

        else if (gamer == computer) {
            hpEqual++;
            eredmenyek.add("Döntetlen.");
        }

        else {
            hpComputer++;
            eredmenyek.add("Gép nyert.");
        }
    }


    private static void Vegeredmeny() {

        if (hpGamer == 3) {
            System.out.println("\n\nA játékot " + nev + " nyerte!");
        }

        if (hpComputer == 3) {
            System.out.println("\nA játékot a gép nyerte!");
        }

        System.out.println("\n\n-------------------------");
        System.out.println(nev + " " + hpGamer + " fordulót nyert.");
        System.out.println("A gép" + " " + hpComputer + " fordulót nyert.");
        System.out.println("Döntetlen " + hpEqual + " alkalommal volt.");
        System.out.println("-------------------------");
    }


    private static void Mentes() {

        try {
            FileWriter fw = new FileWriter("eredmeny.txt");

            for (int i = 0; i < eredmenyek.size(); i++) {
                fw.write(i + 1 + "." + " forduló eredménye: ");
                fw.write(eredmenyek.get(i) + System.getProperty("line.separator"));
            }

            fw.write(System.getProperty("line.separator"));
            fw.write("------------------------" + System.getProperty("line.separator"));
            fw.write("A játékot " + nev + " nyerte!" + System.getProperty("line.separator"));
            fw.write("------------------------" + System.getProperty("line.separator"));

            fw.close();
        }

        catch (Exception e) {
            System.err.println(e);
        }
    }
}
