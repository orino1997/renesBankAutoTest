package renesDeposit.steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import renesDeposit.pages.RenesBasePage;

public class RenesMainPageSteps extends BaseTest {
    RenesBasePage renesBasePage = new RenesBasePage(driver);

    public void clickServiceButton(String buttonName) {
        for(WebElement service : renesBasePage.mainServices) {
            String serviceName = service.findElement(By.xpath(".//div[@class='service__title-text']")).getText();
            if(serviceName.equalsIgnoreCase(buttonName)) {
                WebElement button = service.findElement(By.xpath(".//div[@class='service__title']"));
                wait.until(ExpectedConditions.elementToBeClickable(button));
                button.click();
            }
        }
    }
}
