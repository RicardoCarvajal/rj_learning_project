---
name: requirements-matrix-pdf
description: Genera un PDF con la Matriz de Identificación de Requerimientos. Usar cuando el usuario pida generar, crear o exportar una matriz de requerimientos en PDF.
---

# Skill: Generador de Matriz de Requerimientos en PDF

Genera un documento PDF con formato profesional de la Matriz de Identificación de Requerimientos, siguiendo el estándar del template corporativo.

## Uso

1. Crear un archivo JSON con los datos de la matriz (ver `example_input.json`)
2. Ejecutar el script:

```bash
cd .kiro/skills/requirements-matrix
pip install -r requirements.txt
python generate_requirements_pdf.py <input.json> <output.pdf>
```

## Formato del JSON de entrada

```json
{
  "header": {
    "ramo_cliente": "Nombre del ramo",
    "lider_proyecto": "Nombre del líder",
    "codigo": "XX-YYY-NN",
    "proyecto": "Nombre del proyecto",
    "fecha_actualizacion": "2025-01-15"
  },
  "requirements": [
    {
      "entregable": "Nombre del entregable",
      "codigo": "R1",
      "requerimiento": "Descripción del requerimiento",
      "criterios_aceptacion": "Criterios separados por \\n",
      "fuente": "Alcance Inicial",
      "estado": "Sin Iniciar"
    }
  ]
}
```

## Campos

### Header
| Campo | Descripción |
|-------|-------------|
| ramo_cliente | Ramo del cliente (ej: EPA, Financiero) |
| lider_proyecto | Nombre del líder de proyecto |
| codigo | Código del proyecto (formato RRAANNN) |
| proyecto | Nombre del proyecto |
| fecha_actualizacion | Fecha de última actualización (YYYY-MM-DD) |

### Requirements (array)
| Campo | Descripción |
|-------|-------------|
| entregable | Nombre del entregable (se agrupa visualmente) |
| codigo | Código del requerimiento (R1, R2, ...) |
| requerimiento | Descripción del requerimiento |
| criterios_aceptacion | Criterios de aceptación (opcional) |
| fuente | "Alcance Inicial" o "Gestión de Cambio N" |
| estado | Sin Iniciar, En Progreso, Finalizado, Suspendido |

## Estructura del PDF generado

- Título: "Matriz de Identificación de Requerimientos"
- Encabezado con datos del proyecto
- Resumen de cantidades (alcance inicial, gestiones de cambio, total)
- Tabla con todos los requerimientos agrupados por entregable
