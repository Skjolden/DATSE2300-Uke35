import hjelpeklasser.Tabell;

public class Program {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);              //en tilfeldig tabell på 20 entiteter
        for (int i:a) System.out.print(i + " ");       //skriver ut tabellen a

        int m = Tabell.maks(a);                        //finner posisjonen til største verdi

        System.out.println("\nStorste verdi ligger pa plass " + m);

        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int mb = b[0], nmb = b[1];       // m1 for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Storst(" + a[mb] + ") har posisjon " + mb);
        System.out.println(", nest storst(" + a[nmb] + ") har posisjon " + nmb);

        int[] c = Tabell.nestMaksTurnering(a);
        System.out.print("Storst i turnering er (" + c[0] + ") har posisjon " + c[2]);
        System.out.println(", nest storst (" + c[1] + ") har posisjon " + c[3]);

        int[] d = Tabell.randPerm(5);
        Tabell.skrivln(d);
        int[] e = new int[15];
        //Kopierer d først i e
        Tabell.kopier(d,0,e,0,d.length);
        Tabell.skrivln(e);

        //Kopierer d bakerst i e
        Tabell.kopier(d,0,e,e.length - d.length,d.length);
        Tabell.skrivln(e);

        //Kopierer d på midten av e
        Tabell.kopier(d,0,e,(e.length - d.length)/2,d.length);
        Tabell.skrivln(e);
    }
}
