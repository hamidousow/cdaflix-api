package com.cda.api.service.IMP;

import com.cda.api.dto.film.FilmDto;
import com.cda.api.model.Film;
import com.cda.api.service.IFileService;
import com.cda.api.utils.Constantes;
import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Service
public class FileServiceIMP implements IFileService {

    private final String bucketName = "flixbucket_2";

    String path = "flixkey-3.json";
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);

    private Storage storage;

    Storage anonymousStorage = StorageOptions.getUnauthenticatedInstance().getService();

    public FileServiceIMP() {

        storage = StorageOptions.getDefaultInstance().getService();

        try {
            storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .build()
                    .getService();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

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

    @Override
    public String uploadCloud(MultipartFile file) {

        BlobId blobId;
        try {
            InputStream inputStream = file.getInputStream();
            blobId = BlobId.of(bucketName, Objects.requireNonNull(file.getOriginalFilename()));
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType("image/jpeg")
                .build();
            Blob blob = storage.create(blobInfo, inputStream.readAllBytes());
            Blob newBlob = storage.get(blob.getBlobId());
            System.out.println("NOM DU BLOB : "+blobId.getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return blobId.getName();
    }

    @Override
    public List<FilmDto> getImgUrl(List<FilmDto> films) {

        storage = StorageOptions.getUnauthenticatedInstance().getService();

        Page<Blob> blobs = storage.list(bucketName);

        for(FilmDto film : films) {
            for (Blob blob : blobs.iterateAll()) {
                if(blob.getBlobId().getName().equals(film.getImg())) {
                    film.setImg(blob.getMediaLink());
                }
            }
        }
        return films;
    }
}
