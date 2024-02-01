package xyzBank;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parametrs {
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String[] userFirstNames = { "Ahmad", "jood", "ola", "lubna" };
	String[] userLastNames = { "Amjad", "yaman", "ala'a", "jawad" };
	String[] userPostCodes = { "112347890", "900008765", "099922233", "55500044" };
	int randomIndex = rand.nextInt(userFirstNames.length);
	int randomNumber = rand.nextInt(userLastNames.length);
	int randomInt = rand.nextInt(userPostCodes.length);
	int randomNum = rand.nextInt(1, 3);

}
