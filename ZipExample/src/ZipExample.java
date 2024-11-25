import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipExample {
    public static void main(String[] args) throws IOException {
        String[] filesToZip = {"file1.txt", "file2.txt"};
        String zipFileName = "archive.zip";

        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos)){

            for (String filePath : filesToZip) {
                FileInputStream fis = new FileInputStream(filePath);
                ZipEntry zipEntry = new ZipEntry(filePath);
                zos.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
                fis.close();
            }
            System.out.println("Архив успешно создан: + " + zipFileName);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}