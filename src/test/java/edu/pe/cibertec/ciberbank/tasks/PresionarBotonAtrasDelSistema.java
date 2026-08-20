package edu.pe.cibertec.ciberbank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

/** Presiona el botón "Atrás" físico/virtual del sistema Android (navigate().back()). */
public class PresionarBotonAtrasDelSistema implements Task {

    public static PresionarBotonAtrasDelSistema unaVez() {
        return new PresionarBotonAtrasDelSistema();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof WebDriverFacade) {
            driver = ((WebDriverFacade) driver).getProxiedDriver();
        }
        driver.navigate().back();
    }
}