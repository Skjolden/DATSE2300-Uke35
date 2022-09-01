import hjelpeklasser.Tabell;

public class Program {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);              //en tilfeldig tabell på 20 entiteter
        for (int k:a) System.out.print(k + " ");       //skriver ut tabellen a

        int m = Tabell.maks(a);                        //finner posisjonen til største verdi

        System.out.println("\nStorste verdi ligger pa plass " + m);


        int [] b = {2};
        Tabell.skriv(a, 0, 1);
        Tabell.skriv(a);
        System.out.println();
        Tabell.skrivln(a, 0, 1);
        Tabell.skrivln(a);
        System.out.print("hei");
    }
}
