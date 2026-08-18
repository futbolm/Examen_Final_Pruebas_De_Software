package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.MensajeDeErrorVisible;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que {word} está en la pantalla de login")
    public void que_esta_en_la_pantalla_de_login(String actor) {
        theActorCalled(actor).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre()
        );
    }

    @Cuando("ingresa el usuario {string} y la contraseña {string}")
    public void ingresa_el_usuario_y_la_contrasena(String usuario, String clave) {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario, clave)
        );
    }

    @Entonces("debería ver el saldo {string} en el dashboard")
    public void deberia_ver_el_saldo_en_el_dashboard(String saldo) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(DashboardScreen.SALDO_PRINCIPAL)).isEqualTo(saldo)
        );
    }


    @Entonces("debería ver el mensaje de error {string}")
    public void deberia_ver_el_mensaje_de_error(String mensaje) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(MensajeDeErrorVisible.enPantalla()).isEqualTo(mensaje)
        );
    }
}