package ro.info.wrseg.service;


import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    byte[] save(MultipartFile content);
}
