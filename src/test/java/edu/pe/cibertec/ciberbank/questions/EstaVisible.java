package edu.pe.cibertec.ciberbank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

/** Pregunta genérica: ¿este Target está actualmente visible en pantalla? */
public class EstaVisible implements Question<Boolean> {

    private final Target elemento;

    public EstaVisible(Target elemento) {
        this.elemento = elemento;
    }

    public static EstaVisible el(Target elemento) {
        return new EstaVisible(elemento);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return elemento.resolveFor(actor).isCurrentlyVisible();
    }
}