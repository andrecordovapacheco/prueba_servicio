Feature: Poder realizar el enlace con el servidor

  @pingHealthCheck
  @regresion
  Scenario: Un punto final de verificación de estado simple para confirmar si la API está en funcionamiento.
    Given accedo al servicio de RESTFUL BOOKER
    When ingreso al servicio HealthCheck de ping 
    Then espero una respuesta satisfactoria 
    
    
    