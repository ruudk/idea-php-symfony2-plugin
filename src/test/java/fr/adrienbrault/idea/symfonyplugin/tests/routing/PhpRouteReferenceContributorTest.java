package fr.adrienbrault.idea.symfonyplugin.tests.routing;

import com.jetbrains.php.lang.PhpFileType;
import fr.adrienbrault.idea.symfonyplugin.tests.SymfonyLightCodeInsightFixtureTestCase;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 *
 * @see fr.adrienbrault.idea.symfonyplugin.routing.PhpRouteReferenceContributor
 */
public class PhpRouteReferenceContributorTest extends SymfonyLightCodeInsightFixtureTestCase {


    public void setUp() throws Exception {
        super.setUp();

        myFixture.configureFromExistingVirtualFile(myFixture.copyFileToProject("PhpRouteReferenceContributor.php"));
    }

    protected String getTestDataPath() {
        return "src/test/java/fr/adrienbrault/idea/symfonyplugin/tests/routing/fixtures";
    }

    public void testGenerateUrlProvidesNavigation() {

        Collection<String[]> providers = new ArrayList<String[]>() {{
            add(new String[] {"Symfony\\Component\\Routing\\Generator\\UrlGeneratorInterface", "generate"});
            add(new String[] {"Symfony\\Bundle\\FrameworkBundle\\Controller\\Controller", "generateUrl"});
            add(new String[] {"Symfony\\Bundle\\FrameworkBundle\\Controller\\Controller", "redirectToRoute"});
            add(new String[] {"My\\Proxy\\Routing\\Controller", "generateUrl"});
        }};

        for (String[] provider : providers) {
            assertCompletionContains(PhpFileType.INSTANCE,
                String.format("<?php\n" +
                    "/** @var $f \\%s */\n" +
                    "$f->%s('<caret>')",
                    provider[0], provider[1]
                ),
                "foo_bar"
            );
        }

    }
}
