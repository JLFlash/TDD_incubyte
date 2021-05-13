import java.lang.*;
import java.util.*;


public class TDDExerice
{
	public char del;
	public static void main(String[] args) {
		TDDExerice tddObj = new TDDExerice();
		//Assuming the inputs are given in Standard IO
		//The scan will be terminated when the the line EOF is entered
		//Breaking the string with the /n delimeter is possible and will save time
		//but this method is only used to send input to the required Add method 
		Scanner scanner = new Scanner(System.in);
		StringBuilder inputString = new StringBuilder();
		String inputLine = null;
		String firstLine = scanner.nextLine();
		String delimeter = null;
		if(firstLine.indexOf("//")==0) {
			tddObj.del = firstLine.charAt(2);
		} else {
			tddObj.del = '\0';
			inputString.append(firstLine+"\n");
		}
		while(scanner.hasNext()) {
			inputLine = scanner.nextLine();
			if(inputLine.equals("EOF")) {
				break;
			}
			inputString.append(inputLine+"\n");
		}
		System.out.println(inputString);
		System.out.println("\n"+tddObj.Add(inputString.toString()));
	}
	
	public int Add(String numbers) {
	    if(numbers == null || numbers.equals("")) {
	        return 0;
	    }
		
		StringBuilder numberString = new StringBuilder();
		int total = 0;
		for(int i=0;i<numbers.length();i++) {
			if(numbers.charAt(i)==','||numbers.charAt(i)=='\n'||numbers.charAt(i)==del) {
				if(numberString.toString().equals("")) {
					continue;
				}
				System.out.println((numberString.toString().trim()));
				total = total + Integer.parseInt(numberString.toString().trim());
				numberString = new StringBuilder();
			} else if(numbers.charAt(i)==' ') {
				continue;
			}else {
				
				numberString.append(numbers.charAt(i));
			}
		}
		if(numberString.toString().equals("")) {
			return total;
		}
		total = total + Integer.parseInt(numberString.toString().trim());
		
		return total;
		
	}
	
	
}
