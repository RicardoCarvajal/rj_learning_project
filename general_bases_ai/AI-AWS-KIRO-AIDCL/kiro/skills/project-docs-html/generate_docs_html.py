#!/usr/bin/env python3
"""Genera documentación HTML del proyecto con Swagger UI embebido."""
import json
import os
import sys

import markdown

PROJECT_ROOT = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "..", ".."))
AIDLC_DOCS = os.path.join(PROJECT_ROOT, "aidlc-docs")


def read_md(relative_path):
    """Lee un archivo markdown relativo a aidlc-docs."""
    path = os.path.join(AIDLC_DOCS, relative_path)
    if not os.path.exists(path):
        return ""
    with open(path, "r", encoding="utf-8") as f:
        return f.read()


def md_to_html(md_text):
    """Convierte markdown a HTML."""
    return markdown.markdown(md_text, extensions=["tables", "fenced_code"])


def build_openapi_spec():
    """Construye la especificación OpenAPI 3.0 para las APIs del backend."""
    return {
        "openapi": "3.0.3",
        "info": {
            "title": "Gestión de Unidades Logísticas - API",
            "version": "1.0.0",
            "description": "API REST para la gestión de unidades logísticas (UL) del sistema Zagreus/EPA."
        },
        "servers": [{"url": "/api/v1", "description": "API Gateway"}],
        "paths": {
            "/ul": {
                "post": {
                    "tags": ["UL Core"],
                    "summary": "Crear UL",
                    "operationId": "createUL",
                    "requestBody": {"required": True, "content": {"application/json": {"schema": {"type": "object", "required": ["store_id", "process_type", "ul_type_id"], "properties": {"store_id": {"type": "integer"}, "process_type": {"type": "string", "enum": ["RECEPTION", "PICKING", "TRANSFER"]}, "ul_type_id": {"type": "integer"}}}}}},
                    "responses": {"201": {"description": "UL creada", "content": {"application/json": {"schema": {"type": "object", "properties": {"ul_id": {"type": "string"}, "status": {"type": "string"}, "location": {"type": "string"}, "pdf_url": {"type": "string"}}}}}}, "401": {"description": "No autorizado"}}
                },
                "get": {
                    "tags": ["UL Core"],
                    "summary": "Listar UL",
                    "operationId": "listUL",
                    "parameters": [
                        {"name": "store_id", "in": "query", "schema": {"type": "integer"}},
                        {"name": "status", "in": "query", "schema": {"type": "string"}},
                        {"name": "location", "in": "query", "schema": {"type": "string"}},
                        {"name": "date_from", "in": "query", "schema": {"type": "string", "format": "date"}},
                        {"name": "date_to", "in": "query", "schema": {"type": "string", "format": "date"}}
                    ],
                    "responses": {"200": {"description": "Lista de UL"}}
                }
            },
            "/ul/{id}": {
                "get": {
                    "tags": ["UL Core"],
                    "summary": "Consultar UL",
                    "operationId": "getUL",
                    "parameters": [{"name": "id", "in": "path", "required": True, "schema": {"type": "string"}}],
                    "responses": {"200": {"description": "Detalle de la UL"}, "404": {"description": "UL no encontrada"}}
                }
            },
            "/ul/{id}/close": {
                "patch": {
                    "tags": ["UL Core"],
                    "summary": "Cerrar UL",
                    "operationId": "closeUL",
                    "parameters": [{"name": "id", "in": "path", "required": True, "schema": {"type": "string"}}],
                    "responses": {"200": {"description": "UL cerrada"}, "409": {"description": "UL no está abierta"}}
                }
            },
            "/ul/{id}/articles": {
                "post": {
                    "tags": ["UL Core"],
                    "summary": "Asociar artículo a UL",
                    "operationId": "addArticle",
                    "parameters": [{"name": "id", "in": "path", "required": True, "schema": {"type": "string"}}],
                    "requestBody": {"required": True, "content": {"application/json": {"schema": {"type": "object", "required": ["article_id", "quantity", "doc_type", "doc_number"], "properties": {"article_id": {"type": "integer"}, "quantity": {"type": "number"}, "doc_type": {"type": "string", "enum": ["OC", "ND", "NT", "NV"]}, "doc_number": {"type": "string"}}}}}},
                    "responses": {"201": {"description": "Artículo asociado"}, "409": {"description": "UL no está abierta"}}
                }
            },
            "/ul/{id}/divide": {
                "post": {
                    "tags": ["División"],
                    "summary": "Dividir UL",
                    "operationId": "divideUL",
                    "parameters": [{"name": "id", "in": "path", "required": True, "schema": {"type": "string"}}],
                    "requestBody": {"required": True, "content": {"application/json": {"schema": {"type": "object", "required": ["articles"], "properties": {"articles": {"type": "array", "items": {"type": "object", "properties": {"article_id": {"type": "integer"}, "quantity": {"type": "number"}}}}}}}}},
                    "responses": {"200": {"description": "División exitosa"}, "409": {"description": "UL no está cerrada"}, "422": {"description": "Cantidad excede disponible"}}
                }
            },
            "/ul/unify": {
                "post": {
                    "tags": ["Unificación"],
                    "summary": "Unificar UL",
                    "operationId": "unifyUL",
                    "requestBody": {"required": True, "content": {"application/json": {"schema": {"type": "object", "required": ["destination_ul_id", "source_ul_ids"], "properties": {"destination_ul_id": {"type": "string"}, "source_ul_ids": {"type": "array", "items": {"type": "string"}}}}}}},
                    "responses": {"200": {"description": "Unificación exitosa"}, "409": {"description": "Alguna UL no está cerrada"}}
                }
            },
            "/ul/{id}/label": {
                "post": {
                    "tags": ["Impresión"],
                    "summary": "Generar etiqueta",
                    "operationId": "generateLabel",
                    "parameters": [{"name": "id", "in": "path", "required": True, "schema": {"type": "string"}}],
                    "responses": {"200": {"description": "PDF generado", "content": {"application/json": {"schema": {"type": "object", "properties": {"pdf_url": {"type": "string"}}}}}}}
                }
            },
            "/ul/reprint": {
                "post": {
                    "tags": ["Impresión"],
                    "summary": "Reimprimir etiquetas",
                    "operationId": "reprintLabels",
                    "requestBody": {"required": True, "content": {"application/json": {"schema": {"type": "object", "required": ["ul_ids"], "properties": {"ul_ids": {"type": "array", "items": {"type": "string"}}}}}}},
                    "responses": {"200": {"description": "Etiquetas generadas"}, "410": {"description": "UL eliminada"}}
                }
            },
            "/ul-types": {
                "post": {
                    "tags": ["Tipos UL"],
                    "summary": "Crear tipo UL",
                    "operationId": "createULType",
                    "requestBody": {"required": True, "content": {"application/json": {"schema": {"type": "object", "required": ["store_id", "name", "height_cm", "length_cm", "width_cm", "weight_limit_kg", "position"], "properties": {"store_id": {"type": "integer"}, "name": {"type": "string"}, "height_cm": {"type": "number"}, "length_cm": {"type": "number"}, "width_cm": {"type": "number"}, "weight_limit_kg": {"type": "number"}, "position": {"type": "string", "enum": ["LEFT", "RIGHT", "TOTAL"]}}}}}},
                    "responses": {"201": {"description": "Tipo creado"}, "409": {"description": "Nombre duplicado en centro"}}
                },
                "get": {
                    "tags": ["Tipos UL"],
                    "summary": "Listar tipos UL",
                    "operationId": "listULTypes",
                    "parameters": [{"name": "store_id", "in": "query", "schema": {"type": "integer"}}],
                    "responses": {"200": {"description": "Lista de tipos"}}
                }
            },
            "/ul-types/{id}": {
                "put": {
                    "tags": ["Tipos UL"],
                    "summary": "Actualizar tipo UL",
                    "operationId": "updateULType",
                    "parameters": [{"name": "id", "in": "path", "required": True, "schema": {"type": "integer"}}],
                    "requestBody": {"required": True, "content": {"application/json": {"schema": {"type": "object", "properties": {"name": {"type": "string"}, "height_cm": {"type": "number"}, "length_cm": {"type": "number"}, "width_cm": {"type": "number"}, "weight_limit_kg": {"type": "number"}, "status": {"type": "string", "enum": ["ACTIVE", "INACTIVE"]}, "position": {"type": "string", "enum": ["LEFT", "RIGHT", "TOTAL"]}}}}}},
                    "responses": {"200": {"description": "Tipo actualizado"}}
                }
            },
            "/reports/ul-status": {
                "get": {
                    "tags": ["Reportes"],
                    "summary": "Reporte estado UL",
                    "operationId": "getReport",
                    "parameters": [
                        {"name": "date_from", "in": "query", "required": True, "schema": {"type": "string", "format": "date"}},
                        {"name": "date_to", "in": "query", "required": True, "schema": {"type": "string", "format": "date"}},
                        {"name": "store_id", "in": "query", "schema": {"type": "integer"}},
                        {"name": "location", "in": "query", "schema": {"type": "string"}},
                        {"name": "ul_id", "in": "query", "schema": {"type": "string"}},
                        {"name": "article_id", "in": "query", "schema": {"type": "integer"}}
                    ],
                    "responses": {"200": {"description": "Reporte generado"}}
                }
            },
            "/audit/ul": {
                "get": {
                    "tags": ["Auditoría"],
                    "summary": "Consultar auditoría",
                    "operationId": "getAuditLog",
                    "parameters": [
                        {"name": "ul_id", "in": "query", "schema": {"type": "string"}},
                        {"name": "date_from", "in": "query", "schema": {"type": "string", "format": "date"}},
                        {"name": "date_to", "in": "query", "schema": {"type": "string", "format": "date"}}
                    ],
                    "responses": {"200": {"description": "Log de auditoría"}}
                }
            }
        },
        "components": {
            "securitySchemes": {
                "CognitoAuth": {"type": "http", "scheme": "bearer", "bearerFormat": "JWT"}
            }
        },
        "security": [{"CognitoAuth": []}]
    }


