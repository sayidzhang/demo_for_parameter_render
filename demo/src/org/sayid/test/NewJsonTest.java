package org.sayid.test;

import org.testng.annotations.ParameterOverride;
import org.testng.annotations.ParameterRender;
import org.testng.annotations.Test;

public class NewJsonTest extends DemoTestBase {

    /**
     * this test has two parameters which are read line by line from csv data provider
     * and all jsonfiles we put at resources/jsonfiles/*
     * and in the csv we do not write the long relative or absolute json file location
     * we only write filename
     * 
     * 
     * in this case we use parameter render to caculate the correct json file location
     * @param caseId
     * @param jsonFile
     */
    @Test(dataProvider = "CsvDataProvider")
    public void test(String caseId,
                     @ParameterOverride(parameterRender = "absJsonFile") String jsonFile) {
        System.out.println(caseId);
        System.out.println(jsonFile);
    }

    /**
     * use parameter render to get correct absolute json test files location
     * 
     * @param filename
     * @return
     */
    @ParameterRender(name = "absJsonFile")
    public String findJsonFile(String filename) {
        return "resources/jsonfiles/" + filename;
    }
}
