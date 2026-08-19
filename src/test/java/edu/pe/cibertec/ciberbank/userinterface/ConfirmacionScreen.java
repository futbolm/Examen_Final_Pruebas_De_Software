package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 "Aquí están los botones de la pantalla de confirmación, incluyendo 'Confirmar' y
 el diálogo nativo de Android que aparece después."
 **/
public class ConfirmacionScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private ConfirmacionScreen() {
    }

    public static final Target ORIGEN =
            Target.the("cuenta origen en el resumen").located(By.id(PAQUETE + "lbl_resumen_origen"));

    public static final Target DESTINO =
            Target.the("beneficiario destino en el resumen").located(By.id(PAQUETE + "lbl_resumen_destino"));

    public static final Target MONTO =
            Target.the("monto en el resumen").located(By.id(PAQUETE + "lbl_resumen_monto"));

    public static final Target BOTON_CONFIRMAR =
            Target.the("botón Confirmar").located(By.id(PAQUETE + "btn_confirmar"));

    public static final Target BOTON_VOLVER =
            Target.the("botón Volver").located(By.id(PAQUETE + "btn_volver"));

    /** Botón Aceptar del diálogo nativo de Android que aparece al pulsar Confirmar. */
    public static final Target BOTON_ACEPTAR_DIALOGO =
            Target.the("botón Aceptar del diálogo").located(By.id("android:id/button1"));

    /** Botón Cancelar del diálogo nativo de Android. */
    public static final Target BOTON_CANCELAR_DIALOGO =
            Target.the("botón Cancelar del diálogo").located(By.id("android:id/button2"));
}