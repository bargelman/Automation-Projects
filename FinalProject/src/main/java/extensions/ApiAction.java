package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiAction extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String getUrl) {
        response = httpRequest.get(getUrl);
        response.prettyPrint();
        return response;
    }

    @Step("Post Data To Server")
    public static void post(JSONObject parameters, String resourceURL) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(parameters.toJSONString());
        response = httpRequest.post(resourceURL);
        response.prettyPrint();
    }

    @Step("Update Data In Server")
    public static void put(JSONObject parameters, String resourceURL) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(parameters.toJSONString());
        response = httpRequest.put(resourceURL);
        response.prettyPrint();
    }

    @Step("Delete Data From Server")
    public static void delete(String resourceURL) {
        response = httpRequest.delete(resourceURL);
        response.prettyPrint();
    }

    @Step("Extract Value From JASON Format")
    public static String extractFromJson(Response response, String path) {
        jp = response.jsonPath();
        return jp.getString(path);
    }
}
