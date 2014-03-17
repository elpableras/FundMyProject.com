FundMyProject.com
=================

Se trata de desarrollar un portal orientado a la coordinación de creadores de aplicaciones que requieran financiación para el desarrollo de su proyecto.

La aplicación cumple con el modelo arquitectónico de n-capas. La persistencia se implementa con patrones DAOs y con la base de datos HSQLDB. Además cumple con:

- Uso de Struts 2 en la capa de presentación
- Contador de visitas basado en el uso del contexto
- La autentificación se realiza utilizando un interceptor
- Validación de los formularios de login, registro y creación de proyectos para que:
    - Todos los campos en todos los formularios deben tener valor, no pueden ser nulos.
    - El user (registro) debe tener al menos entre 5 y 50 caracteres
    - La password (registro) debe tener al menos entre 5 y 50 caracteres
    - La descripción del proyecto no puede tener más de 300 caracteres
    - El valor de la acción sobre el proyecto debe ser de al menos 100.0
    - El coste del proyecto deberá ser un valor Double
    - El porcentaje deberá estar comprendido entre 0.0 y 100.0
