package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DasboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/** Navega desde el dashboard hacia Movimientos usando el acceso directo (btn_movimientos). */
public class AbrirMovimientos implements Task {

    public static AbrirMovimientos desdeElDashboard() {
        return new AbrirMovimientos();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DasboardScreen.BOTON_MOVIMIENTOS),
                WaitUntil.the(MovimientosScreen.LISTA_MOVIMIENTOS, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}