def build_html(output_path):
    """Genera el HTML completo."""
    # Read documentation sections
    sections = [
        ("Requerimientos", "inception/requirements/requirements.md"),
        ("Diseño de Aplicación", "inception/application-design/application-design.md"),
        ("Componentes", "inception/application-design/components.md"),
        ("Métodos por Componente", "inception/application-design/component-methods.md"),
        ("Servicios y Orquestación", "inception/application-design/services.md"),
        ("Dependencias entre Componentes", "inception/application-design/component-dependency.md"),
        ("Modelo de Datos", "construction/unit-0-shared/functional-design/domain-entities.md"),
        ("Diseño de Infraestructura", "construction/unit-0-shared/infrastructure-design/infrastructure-design.md"),
        ("Plan de Despliegue", "operations/deployment-plan.md"),
        ("Monitoreo y Observabilidad", "operations/monitoring-observability.md"),
    ]

    nav_items = ""
    content_sections = ""
    for title, path in sections:
        section_id = title.lower().replace(" ", "-").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u")
        md_content = read_md(path)
        if not md_content:
            continue
        html_content = md_to_html(md_content)
        nav_items += f'<li><a href="#{section_id}">{title}</a></li>\n'
        content_sections += f'<section id="{section_id}"><h2>{title}</h2>{html_content}</section>\n'

    nav_items += '<li><a href="#swagger-ui">API Reference (Swagger)</a></li>\n'

    openapi_spec = json.dumps(build_openapi_spec())

    html = f"""<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Documentación — Gestión de Unidades Logísticas</title>
<link rel="stylesheet" href="https://unpkg.com/swagger-ui-dist@5.11.0/swagger-ui.css">
<style>
* {{ margin: 0; padding: 0; box-sizing: border-box; }}
body {{ font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; display: flex; min-height: 100vh; }}
nav {{ width: 260px; background: #1a1a2e; color: #eee; padding: 1rem; position: fixed; height: 100vh; overflow-y: auto; }}
nav h1 {{ font-size: 1rem; margin-bottom: 1rem; color: #fff; }}
nav ul {{ list-style: none; }}
nav li a {{ color: #ccc; text-decoration: none; display: block; padding: 0.4rem 0.6rem; border-radius: 4px; font-size: 0.85rem; }}
nav li a:hover {{ background: #16213e; color: #fff; }}
main {{ margin-left: 260px; padding: 2rem; flex: 1; max-width: 1100px; }}
section {{ margin-bottom: 3rem; }}
h2 {{ color: #1a1a2e; border-bottom: 2px solid #e0e0e0; padding-bottom: 0.5rem; margin-bottom: 1rem; }}
table {{ border-collapse: collapse; width: 100%; margin: 1rem 0; font-size: 0.85rem; }}
th, td {{ border: 1px solid #ddd; padding: 0.5rem; text-align: left; }}
th {{ background: #2F5496; color: white; }}
tr:nth-child(even) {{ background: #f9f9f9; }}
pre {{ background: #f4f4f4; padding: 1rem; overflow-x: auto; border-radius: 4px; font-size: 0.8rem; }}
code {{ background: #f0f0f0; padding: 0.15rem 0.3rem; border-radius: 3px; font-size: 0.85em; }}
pre code {{ background: none; padding: 0; }}
#swagger-ui {{ margin-top: 2rem; }}
</style>
</head>
<body>
<nav>
<h1>📦 Gestión UL</h1>
<ul>
{nav_items}
</ul>
</nav>
<main>
<h1>Documentación del Proyecto — Gestión de Unidades Logísticas</h1>
<p>Sistema de gestión de unidades logísticas (contenedores/pallets) para la cadena EPA (sistema Zagreus).</p>
{content_sections}
<section id="swagger-ui">
<h2>API Reference (Swagger)</h2>
<div id="swagger-container"></div>
</section>
</main>
<script src="https://unpkg.com/swagger-ui-dist@5.11.0/swagger-ui-bundle.js"></script>
<script>
SwaggerUIBundle({{
    spec: {openapi_spec},
    dom_id: '#swagger-container',
    presets: [SwaggerUIBundle.presets.apis, SwaggerUIBundle.SwaggerUIStandalonePreset],
    layout: "BaseLayout"
}});
</script>
</body>
</html>"""

    with open(output_path, "w", encoding="utf-8") as f:
        f.write(html)
    print(f"HTML generado: {output_path}")


def main():
    if len(sys.argv) < 2:
        output = os.path.join(PROJECT_ROOT, "project-docs.html")
    else:
        output = sys.argv[1]
    build_html(output)


if __name__ == "__main__":
    main()
