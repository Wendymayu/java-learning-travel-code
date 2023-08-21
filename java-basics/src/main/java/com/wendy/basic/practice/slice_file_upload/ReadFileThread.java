package com.wendy.basic.practice.slice_file_upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/8/21 23:33
 * @Version 1.0
 */
public class ReadFileThread implements Runnable {
    private SliceInfo sliceInfo;

    public ReadFileThread(SliceInfo sliceInfo) {
        this.sliceInfo = sliceInfo;
    }

    @Override
    public void run() {
        try {
            RandomAccessFile file = new RandomAccessFile(sliceInfo.getFilePath(), "rw");
            file.seek(sliceInfo.getStart());

            FileOutputStream outputStream;
            byte[] buffer = new byte[sliceInfo.getEnd() - sliceInfo.getStart()];

            file.read(buffer);
            int bufferSize = 0;
            bufferSize = file.read(buffer);
            String[] fileNames = sliceInfo.getFileName().split(".");
            String sliceFileName = fileNames[0] + sliceInfo.getSliceCode() + "." + fileNames[1];
            outputStream = new FileOutputStream(sliceFileName);
            outputStream.write(buffer, 0, bufferSize);
/*            while ((bufferSize = file.read(buffer)) > 0) {
                String[] fileNames = sliceInfo.getFileName().split(".");
                String sliceFileName = fileNames[0] + sliceInfo.getSliceCode() + "." + fileNames[1];
                outputStream = new FileOutputStream(sliceFileName);
                outputStream.write(buffer, 0, bufferSize);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
