package renesDeposit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends RenesBasePage{
    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@class='calculator-block__title block-title']")
    public WebElement calcTitle;

    @FindBy(xpath = "//div[@class='calculator__currency-label']")
    public WebElement currencyTitle;

    @FindBy(xpath = "//div[@class='calculator__currency-content']//span[text()]")
    public List<WebElement> currencyForDepositList;

    @FindBy(xpath = "//div[@class='calculator__slide-section']")
    public List<WebElement> slideElements;

    @FindBy(xpath = ".//span[@class = 'js-calc-amount']")
    public WebElement currentSum;

    @FindBy(xpath = "//label[@class='calculator__check-block']")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//div[@class='calculator__btn-row']")
    public WebElement startDepositButton;

    @FindBy(xpath = "//span[@class='js-calc-amount']")
    public WebElement amountOfMoneyNow;

    @FindBy(xpath = "//span[@class='js-calc-result js-calc-result-noanim']")
    public WebElement futureAmountOfMoney;
}
