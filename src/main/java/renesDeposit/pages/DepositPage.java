package renesDeposit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends RenesBasePage{
    public DepositPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='calculator__currency-content']//span[text()]")
    public List<WebElement> currencyForDepositList;

    @FindBy(xpath = "//label[@class = 'calculator__slide-input-label left-label']")
    public WebElement startDepositTitle;

    @FindBy(xpath = "//input[@name ='amount']")
    public WebElement inputForSumOfDeposit;

    @FindBy(xpath = "//span[@class='js-calc-amount']")
    public WebElement currentSum;
}
