package org.sayid.test;

import org.testng.annotations.ParameterOverride;
import org.testng.annotations.ParameterRender;
import org.testng.annotations.Test;

public class NewYamlTest extends DemoTestBase {

    /**
     * this test has two parameters which are read line by line from csv data provider
     * and all yamlfiles we put at resources/yamlfiles/*
     * and in the csv we do not write the long relative or absolute yaml file location
     * we only write filename
     * 
     * 
     * in this case we use parameter render to caculate the correct yaml file location
     * @param caseId
     * @param jsonFile
     */
    @Test(dataProvider = "CsvDataProvider")
    public void test(String caseId,
                     @ParameterOverride(parameterRender = "absYamlFile") String yamlFile) {
        System.out.println(caseId);
        System.out.println(yamlFile);
    }

    /**
     * use parameter render to get correct absolute yaml test files location
     * 
     * @param filename
     * @return
     */
    @ParameterRender(name = "absYamlFile")
    public String findYamlFile(String filename) {
        return "resources/yamlfiles/" + filename;
    }
}
