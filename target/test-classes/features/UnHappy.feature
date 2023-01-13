Feature: Poder realizar el enlace con el servidor

  @UnHappyGetBooking @regresion
  Scenario: No Devuelve ninguna reserva por que no existe el id , deberia de retornar stado de codigo 404
    Given accedo al servicio de RESTFUL BOOKER
    When consulto el servicio de reserva especificas "<id>"
    Then espero obtener el codigo de estado "404"

  @UnHappyCreateBooking @regresion
  Scenario Outline: No deberia de crear por que se le esta ingresando un apellido con numeros, deberia de retornar error 500
    Given accedo al servicio de RESTFUL BOOKER
    When consulto el servicio de reserva especificas "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
    Then espero obtener el codigo de estado "500"

    Examples: 
      | id | nombre | apellido | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      |  1 | Mary   | 999    |        648 | true        | 2022-04-20 | 2022-10-12 | Breakfast       |

      
      @UnHappyUpdateBooking @regresion
  Scenario Outline: No deberia de actualiza una reserva , deberia de salir error 500
    Given accedo al servicio de RESTFUL BOOKER
    And genero el token con el usuario "<user>" y contrasenia "<contrasenia>"
    When actualizo los datos del ids "<id>" a "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
   Then espero obtener el codigo de estado "500"
   
    Examples: 
      | id | user  | contrasenia | nombre | apellido | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      |  1 | admin | password123 | hola   | 112333    |        648 | true        | 2022-04-20 | 2022-10-12 | Breakfast       |
     
     
      @UnHappyPartialUpdateBooking @regresion
  Scenario Outline: No deberia de actualiza parcialmente la reserva , deberia de salir error 500
    Given accedo al servicio de RESTFUL BOOKER
    And genero el token con el usuario "<user>" y contrasenia "<contrasenia>"
    When actualizo los datos del id parcialmentes "<id>" a "<nombre>","<apellido>"
    Then espero obtener el codigo de estado "500"
    
    Examples: 
      | id | user  | contrasenia | nombre | apellido | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      |  1 | admin | password123 | pepe   | 312  |        787 | false       | 2020-12-08 | 2021-03-15 | Breakfast       |
     
      