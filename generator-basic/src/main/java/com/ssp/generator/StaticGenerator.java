package com.ssp.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {


    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String inputPath = projectPath + File.separator + "demo-project" + File.separator + "acm-template";
        copyFileByHutool(inputPath, projectPath);
    }

    public static void copyFileByHutool(String inputPath,
                                        String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
