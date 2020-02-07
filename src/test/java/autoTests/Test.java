package autoTests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.support.ui.WebDriverWait;
import renesDeposit.pages.DepositPage;
import renesDeposit.steps.BaseTest;
import renesDeposit.steps.DepositPageSteps;
import renesDeposit.steps.RenesMainPageSteps;

public class Test extends BaseTest {

    @Before
    public void init() {
        initialize();
        wait = new WebDriverWait(driver,4);
    }
    @Когда("^перейти на страницу \"(.+)\"$")
    public void goToWebSite(String url) {
        driver.navigate().to(url);
    }

    @Когда("^Перейти в меню \"(.+)\"$")
    public void goToServiceMenu(String menuName) {
        RenesMainPageSteps renesMainPAgeSteps = new RenesMainPageSteps();
        System.out.println(menuName);
        renesMainPAgeSteps.clickServiceButton(menuName);
    }

    @Когда("^Выбрать \"(.+)\"$")
    public void chooseCurrency(String currencyName) {
        DepositPageSteps depositPageSteps = new DepositPageSteps();
        System.out.println(currencyName);
        depositPageSteps.chooseCurrency(currencyName);
    }

    @Когда("^Заполнить поле \"Сумма вклада\" значением \"(.+)\"$")
    public void fillTheField(String fieldName, String sumForInput) {
        DepositPageSteps depositPageSteps = new DepositPageSteps();
        depositPageSteps.fillSum(sumForInput);
    }

    @After
    public void tearDown(Scenario scenario) {
        super.tearDown(scenario);
    }
}
