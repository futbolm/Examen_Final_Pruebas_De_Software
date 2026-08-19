package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.tasks.AceptarDialogoDeConfirmacion;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.tasks.TransferirA;
import edu.pe.cibertec.ciberbank.userinterface.ConstanciaScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaStepDefinitions {

    private static final String CLAVE = "Cibertec123";

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }


    @Dado("que {word} inició sesión con el usuario {string}")
    public void que_inicio_sesion_con_el_usuario(String actor, String usuario) {
        theActorCalled(actor).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre(),
                IniciarSesion.con(usuario, CLAVE)
        );
    }

    /*
    *Capturamos el monto como String con regex para evitar que Cucumber
    * confunda el punto decimal en Windows español
    * */
    @Cuando("^transfiere (\\d+(?:\\.\\d+)?) al beneficiario \"([^\"]+)\"$")
    public void transfiere_al_beneficiario(String monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                TransferirA.elBeneficiario(beneficiario, monto)
        );
    }

    @Cuando("^intenta transferir (\\d+(?:\\.\\d+)?) al beneficiario \"([^\"]+)\"$")
    public void intenta_transferir_al_beneficiario(String monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                TransferirA.elBeneficiario(beneficiario, monto)
        );
    }

    @Y("acepta el diálogo de confirmación")
    public void acepta_el_dialogo_de_confirmacion() {
        theActorInTheSpotlight().attemptsTo(
                AceptarDialogoDeConfirmacion.delaTransferencia()
        );
    }

    @Entonces("debería ver un número de operación generado")
    public void deberia_ver_un_numero_de_operacion_generado() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(ConstanciaScreen.NUMERO_OPERACION)).isNotBlank()
        );
    }

    @Y("el saldo debería quedar en {string}")
    public void el_saldo_deberia_quedar_en(String saldo) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(ConstanciaScreen.SALDO_ACTUALIZADO)).isEqualTo(saldo)
        );
    }


}