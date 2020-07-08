package de.jpwinkler.mkmapi.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class MKMApiUtils {

    public static void saveProductsFile(String base64string, String filename, boolean unpack) throws IOException {

        try (OutputStream os = new FileOutputStream(filename)) {
            if (unpack) {
                try (InputStream is = new GZIPInputStream(new ByteArrayInputStream(Base64.decodeBase64(base64string)))) {
                    int bytes_read;
                    byte[] buffer = new byte[1024];
                    while ((bytes_read = is.read(buffer)) > 0) {
                        os.write(buffer, 0, bytes_read);
                    }
                }
            } else {
                os.write(Base64.decodeBase64(base64string));
            }
        }
    }

}
