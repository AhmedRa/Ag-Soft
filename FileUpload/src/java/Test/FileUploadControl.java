/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.sun.faces.el.FacesCompositeELResolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author TamallyMaak
 */
@ManagedBean
@SessionScoped
public class FileUploadControl {

    private String distnation = "D:\\";
    private UploadedFile file;

    public FileUploadControl() {
    }

    public String getDistnation() {
        return distnation;
    }

    public void setDistnation(String distnation) {
        this.distnation = distnation;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void transferfile(String Filename, InputStream in) {
        try {
            OutputStream out = new FileOutputStream(new File(distnation + Filename));
            int reader = 0;
            byte[] bytes = new byte[(int) getFile().getSize()];
            while ((reader = in.read(bytes)) != -1) {
                out.write(bytes, 0, reader);

            }
            in.close();
            out.flush();
            out.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUploadControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUploadControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public  void upload(){
     String extvaldate;
     if(getFile()!=null){
     
     String ext= getFile().getFileName();
     if(ext!=null){
     extvaldate=ext.substring(ext.indexOf(".")+1);
     }else{extvaldate=null;}
     if(extvaldate.equals("pdf")){
     
         try {
             transferfile(getFile().getFileName(),getFile().getInputstream());
         } catch (IOException ex) {
             Logger.getLogger(FileUploadControl.class.getName()).log(Level.SEVERE, null, ex);
              FacesContext context=FacesContext.getCurrentInstance();
         context.addMessage(null,new FacesMessage("Wrong","Error Uploading File"));
         }
         FacesContext context=FacesContext.getCurrentInstance();
         context.addMessage(null,new FacesMessage("Successful",getFile().getFileName()+"is upload type content"+getFile().getContentType()+"ahmed"+getFile().getSize()));
     } else{
                  FacesContext context=FacesContext.getCurrentInstance();
                  context.addMessage(null,new FacesMessage("Wrong Ext","only .pdf"));
                 
     }            
     } else{
             FacesContext context=FacesContext.getCurrentInstance();
                  context.addMessage(null,new FacesMessage("Wrong ","Select a file "));
             
             }
     
     
     }
     }
        
    


