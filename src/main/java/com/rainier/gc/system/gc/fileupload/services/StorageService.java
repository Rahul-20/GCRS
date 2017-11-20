package com.rainier.gc.system.gc.fileupload.services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
		void init();	

	    String store(MultipartFile file);

	    String store(MultipartFile file,String type);

	    Stream<Path> loadAll();

	    Path load(String filename);

	    Resource loadAsResource(String filename);

	    void deleteAll();
	    
	    void deleteFile(String fileName);
}
