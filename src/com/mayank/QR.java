package com.mayank;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class QR {

    String generateQR(String data,String path) throws Exception{
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE,150,150);
        MatrixToImageWriter.writeToPath(matrix,"png", Paths.get(path));

        return path;
    }

    void openQR(String path){
        File f = new File(path);
        Desktop dt = Desktop.getDesktop(); // used to launch application on desktop
        try {
            dt.open(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}