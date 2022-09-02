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

    public static int[] nestMaks(int[] a)
    {
        if (a.length < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");

        int m = Tabell.maks(a);  // m er posisjonen til tabellens største verdi

        Tabell.bytt(a,a.length-1,m);  // bytter om slik at den største kommer forrest

        int k = Tabell.maks(a,0,a.length-1);

        if (k == m) k = a.length - 1; // den nest største lå opprinnelig forrest

        Tabell.bytt(a,a.length-1,m); // bytter tilbake

        return new int[] {m,k};

    } // nestMaks


    // Metode for nestMaksTurnering(int[] a)            Programkode 1.2.13 a)
    public static int[] nestMaksTurnering(int[] a)   // en turnering
    {
        int[] indeks = nestMaks(a);
        int im = indeks[0], inm = indeks[1];
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi,im,inm}; // størst og nest størst

    } // nestMaksTurnering


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

    // Metoden sortering(int[] a)
    public static void sortering(int[] a) {
        for (int i = a.length; i > 1; i--) {
            int m = Tabell.maks(a,0,i);
            Tabell.bytt(a,i-1,m);
        }
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

    // Metoden kopier(int[] a, int i, int[] b, int j, int ant)
    // Kopierer fra tabell a, posisjon i inn i tabell b, posisjon j. ant antall tall fra og med i
    // https://www.geeksforgeeks.org/system-arraycopy-in-java/
    public static void kopier(int[] a, int i, int[] b, int j, int ant)
    {
        for (int n = i + ant; i < n; ) b[j++] = a[i++];
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
