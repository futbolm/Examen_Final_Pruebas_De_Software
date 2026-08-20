package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Locators de la pantalla de Perfil. Todos por resource-id. */
public class PerfilScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private PerfilScreen() {
    }

    public static final Target NOMBRE =
            Target.the("nombre del titular").located(By.id(PAQUETE + "lbl_perfil_nombre"));

    public static final Target USUARIO =
            Target.the("usuario en el perfil").located(By.id(PAQUETE + "lbl_perfil_usuario"));

    public static final Target BOTON_CERRAR_SESION =
            Target.the("botón Cerrar sesión").located(By.id(PAQUETE + "btn_cerrar_sesion"));
}