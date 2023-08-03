package com.cda.api.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    public String upload(MultipartFile file);

    String upload(MultipartFile file, String dir);
}
