package ro.info.wrseg.model;

public class FileDocument {
    private byte[] bytes;

    public FileDocument() {
    }

    public byte[] getBytes() {
        if (bytes == null) {
            bytes = new byte[]{};
        }
        return bytes.clone();
    }

    public void setBytes(byte[] bytes) {
        if (bytes != null) {
            this.bytes = bytes;
        } else {
            this.bytes = new byte[]{};
        }
    }
}
