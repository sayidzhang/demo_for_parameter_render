package org.sayid.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class DemoTestBase {

    /**
     * test is driven by data configured in csv file
     * each test case should have a csv file under /testdata/testcasename
     * and its name should be same with class name like testcaseame.csv
     * 
     * 
     * notes: this is a very common data provider, 
     * put anything else here 
     * will make it urgly and un-maintainable  
     */
    @DataProvider(name = "CsvDataProvider")
    public Iterator<?> getDataProvider(Method method) {

        try {
            Class<?> declaringClass = method.getDeclaringClass();
            String simplename = declaringClass.getSimpleName();
            String csvFile = "resources/" + simplename.toLowerCase() + "/" + simplename + ".csv";
            String absLocation = declaringClass.getClassLoader().getResource(csvFile).getPath();
            InputStream is = new FileInputStream(absLocation);
            InputStreamReader isr = new InputStreamReader(is);
            CSVReader reader = new CSVReader(isr, ',', '\"', 1);

            List<String[]> datas = new ArrayList<String[]>();
            while (true) {
                String[] line = reader.readNext();
                if (line == null) {
                    break;
                }
                datas.add(line);
            }
            return datas.iterator();

        } catch (Exception e) {
            return null;
        }
    }
}
