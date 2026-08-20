# language: es

@perfil
Característica: Cierre de sesión desde el Perfil

  Escenario: Cerrar sesión regresa a la pantalla de login
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando abre la pantalla de perfil
    Y pulsa el botón de cerrar sesión
    Entonces debería regresar a la pantalla de login

  Escenario: El botón atrás del sistema no reingresa al dashboard tras cerrar sesión
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando abre la pantalla de perfil
    Y pulsa el botón de cerrar sesión
    Y presiona el botón atrás del sistema
    Entonces no debería regresar al dashboard