package com.example.uploadingfiles;

import com.example.uploadingfiles.storage.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FileUploadTasks {

    StorageService storageService;

    @Autowired
    FileUploadTasks(StorageService storageService){
        this.storageService = storageService;
    }

    @Scheduled(cron = "0 0,30 * * * *")
    void autoDeleteAll(){
        storageService.deleteAll();
        storageService.init();
        log.info("delete all");

    }
}
