Feature: Poder realizar clas reservas

  @GetBookingIdsAll @regresion
  Scenario: Devuelve los ids de todas las reservas que existen dentro de la API.
    Given accedo al servicio de RESTFUL BOOKER
    When consulto el servicio de todos las reservas
    Then espero obtener todas las reservas

  @GetBookingIdsFilter @regresion
  Scenario Outline: Devuelve los ids de todas las reservas que existen dentro de la API de acuerdo al filtro
    Given accedo al servicio de RESTFUL BOOKER
    When consulto el servicio de todos las reservas de acuerdo  "<firstname>" ,"<lastname>","<checkin>"
    Then espero obtener todas las reservas

    Examples: 
      | firstname | lastname | checkin    |
      | Sally     | Brown    | 2013-02-23 |

  @GetBooking @regresion
  Scenario Outline: Devuelve una reserva específica basada en la identificación de la reserva proporcionada
    Given accedo al servicio de RESTFUL BOOKER
    When consulto el servicio de reserva especifica "<id>"
    Then espero obtener la reserva indicada "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>"

    Examples: 
      | id | nombre | apellido | totalprice | depositpaid | checkin    | checkout   |
      |  1 | Mary   | Jones    |        648 | true        | 2022-04-20 | 2022-10-12 |

  @CreateBooking @regresion
  Scenario Outline: crea una reserva de acuerdo a los datos especificados
    Given accedo al servicio de RESTFUL BOOKER
    When consulto el servicio de reserva especifica "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
    Then espero obtener la reserva  "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>"

    Examples: 
      | id | nombre | apellido | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      |  1 | Mary   | Jones    |        648 | true        | 2022-04-20 | 2022-10-12 | Breakfast       |

  @UpdateBooking @regresion
  Scenario Outline: Actualiza una reserva actual
    Given accedo al servicio de RESTFUL BOOKER
    And genero el token con el usuario "<user>" y contrasenia "<contrasenia>"
    When actualizo los datos del id "<id>" a "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
    Then espero obtener la actualizacion  "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>"

    Examples: 
      | id | user  | contrasenia | nombre | apellido | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      |  1 | admin | password123 | hola   | andre    |        648 | true        | 2022-04-20 | 2022-10-12 | Breakfast       |

  @PartialUpdateBooking @regresion
  Scenario Outline: Actualiza una reserva actual con una carga útil parcial
    Given accedo al servicio de RESTFUL BOOKER
    And genero el token con el usuario "<user>" y contrasenia "<contrasenia>"
    When actualizo los datos del id parcialmente "<id>" a "<nombre>","<apellido>"
    Then espero obtener la actualizacion  "<nombre>","<apellido>","<totalprice>","<depositpaid>","<checkin>","<checkout>"

    Examples: 
      | id | user  | contrasenia | nombre | apellido | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      |  1 | admin | password123 | pepe   | cordova  |        787 | false       | 2020-12-08 | 2021-03-15 | Breakfast       |

  @DeleteBooking @regresion
  Scenario Outline: elimina la reserva creada
    Given accedo al servicio de RESTFUL BOOKER
    And genero el token con el usuario "<user>" y contrasenia "<contrasenia>"
    When elimino la reserva "<id>"
    Then espero la eliminacion de la reserva

    Examples: 
      | id  | user  | contrasenia |
      | 196 | admin | password123 |
