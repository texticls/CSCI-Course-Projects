import java.util.Scanner;
import javax.swing.JOptionPane;

public class DamCD {
      
      // instance variables
      private String name; // name of dam
      private int year; // year dam opened
      private double storage; // contains current storage data
      private double capacity; // contains max capacity of dam data
      private double inflow; // contains inflow data
      private double outflow; // contains outflow data
      private CS12Date date;
      
      // constants
      private int TOL = 1;
      // other class data
      
      // data above here 
      //==================================================
      // methods below here
      
      // default constructor
      public DamCD() {
         name = "<default dam>";
         year = 1900;
         storage = 0.0;
         capacity = 0.0;
         inflow = 0.0;
         outflow = 0.0;
         date = new CS12Date();
      }
      
      // full constructor
      public DamCD(String name, int year, double storage, double capacity, double inflow, double outflow, CS12Date date) {
         this.name = name;
         this.year = year;
         this.storage = storage;
         this.capacity = capacity;
         this.inflow = inflow;
         this.outflow = outflow;
         this.date = date;
      }
      
      public DamCD(String name, int year) {
         this.name = name;
         this.year = year;
      }
      
      public DamCD(String name, double capacity) {
         this.name = name;
         this.capacity = capacity;
      }
      
      // display methods --------------------------
      
      // string version of object data
      public String toString() {
         return name + ", " + year + ", " + storage + ", " + capacity + ", " + inflow + ", " + outflow + ", " + date;
      }
      
      // formatted version of object data
      public void print() {
         System.out.println("name:\t" + name);
         System.out.println("year:\t" + year);
         System.out.println("storage:\t" + storage);
         System.out.println("capacity:\t" + capacity);
         System.out.println("inflow:\t" + inflow);
         System.out.println("outflow:\t" + outflow);
         System.out.println("date:\t" + date);
      }
      
      // overloaded version of print, accepts a label string
      public void print(String message) {
         System.out.println("=======================");
         System.out.println(message);
         System.out.println("=======================");
         print();
      }
      
      // accessors, mutators --------------------------
      
      // name accessor
      public String getName() {
         return name;
      }
      
      // name mutator
      public void setName(String name) {
         this.name = name;
      }

      
      // overloaded mutator version, prompts for data / name
      public void setName(boolean inputMode) {
         String data = UtilsCD.readString("Enter dam name > ", inputMode);
            setName(data);
      }
      
       // year accessor
      public int getYear() {
         return year;
      }
      
      // year mutator
      public void setYear(int year) {
         this.year = year;
      }

      
      // overloaded mutator version, prompts for data / year
      public void setYear(boolean inputMode) {
         int data = UtilsCD.readInt("Enter year built > ", inputMode);
            setYear(data);
      }
      
      // storage accessor
      public double getStorage() {
         return storage;
      }
      
      // storage mutator
      public void setStorage(double storage) {
         this.storage = storage;
      }

      
      // overloaded mutator version, prompts for data / storage
      public void setStorage(boolean inputMode) {
         double data = UtilsCD.readDouble("Enter current storage [acre-ft] > ", inputMode);
            setStorage(data);
      }
      
      // capacity accessor
      public double getCapacity() {
         return capacity;
      }
      
      // capacity mutator
      public void setCapacity(double capacity) {
         this.capacity = capacity;
      }

      
      // overloaded mutator version, prompts for data / capacity
      public void setCapacity(boolean inputMode) {
         double data = UtilsCD.readDouble("Enter max capacity [acre-ft] > ", inputMode);
            setCapacity(data);
      }
      
      // inflow accessor
      public double getInflow() {
         return inflow;
      }
      
      // inflow mutator
      public void setInflow(double inflow) {
         this.inflow = inflow;
      }

      
      // overloaded mutator version, prompts for data / inflow
      public void setInflow(boolean inputMode) {
         double data = UtilsCD.readDouble("Enter current inflow [cu-ft/s] > ", inputMode);
            setInflow(data);
      }
      
      // outflow accessor
      public double getOutflow() {
         return outflow;
      }
      
      // outflow mutator
      public void setOutflow(double outflow) {
         this.outflow = outflow;
      }

      
      // overloaded mutator version, prompts for data / outflow
      public void setOutflow(boolean inputMode) {
         double data = UtilsCD.readDouble("Enter current outflow [cu-ft/s] > ", inputMode);
            setOutflow(data);

      }
      
      // date accessor
      public CS12Date getDate() {
         return date;
      }
      
      // date mutator
      public void setDate(CS12Date date) {
         this.date = date;
      }

      
      // overloaded mutator version, prompts for data / date
      public void setDate(boolean inputMode) {
         int month = UtilsCD.readInt("Enter month dam was build > ", inputMode);
         int day = UtilsCD.readInt("Enter day dam was build > ", inputMode);
         int year = UtilsCD.readInt("Enter year dam was build > ", inputMode);
         CS12Date data = new CS12Date(month, day, year);
         setDate(data);
      }

      
      // equivalance --------------------------
      
      public boolean equals(Object obj) {
      
          if (!(obj instanceof DamCD)) {
           
            return false;
            
          } // end if
          
          else {
          
             DamCD n = (DamCD) obj;
          
             if ( (n.getName().equals(this.name)) &&
                  (Math.abs(n.getYear() - this.year) <= TOL) &&  
                  (Math.abs(n.getStorage() - this.storage) <= TOL)  ) {
          
            return true;
          
             } // end if
          
             else {
          
              return false;
             
             } // end else
          
          }
      
      } // end equals
      
      
      // derived data accessors
      
      
      // utility methods
      
     
   // test code
   public static void main(String [] args) {
      
     DamCD n1 = new DamCD();
     DamCD n2 = new DamCD("Test dam", 2012, 0.0, 0.0, 0.0, 0.0, new CS12Date(1, 1, 1990));
     
     System.out.println(n1);
     n1.print();
     n1.print("Default constructor name is:");
     System.out.println();
     
     System.out.println(n2);
     n2.print();
     n2.print("Full constructor name is:");
     System.out.println();
     UtilsCD.pause();
     
     // test accessor(s)
     System.out.println("n2 name = " + n2.getName());
     System.out.println();
     
     // test mutator(s)
     n2.setName("dam test");
     n2.print("p2 after mutators");
     System.out.println();
     
     n2.setName(false);
     n2.print("n2 after mutator prompts");
     System.out.println();
     UtilsCD.pause();
     
     // test equality
     
     // two different objects should differ
     System.out.println("n1 equals n2? " + n1.equals(n2));
     
     // same object is equal to itself
     System.out.println("n2 equals n2? " + n2.equals(n2));
     
     // a name can't equal another objct
     String temp = new String("temp");
     System.out.println("n2 equals temp? " + n2.equals(temp));
     
     
    } // End Main
    
      
} // End Class