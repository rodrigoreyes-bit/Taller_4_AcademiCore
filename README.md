# 🎓 Taller N°4 - Sistema Académico de Certificaciones Profesionales: "AcademiCore"

**II Semestre - 2025 | ITI - ICCI**
---

## 👨‍🏫 Docentes

- Alejandro Paolini Godoy  

- Cristhian Rabi Reyes  



## 👨‍💻 Ayudantes

- Daniel Durán García  

- Nicolás Rojas Bustos  

---

## 👥 Integrantes
| **Ninibeth Pérez Cortés** | 21.787.686-9 | ICCI | `papaFritaUwU` | 
| **Rodrigo Reyes Alfaro** | 22.123.808-7 | ICCI | `rodrigoreyes-bit` |

---

## 🧠 Descripción del Proyecto: "AcademiCore"

Este proyecto implementa un sistema integral para digitalizar y automatizar la gestión de **Certificaciones Profesionales en Tecnología** de la Universidad Católica del Mish. El objetivo principal es proporcionar **transparencia, eficiencia y automatización** en el seguimiento del progreso académico, resolviendo problemas como el desconocimiento de oportunidades, la falta de métricas y la lentitud en la generación de certificados.

El desarrollo se realiza en **Java**, aplicando rigurosamente los principios de la **Programación Orientada a Objetos (POO)**, una **Arquitectura de 3 Capas** e **Interfaces Gráficas**.

### 🔑 Roles y Módulos Principales

1.  **Administrador:** Gestión completa del sistema y usuarios.
2.  **Coordinador:** Gestión de líneas de certificación, análisis de métricas y supervisión de estudiantes de su área.
3.  **Estudiante:** Visualización de perfil, malla curricular interactiva, inscripción y seguimiento de progreso.

---

## 🎯 Requisitos Técnicos Obligatorios

| Requisito | Cumplimiento |
| :--- | :--- |
| **Arquitectura** | Implementación en **3 capas** (Dominio, Lógica, Presentación). |
| **POO** | Uso de Herencia, Polimorfismo e Interfaces. |
| **Interfaz Gráfica** | Interfaz completa desarrollada con **Java Swing**. |
| **Patrones de Diseño**| Implementación de 4 patrones: **Singleton, Factory, Strategy, Visitor.** |
| **Gestión de Datos** | Uso de colecciones (`ArrayList`). |
| **Persistencia** | Carga de datos mediante archivos `.txt`. |

---

## ⚙️ Estructura del Proyecto y Clases Principales

El proyecto sigue una arquitectura de 3 capas claramente separada en paquetes: **Dominio**, **Lógica** y **Presentacion**
- Estructura clara y ordenada
---

## 🎨 Patrones de Diseño Implementados

| Patrón | Propósito en AcademiCore | Capa / Clase |
| :--- | :--- | :--- |
| **Singleton** | Asegura una única instancia centralizada de la lógica de negocio y colecciones de datos del sistema. | `logica.AcademiCore` |
| **Factory** | Usado para crear instancias correctas de `Usuario` (Admin, Coordinador, Estudiante) al cargar los archivos. | `persistencia.DataFactory` (o `UsuarioFactory`) |
| **Strategy** | Permite intercambiar algoritmos de análisis para el Coordinador (ej. *Análisis de Asignaturas Críticas*, *Estadísticas de Inscripción*). | `util.IAnalisisStrategy` |
| **Visitor** | Permite aplicar operaciones complejas de seguimiento de progreso y requisitos de créditos sobre la estructura de `Certificacion` sin modificar las clases. | `util.ICertificacionVisitor` |

---

## 🚀 Instrucciones de Ejecución

1.  **Clonar el Repositorio:**
    ```bash
    git clone [Link repositorio]
    ```

2.  **Configuración del Entorno:**
    * Tener instalado **Java JDK 17 o superior**.
    * Importa el proyecto en Eclipse.

3.  **Ejecución:**
    * La ejecución comienza en la clase principal  `App.java`.

4.  **Credenciales de Prueba (Login):**
    | Rol | Usuario/Nombre | Contraseña/Rut | 
    | :--- | :--- | :--- |
    | **Administrador** | `admin` | `admin123` |
    | **Coordinador** | `coord.is` | `coord123` |
    | **Estudiante** | `Juan Carlos Pérez López`) | `12345678` |

---

## ✅ Notas Finales

* El código está documentado con JavaDoc.
* Cumple con la obligatoriedad de utilizar interfaces gráficas completas (Swing).
* Se ha implementado la gestión fluida de errores y la validación de datos.
