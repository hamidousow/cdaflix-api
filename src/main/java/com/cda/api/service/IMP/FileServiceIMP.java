package com.cda.api.service.IMP;

import com.cda.api.service.IFileService;
import com.cda.api.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceIMP implements IFileService {

    @Override
    public String upload(MultipartFile file) {
        String filePath = Constantes.FOLDER_PATH+file.getOriginalFilename();

        try {
            File convFile = new File(filePath);
            file.transferTo(convFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath;
    }

    @Override
    public String upload(MultipartFile file, String pathDir) {
        String filePath = pathDir+file.getOriginalFilename();
        System.out.println(filePath);
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath;
    }
}
