import java.util.ArrayList;

import org.junit.Assert;

public class Compare {
public static void main(String[] args) {
	ArrayList list=new ArrayList();
	list.add("ax");
	list.add("b");
	list.add("c");
	list.add("d");
	
	
	ArrayList list1=new ArrayList();
	list1.add("x");
	list1.add("y");
	list1.add("c");
	list1.add("d");
	
	if(list.contains("x"))
			{
		System.out.println("true");
			}
	else
	{
		Assert.assertTrue(list1.get(0)+" is present" ,false);
		System.out.println("false");
	}
	
}
}
