package ComputerApplication;

/**
 * Computer class include Computer information 
 * Assignment (1)
 * @author krupa Maisuriya
 * written by : Krupa - 2394498
 * 
 */

public class Computer {

	private String brand;
	private String model;
	private long SN;
	private double price;
	private int noOfObject =0 ; /* variable intialize to count how many number of object has been created*/

	/**
	 * Parameterized Constructor  
	 * @param brand refers to String value
	 * @param model refers to String value
	 * @param sn refers to serial number value
	 * @param price refers to price value
	 */
	public Computer(String brand, String model, long sn, double price) {

		noOfObject++;
		this.brand = brand;
		this.model = model;
		SN = sn;
		this.price = price;
	}
    /**
     * Constructor that take Computer object as a parameter #copy constructor
     * @param obj refers to Computer Class
     */
	public Computer(Computer obj) {
		noOfObject++;
		this.brand = obj.brand;
		this.model = obj.model;
		SN = obj.SN;
		this.price = obj.price;
	}
    /**
     * method used to return the brand value 
     * @return type is String
     */
	public String getBrand() {
		return brand;
	}
    /**
     * method used to set the value of the brand attribute
     * @param brand refers to brand value which accept the string value
     */
	public void setBrand(String brand) {
		this.brand = brand;
	}
    /**
     * method used to return the model value 
     * @return  type is String
     */
	public String getModel() {
		return model;
	}
	/**
     * method used to set the value of the model attribute
     * @param model refers to model value which accept the string value
     */
	public void setModel(String model) {
		this.model = model;
	}
	 /**
     * method used to return the serial number value 
     * @return  type is long
     */
	public long getSN() {
		return SN;
	}
	/**
     * method used to set the value of the serial number attribute
     * @param sN refers to serial number value which accept the long value
     */
	public void setSN(long sN) {
		SN = sN;
	}
	 /**
     * method used to return the price of the computer
     * @return type is double
     */
	public double getPrice() {
		return price;
	}
	/**
     * method used to set the value of the price attribute
     * @param price refers to price value which accept the double value
     */
	public void setPrice(double price) {
		this.price = price;
	}
    /**
     * toString() method is override to get the  information regarding the computer
     * @return type is String
     */
	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", model=" + model + ", SN=" + SN + ", price=" + price + "]";
	}
	/**
	 * showInfoByIndex method is used to print the information of computer
	 * @param index indicated the index of computer store in array 
	 */
	public void showInfoByIndex(int index)
	{
		System.out.println();
		System.out.println("Computer # " + index);
		System.out.println("Brand : " + this.brand);
		System.out.println("Computer Model : " + this.model);
		System.out.println("SN : " + this.SN);
		System.out.println("Computer Price : $" + this.price);
	}
	/**
	 * findNumberOfCreatedComputers used to get the number of object been created
	 * @return type is integer
	 */
	public int findNumberOfCreatedComputers()
	{
		return 	noOfObject;
	}
	/**
	 * equals method is used to compared tow object with each other 
	 * two Computer objects are considered equal if they have the same brand, model and price
	 * @param obj takes the Computer object as the parameter
	 * @return type is boolean (if two computer are equals than it will return true else false)
	 */
	public boolean equals(Computer obj)
	{
		if(brand.equals(obj.brand) && price == obj.price && model.equals(obj.model))
		{
			return true;
		}
		return false;
	}

}
