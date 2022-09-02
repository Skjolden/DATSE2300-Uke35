package hjelpeklasser;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {   // Samleklasse for tabellmetoder
    private Tabell() {} // privat standardkonstruktør - hindrer instansiering

    // Metoden bytt(int[] a, int i, int j)      Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n) {// en effektiv versjon
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
    public static void randPerm(int[] a) {  // stokker om a
        Random r = new Random();            // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1); // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
    public static int maks(int[] a, int fra, int til) {
        /*if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }
        Erstattet av:*/
        fraTilKontroll(a,a.length,fra,til);

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
    public static int min(int[] a, int fra, int til) {
        /*if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }
        Erstattet av:*/
        fraTilKontroll(a,a.length,fra,til);

        int m = fra;                // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];      // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                m = i;              // indeks til minste verdi oppdateres
                minverdi = a[m];    // minste verdi oppdateres
            }
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }

    // Metoden bytt(char[] c, int i, int j)
    public static void bytt(char[] a, int i, int j) {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    // Metoden skriv(int[] a, int fra, int til)
    public static void skriv(int[] a, int fra, int til) {
        /*if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }
        Erstattet av:*/
        fraTilKontroll(a,a.length,fra,til);

        for (int i = fra; i < til; i++) {
            if (i < til-1) {
                System.out.print(a[i] + " ");
            } else {
                System.out.print(a[i]);
            }
        }
    }

    // Metoden skriv(int[] a)
    public static void skriv(int[] a) {
        skriv(a, 0, a.length);
    }

    // Metoden skrivln(int[] a, int fra, int til)
    public static void skrivln(int[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }

    // Metoden skrivln(int[] a)
    public static void skrivln(int[] a) {
        skrivln(a, 0, a.length);
    }

    // Metoden fraTilKontroll(int tablengde, int fra, int til)  Programkode 1.2.3 a)
    public static void fraTilKontroll(int[] a, int tablengde, int fra, int til)
    {
        if (a == null)                                // a er null
            throw new NullPointerException
                    ("parametertabellen a er null");

        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
    }

    // Metoden vhKontroll(int tablengde, int v, int h)          Programkode 1.2.3 d)
    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    /*
    Forskjellige unntaksklasser fra java
    NullPointerException,  IllegalArgumentException,  IllegalStateException,
    ArrayIndexOutOfBoundsException,  StringIndexOutOfBoundsException,
    IndexOutOfBoundsException,  NoSuchElementException
    InvalidParameterException,  NumberFormatException
    */


}
