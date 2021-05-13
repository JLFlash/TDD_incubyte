import java.lang.*;
import java.util.*;


public class TDDExerice
{
	public static void main(String[] args) {
		TDDExerice tddObj = new TDDExerice();
		//Assuming the inputs are given in Standard IO
		Scanner scanner = new Scanner(System.in);
		String twoNumbers = scanner.nextLine();
		System.out.println(tddObj.Add(twoNumbers));
	}
	
	public int Add(String numbers) {
	    if(numbers == null || numbers.equals("")) {
	        return 0;
	    }
	    String[] split = numbers.split(",");
		int total = 0;
	    for(int i=0;i<split.length;i++) {
			total = total+ Integer.parseInt(split[i].trim());
		}
	    return total;
	}
	
	
}
