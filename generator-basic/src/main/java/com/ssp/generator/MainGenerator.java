package com.ssp.generator;

import com.ssp.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = new File(projectPath, "demo-project/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        StaticGenerator.copyFileByHutool(inputPath, outputPath);
        String inputDynamicFilePath = projectPath + File.separator + "generator-basic/src/main/resources/templates/MainTemplateConfig.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("lll");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("aaa");
        doGenerate(mainTemplateConfig);
    }
}
