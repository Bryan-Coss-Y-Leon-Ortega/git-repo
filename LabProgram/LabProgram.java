package LabProgram;

    import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); 
      String inputMonth;
      int inputDay;
      
      inputMonth = scnr.next();
      inputDay = scnr.nextInt();
      if(inputMonth.equals("March")){
         if(inputDay >31){
            System.out.println("Invalid"); 
         }if(inputDay >= 20){
            System.out.println("Spring");
         }if(inputDay <20 && inputDay > 0){
            System.out.println("Winter");
         }
      }
      else if(inputMonth.equals("April") && (inputDay >0 && inputDay < 31)){
         System.out.println("Spring");
      }else if(inputMonth.equals("May") && (inputDay >0 && inputDay < 32)){
         System.out.println("Spring");
      }
      else if(inputMonth.equals("June")){
         if(inputDay >31){
            System.out.println("Invalid"); 
         }if(inputDay > 20){
            System.out.println("Summer");
         }if(inputDay <= 20 && inputDay > 0){
            System.out.println("Spring");
         }
      }
      else if(inputMonth.equals("July") && (inputDay >0 && inputDay <= 31)){
         System.out.println("Summer");
      }else if(inputMonth.equals("August") && (inputDay >0 && inputDay < 32)){
         System.out.println("Summer");
      }
      else if(inputMonth.equals("September")){
         if(inputDay >30){
            System.out.println("Invalid"); 
         }if(inputDay > 20 && inputDay < 30){
            System.out.println("Autumn");
         }if(inputDay <= 20 && inputDay > 0){
            System.out.println("Summer");
         }
      }
      else if(inputMonth.equals("October") && (inputDay >0 && inputDay <= 31)){
         System.out.println("Autumn");
      }else if(inputMonth.equals("November") && (inputDay >0 && inputDay < 31)){
         System.out.println("Autumn");
      }
      else if(inputMonth.equals("December")){
         if(inputDay >31 || inputDay < 0){
            System.out.println("Invalid"); 
         }if(inputDay > 20){
            System.out.println("Winter");
         }if((inputDay <= 20) && (inputDay > 0)){
            System.out.println("Autumn");
         }
      }
      else if(inputMonth.equals("January") && (inputDay >0 && inputDay <= 31)){
         System.out.println("Winter");
      }else if(inputMonth.equals("February") && (inputDay >0 && inputDay < 30)){
         System.out.println("Winter");
      }
      else{
         System.out.println("Invalid");
      }
      scnr.close();
   }
}


