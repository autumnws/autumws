package ground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Collection {

	public static void main(String[] args) {
		
		//removeIf();
		reduce();
		map();
		regex();
		
	}
	public static void regex() {
		
		String str="aK@gmail.com";
		Pattern p = Pattern.compile("[a-zA-Z]*@[a-zA-Z]*[.]{1}[a-zA-Z]*");
		Matcher matcher = p.matcher(str);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		
	}
	
	public static void map() {
		List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] {10,20,30}));
		List<String> list1 = list.stream().map(number -> "'"+number.toString()+"'2").collect(Collectors.toList());
		System.out.println(list1);
	
		
	}
	
	public static void removeIf() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1,2,3,4,2,5,2,6}));
		list.removeIf( it -> it == 2 );
		System.out.println(list);
		
		list = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1,2,3,4,2,5,2,6}));
		
		int sum = list.stream().reduce(0, (total, number) -> total+=number);
		
		System.out.println(sum);
		
	}
	
	public static void reduce() {

		List<Integer> list = list = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1,2,3,4,2,5,2,6}));	
		int sum = list.stream().reduce(20, (i, number) -> {
			if(number == 2)
				i-=2;
			
			return i;
		});
		
		
		System.out.println(sum);
		
		System.out.println(new Date());
		
	}
	
}
