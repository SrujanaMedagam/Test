package com.valuelabs.lms.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.valuelabs.lms.model.EmployeeLeaves;

@SuppressWarnings("deprecation")
public class ExcelBuilder extends AbstractExcelView {
 
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	response.setContentType("application/vnd.ms-excel");
    	response.setHeader("Content-Disposition", "attachment; filename=GeneratedReport.xls");
    	System.out.println("Reached");
        // get data model which is passed by the Spring container
        @SuppressWarnings("unchecked")
		List<EmployeeLeaves> managerGenerateReport = (List<EmployeeLeaves>) model.get("generateReport");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Leave Reports");
        sheet.setDefaultColumnWidth(30);
         
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLACK.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("Employee ID");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("From Date");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("To Date");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("No Of Days");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("Reason");
        header.getCell(4).setCellStyle(style);
        
        header.createCell(5).setCellValue("Leave Status");
        header.getCell(5).setCellStyle(style);
         
        // create data rows
        int rowCount = 1;
         
        for (EmployeeLeaves reportDetails : managerGenerateReport) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            System.out.println("1");
            System.out.println(reportDetails.getEid());
            aRow.createCell(0).setCellValue(reportDetails.getEid());
            aRow.createCell(1).setCellValue(reportDetails.getFromDate());
            aRow.createCell(2).setCellValue(reportDetails.getToDate());
            aRow.createCell(3).setCellValue(reportDetails.getNoOfDays());
            aRow.createCell(4).setCellValue(reportDetails.getReason());
            if(reportDetails.getLeaveStatus()==1)
            {
            	aRow.createCell(5).setCellValue("Approved");
            }
            else  if(reportDetails.getLeaveStatus()==3)
            {
            	aRow.createCell(5).setCellValue("Rejected");
            }
        }
        workbook.write(response.getOutputStream()); // Write workbook to response.
       
    }
 
}