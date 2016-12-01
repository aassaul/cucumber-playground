import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.junit.Assert;

/**
 * Created by Admin on 12/1/2016.
 */
public class MyStepdefs implements En {
    private boolean isOwner;
    private String articleName;
    private String articleText;

    public MyStepdefs() {
        Given("^I signed up as owner$", () -> {
            System.out.println("Signed up!");
            isOwner = true;
        });

        When("^I write article \"([^\"]*)\"$", (String arg0) -> {
            System.out.println(arg0 + " written");
            articleName = arg0;
        });

        And("^text of article is \"([^\"]*)\"$", (String arg0) -> {
            System.out.println("Text: " + arg0);
            articleText = arg0;
        });

        And("^I post article$", () -> {
            System.out.println("Posted");
        });

        Then("^I should see \"([^\"]*)\"$", (String arg0) -> {
            if (isOwner) {
                Assert.assertEquals("Article is created", arg0);
            } else  {
                Assert.assertEquals("You have no access to post articles", arg0);
            }
        });

        Given("^I signed up as user$", () -> {
            System.out.println("I am user");
            isOwner = false;
        });
        And("^Created article name is \"([^\"]*)\"$", (String arg0) -> {
            Assert.assertEquals(arg0, articleName);
        });

        And("^Created article text is \"([^\"]*)\"$", (String arg0) -> {
            Assert.assertEquals(arg0, articleText);
        });
    }
}
