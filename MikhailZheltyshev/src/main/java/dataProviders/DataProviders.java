package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jsonPojo.TestData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataProviders {

    private final String DATA_ITEM_PREFIX = "data_";

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
        // TODO Data "key" string might be changed in a quite different way, your code should not be linked with its name
        Gson gson = new Gson();
        JsonObject jDataSet = new JsonParser().parse(new FileReader
                ("src/test/resources/JDI_ex8_metalsColorsDataSet.json")).getAsJsonObject();
        Object[][] result = new Object[jDataSet.size()][1];
        for (int i = 1; i <= jDataSet.size(); i++){
            result[i - 1][0] = gson.fromJson(jDataSet.get(DATA_ITEM_PREFIX + i), TestData.class);
        }
        return result;
    }
}
