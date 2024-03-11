package controller;

import com.sun.jdi.ArrayReference;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import Repository.FileWork;

public class FoodManagement {
    public FileWork fw = new FileWork();

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public void AddFood() {
        String p = prompt("insert variety of food with spaces if many: ");
        ArrayList<String> a = new ArrayList<>(List.of(p.split(" ")));
        fw.addAll(a);
    }

    public void listFood(){
        ArrayList<String> a = fw.readAll();
        System.out.println(a);
    }
    public void countFood() {
        ArrayList<String> a = fw.readAll();
        System.out.println(a.size()+" pieces" + " - thats how much food there are");
    }

    public void frequencyOfWords() {
        System.out.println("Thats how much of unique variants of food is at the picnic: ");
        HashMap<String, Integer> a = fw.arrayListToHashMapWithFrequency(fw.readAll());
        int i = 1;
        for (String word : a.keySet()) {
            if (i != a.size()) {
                System.out.print(word +" = "+ a.get(word) + ", ");
                i++;
            } else {
                System.out.print(word +" = "+ a.get(word) + ".\n");
            }
        }
    }

    public void printLongestWord() {
        HashMap<String, Integer> a = fw.arrayListToHashMapWithFrequency(fw.readAll());
        int length = 0;
        String longest = null;
        for (String word : a.keySet()) {
            if (word.length() > length) {
                length = word.length();
                longest = word;
            }
        }
        System.out.println(longest + " is the longest word(" + length + ")");
    }
}
