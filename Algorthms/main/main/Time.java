package main;

public class Time {

	public static void main(String...args) {
		System.out.println(timeConversion("01:20:00"));
	}
	
	static String timeConversion(String s) {
       if(!is12Hours(s)) {
    	   return s;
       }else {
    	   String result = "";
    	   String[] timeSplit = s.split(":");
    	   if(isAm(timeSplit[2])) {
    		   int t = (Integer.valueOf(timeSplit[0])) == 12 ? 0 : Integer.valueOf(timeSplit[0]);
    		   result = String.format("%02d", t) + ":" + timeSplit[1] + ":" + timeSplit[2].substring(0,2);
    	   }else {
    		   int t = (Integer.valueOf(timeSplit[0])) == 12 ? 0 : Integer.valueOf(timeSplit[0]);
    		   result = (t + 12) + ":" + timeSplit[1] + ":" + timeSplit[2].substring(0,2);
    	   }
    	   return result;
       }
    }
	
	static boolean is12Hours(String s) {
		return s.contains("AM")|| s.contains("Am") || s.contains("am") ||
	    		   s.contains("PM") || s.contains("Pm") || s.contains("pm");
	}
	
	static boolean isAm(String s) {
		return s.contains("AM")|| s.contains("Am") || s.contains("am");
	}
	
	static boolean isPm(String s) {
		return s.contains("PM") || s.contains("Pm") || s.contains("pm");
	}
}