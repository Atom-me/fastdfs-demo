package com.atom.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 查询文件信息
 *
 * @author atom
 */
public class QueryFileInfo {

    public static void main(String[] args) throws IOException, MyException {

        ClientGlobal.initByProperties("fastdfs-client.properties");

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        FileInfo fileInfo = storageClient.query_file_info("group1", "M00/00/00/wKg4yGAuaVyAeZkEAADx2wjpGYI518.jpg");
        System.err.println(fileInfo);

    }
}
