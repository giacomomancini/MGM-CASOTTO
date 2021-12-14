package it.unicam.cs.mgm.casotto;

import java.util.Scanner;

public interface InterfaceDipendente {
    /**
     * metodo per scrivere un feedback da inviare al gestore
     */
    default void scrivi_feedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il testo del feedback: ");
        String feedback = scanner.nextLine();
        //TODO aggiungere il feedback alla lista
        scanner.close();
    }
}
