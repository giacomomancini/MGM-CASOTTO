/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.mgm.casotto;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Utente utente = new Utente();
        int scelta;
        do{
        System.out.println("Scegli cosa vuoi fare: ");
        System.out.println("1: Login ");
        System.out.println("2: Registrazione ");
        System.out.println("0: Esci ");
        Scanner scanner = new Scanner(System.in);
        scelta = scanner.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        String username;
        String password;
            switch(scelta) {
                case 1:
                    System.out.println("Digita Username");
                    username = scanner2.nextLine();
                    System.out.println("Digita Password");
                    password = scanner2.nextLine();
                    utente.login(username, password);
                    break;
                case 2:
                    System.out.println("Digita Username");
                    username = scanner2.nextLine();
                    System.out.println("Digita Password");
                    password = scanner2.nextLine();
                    utente.registrazione(username, password);
                    break;
            }
        }
        while(scelta != 0);
    }
}