package com.jobPortal.Bridgeify.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {
    private Path path;
    public Resource getFile(String dir, String fileName) throws IOException {
        Path pathDir=Paths.get(dir);
        Files.list(pathDir).forEach(file->{
            if(file.getFileName().toString().startsWith(fileName)) {
                path=file;
            }
        });
        if(path!=null) {
            return new UrlResource(path.toUri());
        }
        return null;
    }
}
