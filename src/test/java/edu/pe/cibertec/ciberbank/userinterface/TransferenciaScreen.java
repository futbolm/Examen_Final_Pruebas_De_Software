package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Aquí están todos los botones y campos de la pantalla de Transferencias, localizados por su ID.**/
public class TransferenciaScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private TransferenciaScreen() {
    }

    public static final Target SPINNER_BENEFICIARIO =
            Target.the("desplegable de beneficiario").located(By.id(PAQUETE + "spn_beneficiario"));

    public static final Target CAMPO_MONTO =
            Target.the("campo Monto").located(By.id(PAQUETE + "inp_monto"));

    public static final Target CAMPO_CONCEPTO =
            Target.the("campo Concepto").located(By.id(PAQUETE + "inp_concepto"));

    /** El botón real de envío es btn_continuar, NO btn_transferir (ese id no existe aquí). */
    public static final Target BOTON_CONTINUAR =
            Target.the("botón Continuar").located(By.id(PAQUETE + "btn_continuar"));

    public static final Target ERROR_TRANSFERENCIA =
            Target.the("mensaje de error de la transferencia").located(By.id(PAQUETE + "err_transferencia"));

    public static final Target SALDO_DISPONIBLE =
            Target.the("saldo disponible").located(By.id(PAQUETE + "lbl_saldo_disponible"));

    /**
     Buscamos beneficiarios por coincidencia parcial (contains) porque el spinner
     muestra 'Nombre - Banco' completo."
    **/
    public static Target opcionBeneficiario(String nombreBeneficiario) {
        return Target.the("beneficiario: " + nombreBeneficiario)
                .located(By.xpath("//android.widget.TextView[@resource-id='"
                        + PAQUETE + "lbl_spinner_opcion' and contains(@text,'" + nombreBeneficiario + "')]"));
    }
}