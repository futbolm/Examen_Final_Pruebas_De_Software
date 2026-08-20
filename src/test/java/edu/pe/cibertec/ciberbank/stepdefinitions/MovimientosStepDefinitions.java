package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.tasks.AbrirMovimientos;
import edu.pe.cibertec.ciberbank.tasks.DesplazarLista;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MovimientosStepDefinitions {

    @Cuando("abre la pantalla de movimientos")
    public void abre_la_pantalla_de_movimientos() {
        theActorInTheSpotlight().attemptsTo(
                AbrirMovimientos.desdeElDashboard()
        );
    }

    @Cuando("desplaza la lista hasta el final")
    public void desplaza_la_lista_hasta_el_final() {
        theActorInTheSpotlight().attemptsTo(
                DesplazarLista.hastaElFinal()
        );
    }

    @Entonces("debería ver el contador {string}")
    public void deberia_ver_el_contador(String contador) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(MovimientosScreen.CONTADOR_MOVIMIENTOS)).isEqualTo(contador)
        );
    }
}