# language: es

@movimientos
Característica: Consulta de movimientos

  Escenario: La lista carga más movimientos al desplazarse
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando abre la pantalla de movimientos
    Entonces debería ver el contador "Mostrando 15 de 32 movimientos"
    Cuando desplaza la lista hasta el final
    Entonces debería ver el contador "Mostrando 30 de 32 movimientos"