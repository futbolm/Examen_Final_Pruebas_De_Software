package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.EstaVisible;
import edu.pe.cibertec.ciberbank.tasks.AbrirPerfil;
import edu.pe.cibertec.ciberbank.tasks.CerrarSesion;
import edu.pe.cibertec.ciberbank.tasks.PresionarBotonAtrasDelSistema;
import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * Antes, estos steps solo hacían System.out.println("cerrando sesión...") en vez de
 * comprobar algo real. Ahora cada validación usa Ensure sobre un Target concreto.
 *
 * Nota sobre el 2do escenario: como el logout limpia todo el stack de actividades
 * (FLAG_ACTIVITY_CLEAR_TASK), al presionar "atrás" en la pantalla de login la app
 * simplemente sale al home de Android (no se queda "en" ninguna pantalla de la app).
 * Por eso NO validamos "sigue viendo el login" ahí, sino "no volvió al dashboard",
 * que es literalmente lo que pide el enunciado.
 */
public class PerfilStepDefinitions {

    @Cuando("abre la pantalla de perfil")
    public void abre_la_pantalla_de_perfil() {
        theActorInTheSpotlight().attemptsTo(
                AbrirPerfil.desdeElDashboard()
        );
    }

    @Y("pulsa el botón de cerrar sesión")
    public void pulsa_el_boton_de_cerrar_sesion() {
        theActorInTheSpotlight().attemptsTo(
                CerrarSesion.pulsandoElBoton()
        );
    }

    @Y("presiona el botón atrás del sistema")
    public void presiona_el_boton_atras_del_sistema() {
        theActorInTheSpotlight().attemptsTo(
                PresionarBotonAtrasDelSistema.unaVez()
        );
    }

    @Entonces("debería regresar a la pantalla de login")
    public void deberia_regresar_a_la_pantalla_de_login() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EstaVisible.el(LoginScreen.CAMPO_USUARIO)).isTrue()
        );
    }

    @Entonces("no debería regresar al dashboard")
    public void no_deberia_regresar_al_dashboard() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EstaVisible.el(DashboardScreen.SALDO_PRINCIPAL)).isFalse()
        );
    }
}