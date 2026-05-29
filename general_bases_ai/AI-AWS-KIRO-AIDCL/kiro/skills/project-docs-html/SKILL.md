---
name: project-docs-html
description: Genera documentación HTML del proyecto con Swagger UI embebido para las APIs del backend. Usar cuando el usuario pida generar, crear o exportar documentación del proyecto en HTML.
---

# Skill: Generador de Documentación HTML del Proyecto

Genera un archivo HTML autocontenido con la documentación completa del proyecto, incluyendo requerimientos, diseño de aplicación, arquitectura, modelo de datos y un Swagger UI embebido con la especificación OpenAPI de las APIs del backend.

## Uso

```bash
cd .kiro/skills/project-docs-html
pip install -r requirements.txt
python generate_docs_html.py <output.html>
```

El script lee automáticamente los archivos markdown de `aidlc-docs/` y genera un HTML con:

- Resumen ejecutivo del proyecto
- Requerimientos funcionales y no funcionales
- Diseño de aplicación y arquitectura
- Modelo de datos (entidades de dominio)
- Swagger UI interactivo con todos los endpoints del backend

## Output

Un archivo HTML autocontenido que puede abrirse en cualquier navegador. Swagger UI se carga desde CDN.
