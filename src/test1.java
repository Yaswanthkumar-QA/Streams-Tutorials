import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	
	 @Test
		public void regular() {
			ArrayList<String> names=new ArrayList<String>();
			names.add("Amar");
			names.add("Adi");
			names.add("Sreenath");
			names.add("Yaswanth");
			names.add("Sudheer");
			
			int count=0;
			
			for(int i=0;i<names.size();i++)
			{
				String name=names.get(i);
				
				if(name.startsWith("A"))
				{
					count++;
				}
			}
			System.out.println(count);
		}
		
		@Test
		public void streamsFilter() {
			ArrayList<String> names=new ArrayList<String>();
			names.add("Amar");
			names.add("Adi");
			names.add("Sreenath");
			names.add("Yaswanth");
			names.add("Sudheer");
			
			long c=names.stream().filter(s->s.startsWith("A")).count();
			System.out.println(c);  //output 2
			
			long d=Stream.of("Amar","Adi","Sreenath","Yaswanth","Sudheer").filter(s->
			{
				
				s.startsWith("A");    // It always return True
				return false;
			}).count();  
			System.out.println(d);    // output 0
			
			// Print all the names of array
			
			names.stream().filter(l->l.length()>4).forEach(l->System.out.println(l));
			
			names.stream().filter(l->l.length()>4).limit(1).forEach(l->System.out.println(l));
			
			
			
		
	    }
	    
		
	@Test
	public void streamsMap() {
		
		// Steam manipulations:
		//Print the name which has last letter as "h" in UpperCase
		Stream.of("Amar","Adi","Sreenath","Yaswanth","Sudheer").filter(s->s.endsWith("h")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Convert Arrays to list
		List<String> names=Arrays.asList("Amar","Adi","Sreenath","Yaswanth","Sudheer");
		
		names.stream().filter(s->s.startsWith("S")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String> professions=Arrays.asList("Railway","Railcontrac","Software","Assistant Manager","CAG");
		
		// Combining/Merging two strings : concat
		
		Stream<String> newStream=Stream.concat(names.stream(), professions.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//match method
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Yaswanth"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
		
	}
	
	
	@Test
	public void streamsCollect() {
		
		List<String> ls=Stream.of("Amar","Adi","Sreenath","Yaswanth","Sudheer").filter(s->s.endsWith("h")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(ls.get(0)); // Frist name with return from list
		
		//Assignment
		
		List<Integer> no=Arrays.asList(3,2,2,7,5,1,9);
		
		//Print Unique number from this array
		// sort the array
		//no.stream().distinct().forEach(a->System.out.println(a));
		List<Integer> values=no.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(values.get(2));  // After sorting we can get 3rd value in the string
		
		
	}
	
	}

