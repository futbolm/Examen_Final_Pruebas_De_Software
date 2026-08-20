package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DasboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.PerfilScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AbrirPerfil implements Task {

    public static AbrirPerfil desdeElDashboard() {
        return new AbrirPerfil();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DasboardScreen.BOTON_ABRIR_MENU),
                WaitUntil.the(DasboardScreen.BOTON_MENU_PERFIL, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DasboardScreen.BOTON_MENU_PERFIL),
                WaitUntil.the(PerfilScreen.BOTON_CERRAR_SESION, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}