package com.atom.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author atom
 */
public class UploadFile {

    public static void main(String[] args) throws IOException, MyException {
      /*  //加载原 conf 格式文件配置：
        ClientGlobal.init("fdfs_client.conf");
        ClientGlobal.init("config/fdfs_client.conf");
        ClientGlobal.init("/opt/fdfs_client.conf");
        ClientGlobal.init("C:\\Users\\James\\config\\fdfs_client.conf");*/

        //加载 properties 格式文件配置：
//        ClientGlobal.initByProperties("fastdfs-client.properties");
//        ClientGlobal.initByProperties("config/fastdfs-client.properties");
//        ClientGlobal.initByProperties("/opt/fastdfs-client.properties");
//        ClientGlobal.initByProperties("C:\\Users\\James\\config\\fastdfs-client.properties");

     /*   //加载 Properties 对象配置：
        Properties props = new Properties();
        props.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS, "10.0.11.101:22122,10.0.11.102:22122");
        ClientGlobal.initByProperties(props);*/
/*
        //加载 trackerServers 字符串配置：
        String trackerServers = "10.0.11.101:22122,10.0.11.102:22122";
        ClientGlobal.initByTrackers(trackerServers);*/


        ClientGlobal.initByProperties("fastdfs-client.properties");

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        String[] jpgs = storageClient.upload_file("/Users/atom/ubuntu-wallpapers/red-ubuntu.jpg", "jpg", null);
        InetSocketAddress[] tracker_servers = ClientGlobal.getG_tracker_group().tracker_servers;
        for (InetSocketAddress tracker_server : tracker_servers) {
            System.out.println(tracker_server);
        }

        for (String jpg : jpgs) {
            System.err.println(jpg);
            //group1
//            M00/00/00/wKj9gFpaeTKAQiNzAAAaiKZLWAo252.jpg
//            http://192.168.56.200
        }


    }
}
