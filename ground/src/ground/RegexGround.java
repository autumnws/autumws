package ground;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGround {

	
	public static void main(String[] args) {
		// String to be scanned to find the pattern.
	      String line = "/eureka";
	      String pattern = "/eureka"; 

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      //System.out.println(m.groupCount());
	      if (m.find( )) {
	        int count = m.groupCount();
	        for(int i=0;i<=count;i++)
	        	System.out.format("Group %d :%s\n",i, m.group(i) );
	      } else {
	         System.out.println("NO MATCH");
	      }
	}
}
