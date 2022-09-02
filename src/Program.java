import hjelpeklasser.Tabell;

public class Program {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);              //en tilfeldig tabell på 20 entiteter
        for (int i:a) System.out.print(i + " ");       //skriver ut tabellen a

        int m = Tabell.maks(a);                        //finner posisjonen til største verdi

        System.out.println("\nStorste verdi ligger pa plass " + m);

        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int m1 = b[0], nm = b[1];       // m1 for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Storst(" + a[m1] + ") har posisjon " + m1);
        System.out.println(", nest storst(" + a[nm] + ") har posisjon " + nm);

        Tabell.sortering(a);
        Tabell.skrivln(a);
    }
}
