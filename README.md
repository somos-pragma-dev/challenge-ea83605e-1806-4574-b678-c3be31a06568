# Desarrollo de API REST para gestión de productos

El equipo de desarrollo de una fintech necesita implementar una API REST que gestione productos financieros. La API debe permitir la creación, lectura, actualización y eliminación de productos. Los productos tienen atributos como nombre, precio, stock y categoría. La API debe validar que los nombres de los productos no sean duplicados y que los precios no sean negativos. Además, debe manejar adecuadamente los errores y proporcionar respuestas coherentes.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Java Spring Boot REST API |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición y creación de la API

**Objetivo:** Definir y crear la estructura básica de la API REST.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los endpoints necesarios para la gestión de productos.
- Definir los métodos HTTP (GET, POST, PUT, DELETE) para cada operación.
- Implementar la estructura básica de la API con los endpoints definidos.

**Entregable:** API REST con endpoints básicos para la gestión de productos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la estructura de datos necesaria para representar un producto.
- Piensa en cómo manejar las solicitudes y respuestas de la API.

</details>

### Fase 2: Validación de datos y manejo de errores

**Objetivo:** Implementar la validación de datos y el manejo de errores en la API.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Agregar validaciones para asegurar que los nombres de los productos no sean duplicados y que los precios no sean negativos.
- Manejar los errores de validación y proporcionar respuestas coherentes al cliente.

**Entregable:** API REST con validaciones de datos y manejo de errores implementados.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo almacenar y comparar los nombres de los productos para evitar duplicados.
- Piensa en cómo comunicar los errores de validación al cliente de manera clara.

</details>

### Fase 3: Integración con base de datos y documentación

**Objetivo:** Integrar la API con una base de datos y documentar los endpoints usando Swagger.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Integrar la API con una base de datos H2 para el almacenamiento de productos.
- Documentar los endpoints de la API usando Swagger para que los desarrolladores puedan entender y usar la API de manera efectiva.

**Entregable:** API REST integrada con base de datos H2 y documentada con Swagger.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo conectar la API con la base de datos H2.
- Piensa en cómo documentar los endpoints de manera clara y concisa usando Swagger.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una API REST y cuáles son sus características principales?
- **paraQueSirve**: ¿Para qué sirve la API REST en el contexto de la gestión de productos?
- **comoSeUsa**: ¿Cómo se usan los endpoints de la API para crear, leer, actualizar y eliminar productos?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir al validar los datos de los productos y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la integración de la API con una base de datos y la documentación de los endpoints?

## Criterios de Evaluacion

- Definición y creación de la estructura básica de la API REST.
- Implementación de validaciones de datos y manejo de errores.
- Integración de la API con una base de datos H2.
- Documentación clara y concisa de los endpoints usando Swagger.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
