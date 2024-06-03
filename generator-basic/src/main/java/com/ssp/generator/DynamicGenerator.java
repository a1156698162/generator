package com.ssp.generator;

import com.ssp.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class DynamicGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "generator-basic/src/main/resources/templates/MainTemplateConfig.java.ftl";
        System.out.println(inputPath);
        String outputPath =  "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Ssp");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        //指定模版文件所在路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        //设置模版文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        configuration.setNumberFormat("0.######");
        //创建模版对象，加载指定模版
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        //数据模型
        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        out.close();
    }
}
