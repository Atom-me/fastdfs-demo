package com.atom.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author atom
 */
public class DownloadFile {

    public static void main(String[] args) throws IOException, MyException {

        ClientGlobal.initByProperties("fastdfs-client.properties");

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        byte[] fileBytes = storageClient.download_file("group1", "M00/00/00/wKg4yGAuaVyAeZkEAADx2wjpGYI518.jpg");

        /*FileOutputStream fileOutputStream = new FileOutputStream("/Users/atom/temp/a.jpg");
        fileOutputStream.write(fileBytes);
        fileOutputStream.close();*/

        Path write = Files.write(Paths.get("/Users/atom/temp/b.jpg"), fileBytes);
        System.err.println(write);

    }
}
