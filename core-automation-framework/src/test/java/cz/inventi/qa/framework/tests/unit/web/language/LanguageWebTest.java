package cz.inventi.qa.framework.tests.unit.web.language;

import cz.inventi.qa.framework.core.data.enums.Language;
import cz.inventi.qa.framework.core.objects.test.WebFlow;
import cz.inventi.qa.framework.testapps.testweb.lang.Index;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageWebTest extends WebFlow {

    @Test
    public void getLanguageDictionaryTest() {
        getParametersManager().getCommonParameters().setLanguage(Language.EN);
        Assert.assertTrue(getLanguageManager().getDictionary().keySet().size() > 0);
    }

    @Test
    public void wordTranslationTest() {
        homePage
            .getSidePanel()
            .getSideInfos()
            .get(0)
            .assertReadMoreText(getLanguageManager().getTranslation(Index.READ_MORE));
    }
}

