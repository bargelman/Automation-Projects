package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

public class GrafanaAPI extends CommonOps {

    @Test(priority = 1, description = "TEST01 - Add New Team And Verify")
    @Description("This Test Create New Teams and verifies Teams Created")
    public void addNewTeam() {
        ApiFlows.postTeam("Avengers", "Avengers@team.com");
        ApiFlows.postTeam("Marvel", "Marvel@team.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "Avengers");

    }

    @Test(priority = 2, description = "TEST02 - Get Teams From Grafana")
    @Description("This Test verifies Some Property Of Team")
    public void verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "Marvel");
    }

    @Test(priority = 3, description = "TEST03 - Update Team And Verify")
    @Description("This Test Updates A Team And verifies If Updated")
    public void updateTeam() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("Spidey", "Spidey@team.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "Spidey@team.com");
    }

    @Test(priority = 4, description = "TEST04 - Delete Team And Verify")
    @Description("This Test Delete A Team And verifies If Deleted")
    public void deleteTeam() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}
