package ru.homemade.mivanov.installerdias.fileop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

@Component
public class CheckFiles {

    @Autowired
    protected Unzipper unzipper;

    private interface systemVariable{
        String PRODUCT_DIRECTORY = "PRODUCT_DIRECTORY";
    }

    public CheckFiles() {
    }

    @PostConstruct
    public void runAfterObjectCreated() throws IOException {
        //String strdir = System.getenv("F:\\diasoft_work\\");
        File dir = new File("F:\\diasoft_work\\");

        File[] matches = dir.listFiles(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                return name.startsWith("FT") && name.endsWith(".zip");
            }
        });
        unzipper.unzip(matches);
    }
}
