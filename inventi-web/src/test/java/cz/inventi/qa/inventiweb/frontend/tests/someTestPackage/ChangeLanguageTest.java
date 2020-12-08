package cz.inventi.qa.inventiweb.frontend.tests.someTestPackage;

import cz.inventi.qa.framework.core.data.enums.Language;
import cz.inventi.qa.inventiweb.frontend.tests.RegressionTest;
import org.testng.annotations.Test;

public class ChangeLanguageTest extends RegressionTest {

    @Test
    public void changeLanguage() {
        homePage
            .getTopMenu()
            .getLanguageSwitcher()
            .switchLanguageTo(Language.EN)
                .assertCurrentLanguageIs(Language.EN)
            .switchLanguageTo(Language.CS_CZ)
                .assertCurrentLanguageIs(Language.CS_CZ);
    }
}
