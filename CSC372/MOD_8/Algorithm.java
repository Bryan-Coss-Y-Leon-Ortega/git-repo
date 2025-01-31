package CSC372.MOD_8;

import java.util.LinkedList;

public class Algorithm extends Car {
    
    public static void numSort(LinkedList<Car> Garage){

        int min;
        for(int i = 0; i < Garage.size() -1; i++){
            min = i;
            for(int j = i+1; j < Garage.size(); j++){
                if(Garage.get(j).getMpg() < Garage.get(min).getMpg()){
                    Car temp = Garage.get(i);
                    Garage.set(i, Garage.get(j));
                    Garage.set(j, temp);
            }
                
            }
        }
    }
}
