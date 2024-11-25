import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;

public class UnzipExample {
    public static void main(String[] args) {
        String zipFileName = "archive.zip"; // Имя архива
        String outputDir = "./output"; // Директория для извлечения

        try (FileInputStream fis = new FileInputStream(zipFileName);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                String outFileName = outputDir + "/" + zipEntry.getName();
                FileOutputStream fos = new FileOutputStream(outFileName);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                fos.close();
                zis.closeEntry();
            }

            System.out.println("Архив успешно распакован в: " + outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}