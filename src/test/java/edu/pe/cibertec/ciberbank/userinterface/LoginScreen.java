package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LoginScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private LoginScreen() {
    }

    public static final Target CAMPO_USUARIO =
            Target.the("campo Usuario").located(By.id(PAQUETE + "inp_usuario"));

    public static final Target CAMPO_CLAVE =
            Target.the("campo Contraseña").located(By.id(PAQUETE + "inp_clave"));

    public static final Target BOTON_INGRESAR =
            Target.the("botón Ingresar").located(By.id(PAQUETE + "btn_ingresar"));

    public static final Target ERROR_USUARIO =
            Target.the("error del campo Usuario").located(By.id(PAQUETE + "err_usuario"));

    public static final Target ERROR_CLAVE =
            Target.the("error del campo Contraseña").located(By.id(PAQUETE + "err_clave"));

    public static final Target ERROR_LOGIN =
            Target.the("mensaje de error del login").located(By.id(PAQUETE + "err_login"));

    public static final Target BOTON_REINICIAR_DATOS =
            Target.the("enlace Reiniciar datos de prueba").located(By.id(PAQUETE + "btn_reiniciar_datos"));
}