package apicalls;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.testng.ITestContext;
import utilities.FilePaths;
import utilities.JsonUtils;
import utilities.PropertyConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author amalyahayrapetova
 */

public class JiraApiCalls {

    private static final String CREATE_CYCLE_JSON = FilePaths.USER_DIR_PATH + "/src/main/resources/apicalls/createCycle.json";
    private static final String EXECUTE_TEST_JSON = FilePaths.USER_DIR_PATH + "/src/main/resources/apicalls/executeTest.json";
    private static String cycleKey;
    private static String cycleVersion;


    /**
     * Create test cycle call.
     *
     * @return
     */
    public static void createTestCycle(ITestContext iTestContext) throws IOException, InterruptedException {
        JsonElement convert = JsonUtils.fromPath(CREATE_CYCLE_JSON);
        cycleVersion = System.getProperty("cycleVersion");
        String cycleName = System.getProperty("cycle.name");
        if (cycleName.isBlank())
            cycleName = iTestContext.getCurrentXmlTest().getSuite().getName();
        JsonObject cycleJson = (JsonObject) JsonUtils.editValue(convert, "name", cycleName + " " + cycleVersion);
        String response = post(PropertyConfig.getProperty(FilePaths.TM4J_CONFIG_PROPERTIES, "jira.create.cycle.endpoint"), cycleJson);
        cycleKey = JsonUtils.getValue(JsonUtils.convertStringToJson(response), "key").getAsString();
    }


    /**
     * Execute test cases.
     *
     * @param testKey
     * @param status
     */
    public static void executeTest(String testKey, String status) throws IOException, InterruptedException {
        JsonElement convert = JsonUtils.fromPath(EXECUTE_TEST_JSON);
        convert = JsonUtils.editValue(convert, "testCycleKey", cycleKey);
        convert = JsonUtils.editValue(convert, "testCaseKey", testKey);
        convert = JsonUtils.editValue(convert, "statusName", status);
        post(PropertyConfig.getProperty(FilePaths.TM4J_CONFIG_PROPERTIES, "jira.test.execution.endpoint"), (JsonObject) convert);

    }

    /**
     * POST Request
     *
     * @param endPoint
     * @param json
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private static String post(String endPoint, JsonObject json) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .uri(URI.create(endPoint))
                .setHeader("Authorization", PropertyConfig.getProperty(FilePaths.TM4J_CONFIG_PROPERTIES, "jira.authorization.token"))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();

    }
}
