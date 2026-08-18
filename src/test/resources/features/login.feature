# language: es

@login
Característica: Inicio de sesión en CiberBank
  Como cliente del banco
  Quiero iniciar sesión en la aplicación
  Para consultar el saldo de mis cuentas

  Escenario: Ingreso exitoso con credenciales válidas
    Dado que Jaime está en la pantalla de login
    Cuando ingresa el usuario "jaime" y la contraseña "Cibertec123"
    Entonces debería ver el saldo "S/ 4,850.00" en el dashboard

  Escenario: Ingreso con contraseña incorrecta
    Dado que Jaime está en la pantalla de login
    Cuando ingresa el usuario "jaime" y la contraseña "malaClave"
    Entonces debería ver el mensaje de error "Credenciales inválidas"

  Esquema del escenario: Ingresos rechazados por usuario bloqueado o campos vacíos
    Dado que Jaime está en la pantalla de login
    Cuando ingresa el usuario "<usuario>" y la contraseña "<clave>"
    Entonces debería ver el mensaje de error "<mensaje>"

    Ejemplos:
      | usuario   | clave       | mensaje                               |
      | bloqueado | Cibertec123 | Usuario bloqueado. Contacte a soporte |
      |           |             | El usuario es obligatorio             |