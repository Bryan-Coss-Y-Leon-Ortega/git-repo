import java.util.HashMap;

public class Map_practice {


    /*
    Hash maps are data structures that store key-value pairs

    
    */
    public static void main(String args[]){

        HashMap<String, Double> map = new HashMap<>();

        map.put("apple", 0.50);


        /*
        Here we are printing the map

        */
        for(String key: map.keySet()){
            System.out.println(key + " :$" + map.get(key));
        }

    }
}
