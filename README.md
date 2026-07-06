Antes de ejecutar el proyecto es necesario completar el archivo "application.properties" con:

- weather-api.api-key
- spring.mail.username
- spring.mail.password

La contraseña de mail debe ser una App Password de Google. Estos campos los rellene con credenciales personales al elaborar el trabajo para poder testear su
funcinamiento, pero por un tema de privacidad y seguridad los dejo "a rellenar".

Para la elaboración del trabajo utilize mucho los contenidos en la Clase 2 referidos al consumo de API REST, en especial el repositorio que se realizo
durante dicha clase (https://github.com/dds-utn/rest-paises/tree/main). Cabe resaltar que se uso el Patron Adapter para el consumo del WeatherAPI y JavaMailSender
para el envio de Mails.

Adjunto imagen de como se ve un mail recibido con una alerta:
<img width="406" height="186" alt="image" src="https://github.com/user-attachments/assets/eb5bf4f0-29d4-49d6-a17a-6fcbd5b2357c" />
