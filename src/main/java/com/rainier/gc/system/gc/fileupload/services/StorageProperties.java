package com.rainier.gc.system.gc.fileupload.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@ConfigurationProperties("storage")
@Service
public class StorageProperties {
	
	/**
     * Folder location for storing files
     */
	//@Value("uploadFileSystemPath")
	private String location = "/opt/gcs/img/"; // in UNIX 
	
	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
