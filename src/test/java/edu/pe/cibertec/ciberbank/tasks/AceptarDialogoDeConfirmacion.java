package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import edu.pe.cibertec.ciberbank.userinterface.ConstanciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AceptarDialogoDeConfirmacion implements Task {

    public static AceptarDialogoDeConfirmacion delaTransferencia() {
        return new AceptarDialogoDeConfirmacion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Espera a que la pantalla de resumen termine de cargar tras el
                // "Continuar" de Transferencias la transición no es instantánea.
                WaitUntil.the(ConfirmacionScreen.BOTON_CONFIRMAR, isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(ConfirmacionScreen.BOTON_CONFIRMAR),
                WaitUntil.the(ConfirmacionScreen.BOTON_ACEPTAR_DIALOGO, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(ConfirmacionScreen.BOTON_ACEPTAR_DIALOGO),
                WaitUntil.the(ConstanciaScreen.NUMERO_OPERACION, isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
}