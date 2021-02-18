//  Starting point for Program 2
//  Birthday.java
//  Die
//
import java.util.*;

//------------------------------------------------------------------------------
public class Birthday{
    public static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May",
    "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    public static final String[] days = { "Sunday", "Monday", "Tuesday",
    "Wednesday", "Thursday", "Friday", "Saturday" };
    public static final int[] startsOn = {5, 1, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3, };
    public static final int[] numberofdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		//number of days in months

    // The collection of data members stores the STATE of an object.
    // Data members of a class are normally private.   Document each one.
    private String month;   	// 3-letter abbreviation for the month.
    private int date;       	// Will be 1..31
    private String day;     	// The day of the week.
    private int numofmonth;		//Number of months
    private int daysinmonth;	//Days in month
    //--------------------------------------------------------------------------
    // Compute a new random value for the die.
    // Postcondition: the return value is between 1 and faces.
    Birthday( String m, int d){
        month = m;
        date = d;
        calculateDay();
    }

    //--------------------------------------------------------------------------
    private void calculateDay() {
        int found, k, answer;
        for(k=0; k<12; ++k) {
            if (months[k].equals(month))  break;
        }
        found = k;
        
        numofmonth = k;				//initializing the number of the month
        
        if (found == 12)
            System.out.println("Your month name was not a valid 3-letter abbreviation.");
        else {
            answer = (startsOn[k] + date -1)%7;
            day = days[answer];
        }
    }
    
    //---Calculate day of the year
    private int Calculate_nthday() {
    	int i, sum;
    	sum=0;
    	for(i=0; i<numofmonth; i++) {		
    		sum += numberofdays[i];				//sum all the days of passed months
    	}
    	sum += date;							//adding the date in sum
    	daysinmonth = sum;
    	return daysinmonth;						//returns nth day of the year
    }

    //---------- A get function gives read-only access to a private data member.
    public String getDay(){  return day;  }

    //--------------------------------------------------------------------------
    // Define toString for every class.
    // Return a string that reports the state of the class. Used for debugging.
    public String toString(){
        return month +" " + date ;
    }

    //--------------------------------------------------------------------------
    public static  void  main( String[] args ) {
        int date;
        String monthname;
        Scanner sc = new Scanner( System.in );

        System.out.println("\nBirthday Day Calculator, Welcome!");
        System.out.print ("Months are: ");
        for( String s : months) System.out.print( s+"  " );

        System.out.println("\n\nPlease enter your birth month and date:");
        monthname = sc.next();
        date = sc.nextInt();
        Birthday b = new Birthday (monthname, date);

        System.out.printf ( "Your %s birthday is on %s this year\n\n it is day %s of the year",
                           b.toString(), b.getDay(), b.Calculate_nthday() );							//prints the number of days in year.
    }
}


/*
 ----------------------------------------------------------------------------------------
 Output for December 31:
 
 Your Dec 31 birthday is on Friday this year

 it is day 365 of the year
 
 -----------------------------------------------------------------------------------------
 Output for January 1:
 
 Your Jan 1 birthday is on Friday this year

 it is day 1 of the year
 
 -----------------------------------------------------------------------------------------
 Output for February 1:
 
 Your Feb 26 birthday is on Friday this year

 it is day 57 of the year
 
 -------------------------------------------------------------------------------------------
 Output for October 31:
 
 Your Oct 31 birthday is on Sunday this year

 it is day 304 of the year
 
 --------------------------------------------------------------------------------------------
 Output for October 25:
 
 Your Oct 25 birthday is on Monday this year

 it is day 298 of the year
 
 ---------------------------------------------------------------------------------------------
  */