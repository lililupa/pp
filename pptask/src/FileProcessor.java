import java.io.*;
import java.util.zip.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class FileProcessor {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "1234567890123456".getBytes(); // Пример ключа (16 байт)

    public static void main(String[] args){
        String inputFile = "C:\\Users\\I\\IdeaProjects\\pptask\\input.txt";
        String outputFile = "C:\\Users\\I\\IdeaProjects\\pptask\\output.txt";
        String zipFile = "output.zip";
        String encryptedFile = "encrypted.zip";
        String decryptedFile = "decrypted.zip";
        String unzippedFile = "unzipped_output.txt";

        try {
            // Чтение и обработка данных
            String inputContent = readFile(inputFile);
            String processedContent = processContent(inputContent);

            // Запись данных в выходной файл
            writeFile(outputFile, processedContent);

            // Архивация выходного файла
            zipFile(outputFile, zipFile);
            System.out.println("Файл заархивирован: " + zipFile);

            // Шифрование заархивированного файла (байтовый поток)
            encryptFile(zipFile, encryptedFile);
            System.out.println("Файл зашифрован: " + encryptedFile);

            // Дешифрование файла (байтовый поток)
            decryptFile(encryptedFile, decryptedFile);
            System.out.println("Файл дешифрован: " + decryptedFile);

            // Разархивация файла
            unzipFile(decryptedFile, unzippedFile);
            System.out.println("Файл разархивирован в: " + unzippedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Чтение файла
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    // Запись файла
    private static void writeFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }

    // Обработка контента (поиск и замена арифметических операций)
    private static String processContent(String content) {
        return content.replaceAll("2\\s*\\+\\s*2", "4");  // Пример простой обработки
    }

    // Архивация файла (ZIP)
    private static void zipFile(String inputFile, String outputFile) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            ZipEntry zipEntry = new ZipEntry(inputFile);
            zos.putNextEntry(zipEntry);

            try (FileInputStream fis = new FileInputStream(inputFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) >= 0) {
                    zos.write(buffer, 0, length);
                }
            }

            zos.closeEntry();
        }
    }

    // Разархивация файла (ZIP)
    private static void unzipFile(String inputFile, String outputFile) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(inputFile))) {
            ZipEntry zipEntry = zis.getNextEntry();
            if (zipEntry != null) {
                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = zis.read(buffer)) >= 0) {
                        fos.write(buffer, 0, length);
                    }
                }
            }
            zis.closeEntry();
        }
    }// Шифрование файла (байтовый поток)
    private static void encryptFile(String inputFile, String outputFile) throws Exception {
        Key aesKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                cos.write(buffer, 0, length);
            }
        }
    }

    // Дешифрование файла (байтовый поток)
    private static void decryptFile(String inputFile, String outputFile) throws Exception {
        Key aesKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, aesKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = cis.read(buffer)) >= 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
}