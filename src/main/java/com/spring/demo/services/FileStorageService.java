package com.spring.demo.services;

import com.spring.demo.config.FileStorageProperties;
import com.spring.demo.errors.FileStorageException;
import com.spring.demo.errors.RequestFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileProperties) throws FileStorageException {

        this.fileStorageLocation = Paths.get(fileProperties.getLocation()).toAbsolutePath().normalize();
        try{

            if(!Files.isDirectory(this.fileStorageLocation))
                Files.createDirectories(this.fileStorageLocation);

        }catch (Exception ex){

            throw new FileStorageException("Could not find or create directory", ex);
        }
    }

    public String storeFile(MultipartFile file) throws FileStorageException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try{

            if(fileName.contains("..")){

                throw new FileStorageException("Sorry, File name contains invalid path sequence");
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return targetLocation.toUri().toURL().toString();
        }catch (IOException ex){

            throw new FileStorageException("Could not store file "+fileName+" please try again", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) throws RequestFileNotFoundException {

        try{

           Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
           Resource resource = new UrlResource(filePath.toUri());
           if(resource.exists()){

               return resource;
           }else{

                throw new RequestFileNotFoundException("File Not found "+fileName);
           }
        }catch (MalformedURLException ex){

            throw new RequestFileNotFoundException("File not found "+fileName, ex);
        }
    }

}
