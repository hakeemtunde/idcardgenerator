/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.main;

import com.foresight.boundry.ImageFileView;
import com.foresight.boundry.ImageFilter;
import com.foresight.boundry.ImagePreview;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author hakeemtunde
 */
public class OpenFileAction  {
    private final JFrame frame;
    private final JTextField jTextField;
    private File selFile;

    OpenFileAction(JFrame frame, JTextField jtf) {
        this.frame = frame;        
        jTextField = jtf;
    }
    
    public void openFileDlg() {
        JFileChooser chooser = new JFileChooser();
        
        chooser.addChoosableFileFilter(new ImageFilter());
        chooser.setAcceptAllFileFilterUsed(false);
        
        chooser.setFileView(new ImageFileView());
        
        chooser.setAccessory(new ImagePreview(chooser));
        
        int returnVal = chooser.showDialog(frame, "Select Image");
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            selFile = chooser.getSelectedFile();
        }
        
        if (selFile != null && jTextField != null) {
            jTextField.setText(selFile.getAbsolutePath());
        }
        
        //reset the file chooser
        chooser.setSelectedFile(null);
    }
    
    public File getSelectedFile() {
        return selFile;
    }
    
   
}