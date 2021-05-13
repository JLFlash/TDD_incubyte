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
		try {
			System.out.println("\n"+tddObj.Add(inputString.toString()));
		} catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public int Add(String numbers) throws Exception {
	    if(numbers == null || numbers.equals("")) {
	        return 0;
	    }
		StringBuilder negativeStrings = new StringBuilder();
		StringBuilder numberString = new StringBuilder();
		int total = 0;
		for(int i=0;i<numbers.length();i++) {
			char currentChar = numbers.charAt(i);
			if(currentChar==','||currentChar=='\n'||currentChar==del) {
				if(numberString.toString().equals("")) {
					continue;
				}
				int currentInteger = Integer.parseInt(numberString.toString().trim());
				System.out.println(currentInteger);
				if(currentInteger>0) {
					total = total + currentInteger;
				} else {
					negativeStrings.append(""+currentInteger);
				}
				
				numberString = new StringBuilder();
			} else if(currentChar==' ') {
				continue;
			}else {
				numberString.append(currentChar);
			}
		}
		if(negativeStrings.length()>0) {
			throw new Exception("Negatives not allowed "+negativeStrings);
		}
		if(numberString.toString().equals("")) {
			return total;
		}
		total = total + Integer.parseInt(numberString.toString().trim());
		
		return total;
		
	}
	
	
}
