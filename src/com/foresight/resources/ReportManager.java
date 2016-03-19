/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.resources;

/**
 *
 * @author hakeemtunde
 */
import java.io.InputStream;

public class ReportManager {
    
    private final static ReportManager singleton;

    static {
        singleton = new ReportManager();
    }

    public InputStream getJasperFile(String reportFile) {
        return getClass().getResourceAsStream(reportFile + ".jasper");
    }

    public InputStream getJrxmlFile(String reportFile) {
        return getClass().getResourceAsStream(reportFile + ".jrxml");
    }

    public static ReportManager get() {
        return singleton;
    }
    
}
