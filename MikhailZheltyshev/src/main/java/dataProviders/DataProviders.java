package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jsonPojo.TestData;
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
        Gson gson = new Gson();
        JsonObject jDataSet = new JsonParser().parse(new FileReader
                ("src/test/resources/JDI_ex8_metalsColorsDataSet.json")).getAsJsonObject();
        Object[][] result = new Object[jDataSet.size()-1][1];
        for (int i = 1; i <= jDataSet.size()-1; i++){
            result[i - 1][0] = gson.fromJson(jDataSet.get("data_" + i), TestData.class);
        }
        return result;
    }
}
