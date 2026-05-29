#!/usr/bin/env python3
"""Genera un PDF de Matriz de Identificación de Requerimientos desde un JSON."""
import json
import os
import sys
from reportlab.lib import colors
from reportlab.lib.pagesizes import letter, landscape
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.units import cm
from reportlab.platypus import (
    SimpleDocTemplate, Table, TableStyle, Paragraph, Spacer, Image
)

PAGE_W = landscape(letter)[0]
MARGIN = 1.2 * cm
USABLE_W = PAGE_W - 2 * MARGIN  # ~25.56 cm


def load_input(path):
    with open(path, "r", encoding="utf-8") as f:
        return json.load(f)


def compute_summary(requirements):
    codes_initial = set()
    codes_change = set()
    for r in requirements:
        fuente = r.get("fuente", "")
        code = r.get("codigo", "")
        if fuente == "Alcance Inicial":
            codes_initial.add(code)
        elif "Gestión de Cambio" in fuente:
            codes_change.add(code)
    suspended = {r["codigo"] for r in requirements if r.get("estado") == "Suspendido"}
    alcance = len(codes_initial - suspended)
    cambio = len(codes_change - suspended)
    return alcance, cambio, alcance + cambio


def build_pdf(data, output_path):
    doc = SimpleDocTemplate(
        output_path, pagesize=landscape(letter),
        leftMargin=MARGIN, rightMargin=MARGIN,
        topMargin=MARGIN, bottomMargin=MARGIN
    )
    styles = getSampleStyleSheet()
    cell_style = ParagraphStyle("Cell", parent=styles["Normal"], fontSize=7, leading=9)
    header_style = ParagraphStyle("Header", parent=styles["Normal"], fontSize=7, leading=9, textColor=colors.white)
    elements = []

    h = data["header"]
    reqs = data["requirements"]

    # --- Logo + Title ---
    logo_path = os.path.join(os.path.dirname(os.path.abspath(__file__)), "logointelix-sin-fondo.png")
    title_style = ParagraphStyle("TitleC", parent=styles["Title"], fontSize=16, alignment=1, spaceAfter=0)
    title_para = Paragraph("<b>Matriz de Identificación de Requerimientos</b>", title_style)
    if os.path.exists(logo_path):
        logo = Image(logo_path, width=3.2 * cm, height=1.1 * cm)
        tt = Table([[logo, title_para]], colWidths=[4 * cm, USABLE_W - 4 * cm])
        tt.setStyle(TableStyle([("VALIGN", (0, 0), (-1, -1), "MIDDLE")]))
        elements.append(tt)
    else:
        elements.append(title_para)
    elements.append(Spacer(1, 0.4 * cm))

    # --- Header: 10 columns, 2 rows ---
    estado_proyecto = h.get("estado_proyecto", "")
    categoria = h.get("categoria", "")
    fecha = h.get("fecha_actualizacion", "")
    proyecto = h.get("proyecto", "")
    gc_count = str(h.get("cantidad_gestion_cambio", 0))

    row1 = [
        "Ramo Cliente", h.get("ramo_cliente", ""),
        "Líder de Proyecto", h.get("lider_proyecto", ""),
        "Código", h.get("codigo", ""),
        "Estado", estado_proyecto,
        "Categoría", categoria,
    ]
    row2 = [
        "Cantidad Gestión de Cambio", "", gc_count,
        "Cantidad de Requerimientos", "", "",
        "Proyecto", proyecto,
        "Fecha de Actualización", fecha,
    ]
    # 10 cols that sum to USABLE_W
    cw_header = [
        USABLE_W * 0.12,  # Ramo Cliente label
        USABLE_W * 0.07,  # value
        USABLE_W * 0.11,  # Líder label
        USABLE_W * 0.15,  # value
        USABLE_W * 0.06,  # Código label
        USABLE_W * 0.08,  # value
        USABLE_W * 0.06,  # Estado/Proyecto label
        USABLE_W * 0.12,  # value
        USABLE_W * 0.13,  # Categoría/Fecha label
        USABLE_W * 0.10,  # value
    ]
    ht = Table([row1, row2], colWidths=cw_header)
    ht.setStyle(TableStyle([
        ("SPAN", (0, 1), (1, 1)),  # "Cantidad Gestión de Cambio" spans cols 0-1
        ("SPAN", (3, 1), (4, 1)),  # "Cantidad de Requerimientos" spans cols 3-4
        ("FONTSIZE", (0, 0), (-1, -1), 7),
        ("FONTNAME", (0, 0), (0, -1), "Helvetica-Bold"),
        ("FONTNAME", (2, 0), (2, -1), "Helvetica-Bold"),
        ("FONTNAME", (3, 1), (3, 1), "Helvetica-Bold"),
        ("FONTNAME", (4, 0), (4, 0), "Helvetica-Bold"),
        ("FONTNAME", (6, 0), (6, -1), "Helvetica-Bold"),
        ("FONTNAME", (8, 0), (8, -1), "Helvetica-Bold"),
        ("GRID", (0, 0), (-1, -1), 0.5, colors.grey),
        ("LEFTPADDING", (0, 0), (-1, -1), 4),
        ("RIGHTPADDING", (0, 0), (-1, -1), 4),
        ("TOPPADDING", (0, 0), (-1, -1), 5),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 5),
    ]))
    elements.append(ht)
    elements.append(Spacer(1, 0.35 * cm))

    # --- Summary row (7 cols, centered) ---
    alcance, cambio, total = compute_summary(reqs)
    sum_data = [[
        "Cantidad de Requerimientos", "Alcance Inicial", str(alcance),
        "Por Gestiones de Cambio", str(cambio), "Total", str(total)
    ]]
    sw = [USABLE_W*0.18, USABLE_W*0.12, USABLE_W*0.05,
          USABLE_W*0.18, USABLE_W*0.05, USABLE_W*0.06, USABLE_W*0.05]
    st = Table(sum_data, colWidths=sw, hAlign="CENTER")
    st.setStyle(TableStyle([
        ("FONTSIZE", (0, 0), (-1, -1), 7),
        ("FONTNAME", (0, 0), (0, 0), "Helvetica-Bold"),
        ("FONTNAME", (1, 0), (1, 0), "Helvetica-Bold"),
        ("FONTNAME", (3, 0), (3, 0), "Helvetica-Bold"),
        ("FONTNAME", (5, 0), (5, 0), "Helvetica-Bold"),
        ("GRID", (0, 0), (-1, -1), 0.5, colors.grey),
        ("ALIGN", (2, 0), (2, 0), "CENTER"),
        ("ALIGN", (4, 0), (4, 0), "CENTER"),
        ("ALIGN", (6, 0), (6, 0), "CENTER"),
        ("LEFTPADDING", (0, 0), (-1, -1), 4),
        ("RIGHTPADDING", (0, 0), (-1, -1), 4),
        ("TOPPADDING", (0, 0), (-1, -1), 5),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 5),
    ]))
    elements.append(st)
    elements.append(Spacer(1, 0.5 * cm))

    # --- Requirements table (6 cols, full width) ---
    col_widths = [
        USABLE_W * 0.15,  # Entregable
        USABLE_W * 0.05,  # Código
        USABLE_W * 0.25,  # Requerimiento
        USABLE_W * 0.30,  # Criterios
        USABLE_W * 0.13,  # Fuente
        USABLE_W * 0.12,  # Estado
    ]
    table_header = [
        Paragraph("<b>Entregable</b>", header_style),
        Paragraph("<b>Código</b>", header_style),
        Paragraph("<b>Requerimiento</b>", header_style),
        Paragraph("<b>Criterio(s) de Aceptación</b>", header_style),
        Paragraph("<b>Fuente</b>", header_style),
        Paragraph("<b>Estado</b>", header_style),
    ]
    table_data = [table_header]

    prev_entregable = None
    for r in reqs:
        entregable = r.get("entregable", "")
        display_entregable = entregable if entregable != prev_entregable else ""
        prev_entregable = entregable
        row = [
            Paragraph(display_entregable, cell_style),
            Paragraph(r.get("codigo", ""), cell_style),
            Paragraph(r.get("requerimiento", ""), cell_style),
            Paragraph(r.get("criterios_aceptacion", "").replace("\n", "<br/>"), cell_style),
            Paragraph(r.get("fuente", ""), cell_style),
            Paragraph(r.get("estado", ""), cell_style),
        ]
        table_data.append(row)

    t = Table(table_data, colWidths=col_widths, repeatRows=1)
    t.setStyle(TableStyle([
        ("BACKGROUND", (0, 0), (-1, 0), colors.HexColor("#2F5496")),
        ("TEXTCOLOR", (0, 0), (-1, 0), colors.white),
        ("FONTSIZE", (0, 0), (-1, -1), 7),
        ("GRID", (0, 0), (-1, -1), 0.5, colors.grey),
        ("VALIGN", (0, 0), (-1, -1), "TOP"),
        ("LEFTPADDING", (0, 0), (-1, -1), 4),
        ("RIGHTPADDING", (0, 0), (-1, -1), 4),
        ("TOPPADDING", (0, 0), (-1, -1), 4),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 4),
        ("ROWBACKGROUNDS", (0, 1), (-1, -1), [colors.white, colors.HexColor("#F2F2F2")]),
    ]))
    elements.append(t)

    doc.build(elements)
    print(f"PDF generado: {output_path}")


def main():
    if len(sys.argv) < 3:
        print("Uso: python generate_requirements_pdf.py <input.json> <output.pdf>")
        sys.exit(1)
    data = load_input(sys.argv[1])
    build_pdf(data, sys.argv[2])


if __name__ == "__main__":
    main()
