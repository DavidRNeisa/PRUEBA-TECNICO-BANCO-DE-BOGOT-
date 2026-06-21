# PRUEBA-TECNICO-BANCO-DE-BOGOTA

Claro. Te dejo una versión más clara, formal y bien redactada del contexto y la especificación del proyecto, sin emojis:

---

## Contexto del proyecto

El objetivo de este proyecto es desarrollar una herramienta web sencilla que permita a los practicantes registrar su información mediante un formulario, y que posteriormente los analistas de selección puedan revisar y gestionar dicha información. La aplicación contará con dos módulos principales: uno orientado al registro de practicantes y otro destinado a la consulta y evaluación de candidatos por parte de los analistas.

En el módulo de practicantes, los usuarios podrán ingresar sus datos personales y académicos, así como cargar su hoja de vida en formato PDF. En el módulo de analistas, se podrá visualizar el listado de practicantes registrados, consultar su información detallada y asignarles un estado de evaluación como “viable” o “no viable”.

Este desarrollo podrá realizarse con cualquier lenguaje de programación o framework conocido por el equipo, utilizando herramientas gratuitas o con licencia académica. No es obligatorio desplegar la aplicación en la nube, ya que puede ejecutarse de manera local.

Además, el proyecto incluirá acompañamiento durante el proceso de desarrollo, fomentando la democratización del conocimiento dentro del equipo. Para ello, se contará con liderazgo de equipo y se creará un grupo en Microsoft Teams con el fin de resolver dudas, compartir avances y facilitar la comunicación entre los integrantes.

---

## Especificación funcional

### 1. Módulo de registro para practicantes

El sistema deberá permitir que los practicantes diligencien un formulario con los siguientes campos obligatorios:

* Nombre completo
* Correo electrónico
* Carrera universitaria
* Semestre actual
* Carga de archivo: hoja de vida en formato PDF

El formulario debe incluir validaciones básicas para asegurar que los campos obligatorios no estén vacíos y que el archivo cargado cumpla con el formato requerido.

### 2. Panel de analista

El sistema deberá contar con un panel de administración en el que los analistas puedan:

* Visualizar la lista de practicantes registrados
* Consultar la información detallada de cada practicante
* Cambiar el estado del candidato a “viable” o “no viable”

### 3. Back-end

La aplicación deberá incluir una API sencilla que permita:

* Guardar la información de los practicantes
* Consultar el listado de practicantes registrados
* Actualizar el estado de evaluación de cada candidato

La información deberá almacenarse en una base de datos local, como SQLite o una alternativa similar. Los archivos cargados deberán guardarse en una carpeta del servidor.

### 4. Funcionalidades adicionales opcionales

Como mejora adicional, se podrá implementar:

* Autenticación básica para restringir el acceso al panel de analistas mediante usuario y contraseña
* Descarga de la hoja de vida desde el panel de analista

### 5. Documentación

El proyecto deberá incluir un archivo README con instrucciones claras para:

* Instalar el proyecto
* Ejecutar la aplicación localmente
* Describir su funcionamiento general

Si es posible, también se pueden incluir capturas de pantalla del sistema.
