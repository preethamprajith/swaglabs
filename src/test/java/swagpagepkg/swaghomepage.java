package swagpagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class swaghomepage {

	
	WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement products;

    @FindBy(tagName = "a")
    List<WebElement> Links;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement addcart;

    public swaghomepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String textmethod() {
        wait.until(ExpectedConditions.visibilityOf(products));
        return products.getText();
    }

    public int linkcountmenthod() {
        return Links.size();
    }

}
