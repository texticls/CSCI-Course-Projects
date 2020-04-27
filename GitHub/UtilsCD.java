import java.util.Scanner;
import javax.swing.JOptionPane;

public class UtilsCD {

    //---------------------------------------------------------------------------
    // user input methods, by datatype
    //---------------------------------------------------------------------------
    
    // get an int value
    public static int readInt(String prompt, boolean flag) {
 
        // set up data and objects
        Scanner input;
        String dataStr;
        String garbage;
        int data = 0;
        boolean failed = true;
        
        // prompt for an input int value using Scanner mode, for input2=false case
        if (!flag) {
          input = new Scanner(System.in);
          System.out.print(prompt);
          
          while ( !input.hasNextInt() ) {
            garbage = input.nextLine();
            System.out.print("\nPlease enter option as integer > ");
            
          }
          
          data = input.nextInt();
           
        }
        
        // prompt for an input int value using JOptionPane mode, for input2=true case
        else {
            while (failed == true) {
               try {
            
                   data = Integer.parseInt( JOptionPane.showInputDialog(null, prompt) );
                   failed = false;
               }
                
               catch(NumberFormatException nfe) {
               }
               
            }       
              
        }
              
        return data; 
       
    }
    
    //---------------------------------------------------------------------------
    // age-related methods
    //---------------------------------------------------------------------------
    
    // returns the age as of some REFERENCE date (2-input overloaded form, MODS NEEDED)
    public static int getAge(CS12Date dateBd, CS12Date dateRef) {
        int age = -1; // starting default output
        int bdMonth;
        int bdDay;
        int bdYear;
        int refMonth;
        int refDay;
        int refYear;
        
        bdMonth = dateBd.getMonth();
        bdDay = dateBd.getDay();
        bdYear = dateBd.getYear();
        refMonth = dateRef.getMonth();
        refDay = dateRef.getDay();
        refYear = dateRef.getYear();   
        
        // case 1: check for birthday year in furute
        if (bdYear > refYear) {
            age = -1;
            System.out.println("\nError: provided birthdate " + dateBd + " is after the current date " + dateRef);
        }
                
        // case 2: check for...
        else if((bdMonth > refMonth) && (bdYear >= refYear)) {
            age = -1;
            System.out.println("\nError: provided birthdate " + dateBd + " is after the current date " + dateRef);
        }
        
        // case 3: check for birthday in future
        else if ((bdDay > refDay) && (bdMonth >= refMonth) && (bdYear >= refYear)) {
            age = -1;
            System.out.println("\nError: provided birthdate " + dateBd + " is after the current date " + dateRef);
        }
        
        // if we get this far, person has been "born" and has a BD within 12 month year
        
        else {
        
            // case 4: check for month of birthday that has not happened
            if (bdMonth > refMonth) {
                age = (refYear - bdYear) - 1;
            }
            
            // case 5: check for birthday day that has not happened
            else if ((bdDay > refDay) && (bdMonth >= refMonth)) {
                 age = (refYear - bdYear) -1;
            }
            
            // case 6: all other birthdays
            else {
                age = (refYear - bdYear);
            }
        
        }
        
        // return ONE common age here, not multiple return statements above!
        return age;
        
    } // end 2-input overloaded version
    
    //---------------------------------------------------------------------------

    // returns the age as of TODAY'S date (1-input overloaded form, NO CHANGES NEEDED, DO NOT EDIT)
    public static int getAge(CS12Date dateBd) {
        int age;
        CS12Date dateToday = today();
        
        // calls overloaded version of above method, using TODAY as the reference date
        age = getAge(dateBd, dateToday);  
        return age;
        
    } // end 1-input overloaded version
    
    
    //---------------------------------------------------------------------------
    // date-related methods 
    //---------------------------------------------------------------------------
    
    // returns today's date as a CS12Date (NO CHANGES NEEDED, DO NOT EDIT)
    public static CS12Date today() {
    
        // simply return a default date, which is today
        return new CS12Date();
        
    }
    
    public static char readChar(String prompt, boolean flag) {
 
        // set up data and objects
        Scanner input;
        String dataStr;
        char data;
        
        // prompt for an input int value using Scanner mode, for input2=false case
        if (!flag) {
          input = new Scanner(System.in);
          System.out.print(prompt);
          data = input.next().charAt(0);
          return data; 
        }
        
        // prompt for an input int value using JOptionPane mode, for input2=true case
        else {
            dataStr = JOptionPane.showInputDialog(null, prompt);
            
            data = dataStr.charAt(0);
        }
           
        return data; 
        
        }
        
    public static double readDouble(String prompt, boolean flag) {
 
        // set up data and objects
        Scanner input;
        String dataStr;
        String garbage;
        double data = 0;
        boolean failed = true;
        
        // prompt for an input int value using Scanner mode, for input2=false case
        if (!flag) {
          input = new Scanner(System.in);
          System.out.print(prompt);
          
          while ( !input.hasNextDouble() ) {
            garbage = input.nextLine();
            System.out.print("\nPlease enter option as a double > ");
            
          }
          
          data = input.nextDouble();
           
        }
        
        // prompt for an input int value using JOptionPane mode, for input2=true case
        else {
            while (failed == true) {
               try {
            
                   data = Double.parseDouble( JOptionPane.showInputDialog(null, prompt) );
                   failed = false;
               }
                
               catch(NumberFormatException nfe) {
               }
               
            }       
              
        }
              
        return data; 
       
    }
    
   public static String readString(String prompt, boolean flag) {
 
        // set up data and objects
        Scanner input;
        String dataStr;
        String data;
        
        // prompt for an input int value using Scanner mode, for input2=false case
        if (!flag) {
          input = new Scanner(System.in);
          System.out.print(prompt);
          data = input.nextLine();
          return data; 
                
        }
        
        // prompt for an input int value using JOptionPane mode, for input2=true case
        else {
        
            data = JOptionPane.showInputDialog(null, prompt);      
            
        }
           
        return data; 
        
        }
       
   public static void pause(String message) {
       // ignores any returned value
       readString(message, false);
       System.out.println();  // add a blank line      
   }
    
   public static void pause() {
         pause("Press <Enter> to continue... ");  
   }
       
} // end class