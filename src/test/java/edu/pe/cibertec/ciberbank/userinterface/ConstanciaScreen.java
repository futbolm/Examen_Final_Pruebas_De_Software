package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 Pantalla final donde se muestra el comprobante de la transferencia con el número de operación.
 **/
public class ConstanciaScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private ConstanciaScreen() {
    }

    public static final Target NUMERO_OPERACION =
            Target.the("número de operación generado").located(By.id(PAQUETE + "lbl_numero_operacion"));

    public static final Target DESTINO =
            Target.the("beneficiario en el comprobante").located(By.id(PAQUETE + "lbl_constancia_destino"));

    public static final Target MONTO =
            Target.the("monto en el comprobante").located(By.id(PAQUETE + "lbl_constancia_monto"));

    public static final Target SALDO_ACTUALIZADO =
            Target.the("saldo actualizado").located(By.id(PAQUETE + "lbl_saldo_actualizado"));

    public static final Target BOTON_IR_INICIO =
            Target.the("botón Ir al inicio").located(By.id(PAQUETE + "btn_ir_inicio"));
}