package swagtestpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.swagbase;

public class swaghometest extends  swagbase {
	
	 @Test(priority = 1)
	    public void textverification() {

	        

	        // Verify Products page
	        String producttext = homeobj.textmethod();

	        Assert.assertEquals(producttext, "Products");
	    }

	    @Test(priority = 2, dependsOnMethods = {"textverification"})
	    public void linkverification() {

	        int linkcount = homeobj.linkcountmenthod();

	        System.out.println("Number of links: " + linkcount);

	        Assert.assertTrue(linkcount > 0,
	                "No links found on Products page");
	    }

}
