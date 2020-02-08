package renesDeposit.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import renesDeposit.pages.DepositPage;
import java.util.List;

public class DepositPageSteps extends BaseTest{
    private DepositPage depositPage = new DepositPage(driver);

    public void chooseCurrency(String currencyName) {
        for(WebElement currency : depositPage.currencyForDepositList) {
            if(currency.getText().equalsIgnoreCase(currencyName)) {
                wait.until(ExpectedConditions.elementToBeClickable(currency));
                currency.click();
            }
        }
    }

    public void setUnfoInInput(String fieldName, String input) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", depositPage.currencyTitle);
        for(WebElement element : depositPage.slideElements) {
            String title = element.findElement(By.xpath(".//label[text()]")).getText();
            if (title.equalsIgnoreCase(fieldName)) {
                WebElement inputBox = element.findElement(By.xpath(".//input"));
                inputBox.click();
                inputBox.clear();
                inputBox.sendKeys(input);
                inputBox.sendKeys(Keys.ENTER);
            }
        }
    }

    public void setInfoInDropList(String name, String input) {
        for(WebElement element : depositPage.slideElements) {
            String title = element.findElement(By.xpath(".//label[text()]")).getText();
            if(title.equalsIgnoreCase(name)) {
                WebElement selectBox = element.findElement(By.xpath(".//div[@class = 'jq-selectbox__select-text']"));
                selectBox.click();
                WebElement dropDownList = element.findElement(By.xpath(".//div[@class='jq-selectbox__dropdown']"));
                wait.until(ExpectedConditions.visibilityOf(dropDownList));
                List<WebElement> selectList = dropDownList.findElements(By.xpath(".//li"));
                for(WebElement select : selectList) {
                    if(select.getText().equalsIgnoreCase(input)) {
                        select.click();
                    }
                }
            }
        }
    }

    public void tickCheckbox(String checkBoxName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", depositPage.startDepositButton);
        for(WebElement element : depositPage.checkBoxes) {
            String checkBoxText = element.findElement(By.xpath(".//span[text()]")).getText();
            if(checkBoxName.equalsIgnoreCase(checkBoxText)) {
                WebElement checkInput = element.findElement(By.xpath(".//span[@class='calculator__check-block-input']"));
                checkInput.click();
            }
        }
    }

    public void tickCheckbox(String checkBoxName, String choice) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", depositPage.startDepositButton);
        for(WebElement element : depositPage.checkBoxes) {
            String checkBoxText = element.findElement(By.xpath(".//span[text()]")).getText();
            if(checkBoxName.equalsIgnoreCase(checkBoxText)) {
                if(choice.equalsIgnoreCase("да")) {
                    WebElement checkInput = element.findElement(By.xpath(".//span[@class='calculator__check-block-input']"));
                    checkInput.click();
                }
            }
        }
    }

    public void checkCalc(String fieldName, String sum) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", depositPage.calcTitle);
        if (fieldName.equalsIgnoreCase("Есть сейчас")) {
            Assert.assertEquals(sum, depositPage.amountOfMoneyNow.getText());
        } else if (fieldName.equalsIgnoreCase("Будет")) {
            Assert.assertEquals(sum, depositPage.futureAmountOfMoney.getText());
        }
    }
}

