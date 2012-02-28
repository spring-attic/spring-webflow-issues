package org.springframework.webflow.issues;

import java.io.Serializable;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

public class FileUploadBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public void listener(FileUploadEvent event) throws Exception{
        UploadedFile file = event.getUploadedFile();
        System.out.println("Uploaded file: " + file.getName());
    }
	
}
