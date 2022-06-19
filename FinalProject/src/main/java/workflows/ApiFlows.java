package workflows;

import extensions.ApiAction;
import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Team Property")
    public static String getTeamProperty(String jPath) {
        response = ApiAction.get("api/teams/search");
        return ApiAction.extractFromJson(response, jPath);
    }

    @Step("Business Flow: Create New Team In Grafana")
    public static void postTeam(String name, String email) {
        parameters.put("name", name);
        parameters.put("email", email);
        ApiAction.post(parameters, "/api/teams");
    }

    @Step("Business Flow: Update Existing Team In Grafana")
    public static void updateTeam(String name, String email, String id) {
        parameters.put("name", name);
        parameters.put("email", email);
        ApiAction.put(parameters, "/api/teams/" + id);
    }

    @Step("Business Flow: Delete Existing Team In Grafana")
    public static void deleteTeam(String id) {
        ApiAction.delete("/api/teams/" + id);
    }

}
