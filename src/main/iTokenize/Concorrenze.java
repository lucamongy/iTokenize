package main.iTokenize;

import java.util.ArrayList;

public class Concorrenze {

    private static ArrayList<String> res = new ArrayList<String>();
    private static ArrayList<Integer> c = new ArrayList<Integer>();


    public static boolean calcConcorrenze(ArrayList<String> p){
        int a = 0;
        String temp;
        if (p.isEmpty()) return false;
        for (int i = 0; i < p.size(); i++) {
            temp = p.get(i);
            if (res.contains(temp)) {
                System.out.println("CONCORRENZA DI '" + temp + "' ALLA LISTA.");
                a = c.get(res.indexOf(temp)) + 1;
                c.add(res.indexOf(temp), a);
            } else {
                System.out.println("AGGIUNGO '" + temp + "' ALLA LISTA.");
                res.add(temp);
                c.add(1);
            }
        }
        return true;
    }

    public static boolean toFileTXT(){
        return FileManager.printFileTXT(res, c);
    }

    public static boolean toFileCSV(){
        return FileManager.printFileCSV(res, c);
    }

    public static void printWords(){
        for (int i = 0; i < res.size(); i++) {
            System.out.println("'" + res.get(i) + "' "+ c.get(i));
        }
    }

    public static ArrayList<String> getParole(){
        return res;
    }

    public static ArrayList<Integer> getConcorrenze(){
        return c;
    }
}
