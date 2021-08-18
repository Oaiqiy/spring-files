package com.example.uploadingfiles;

import com.example.uploadingfiles.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileUploadTasks {

    StorageService storageService;

    @Autowired
    FileUploadTasks(StorageService storageService){
        this.storageService = storageService;
    }

    @Scheduled(cron = "* 0,30 * * * *")
    void autoDeleteAll(){
        storageService.deleteAll();
    }
}
