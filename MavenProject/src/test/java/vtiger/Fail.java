package vtiger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.Baseclass;
import generic.Java_utilities;

@Listeners(generic.Listener_Implementation.class)
public class Fail extends Baseclass{	
@Test(retryAnalyzer=generic.RetryAnalyzer.class)
public void ilure(){
	Assert.assertFalse(true);
	}
}
