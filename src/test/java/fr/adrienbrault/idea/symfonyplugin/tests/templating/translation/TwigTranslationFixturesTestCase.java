package fr.adrienbrault.idea.symfonyplugin.tests.templating.translation;

import fr.adrienbrault.idea.symfonyplugin.tests.SymfonyLightCodeInsightFixtureTestCase;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 * @see fr.adrienbrault.idea.symfonyplugin.templating.TwigTemplateCompletionContributor
 */
abstract public class TwigTranslationFixturesTestCase extends SymfonyLightCodeInsightFixtureTestCase {

    public void setUp() throws Exception {
        super.setUp();
        myFixture.copyFileToProject("messages.de.yml", "Resources/translations/messages.de.yml");
        myFixture.copyFileToProject("foo.de.yml", "Resources/translations/foo.de.yml");
        myFixture.copyFileToProject("interchange.en.xlf", "interchange.en.xlf");
    }

    protected String getTestDataPath() {
        return "src/test/java/fr/adrienbrault/idea/symfonyplugin/tests/templating/translation/fixtures";
    }

}
