package CSC372.MOD_7_Ex;

import java.util.HashSet;
import java.util.LinkedList;

public class Main{

    public static void main(String[] args){


        HashSet<String> set = new HashSet<String>();
        
        //set.add(null);
        set.add("A");
        set.add("A");
        set.add("A");
        set.add("A");
        set.add("A");
        set.add("A");
        set.add("B");
        set.add(null);  

        System.out.println(set);

        LinkedList<String> list = new LinkedList<String>();

        list.add(null);
        list.add("A");
        list.add("A");
        list.add("B");
        list.add(null);

        System.out.println(list);
    }

} 