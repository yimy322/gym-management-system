# Marco Teórico

## Antecedentes

Para la realización del presente proyecto, se tomaron en consideración diversos trabajos previos relacionados con el desarrollo de sistemas web de gestión administrativa, especialmente tesis y proyectos de pregrado que abordan problemáticas similares al objetivo de esta investigación. Estas investigaciones permitieron identificar distintos enfoques y soluciones aplicadas en la administración de usuarios, control de membresías, gestión de pagos y seguimiento de asistencia en organizaciones como gimnasios y otros servicios.

El análisis de estos antecedentes resulta importante porque permite sustentar la viabilidad del proyecto y comprender cómo la implementación de herramientas tecnológicas contribuye a optimizar procesos administrativos, reducir errores operativos y mejorar la toma de decisiones.

A continuación, se presentan algunos estudios que sirven como referencia para la propuesta del desarrollo de un Sistema Web Integral para mejorar la gestión administrativa del gimnasio STRKE.

### Antecedente Internacional

En el contexto internacional, la tesis titulada “Aplicación web para mejorar la gestión administrativa del departamento de vinculación de la Universidad Estatal de Bolívar”, desarrollada por Pachala Guzmán (2015) en Ecuador, tuvo como finalidad optimizar la gestión de programas y proyectos mediante la implementación de un sistema informático que permitiera organizar, evaluar y monitorear la información institucional.

El estudio concluyó que la implementación del sistema web permitió mejorar significativamente la organización de la información, optimizar los procesos administrativos y facilitar la toma de decisiones dentro de la institución. Este antecedente demuestra que la automatización de procesos administrativos mediante plataformas web representa una solución efectiva para mejorar la eficiencia organizacional.

### Antecedente Nacional

En el ámbito nacional, la tesis titulada “Implementación de un sistema web para mejorar la gestión de ventas en la empresa Easy Construction Cr S.A.C.”, desarrollada por Uceda Gutiérrez (2025), tuvo como finalidad optimizar el proceso de ventas mediante la automatización de tareas clave como la gestión de clientes, control de inventario y registro de operaciones.

La investigación utilizó tecnologías como Angular como framework de desarrollo, TypeScript como lenguaje de programación y MongoDB como sistema de base de datos. Los resultados evidenciaron una mejora significativa en el control administrativo y en la eficiencia operativa de la empresa, permitiendo reducir errores manuales y mejorar el acceso a la información.

Otro antecedente relevante es la investigación de Vilca y Pulache (2023), titulada “Desarrollo de un sistema web para la gestión administrativa en un gimnasio, Lima 2022”, donde se evidenció que la implementación del sistema mejoró significativamente la eficacia administrativa, pasando de 50.37% a 95.38%, así como la confiabilidad de los procesos internos. Asimismo, Adauto y Torre (2023), en su proyecto desarrollado para el gimnasio “Bull Gym Fitness”, identificaron deficiencias en el control de clientes, membresías e inventario de equipos. La implementación del sistema web permitió optimizar la administración de recursos y mejorar el acceso a la información.

Por otro lado, Palma-Caffo (2023), en la implementación de un sistema web para ventas online del gimnasio Power Flex Gym, concluyó que el 100% de los trabajadores consideró que el sistema mejoró la atención al cliente y fortaleció la gestión comercial del gimnasio.


Estos antecedentes resultan relevantes para el presente proyecto, ya que demuestran cómo la implementación de un sistema web puede mejorar procesos internos y fortalecer la gestión administrativa en diferentes tipos de organizaciones.

## Bases Teóricas

El uso de la tecnología para apoyar los procesos de gestión administrativa se ha convertido en una necesidad fundamental para organizaciones de cualquier tamaño. En el caso de los gimnasios, el control de usuarios, membresías, pagos y asistencia constituye un aspecto clave para mantener un adecuado funcionamiento del negocio.

Un manejo ineficiente de estos procesos puede generar desorganización, pérdida de información, errores en los registros, retrasos administrativos y dificultades en la atención al cliente. Por ello, los sistemas web se han consolidado como herramientas tecnológicas que permiten optimizar la gestión, mejorar la precisión de los datos y facilitar la toma de decisiones.

A partir de este contexto, el presente marco teórico expone los conceptos fundamentales que sustentan el desarrollo del Sistema Web Integral para la Gestión Administrativa del gimnasio STRKE, así como las principales tecnologías empleadas para su implementación.

### Sistema Web

