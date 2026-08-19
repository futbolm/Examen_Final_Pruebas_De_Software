package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DasboardScreen {
    private static final String PAQUETE=  "edu.pe.cibertec.ciberbank:id/";

    private DasboardScreen (){}

    public static final Target SALUDO =
            Target.the("saludo bienvenida").located(By.id(PAQUETE + "lbl_bienvenida"));

    public static final Target SALDO_PRINCIPAL =
            Target.the("saldo principal").located(By.id(PAQUETE + "lbl_saldo_principal"));

    public static final Target CUENTA_PRINCIPAL =
            Target.the("cuenta principal").located(By.id(PAQUETE + "lbl_cuenta_principal"));

    public static final Target BOTON_MENU =
            Target.the("boton_menu").located(By.id(PAQUETE + "btn_menu"));

    public static final Target BOTON_SERVICIOS =
            Target.the("acceso rapido servicios").located(By.id(PAQUETE + "btn_servicios"));

    /** Acceso directo en el propio dashboard (no requiere abrir el menú lateral). */
    public static final Target BOTON_TRANSFERIR =
            Target.the("acceso rápido transferir").located(By.id(PAQUETE + "btn_transferir"));

    /** Acceso directo en el propio dashboard (no requiere abrir el menú lateral). */
    public static final Target BOTON_MOVIMIENTOS =
            Target.the("acceso rápido movimientos").located(By.id(PAQUETE + "btn_movimientos"));

    /** Ícono hamburguesa que abre el menú lateral (drawer). */
    public static final Target BOTON_ABRIR_MENU =
            Target.the("botón abrir menú lateral").located(By.id(PAQUETE + "btn_menu"));

    // Los siguientes SOLO son visibles dentro del menú lateral (después de pulsar
    // BOTON_ABRIR_MENU). Perfil no tiene acceso rápido en el dashboard, así que para
    // llegar ahí es obligatorio pasar por el drawer.
    public static final Target BOTON_MENU_TRANSFERENCIAS =
            Target.the("menú Transferencias").located(By.id(PAQUETE + "btn_nav_transferencias"));

    public static final Target BOTON_MENU_MOVIMIENTOS =
            Target.the("menú Movimientos").located(By.id(PAQUETE + "btn_nav_movimientos"));

    public static final Target BOTON_MENU_PERFIL =
            Target.the("menú Perfil").located(By.id(PAQUETE + "btn_nav_perfil"));
}