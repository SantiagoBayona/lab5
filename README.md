# Laboratorio5-CVDS

# PARTE UNO

1. Abra una terminal Linux o consola de comandos Windows.
2. Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:
   * Host: www.escuelaing.edu.co
   * Puerto: 80     

3. Antes de que el servidor cierre la conexión por falta de comunicación:
Revise la página 36 del RFC del protocolo HTTP, sobre cómo realizar una petición GET. Con esto, solicite al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP.
Asegúrese de presionar ENTER dos veces después de ingresar el comando.
Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.

**Error 301: Se refiere a un error de tipo REDIRECCIONAMIENTO utilizando la version HTTP 1.0** 
**Resultado**

~~~
HTTP/1.1 301 Moved Permanently 
Date: Fri, 11 March 2022 11:47:19 GMT
Server: Apache/2.2.22 (Fedora)
Location: https://www.escuelaing.edu.co/sssss/abc.html
Content-Length: 339
Connection: close
Content-Type: text/html; charset=iso-8859-1
~~~

~~~
<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
<html><head>
<title>301 Moved Permanently</title>
</head><body>
<h1>Moved Permanently</h1>
<p>The document has moved <a href="https://www.escuelaing.edu.co/sssss/abc.html">here</a>.</p>
<hr>
<address>Apache/2.2.22 (Fedora) Server at www.escuelaing.edu.co Port 80</address>
</body></html>
Connection closed by foreign host.
~~~

¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?
**Error 400: Se refiere a un error de tipo cliente utilizando la version HTTP 1.1** 
**Resultado**

~~~
HTTP/1.1 400 Bad Request
Date: Fri, 11 March 2022 11:39:23 GMT
Server: Apache/2.2.22 (Fedora)
Content-Length: 313
Connection: close
Content-Type: text/html; charset=iso-8859-1

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
<html><head>
<title>400 Bad Request</title>
</head><body>
<h1>Bad Request</h1>
<p>Your browser sent a request that this server could not understand.<br />
</p>
<hr>
<address>Apache/2.2.22 (Fedora) Server at www.escuelaing.edu.co Port 80</address>
</body></html>
~~~


4. Realice una nueva conexión con telnet, esta vez a:
Host: www.httpbin.org
Puerto: 80
Versión HTTP: 1.1
Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

**RESULTADO**

~~~
HTTP/1.1 400 Bad Request
Server: awselb/2.0
Date: Fri, 11 March 2022 12:35:43 GMT
Content-Type: text/html
Content-Length: 138
Connection: close`

`<html>
<head><title>400 Bad Request</title></head>
<body bgcolor="white">
<center><h1>400 Bad Request</h1></center>
</body>
</html>
~~~

5. Seleccione el contenido HTML de la respuesta y copielo al cortapapeles CTRL-SHIFT-C. Ejecute el comando wc (word count) para contar palabras con la opción -c para contar el número de caracteres:
**Resultado de la cantidad de caracteres **

➜  ~ wc -c resultado.txt      
3742 resultado.txt

![ImgenGetPost](https://github.com/EstebananoT/lab5/blob/main/img/getpost.png)

6. En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos:

**UTILIZANDO curl -v www.httpbin.org**

~~~
* Rebuilt URL to: www.httpbin.org/
*   Trying 52.202.2.199...
* TCP_NODELAY set
* Connected to www.httpbin.org (52.202.2.199) port 80 (#0)
> GET / HTTP/1.1
> Host: www.httpbin.org
> User-Agent: curl/7.58.0
> Accept: */*
~~~

**UTILIZANDO curl -i www.httpbin.org**

~~~
HTTP/1.1 200 OK
Date: Fri, 11 March 2022 12:58:46 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 9593
Connection: keep-alive
Server: gunicorn/19.9.0
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true
~~~
