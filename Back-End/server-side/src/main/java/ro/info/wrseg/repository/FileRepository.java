package ro.info.wrseg.repository;

import org.springframework.stereotype.Component;
import ro.info.wrseg.model.FileDocument;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Component("fileRepository")
public class FileRepository {
    public byte[] save(FileDocument fileDocument) {
        try {
            ByteArrayInputStream byteArray = new ByteArrayInputStream(fileDocument.getBytes());
            Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
            ImageReader reader = (ImageReader) readers.next();
            Object source = byteArray;
            ImageInputStream inputStream = null;
            inputStream = ImageIO.createImageInputStream(source);
            reader.setInput(inputStream, true);
            ImageReadParam param = reader.getDefaultReadParam();
            Image image = reader.read(0, param);
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            g2.drawImage(image, null, null);
            File imageFileDocument = new File("./../assets/image1.jpg");
            ImageIO.write(bufferedImage, "jpg", imageFileDocument);
            System.out.println(imageFileDocument.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileDocument.getBytes();
    }
}
