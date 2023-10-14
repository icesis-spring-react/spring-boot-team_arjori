# Taller 3: Spring Boot.

## Integrantes:

- Ricardo Medina Sterling.
- José Alejandro García Marcos.
- Ariel Eduardo Pabón Bolaños.

## Prerrequisitos:

- Usar IntelliJ preferiblemente.

## Modo de utilización de la API:

Para emplear los endpoints de la API se requiere autenticación, la cual se puede hacer a través de un usuario y contraseña o con un JWT generado por el servidor. En las solicitudes se tendrá un campo llamado "Authorization" que contendrá el tipo de autenticación a emplear y la credencial.

En este proyecto se tiene un sólo usuario quemado en el código:

-username: admin
-password: admin

### Autenticación básica:

Para este tipo de autenticación se debe pasar las credenciales de usuario y contraseña, como se muestra en la Figura 1 y 2.

![BASIC_AUTH_OK](/docs/BASIC_AUTH_OK.png)

<br>
*Figura 1: Autenticación básica realizada con éxito y generación de JWT.*
<br>

![BASIC_AUTH_REJ](/docs/BASIC_AUTH_REJ.png)

<br>
*Figura 2: Autenticación básica realizada sin éxito.*
<br>

### Autenticación por JWT:

Para este tipo de autenticación se debe pasar el JWT generado (como en la Figura 1), tal y como se muestra en la Figura 3 y 4.

![JWT_AUTH_OK](/docs/JWT_AUTH_OK.png)

<br>
*Figura 3: Autenticación con JWT realizada con éxito.*
<br>

![JWT_AUTH_REJ](/docs/JWT_AUTH_REJ.png)

<br>
*Figura 4: Autenticación con JWT realizada sin éxito.*
<br>
