package com.cybertek.tests.day10_fileUploadTest;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1(){
     //   /Users/Munevver/IdeaProjects/EU7TestNGSelenium/src/test/resources/textfile.txt

        System.out.println(System.getProperty("os.name")); //Mac OS X
        System.out.println(System.getProperty("user.dir")); //it gives location of project dinamically
        //    /Users/Munevver/IdeaProjects/EU7TestNGSelenium

        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);

        String filePath ="src/test/resources/textfile.txt";

        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath);



    }
}
