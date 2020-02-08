package autoTests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        renesMainPAgeSteps.clickServiceButton(menuName);
    }

    @Когда("^Выбрать \"(.+)\"$")
    public void chooseCurrency(String currencyName) {
        DepositPageSteps depositPageSteps = new DepositPageSteps();
        depositPageSteps.chooseCurrency(currencyName);
    }

    @Когда("^Заполняются поля:$")
    public void fillTheFieldOfSum(DataTable table) {
        DepositPageSteps depositPageSteps = new DepositPageSteps();
        table.asMap(String.class, String.class)
                .forEach((k,v) -> depositPageSteps.setUnfoInInput((String)k,(String)v));
    }
    @Когда("^Вставить в поле \"(.+)\" значение \"(.+)\"$")
    public void setTerms(String fieldNAme, String term) {
        DepositPageSteps depositPageSteps = new DepositPageSteps();
        depositPageSteps.setInfoInDropList(fieldNAme, term);
    }
    @Когда("^Отметить поле \"(.+)\"$")
    public void clickCheckBox(String checkBoxName) {
        DepositPageSteps depositPageSteps = new DepositPageSteps();
        depositPageSteps.tickCheckbox(checkBoxName);
    }

    @Тогда("^Проверить, что поля равны значениям:$")
    public void checkResults(DataTable table) {
        DepositPageSteps depositPageSteps = new DepositPageSteps();
        table.asMap(String.class, String.class)
                .forEach((k,v) -> depositPageSteps.checkCalc((String)k,(String)v));
    }
    @After
    public void tearDown(Scenario scenario) {
        super.tearDown(scenario);
    }
}
