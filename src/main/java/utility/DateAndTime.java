package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;

public class DateAndTime {
public static String getDateAndTime() {
		
		LocalDateTime date=LocalDateTime.now();
		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		String dateAndTime=date.format(pattern);
		return dateAndTime;
		
	}

}

