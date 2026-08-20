package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class DesplazarLista implements Task {

    private static final int INTENTOS_MAXIMOS = 3;

    public static DesplazarLista hastaElFinal() {
        return new DesplazarLista();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = driverDe(actor);

        for (int i = 0; i < INTENTOS_MAXIMOS; i++) {
            if (yaCargoMas(actor)) {
                return;
            }

            WebElement lista = MovimientosScreen.LISTA_MOVIMIENTOS.resolveFor(actor);
            Rectangle rect = lista.getRect();

            int centroX = rect.getX() + rect.getWidth() / 2;
            int inicioY = rect.getY() + (int) (rect.getHeight() * 0.80);
            int finY = rect.getY() + (int) (rect.getHeight() * 0.50);

            PointerInput dedo = new PointerInput(PointerInput.Kind.TOUCH, "dedo");
            Sequence swipe = new Sequence(dedo, 0);
            swipe.addAction(dedo.createPointerMove(Duration.ZERO,
                    PointerInput.Origin.viewport(), centroX, inicioY));
            swipe.addAction(dedo.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(dedo.createPointerMove(Duration.ofMillis(400),
                    PointerInput.Origin.viewport(), centroX, finY));

            // Pausa sosteniendo el dedo en el mismo punto antes de soltar: sin
            // esto, el swipe genera inercia fling y la lista sigue scrolleando
            // sola después de soltar, pasándose de 30 directo a 32 movimientos.
            swipe.addAction(dedo.createPointerMove(Duration.ofMillis(250),
                    PointerInput.Origin.viewport(), centroX, finY));
            swipe.addAction(dedo.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            ((Interactive) driver).perform(Collections.singletonList(swipe));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private <T extends Actor> boolean yaCargoMas(T actor) {
        try {
            String texto = MovimientosScreen.CONTADOR_MOVIMIENTOS.resolveFor(actor).getText();
            return texto != null && !texto.isBlank() && !texto.startsWith("Mostrando 15 de");
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    private WebDriver driverDe(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof WebDriverFacade) {
            driver = ((WebDriverFacade) driver).getProxiedDriver();
        }
        return driver;
    }
}