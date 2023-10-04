import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner cititor = new Scanner(System.in);

        System.out.println("Doriti sa incepem jocul?");
        String raspuns = cititor.nextLine();
        if (raspuns.equalsIgnoreCase("da")) {
            startGame();
        } else if (raspuns.equalsIgnoreCase("nu")) {
            System.out.println("Va mai asteptam pe la noi!");
        } else {
            System.out.println("Nu ai introdus un raspuns valabil.Raspunde cu da sau nu.");
        }

    }

    public static void startGame() {
        int buget = 100;
        ArrayList<String> posibilitati = new ArrayList<>(Arrays.asList("SAPTE", "CIRESE", "DIAMANT"));

        Scanner cititor = new Scanner(System.in);
        Random generator = new Random();

        while (true) {
            System.out.println("Introduceti miza. Bugetul vostru este de " + buget);
            double miza = cititor.nextDouble();
            if (miza > buget) {
                System.out.println("Nu ai suficienti bani.");
            } else {
                //traggem de roata
                buget -= miza;
                System.out.println("Am tras de roata.");
                String rezultat1 = posibilitati.get(generator.nextInt(posibilitati.size()));
                String rezultat2 = posibilitati.get(generator.nextInt(posibilitati.size()));
                String rezultat3 = posibilitati.get(generator.nextInt(posibilitati.size()));

                System.out.println(rezultat1);
                System.out.println(rezultat2);
                System.out.println(rezultat3);

                if (rezultat1.equalsIgnoreCase(rezultat2) && rezultat2.equalsIgnoreCase(rezultat3)){
                    System.out.println("JACKPOT");
                    double deAdaugat=(30.0/100.0)*miza;
                    buget+=miza+deAdaugat;
                } else if (rezultat1.equalsIgnoreCase(rezultat2) || rezultat2.equalsIgnoreCase(rezultat3)||rezultat1.equalsIgnoreCase(rezultat3)) {
                    System.out.println("SEMI-JACKPOT");
                    double deAdaugat=(90.0/100.0)*miza;
                    buget+=deAdaugat;
                }else {
                    System.out.println("AI PIERDUT.");
                }
                if (buget<=1){
                    System.out.println("AI PIERDUT JOCUL:((");
                    break;
                }else if(buget>=1000){
                    System.out.println("AI CASTIGAT JOCUL!!!");
                    break;
                }

            }


        }
    }
}