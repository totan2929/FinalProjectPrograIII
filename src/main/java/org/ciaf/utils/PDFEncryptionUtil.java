package org.ciaf.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.File;
import java.io.IOException;

public class PDFEncryptionUtil {

    public static void encryptPDF(File archivePDF, String password) throws IOException {
        PDDocument document = PDDocument.load(archivePDF);

        AccessPermission permission = new AccessPermission();
        StandardProtectionPolicy policy = new StandardProtectionPolicy(password, password, permission);
        policy.setEncryptionKeyLength(128);
        policy.setPermissions(permission);

        document.protect(policy);
        document.save(archivePDF);
        document.close();
    }
}
