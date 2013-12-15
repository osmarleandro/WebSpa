package net.seleucus.wsp.main;

import java.io.Console;
import java.nio.CharBuffer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public abstract class WSGestalt {

	private Console myConsole;

	public WSGestalt(WebSpa myWebSpa) {
		
		this.myConsole = myWebSpa.getConsole();
		
	}
	
	public String readLineOptional(final String displayString) {
		
		StringBuilder displayBuilder = new StringBuilder();
		
		displayBuilder.append("-[Optional] ");
		displayBuilder.append(displayString);
		
		return myConsole.readLine(displayBuilder.toString());
		
	}
	
	public int readLineOptionalInt(final String displayString) {
		
		String inputString = readLineOptional(displayString);
		int output = -1;
		
		try {
			
			output = Integer.parseInt(inputString);
			
		} catch(NumberFormatException ex) {
			
			println("Invalid Number");
			
		}
		
		return output;
		
	}
	
	public String readLineRequired(final String displayString) {
		
		StringBuilder displayBuilder = new StringBuilder();
		
		displayBuilder.append("=[Required] ");
		displayBuilder.append(displayString);
		
		String outputString;
		
		do {
		
			outputString = myConsole.readLine(displayBuilder.toString()).trim();
			
			if(outputString.isEmpty()) {
			
				println("Your Input Cannot Be Blank");
				
			}
			
		} while(outputString.isEmpty());
		
		return outputString;
		
	}
	
	public int readLineRequiredInt(final String displayString, int minInclusiveValue, int maxInclusiveValue) {
		
		StringBuilder displayBuilder = new StringBuilder();
		displayBuilder.append(displayString);
		displayBuilder.append(" [");
		displayBuilder.append(minInclusiveValue);
		displayBuilder.append(',');
		displayBuilder.append(maxInclusiveValue);
		displayBuilder.append("]: ");
		
		int output = -1;
		do {
			String inputString = readLineRequired(displayBuilder.toString());
			
			try {
			
				output = Integer.parseInt(inputString);
			
			} catch(NumberFormatException ex) {
			
				println("Invalid Number");
			
			}
		
		} while( (output < minInclusiveValue) || (output > maxInclusiveValue) );
		
		return output;
		
	}
	
	public String readLineServerPrompt() {
		
		return myConsole.readLine("web-spa-server>");
		
	}
	
	public void log(final String display) {
		
		final Date currentDate = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("[yyyy-MM-dd HH-mm-ss] ");
		final String formattedDate = sdf.format(currentDate);
		
		System.out.print('\n' + formattedDate + StringUtils.abbreviateMiddle(display, "...", 40) );
		
	}
	
	public CharSequence readPasswordRequired(final String displayString) {
		
		StringBuilder displayBuilder = new StringBuilder();
		
		displayBuilder.append("=[Required] ");
		displayBuilder.append(displayString);
		
		char[] passCharArrayOne, passCharArrayTwo;
		boolean passPhrasesMatch = false;
		
		do {
		
			passCharArrayOne = myConsole.readPassword(displayBuilder.toString());
			passCharArrayTwo = myConsole.readPassword("=[Required] Re-enter the above value: ");
			
			passPhrasesMatch = Arrays.equals(passCharArrayOne, passCharArrayTwo);
			
			if(!passPhrasesMatch) {
				
				println("The Pass-Phrases Entered do not Match");
				println("Please try again");
				
			} else if(passCharArrayOne.length <= 0) {

				println("The Pass-Phrase Cannot Be Blank");

			}
						
		} while( (passCharArrayOne.length <= 0) || (!passPhrasesMatch) );
		
		return CharBuffer.wrap(passCharArrayOne);
		
	}
	
	public void println(final String line) {
		
		myConsole.writer().println(line);
		
	}
	
	public void printlnWithTimeStamp(final String line) {
		
		final Date currentDate = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("[yyyy-MM-dd HH-mm-ss] ");
		final String formattedDate = sdf.format(currentDate);
		
		myConsole.writer().println( formattedDate + StringUtils.abbreviateMiddle(line, "...", 40) );
	}
	
	public abstract void exitConsole();

	public abstract void runConsole() throws SQLException;
	
}