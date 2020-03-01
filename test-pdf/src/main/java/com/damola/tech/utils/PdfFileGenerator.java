package com.damola.tech.utils;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Omoede.Aihe on 3/21/2017.
 */

public class PdfFileGenerator implements IFileGenerator {

    private static final Logger logger = LoggerFactory.getLogger(PdfFileGenerator.class);

    private String filename;
    PdfWriter writer;
    PdfDocument pdf;
    Document document;
    Table activeTable = null;

    public PdfFileGenerator(String filename){
        this.filename = filename;
        if(!this.filename.contains(".pdf")){
            this.filename += ".pdf";
        }

    }

    public void open() {
        try {
            this.writer = new PdfWriter(this.filename);
            this.pdf = new PdfDocument(this.writer);
            this.document = new Document(this.pdf, PageSize.A4.rotate());
        }
        catch (Exception ex){
            logger.error("{}", ex);
        }
    }

    public void close() {
        try {
            if(null != this.activeTable){
                this.document.add(this.activeTable);
            }
            this.document.close();
        }
        catch (Exception ex){
            logger.error("{}", ex);
        }
    }
    
    public void createActiveHeaders(List<?> list, List<String> dataFieldNames) {
        try {
            this.activeTable = new Table(dataFieldNames.size());
            this.activeTable.setWidth(UnitValue.createPercentValue(100));
            PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
            this.document.add(new Paragraph("Report").setFont(font));
            List<String> tracker = new ArrayList<String>();
            for(Object object : list) {
            	Method [] superMethods = null;
            	Class<?> classObj = object.getClass();
            	Class<?> superClassObj = object.getClass().getSuperclass();
            	if(superClassObj != null){
                	superMethods = superClassObj.getDeclaredMethods();
                }   
        		Method [] methods = classObj.getDeclaredMethods();
        		if(superMethods != null){
        			List<Method> methodsList = new ArrayList<Method>();
        			methodsList.addAll(Arrays.asList(methods));
        			methodsList.addAll(Arrays.asList(superMethods));
        			methods = methodsList.toArray(methods);
        		}
        		for(Method method : methods){
        			if(method.getName().startsWith("get") && 
        					dataFieldNames.contains(method.getName().substring(3).toUpperCase())){
        				if(!tracker.contains(method.getName().substring(3))) {
            				this.activeTable.addHeaderCell(new Cell().add(new Paragraph(method.getName().substring(3))));
            				tracker.add(method.getName().substring(3));
        				}
        			}
        		}
            }
        }
        catch (Exception ex){
            logger.error("{}", ex);
        }
    }

    public void appendActiveRow(List<?> list, List<String> dataFieldNames) {
    	try {
    		for(Object object : list){
        		Method [] superMethods = null;
                Class<?> classObj = object.getClass();
                Class<?> superClassObj = object.getClass().getSuperclass();
                if(superClassObj != null){
                	superMethods = superClassObj.getDeclaredMethods();
                }
        		Method [] methods = classObj.getDeclaredMethods();
        		if(superMethods != null){
        			List<Method> methodsList = new ArrayList<Method>();
        			methodsList.addAll(Arrays.asList(methods));
        			methodsList.addAll(Arrays.asList(superMethods));
        			methods = methodsList.toArray(methods);
        		}
        		for(Method method : methods){
        			if(method.getName().startsWith("get") && 
        					dataFieldNames.contains(method.getName().substring(3).toUpperCase())){
        				Object val = method.invoke(object);
        				if(val!= null){
        					this.activeTable.addCell(new Cell().add(new Paragraph(val.toString())));
        				}else{
        					this.activeTable.addCell(new Cell().add(new Paragraph("N/A")));
        				}
        			}
        		}
        	}
    	}catch(Exception ex) {
    		logger.error("{}", ex);
    	}
    }
    

    public void appendBlank(int num){
        for(int x=0; x < num; x++) {
            this.document.add(new Paragraph("\n"));
        }
    }

    public void deleteFile(String fileName) {
    }

	public void resizeColumns(Class<?> classType, List<String> dataFieldNames) throws Exception {

	}
}
