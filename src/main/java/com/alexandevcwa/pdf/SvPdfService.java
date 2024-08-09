package com.alexandevcwa.pdf;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@WebServlet(name = "svPdfService", value = "/sv-pdf-service")
public class SvPdfService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/reports/REP_001.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
            OutputStream outputStream = resp.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            resp.setContentType("application/pdf");
            resp.setHeader("Content-Disposition", "inline; filename="+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + ".pdf");
            outputStream.flush();
            outputStream.close();
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
