## Resolución de conflictos

Al intentar traer los cambios de develop a nuestra rama `feature/STRK-2-spring-security` nos salió un conflicto.

![descripcion de la imagen](../resultados/capturas_pantalla/conflictos1.png)

Identificamos el archivo que tiene el error.

![descripcion de la imagen](../resultados/capturas_pantalla/conflictos2.png)

Como queremos conservar el cambio que hicimos en la rama actual, lo corregimos.
Y quedaría así:

![descripcion de la imagen](../resultados/capturas_pantalla/conflictos3.png)

Luego agregamos el archivo que corregimos y hacemos un commit indicando la resolución del conflicto y subimos el cambio.

![descripcion de la imagen](../resultados/capturas_pantalla/conflictos4.png)

Y listo, ahora ya podremos hacer el PR sin conflictos.

![descripcion de la imagen](../resultados/capturas_pantalla/conflictos5.png)

