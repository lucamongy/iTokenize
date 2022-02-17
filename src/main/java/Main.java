import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("----* INIZIO DEBUG *----");
        ArrayList<String> p = FileManager.fileRead("input.txt");
        if (!Concorrenze.calcConcorrenze(p)) System.out.println("FILE VUOTO");
        else {
            System.out.println("----*  STAMPA LISTA *----");
            Concorrenze.printWords();
            if (Concorrenze.toFileTXT()) System.out.println("SCRITTURA TXT CON SUCCESSO.");
            if (Concorrenze.toFileCSV()) System.out.println("SCRITTURA CSV CON SUCCESSO.");
        }
    }
}
