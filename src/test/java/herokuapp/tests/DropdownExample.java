package herokuapp.tests;

import org.testng.annotations.Test;

public class DropdownExample extends TestBase {

    @Test
    public void shouldBeAbleToSelectOption() {
        app.dropdownPage().visit();
        app.dropdownPage().selectOption("Option 1");
    }
}
