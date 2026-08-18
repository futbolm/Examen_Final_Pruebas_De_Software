package edu.pe.cibertec.ciberbank.questions;

import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class MensajeDeErrorVisible implements Question<String> {

    private static final List<Target> POSIBLES_ERRORES = List.of(
            LoginScreen.ERROR_LOGIN,
            LoginScreen.ERROR_USUARIO
    );

    public static MensajeDeErrorVisible enPantalla() {
        return new MensajeDeErrorVisible();
    }

    @Override
    public String answeredBy(Actor actor) {
        return POSIBLES_ERRORES.stream()
                .filter(target -> target.resolveFor(actor).isCurrentlyVisible())
                .findFirst()
                .map(target -> target.resolveFor(actor).getText())
                .orElse("");
    }
}