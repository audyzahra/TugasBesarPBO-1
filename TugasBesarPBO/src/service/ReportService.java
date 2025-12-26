package service;

import config.DatabaseConnection;
import exception.CustomException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ReportService {

    public void generateMobilReport() throws CustomException {
        try {
            Connection conn = DatabaseConnection.getConnection();

            // Load report template (AMAN)
            var reportStream = getClass().getResourceAsStream("/reports/mobil_report.jrxml");
            if (reportStream == null) {
                throw new CustomException("File mobil_report.jrxml tidak ditemukan");
            }

            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            // Parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("REPORT_TITLE", "Laporan Data Mobil");

            // Fill report
            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(jasperReport, parameters, conn);

            // View report
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Laporan Data Mobil");
            viewer.setVisible(true);

        } catch (Exception e) {
            throw new CustomException("Error generate report mobil: " + e.getMessage(), e);
        }
    }

    public void generatePenjualanReport() throws CustomException {
        try {
            Connection conn = DatabaseConnection.getConnection();

            // Load report template (AMAN)
            var reportStream = getClass().getResourceAsStream("/reports/penjualan_report.jrxml");
            if (reportStream == null) {
                throw new CustomException("File penjualan_report.jrxml tidak ditemukan");
            }

            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            // Parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("REPORT_TITLE", "Laporan Penjualan Mobil");

            // Fill report
            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(jasperReport, parameters, conn);

            // View report
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Laporan Penjualan");
            viewer.setVisible(true);

        } catch (Exception e) {
            throw new CustomException("Error generate report penjualan: " + e.getMessage(), e);
        }
    }
}
