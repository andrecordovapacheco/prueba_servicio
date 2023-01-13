Feature: servicio de autentificacion

  @creartoken @regresion
  Scenario Outline: Crea un nuevo token de autenticacion para usar para acceder a PUT y DELETE /booking
    Given accedo al servicio de RESTFUL BOOKER
    When ingreso al servicio de creacion de token de acuerdo al usuario "<usuario>" y contrasenia "<contrasenia>"
    Then espero obtener un token y el estado code 200

    Examples: 
      | usuario | contrasenia |
      | admin   | password123 |
