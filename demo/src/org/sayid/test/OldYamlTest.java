package org.sayid.test;

import org.testng.annotations.Test;

public class OldYamlTest extends DemoTestBase {

    /**
     * this test has two parameters which are read line by line from csv data provider
     * and all yamlfiles we put at resources/yamlfiles/*
     * and in the csv we do not write the long relative or absolute yaml file location
     * we only write filename
     * so we need to let the csv dataprovider to find the absolute location
     * or we use the new annotation parameter render
     * @param caseId
     * @param yamlFile
     */
    @Test(dataProvider = "CsvDataProvider")
    public void test(String caseId, String yamlFile) {
        System.out.println(caseId);
        System.out.println(yamlFile);
    }
}
