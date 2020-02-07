package renesDeposit.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import renesDeposit.pages.DepositPage;

import java.security.Key;

public class DepositPageSteps extends BaseTest{
    DepositPage depositPage = new DepositPage(driver);

    public void chooseCurrency(String currencyName) {
        for(WebElement currency : depositPage.currencyForDepositList) {
            if(currency.getText().equalsIgnoreCase(currencyName)) {
                wait.until(ExpectedConditions.elementToBeClickable(currency));
                currency.click();
            }
        }
    }
    public void fillSum(String sum) {
        depositPage.inputForSumOfDeposit.click();
        depositPage.inputForSumOfDeposit.sendKeys(sum);
        depositPage.inputForSumOfDeposit.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.textToBePresentInElement(depositPage.currentSum, "500 000"));
    }

    public void chooseTerm(String term) {

    }


/*    public void fillDepositGaps(String fieldName, String number) {
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", depositPage.startDepositTitle);
        for(WebElement field : depositPage.inputsList) {
            String name = field.findElement(By.xpath(".//div[@data-property]//label[@class ='calculator__slide-input-label']"))
                    .getText();
            if(name.equalsIgnoreCase(fieldName)) {
                depositPage.input = field.findElement(By.xpath(".//input"));
                depositPage.input.click();
                depositPage.input.clear();
                depositPage.input.sendKeys(number);
                depositPage.input.sendKeys(Keys.ENTER);
            }
        }
    }*/
}
