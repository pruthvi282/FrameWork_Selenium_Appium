package generic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * 
 * @author Pruthvi
 *
 */

public class Java_utilities {
	
	/**
	 * Fetches DAY MON DATE TIME 
	 * @param data
	 * @return
	 */
		public  String date (String data) {
			Date d=new Date();
			String dates=d.toString();
			String date_value = dates.replaceAll(":", "-");
			String[] date_arr = date_value.split(" ");
			Map<String, String> map=new HashMap<String, String>();
			map.put("DAY", date_arr[0]);
			map.put("MON", date_arr[1]);
			map.put("DATE",date_arr[2]);
			map.put("TIME",date_arr[3]);
			map.put("YEAR",date_arr[5]);
			String value = map.get(data);
			return value;
			
		}
		
		public  String DatewithTime () {
			Date d=new Date();
			String dates=d.toString();
			return dates;
		}
			/**
	 * returns a data concated with randam num
	 * @param s
	 * @param value
	 * @return
	 */
	public  String randam_name(String s,int value){
		Random r=new Random();
		int num = r.nextInt(value);
		String data=s+num;
		return data;
		
	}

}
