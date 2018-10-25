package ro.info.wrseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.info.wrseg.exception.UploadException;
import ro.info.wrseg.model.FileDocument;
import ro.info.wrseg.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {
    private FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public byte[] save(MultipartFile content) {
        FileDocument fileDocument = new FileDocument();
        try {
            fileDocument.setBytes(content.getBytes());
        } catch (Exception e) {
            throw new UploadException();
        }
        return fileRepository.save(fileDocument);
    }
}
