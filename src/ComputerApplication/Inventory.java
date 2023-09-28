package ComputerApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Inventory class allow owner to perform different action that help in keeping
 * track of computers Assignment (1)
 * 
 * @author krupa Maisuriya written by : Krupa - 2394498
 * 
 */
public class Inventory {

	static Scanner scan = new Scanner(System.in);
	static int computerStore = 0; /* computerStore attribute : maximum number of computers have in store */
	static int noOfComputerUserEnter = 0; /*
											 * noOfComputerUserEnter attribute will store count of how many computer
											 * user added
											 */
	static Computer[] inventory; /* array initialize to store the computer information enter by user */
	final static String ownerPassword = "password"; /*constant attribute containing the owner password "password"*/

	
	/** findComputersBy used to search all the computers by brand
	 * name
	 * 
	 * @param brand takes brand name value as a parameter which accept
	 * the string value
	 */
	public static void findComputersBy(String brand) {
		boolean flag = false;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].getBrand().equals(brand)) {
				flag = true;
				inventory[i].showInfoByIndex(i +1);
			}
		}
		if (!flag) {
			System.out.println("No computer found by this brand " + brand);
		}
	}

	/**
	 * findCheaperThan used to search all the computers that have less than
	 * particular price enter by the owner
	 * 
	 * @param price takes price value as a parameter which accept the double value
	 */
	public static void findCheaperThan(double price) {
		boolean flag = false;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].getPrice() < price) {
				flag = true;
				inventory[i].showInfoByIndex(i + 1);
			}
		}
		if (!flag) {
			System.out.println("No computer found less than $" + price + "price");
		}
	}
	/**
	 * storeInventoryInFile store all the data of inventory in text file
	 */
	public static void storeInventoryInFile()
	{
		 PrintWriter pw = null;
		 try {
       	  pw = new PrintWriter(new FileOutputStream("computer.txt"));
         }catch(FileNotFoundException e)
         {
       	  System.out.println("file not found");
         }
     
		for (int i = 0; i < inventory.length; i++) {
			
			if (inventory[i] != null) {
				pw.println();	
				pw.println("Computer # " + (i + 1));
				pw.println("Brand : " + inventory[i].getBrand());
				pw.println("Computer Model : " + inventory[i].getModel());
				pw.println("SN : " + inventory[i].getSN());
				pw.println("Computer Price : $" + inventory[i].getPrice());
			
				pw.println("-------------------------");
				pw.println();
			}
		}
		pw.close();
	}
	

	/**
	 * mainMenu method prompt the action list 1.Enter new computers (password
	 * required) 2.Change information of a computer (password required) 3.Display
	 * all computers by a specific brand 4.Display all computers under a certain a
	 * price 5.Quit
	 * 
	 * and based on that allow owner to choice the action based on owner choice that
	 * action will be performed to keep track
	 */
	public static void mainMenu() {

		System.out.println();
		System.out.println("What do you want to do?\r\n" + "1.Enter new computers (password required)\r\n"
				+ "2.Change information of a computer (password required)\r\n"
				+ "3.Display all computers by a specific brand\r\n"
				+ "4.Display all computers under a certain a price.\r\n" + "5.Quit");

		System.out.println("Please enter your choice > ");
		int choice  = 0;
		 boolean isflag = false;
			while(!isflag)
			{
			try {
				choice = scan.nextInt();
				isflag = true;
			}catch(InputMismatchException e) {
		         System.out.println( "this is bad value");    	                   
		         scan.nextLine(); 
			}
		  }
		
		//int choice = scan.nextInt();
			while (choice < 1 || choice > 5) {
				System.out.println("Please enter your choice between 1 and 5 > ");
				choice = scan.nextInt();
			}

		switch (choice) {
		case 1:
			if (isValidPassword()) {
				System.out.println("How many computers you want ? ");
				
				int noOfComputer  = 0;
				 boolean isnoOfComputer = false;
					while(!isnoOfComputer)
					{
					try {
						noOfComputer = scan.nextInt();
						isnoOfComputer = true;
					}catch(InputMismatchException e) {
				         System.out.println( "this is bad value");    	                   
				         scan.nextLine(); 
					}
				  }
				
				
				while (noOfComputer <= 0) {
					System.out.println("Please enter number greater than 0 ");
					noOfComputer = scan.nextInt();
				}

				
				//int noOfComputer = scan.nextInt();
				noOfComputerUserEnter = noOfComputerUserEnter + noOfComputer;
				if (noOfComputerUserEnter <= computerStore) {
					for (int i = 0; i < noOfComputerUserEnter; i++) {

						if (inventory[i] == null) {
							System.out.println("Enter Information for Computer (brand,model,SN,price) for " + (i + 1));
							
							  String brand = scan.next();
							    String model = scan.next();
							    long sn  = 0;
								boolean isLong = false;
								while(!isLong)
								{
								 try {
									sn  = scan.nextLong();
								    isLong = true;
								 }catch(InputMismatchException e) {
							         System.out.println( "this is bad value");    	                   
							         scan.nextLine(); 
								 }
							    }
								double price  = 0;
								boolean isdouble = false;
								while(!isdouble)
								{
								 try {
									 price  = scan.nextDouble();
									 isdouble = true;
								 }catch(InputMismatchException e) {
							         System.out.println( "this is bad value");    	                   
							         scan.nextLine(); 
								 }
							    }
							inventory[i] = new Computer(brand,model,sn,price);

						}
					}

				} else {
					if (noOfComputerUserEnter > 0 && noOfComputerUserEnter != computerStore) {
						noOfComputerUserEnter = noOfComputerUserEnter - noOfComputer;
					}

					System.out.println(" Sorry we dont have space to add computer in inventory ?");
					mainMenu();
				}

			}
			mainMenu();
			break;

		case 2:
			if (isValidPassword()) {
				System.out.println();
				System.out.println("Enter number which computer you want to modify ");
				int index = 0;
				boolean isInt = false;
				while(!isInt)
				{
				try {
					
					index = scan.nextInt();	
					
					isInt = true;
					
				}catch(InputMismatchException e) {
			         System.out.println( "this is bad value");                       
			         scan.nextLine();
				}
				}
				
				while(index <= 0)
				{
					System.out.println("Please enter number greater than 0  ");
					index = scan.nextInt();
				}
				//int index = scan.nextInt();

				if (computerStore > 0) {
					if (index > 0 && index <= noOfComputerUserEnter) {
						inventory[index - 1].showInfoByIndex(index);
						changeAttribute(index - 1);

					} else if (index > 0 && index <= computerStore) {
						System.out.println("you want to enter another computer or quit this operation  (Y or N) ? ");
						char confirm = scan.next().charAt(0);
						if (confirm == 'y') {
						
							noOfComputerUserEnter = noOfComputerUserEnter + 1;
						
							System.out.println("Enter Information for Computer (brand,model,SN,price) for "
									+ noOfComputerUserEnter);
							int addindex = noOfComputerUserEnter - 1 ;
						    String brand = scan.next();
						    String model = scan.next();
						    long sn  = 0;
							boolean isLong = false;
							while(!isLong)
							{
							 try {
								sn  = scan.nextLong();
							    isLong = true;
							 }catch(InputMismatchException e) {
						         System.out.println( "this is bad value");    	                   
						         scan.nextLine(); 
							 }
						    }
							double price  = 0;
							boolean isdouble = false;
							while(!isdouble)
							{
							 try {
								 price  = scan.nextDouble();
								 isdouble = true;
							 }catch(InputMismatchException e) {
						         System.out.println( "this is bad value");    	                   
						         scan.nextLine(); 
							 }
						    }
							inventory[addindex] = new Computer(brand,model,sn,price);

						}
					} else {
						System.out.println("You have enter invalid number");
					}
				} else {
					System.out.println("Sorry you dont have any computer in store!");
				}

			}
			mainMenu();
			break;

		case 3:
			System.out.println();
			System.out.println("Enter a brand name to search");
			String searchBrand = scan.next();
			if (searchBrand.length() > 0) {
				findComputersBy(searchBrand);
			}
			mainMenu();
			break;

		case 4:
			System.out.println();
			System.out.println("Enter a price value to search");
			double searchPrice = 0;
			boolean isflag1 = false;
			while(!isflag1)
			{
			 try {
				
				searchPrice = scan.nextDouble();
				isflag1 = true;
				
			 }catch(InputMismatchException e) {
		         System.out.println( "this is bad value");    
		         scan.nextLine(); 
			 }
			}
				
			findCheaperThan(searchPrice);
			mainMenu();
			break;

		case 5:
			storeInventoryInFile();
			System.out.println("Thank you for using our application. Program has terminated");
			scan.close();
			break;

		}
	}

	/**
	 * changeAttribute method prompt the user which attribute they wish to change by
	 * displaying the menu for the particular computer store in array. (brand ,
	 * model , SN , price and quit this operation and go back to the main menu)
	 * based on choice allow user to modify the attribute value by entering the
	 * value
	 * 
	 * @param index accepts the index of computer store in array
	 */
	public static void changeAttribute(int index) {
		System.out.println();
		System.out.println("What information would you like to change?\r\n" + "1.brand\r\n" + "2.model\r\n" + "3.SN\r\n"
				+ "4.price.\r\n" + "5.Quit");

		System.out.println("Please enter your choice > ");
		//int choice = scan.nextInt();
		
		int choice  = 0;
		 boolean isflag = false;
			while(!isflag)
			{
			try {
				choice = scan.nextInt();
				isflag = true;
			}catch(InputMismatchException e) {
		         System.out.println( "this is bad value");    	                   
		         scan.nextLine(); 
			}
		  }
		
		
		while (choice < 1 || choice > 5) {
			System.out.println("Please enter your choice between 1 and 5 > ");
			choice = scan.nextInt();
		}
		
//		while (choice < 1 && choice > 5) {
//			System.out.println("Please enter your choice between 1 and 5 > ");
//			choice = scan.nextInt();
//		}

		switch (choice) {
		case 1:
			System.out.println("Enter brand name to modify : ");
			inventory[index].setBrand(scan.next());
			changeAttribute(index);
			break;
		case 2:
			System.out.println("Enter model name to modify : ");
			inventory[index].setModel(scan.next());
			changeAttribute(index);
			break;
		case 3:
			System.out.println("Enter Serial number to modify : ");
			long sn  = 0;
			boolean isLong = false;
			while(!isLong)
			{
			 try {
				sn  = scan.nextLong();
						isLong = true;
			 }catch(InputMismatchException e) {
		         System.out.println( "this is bad value");    	                   
		         scan.nextLine(); 
			 }
		    }
			
			inventory[index].setSN(sn);
			changeAttribute(index);
			break;
		case 4:
			System.out.println("Enter price to modify : ");
			double price  = 0;
			boolean isPrice = false;
			while(!isPrice)
			{
				try {
				 price  = scan.nextLong();
				isPrice = true;
				}catch(InputMismatchException e) {
		         System.out.println( "this is bad value");    	                   
		         scan.nextLine(); 
				}
			}
			
			
			inventory[index].setPrice(price);
			changeAttribute(index);
			break;

		default:
			break;

		}

	}

	/**
	 * isValidpassword will validate the password enter by the user with
	 * ownerPassword attribute value password is required for two main menu options
	 * only The computerstore owner has 3 tries to enter the correct password. After
	 * the 3rd illegal entry displaying the main meny
	 * 
	 * @return type is boolean if the password is valid than it will return true
	 *         else false
	 */
	public static boolean isValidPassword() {
		int pwdEnter = 0;
		System.out.println("Please Enter your password as password : ");
		String pwd = scan.next();
		while (pwdEnter < 3) {

			if (pwd.equals(ownerPassword)) {
				break;

			} else {
				pwdEnter++;
				System.out.println("Please Enter your password as password only ( : " + pwdEnter + ")" );
				pwd = scan.next();
			}

		}

		if (pwdEnter == 3) {
			System.out.println("Sorry you have exit your tries to enter your password");
			return false;
		}

		return true;
	}

	/**
	 * main method to compile
	 * @param args accept string array element 
	 */
	public static void main(String[] args) {
		
		// Scanner scan = new Scanner(System.in);

		System.out.println("**********Welcome to Computer Store**********");

		System.out.println("Enter maximum number of computers you have in your store ?");
		 boolean isflag = false;
		while(!isflag)
		{
		try {
			
			computerStore = scan.nextInt();	
			// System.out.println("try " + computerStore);
			
			isflag = true;
			while (computerStore < 1) {
				System.out.println("Please Enter maximum number of computers you have in your store ? ");
				computerStore = scan.nextInt();
				
			}
					
			System.out.println();
			inventory = new Computer[computerStore];
			mainMenu();
		}catch(InputMismatchException e) {
	         System.out.println( "this is bad value");    
	                   
	         scan.nextLine();
	        
	         
		}
	  }
		

	}

}