Un sistema web es una aplicación informática que se ejecuta a través de un navegador y permite a los usuarios acceder, procesar y gestionar información mediante internet o una red interna (Crea System, 2022). Su principal objetivo es facilitar el acceso a los datos, optimizar procesos organizacionales y mejorar la interacción entre el usuario y el sistema.

En el contexto del presente proyecto, el sistema web permitirá gestionar la información del gimnasio STRKE, incluyendo el registro de afiliados, control de membresías, pagos y asistencia, brindando datos organizados, centralizados y accesibles para una mejor administración.

#### Componentes del sistema web aplicados en el proyecto

* Software: aplicación web desarrollada utilizando Spring Boot.
* Base de datos: MySQL para el almacenamiento estructurado de la información.
* Usuarios: administrador y personal autorizado del gimnasio.
* Procesos: registro, actualización y consulta de afiliados, membresías, pagos y asistencia.

### Sistema de Gestión

Un sistema de gestión es un conjunto de herramientas, procesos y recursos que permite administrar información y controlar actividades dentro de una organización. Su propósito principal es mejorar la eficiencia, la organización y la productividad institucional.

En este proyecto, el sistema de gestión permitirá organizar y controlar las operaciones administrativas del gimnasio STRKE, facilitando el seguimiento de clientes, el control financiero y la supervisión de membresías activas.

## Tecnologías Utilizadas

### Lenguaje de Programación

#### Java

Java es un lenguaje de programación orientado a objetos ampliamente utilizado en el desarrollo de aplicaciones empresariales debido a su seguridad, portabilidad y escalabilidad. En este proyecto, Java será utilizado para construir la lógica del sistema y permitir la interacción entre la interfaz del usuario y la base de datos.

### Framework

#### Spring Boot

Spring Boot es un framework de código abierto basado en Java que facilita el desarrollo de aplicaciones web robustas y escalables. Permite reducir la configuración inicial del proyecto y agiliza la implementación de funcionalidades backend, mejorando la productividad del desarrollo.

### Base de Datos

#### MySQL

MySQL es un sistema de gestión de bases de datos relacional ampliamente utilizado en aplicaciones empresariales por su eficiencia, seguridad y facilidad de integración. En este proyecto, será utilizado para almacenar toda la información relacionada con usuarios, membresías, pagos y asistencia.

Se eligió MySQL debido a que permite manejar grandes volúmenes de información de forma estructurada y segura, sin comprometer el rendimiento del sistema.

### Tecnologías de Interfaz

#### Thymeleaf

Thymeleaf es un motor de plantillas Java del lado del servidor que permite integrar la lógica backend con las vistas HTML, facilitando el desarrollo de interfaces dinámicas y organizadas.

#### Bootstrap

Bootstrap es un framework CSS de código abierto orientado al diseño de interfaces web responsivas y modernas. Permite mejorar la experiencia del usuario mediante una presentación visual clara, ordenada y adaptable a distintos dispositivos.

### Control de Versiones (Git)

Git es un sistema de control de versiones que permite a los desarrolladores registrar, gestionar y supervisar los cambios realizados en el código fuente de un proyecto (The Forage, 2024). Su propósito principal es mantener un historial de versiones que facilite recuperar cambios anteriores, organizar el desarrollo y mejorar el trabajo colaborativo.

En este proyecto, Git será utilizado para controlar las versiones del sistema web del gimnasio STRKE, registrando los avances realizados durante el desarrollo y permitiendo una mejor administración del código fuente.

#### Componentes aplicados en el proyecto

* Repositorio: almacenamiento del código fuente.
* Commits: registro de cambios realizados.
* Ramas: desarrollo independiente de funcionalidades.
* Historial: seguimiento y control de versiones.

### Plataforma de Desarrollo Colaborativo (GitHub)

GitHub es una plataforma de desarrollo colaborativo basada en la nube que utiliza Git como sistema de control de versiones, permitiendo almacenar, administrar y supervisar proyectos de software (EBAC, 2023).

Su propósito es facilitar el trabajo en equipo, el seguimiento del progreso y la colaboración entre desarrolladores mediante herramientas como repositorios, ramas, issues y pull requests.

En el presente proyecto, GitHub será utilizado para almacenar el código fuente del sistema web del gimnasio STRKE, gestionar cambios y organizar el desarrollo mediante un flujo de trabajo colaborativo.

### Componentes aplicados en el proyecto

* Repositorio: almacenamiento del proyecto en la nube.
* Commits: registro de modificaciones.
* Ramas: desarrollo separado por funcionalidades.
* Issues: seguimiento de tareas y problemas.
* Pull Requests: revisión y aprobación de cambios antes de integrarlos.
