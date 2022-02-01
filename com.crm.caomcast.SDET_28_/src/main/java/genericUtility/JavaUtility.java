package genericUtility;


import java.util.Date;
import java.util.Random;
/** this is method is used to get random numbers
 * java utility class
 * @author Ammu
 *
 */

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random ran= new Random();
		int randomNumber=ran.nextInt(5000);
		
		return randomNumber;
		
	}
	/**
	 * this method is used to get system date and time
	 * @return
	 */
	public String systemDateandTime()
	{
		Date date=new Date();
		String dataAndTime=date.toString();
		return dataAndTime;
		
		
	}

}
