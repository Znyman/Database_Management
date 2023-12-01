package zacheryNyman;

import java.io.* ;
import java.util.Random ;

public class DataGenerator {
	public static void main(String[] args) {

		Random generator = new Random() ;
		int NumCustomers = 3000 ;
		int NumLoans = 1000 ;
		int NumLoansPaying = 30000 ;

		try {
			String tuple ;      // a tuple/record of attributes
			String a1, a2, a3, a4, a5, a6, a7 ; // attributes 1 .. 8
			File file = null ;
			FileWriter fw = null ;
			BufferedWriter bw = null ;


			// create the customers relation

			file = new File("data-customers.csv") ;
			fw = new FileWriter(file) ;
			bw = new BufferedWriter(fw) ;

			for (int i = 6 ; i <= NumCustomers ; i++)
			{
				a1 = Integer.toString(i) ;// customerid
				a2 = "Jenny" + Integer.toString(i) ;// first name
				a3 = "Davis" + Integer.toString(i) ;// last name
				a4 = a2 + "." + a3 + "@du.edu";// email
				a5 = Integer.toString( generator.nextInt(1000000000)+i) ;  // phone number
				a6 = i + " Hunkey Dorey Ln Keystone CO 80210";
				tuple = a1 + "," + a2 + "," + a3 + "," + a4 + "," + a5 + "," + a6 + "\n";

				bw.write(tuple) ;
			}
			bw.close() ;

			// create the loans relation

			file = new File("data-loans.csv") ;
			fw = new FileWriter(file) ;
			bw = new BufferedWriter(fw) ;

			for (int i = 1 ; i <= NumLoans ; i++)
			{
				a1 = Integer.toString(i) ; // loanid
				a2 = Integer.toString(generator.nextInt(5000000)+500000) ;// balance
				a3 = "Investment Loan" ;   // Loan type
				a4 = Integer.toString(generator.nextInt(10)+3) ;// interest rate
				a5 = Integer.toString(generator.nextInt(50000)+1000);// previous payment
				a6 = Integer.toString(generator.nextInt(50000)+1000);// next payment
				a7 = Integer.toString(generator.nextInt(12)+1) + 
						"/" + Integer.toString(generator.nextInt(28)+1) + "/2018";// next payment date
				tuple = a1 + "," + a2 + "," + a3 + "," + a4 + "," + a5 + "," + a6 + "," + a7 + "\n";

				bw.write(tuple) ;
			}
			bw.close() ;


			// create the isPaying relation
			// NOTE: we know there are customer tuples for customerid 1..NumSailors
			//       and that there are loan tuples for loanid 1..NumBoats,
			//       so we just draw random numbers from those ranges

			file = new File("data-is-paying.csv") ;
			fw = new FileWriter(file) ;
			bw = new BufferedWriter(fw) ;

			for (int i = 1 ; i <= NumLoansPaying ; i++) {
				// customerid
				a1 = Integer.toString( generator.nextInt(NumCustomers)+1 ) ;

				// loanid
				a2 = Integer.toString( generator.nextInt(NumLoans)+1 ) ;

				tuple = a1 + "," + a2 + "\n";

				bw.write(tuple) ;
			}
			bw.close() ;
			

			file = new File("data-accounts.csv") ;
			fw = new FileWriter(file) ;
			bw = new BufferedWriter(fw) ;

			for (int i = 1 ; i <= NumCustomers*2 ; i++) {
				// customerid
				a1 = Integer.toString( generator.nextInt(NumCustomers)+1 ) ;

				// account number
				a2 = Integer.toString( i ) ;

				// balance
				a3 = Integer.toString(generator.nextInt(5000000)+500000) ;

				tuple = a1 + "," + a2 + "," + a3 + "\n";

				bw.write(tuple) ;
			}
			bw.close() ;
			
			
			file = new File("data-banks.csv") ;
			fw = new FileWriter(file) ;
			bw = new BufferedWriter(fw) ;

			for (int i = 1 ; i <= NumCustomers*2 ; i++) {
				// customerid
				a1 = Integer.toString( generator.nextInt(NumCustomers)+1 ) ;

				// bank name
				a2 = "US Bank";
				
				//address
				a3 = i + " Money Making Blvd Breckenridge CO 80250";

				//phone number
				a4 = Integer.toString( generator.nextInt(1000000000)+i) ;  

				tuple = a1 + "," + a2 + "," + a3 + "," + a4 + "\n";

				bw.write(tuple) ;
			}
			bw.close() ;
			
			
			file = new File("data-collateral.csv") ;
			fw = new FileWriter(file) ;
			bw = new BufferedWriter(fw) ;

			for (int i = 1 ; i <= NumCustomers*2 ; i++) {
				//customerid
				a1 = Integer.toString( generator.nextInt(NumCustomers)+1 ) ;

				//property
				a2 = i + " Investment Property Ave Manhattan NY 35201";
				
				//natural resources
				a3 = "Natural Gas";

				//machinery
				a4 = "Microprocessor plant in China" ;

				tuple = a1 + "," + a2 + "," + a3 + "," + a4 + "\n";

				bw.write(tuple) ;
			}
			bw.close() ;


		}
		catch (IOException e) {
			e.printStackTrace() ;
		}
	}
}
