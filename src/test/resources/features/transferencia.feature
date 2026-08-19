# language: es

@transferencia
Característica: Transferencia a beneficiarios
  Como cliente del banco
  Quiero transferir dinero a mis beneficiarios
  Para pagarles sin usar efectivo

  Escenario: Transferencia exitosa a un beneficiario
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando transfiere 250.50 al beneficiario "Luis Ramos"
    Y acepta el diálogo de confirmación
    Entonces debería ver un número de operación generado
    Y el saldo debería quedar en "S/ 4,599.50"

  Escenario: El monto excede el límite por operación
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando intenta transferir 3500 al beneficiario "Maria Torres"
    Entonces debería ver el mensaje de error "Excede el límite de S/ 3,000.00 por operación"

  Escenario: El usuario sin saldo no puede transferir
    Dado que Jaime inició sesión con el usuario "sinsaldo"
    Cuando intenta transferir 100 al beneficiario "Pedro Salas"
    Entonces debería ver el mensaje de error "Saldo insuficiente"