package main.iTokenize;


import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class FileManager {

    public static ArrayList<String> fileRead(String path){
        ArrayList<String> words= new ArrayList<String>();
        try {
            File f = new File(path);
            Scanner scan = new Scanner(f);
            System.out.println("INIZIO LETTURA DEL FILE '"+path+"'.");
            while (scan.hasNext()) {
                words.add(scan.next());
            }
            scan.close();
            System.out.println("LETTURA FILE COMPLETATA CON SUCCESSO.");
        } catch (FileNotFoundException e) {
            System.out.println("FILE NON TROVATO");
        } catch (Exception e){
            System.out.println("Errore Generico");
        }

        return words;
    }

    public static boolean printFileTXT(ArrayList<String> s, ArrayList<Integer> c){
        ListIterator<String> its = s.listIterator();
        ListIterator<Integer> itc = c.listIterator();
        try {
            PrintStream f = new PrintStream(new File("RESULT.txt"));
            System.out.println("INIZIO SCRITTURA FILE TXT.");
            while (its.hasNext() && itc.hasNext())
                f.println(its.next()+" "+itc.next());
            f.flush();
            f.close();
            return true;
        } catch (IOException e) {
            System.out.println("ERRORE DI I/O");
            return false;
        } catch (Exception e){
            System.out.println("ERRORE GENERALE");
            return false;
        }
    }

    public static boolean printFileCSV(ArrayList<String> s, ArrayList<Integer> c){
        ListIterator<String> its = s.listIterator();
        ListIterator<Integer> itc = c.listIterator();
        try {
            FileWriter csvWriter = new FileWriter("RESULT.csv");
            System.out.println("INIZIO SCRITTURA FILE CSV.");
            csvWriter.append("Word");
            csvWriter.append(",");
            csvWriter.append("Times");
            csvWriter.append("\n");
            while(its.hasNext() && itc.hasNext()){
                csvWriter.append(its.next()+","+itc.next());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
            return true;
        }catch(IOException e){
            System.out.println("ERRORE DI I/O");
            return false;
        }
    }
}
