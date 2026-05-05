package com.it.unimol.atenei;

import com.it.unimol.atenei.org.Ateneo;

/* Seguire le indicazioni riportate in 'Istruzioni attività' e restituire i file .java, .class, .jar: Gestione Ateneo */
public class MainAteneo {

    public static void main(String[] args) {
        //Test 1
        //Istanziare un ateneo (ad es. unimol)
        Ateneo ateneo = new Ateneo("Unimol");

        //Invocare il metodo per specificare il rettore (ad es. Giuseppe Vanoli)
        ateneo.setRettore("Giuseppe", "Vanoli");

        //Stampare nome e cognome del rettore di un ateneo (ad es. "Rettore Universita' del Molise: Giuseppe Vanoli)
        System.out.println(ateneo.getName() + " Rettore: " + ateneo.getRettore());

        //Test 2
        //Immatricolare uno studente all'ateneo istanziato nel punto 1. (ad es. Mario Rossi),
        // salvando il num. di matricola in una variabile locale
        Integer m1 = ateneo.immatricola("Mario", "Rossi");
        //ateneo

        //Immatricolare un altro studente all'ateneo istanziato nel punto 1. (ad es. Giuseppe Verdi),
        // salvando il num. di matricola in una variabile locale
        Integer m2 = ateneo.immatricola("Giuseppe", "Verdi");

        //Stampare i num. di matricola dei due studenti appena immatricolati (ad es. "Immatricolati studenti 10000, 10001")
        System.out.println("Immatricolati studenti: " + m1 + " " + m2);

        //Stampare le informazioni relative al primo studente immatricolato (ad es. "Studente1 = 10000 Mario Rossi")
        System.out.println(ateneo.getStudente(m1));

        //Test 3
        //Attivare un corso nell'ateneo istanziato nel punto 1. (ad es. Crittografia, Anna Lisa Ferrara), salvando il codice del corso in una variabile locale
        Integer corsoId1 = ateneo.attiva("Automated Software Delivery", "Simone", "Scalabrino");
        //Attivare un altro corso nell'ateneo istanziato nel punto 1. (ad es. , Manuela Flores),
        // salvando il codice del corso in una variabile locale
        Integer corsoId2= ateneo.attiva("Programmazione Object-Oriented", "Manuela", "Flores");
        //Stampare i codici dei corsi appena attivati (ad es. "Corsi attivati 10 e 11")
        System.out.println("Corsi attivati: " + corsoId1 + " " + corsoId2);
        //Stampare le informazioni relative al primo corso attivato (ad es. "10, Crittografia, Anna Lisa Ferrara")
        System.out.println(ateneo.getCorso(corsoId1));
        // Stampare le informazioni relative al secondo corso attivato
        System.out.println(ateneo.getCorso(corsoId2));

        //Test 4
        //Es. Mario Rossi (100000) si iscrive al corso Automated Software Delivery (10)
        /*
        *
        -Registrare il secondo studente al primo corso

        -Registrare il secondo studente al secondo corso

        -Stampare la frase "Lista iscritti a ...:"

                -Stampare la lista degli studenti iscritti al primo corso

        -Stampare la frase "Lista corsi di ...:"

        -Stampare la lista dei corsi del piano di studi del secondo studente*/
        ateneo.registra(m1, corsoId1, ateneo);
        ateneo.registra(m2, corsoId1, ateneo);
        ateneo.listaIscritti(corsoId1);

        ateneo.registra(m2, corsoId2, ateneo);
        ateneo.listaIscritti(corsoId2);
    }
}