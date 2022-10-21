package herokuapp.tests;

import org.testng.annotations.Test;

public class DropdownExampleTests extends TestBase {

    @Test
    public void shouldBeAbleToSelectOption() {
        app.dropdownPage().visit();
        app.dropdownPage().selectOption("2");
    }
}
