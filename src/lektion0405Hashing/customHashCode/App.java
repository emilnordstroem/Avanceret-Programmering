package lektion0405Hashing.customHashCode;

import java.util.HashSet;

public class App {

    public static void main(String[] args) {
        /*
        Spm 1: Hvad sker der, når man indsætter to bil objekter der har præcis de
        samme attributter i det samme HashSet?
        Svar: Hash koder baseres på memory lokationen - default - og selvom to objekter indeholder
        samme attributter, vil hashkoden stadig være forskellig
         */

        HashSet<Bil> registreretBiler = new HashSet<>();
        System.out.println("Tilføjet biler");
        tilfoejBiler(registreretBiler);
        registreretBiler.forEach(bil -> System.out.println(bil.toString()));
        System.out.println("Tilføjet dupletter");
        tilfoejBiler(registreretBiler);
        registreretBiler.forEach(bil -> System.out.println(bil.toString()));

    }

    private static void tilfoejBiler(HashSet<Bil> registreretBiler){
        registreretBiler.add(
                new Bil(
                        "12345678",
                        "Mercedes",
                        "C220",
                        "Sort"
                )
        );
        registreretBiler.add(
                new Bil(
                        "23456781",
                        "Porsche",
                        "Taycan",
                        "Rød"
                )
        );
        registreretBiler.add(
                new Bil(
                        "34567812",
                        "Land Rover",
                        "Sport",
                        "Sort"
                )
        );
        registreretBiler.add(
                new Bil(
                        "45678123",
                        "Skoda",
                        "Superb",
                        "Grå"
                )
        );
    }

}
