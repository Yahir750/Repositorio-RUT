# Repositorio-RUT

## ¿Qué es este proyecto?
**Repositorio-RUT** implementa un **Sistema de economía circular para desechos electrónicos**, enfocado en apoyar procesos como registro, organización y seguimiento del manejo de e-waste, con el objetivo de facilitar su reutilización, recuperación o disposición responsable.

El proyecto está planteado como una solución **moderna y desplegable**, basada en **contenedores** y una **arquitectura de microservicios** para separar responsabilidades, facilitar el escalamiento y simplificar el despliegue.

---

## Arquitectura (Microservicios + Docker)
El sistema está organizado en componentes independientes que se ejecutan en contenedores (Docker) y se comunican entre sí.

A alto nivel, el enfoque es:

- **Servicios desacoplados** (cada uno con su responsabilidad)
- **Contenerización** para entornos reproducibles
- **Orquestación con Docker Compose** para levantar todo el stack localmente
- **Persistencia** mediante base de datos

---

## Tecnologías utilizadas
### Contenedores y despliegue
- **Docker**
- **Docker Compose**

### Backend / Servicios
- **Java** (servicios y lógica del sistema)

### Base de datos
- **MySQL** (persistencia de datos)

### Frontend
- **HTML**
- **CSS**

---

## ¿Qué resuelve?
El sistema busca aportar estructura al manejo de residuos electrónicos, apoyando tareas como:
- **registro/clasificación** de desechos
- **control del flujo** del residuo (etapas, estados o movimientos)
- **consulta y visualización** de información relevante

---

## Cómo ejecutar (entorno local con Docker)

1. Clonar el repositorio
   ```bash
   git clone https://github.com/Yahir750/Repositorio-RUT.git
   cd Repositorio-RUT
   ```

2. Levantar los contenedores
   ```bash
   docker compose up --build
   ```

3. Detener el entorno
   ```bash
   docker compose down
   ```
