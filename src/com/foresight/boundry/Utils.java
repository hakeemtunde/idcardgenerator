/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package com.foresight.boundry;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/* Utils.java is used by FileChooserDemo2.java. */
public class Utils {
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    public final static String png = "png";
    
    public final static String logoPath = "logo";
    public final static String backgroundPath = "background";
    public final static String staffPath = "staff_image";
    public final static String staffSign = "staff_sign";
    public final static String barcodePath = "barcode";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Utils.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    
    public static ImageIcon getmageIcon(String filename) {
        
        Path path = Paths.get(filename);
        File file = path.toFile();
        
        //for file with extension
        if (getExtension(file) != null) {
            return resizeImage(new ImageIcon(filename));
        }
        
        ImageIcon tmpIcon=null;
        //if file extension is null
        path = Paths.get(filename+"."+png);
        file = path.toFile();
        if (file.exists()) {
         return resizeImage(new ImageIcon(path.toString()));
        } 

        path = Paths.get(filename+"."+jpeg);
        file = path.toFile();
        if (file.exists()) {
             return resizeImage(new ImageIcon(path.toString()));
        } 

        path = Paths.get(filename+"."+jpg);
        file = path.toFile();
        if (file.exists()) {
             return resizeImage(new ImageIcon(path.toString()));
        } 

        path = Paths.get(filename+"."+gif);
        file = path.toFile();
        if (file.exists()) {
             return resizeImage(new ImageIcon(path.toString()));
        } 
        
        return tmpIcon;
    }
    
    private static ImageIcon resizeImage(ImageIcon tmpIcon) {
        if (tmpIcon != null) {
            if (tmpIcon.getIconWidth() > 90) {
                tmpIcon = new ImageIcon(tmpIcon.getImage().
                                          getScaledInstance(100, -1,
                                                      Image.SCALE_DEFAULT));
            } 
        }
        
        return tmpIcon;
    }
    
   public static void removeExistingImage(String filename) {
        Path path = Paths.get(filename+"."+png);
        File file = path.toFile();
        
        if (file.exists()) {
            file.delete();
            System.out.println("Deleting file");
        }
        
        path = Paths.get(filename+"."+jpeg);
        file = path.toFile();
        if (file.exists()) {
            file.delete();
            System.out.println("Deleting file");
        }
        
        path = Paths.get(filename+"."+jpg);
        file = path.toFile();
        if (file.exists()) {
            file.delete();
            System.out.println("Deleting file");
        }
        
        path = Paths.get(filename+"."+gif);
        file = path.toFile();
        if (file.exists()) {
            file.delete();
            System.out.println("Deleting file");
        }
   }
    
    public static String getImageLocation(String foldername, String filename) {
        //"./.images/logo/"
        return "./.images/"+foldername+"/"+filename;
    }
    
    public static void moveImageFile(String sourcePath, String foldername, String fileName) {
        
        // source
        Path source = Paths.get(sourcePath);        
        //target 
        Path target = Paths.get(Utils.getImageLocation(foldername, fileName+ "." 
                + Utils.getExtension(new File(sourcePath))));
        
        try {
               Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println("Error Moving------------------ "+ e.getMessage());
        }
        

    }
    
    public static File getStoreFile(String filename) {
        
        Path path = Paths.get(filename+"."+png);
        File file = path.toFile();
        if (file.exists()) {
         return file;
        } 

        path = Paths.get(filename+"."+jpeg);
        file = path.toFile();
        if (file.exists()) {
             return file;
        } 

        path = Paths.get(filename+"."+jpg);
        file = path.toFile();
        if (file.exists()) {
              return file;
        } 

        path = Paths.get(filename+"."+gif);
        file = path.toFile();
        if (file.exists()) {
              return file;
        } 
        
        return null;
    
    }
    
    public static BufferedImage getImage(String foldername, String filename) {
        
        BufferedImage image = null;
        
        String path = getImageLocation(foldername, filename);
        File file = getStoreFile(path);       
        
        if (file != null) {
            System.out.println("File Path: "+ file.getAbsolutePath());
            try {
                image = ImageIO.read(file);
            } catch (IOException ioe) {
                System.err.println("Error reading image: "+ ioe.getMessage());
            }
        }
        
        
        return image;
    }
    
    public static void openPdf() {
        try {
            File filename = new File("IdCard");
            if (filename.exists()) {
                if (java.awt.Desktop.isDesktopSupported()) {
                    java.awt.Desktop.getDesktop().open(filename);
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Error opening IDCard: "+ e.getMessage());
           
        }
    }
}
