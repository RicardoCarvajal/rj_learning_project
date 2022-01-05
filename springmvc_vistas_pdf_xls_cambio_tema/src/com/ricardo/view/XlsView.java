package com.ricardo.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.ricardo.model.entity.Caja;

public class XlsView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response)
            throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"CajaList.xls\"");

        Sheet sheet = workbook.createSheet("CajaList");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("IP");
        header.createCell(2).setCellValue("TIPO_CAJA");

        int count_row = 1;

        for (Caja caja : (List<Caja>) model.get("cajaList")) {
            Row cajaRow = sheet.createRow(count_row++);

            cajaRow.createCell(0).setCellValue(caja.getId());
            cajaRow.createCell(1).setCellValue(caja.getIp());
            cajaRow.createCell(2).setCellValue(caja.getTipoCaja());
        }
    }

}