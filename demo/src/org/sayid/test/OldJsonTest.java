package org.sayid.test;

import org.testng.annotations.Test;

public class OldJsonTest extends DemoTestBase {

    /**
     * this test has two parameters which are read line by line from csv data provider
     * and all jsonfiles we put at resources/jsonfiles/*
     * and in the csv we do not write the long relative or absolute json file location
     * we only write filename
     * so we need to let the csv dataprovider to find the absolute location
     * or we use the new annotation parameter render
     * @param caseId
     * @param jsonFile
     */
    @Test(dataProvider = "CsvDataProvider")
    public void test(String caseId, String jsonFile) {
        System.out.println(caseId);
        System.out.println(jsonFile);
    }
}
