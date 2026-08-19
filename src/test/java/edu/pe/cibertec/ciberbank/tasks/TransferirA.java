package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 *"Usamos 'mobile: type' para evitar que el teclado numérico se coma el
 *punto decimal al escribir montos."
 **/
public class TransferirA implements Task {

    private final String beneficiario;
    private final String monto;

    public TransferirA(String beneficiario, String monto) {
        this.beneficiario = beneficiario;
        this.monto = monto;
    }

    public static TransferirA elBeneficiario(String beneficiario, String monto) {
        return new TransferirA(beneficiario, monto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                AbrirTransferencia.desdeElDashboard(),
                Click.on(TransferenciaScreen.SPINNER_BENEFICIARIO),
                WaitUntil.the(TransferenciaScreen.opcionBeneficiario(beneficiario), isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.opcionBeneficiario(beneficiario)),
                Click.on(TransferenciaScreen.CAMPO_MONTO),
                Clear.field(TransferenciaScreen.CAMPO_MONTO)
        );
        escribirMontoConfiable(actor);
        actor.attemptsTo(
                OcultarTeclado.siEstaAbierto(),
                Click.on(TransferenciaScreen.BOTON_CONTINUAR)
        );
    }

    private <T extends Actor> void escribirMontoConfiable(T actor) {
        AppiumDriver driver = driverDe(actor);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("text", monto);
        driver.executeScript("mobile: type", parametros);
    }

    private AppiumDriver driverDe(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof WebDriverFacade) {
            driver = ((WebDriverFacade) driver).getProxiedDriver();
        }
        return (AppiumDriver) driver;
    }
}