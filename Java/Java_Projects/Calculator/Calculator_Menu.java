public class Calculator_Menu {
    
    /*
        This is going to be the Agile style menu for calculator. 
        This is going to read a line from user input and then return the resultant
        format # (+-/*) #
            else error
                error should return a blank screen for user to try again
    */
    public void calcMenu(){
        boolean flag = false;
        Scanner scan = new Scanner(System.in);
        String userLine = "";
        System.out.println("Welcome to the calculator app");
        do{
            userLine = scan.nextLine();
            calc(userLine);
        }while(flag != true);

    } 
    public void calc(String userLine){
        System.out.println("String entered:" + userLine );
    }
}
