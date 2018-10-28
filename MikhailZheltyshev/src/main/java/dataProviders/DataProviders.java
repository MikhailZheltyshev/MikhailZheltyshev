package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import jsonPojo.DataSet;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataProviders {

    @DataProvider(parallel = true)
    public Object[][] checkTextsOnIndexDataProvider() {
        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @DataProvider
    public Object[][] checkMetalsAndColorsPageDataProvider() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"));
        Gson gson = new Gson();
        DataSet dataSet = gson.fromJson(jsonData, DataSet.class);
        Object[][] result = new Object[6][1];
        result[0][0] = dataSet.getData_1();
        result[1][0] = dataSet.getData_2();
        result[2][0] = dataSet.getData_3();
        result[3][0] = dataSet.getData_4();
        result[4][0] = dataSet.getData_5();
        result[5][0] = dataSet.getData_6();
        return result;
    }
}
