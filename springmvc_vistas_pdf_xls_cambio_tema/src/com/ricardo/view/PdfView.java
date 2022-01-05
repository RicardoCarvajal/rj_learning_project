package com.ricardo.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ricardo.model.entity.Caja;

public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Caja> cajaList = (List<Caja>) model.get("cajaList");

        PdfPTable table = new PdfPTable(3);

        table.addCell("ID");
        table.addCell("IP");
        table.addCell("TIPO_CAJA");

        for (Caja caja : (List<Caja>) model.get("cajaList")) {
            table.addCell(caja.getId().toString());
            table.addCell(caja.getIp());
            table.addCell(String.valueOf(caja.getTipoCaja()));
        }

        document.add(table);
    }

}
