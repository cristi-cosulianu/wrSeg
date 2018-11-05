package ro.info.wrseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ro.info.wrseg.model.FileUpload;
import ro.info.wrseg.service.FileStorageService;

import java.io.IOException;

@RestController
@RequestMapping("/upload-file")
public class FileController {
    private FileStorageService fileStorageService;

    @Autowired
    FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping()
    public ResponseEntity<Resource> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
       FileUpload fileUpload = fileStorageService.save(multipartFile);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(multipartFile.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + "file1" + "\"")
                .body(new ByteArrayResource(fileUpload.getMultipartFile().getBytes()));
    }
}
