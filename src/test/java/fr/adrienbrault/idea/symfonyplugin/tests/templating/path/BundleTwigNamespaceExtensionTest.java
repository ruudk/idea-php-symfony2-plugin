package fr.adrienbrault.idea.symfonyplugin.tests.templating.path;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.VfsTestUtil;
import com.intellij.util.containers.ContainerUtil;
import fr.adrienbrault.idea.symfonyplugin.extension.TwigNamespaceExtensionParameter;
import fr.adrienbrault.idea.symfonyplugin.templating.path.BundleTwigNamespaceExtension;
import fr.adrienbrault.idea.symfonyplugin.templating.path.TwigPath;
import fr.adrienbrault.idea.symfonyplugin.tests.SymfonyLightCodeInsightFixtureTestCase;

import java.util.Collection;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 * @see fr.adrienbrault.idea.symfonyplugin.templating.path.BundleTwigNamespaceExtension
 */
public class BundleTwigNamespaceExtensionTest extends SymfonyLightCodeInsightFixtureTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();

        VirtualFile virtualFile = myFixture.copyFileToProject("classes.php");
        VfsTestUtil.createDir(virtualFile.getParent(), "Resources/views");
    }

    public String getTestDataPath() {
        return "src/test/java/fr/adrienbrault/idea/symfonyplugin/tests/templating/path/fixtures";
    }

    public void testThatBundleNamespacesAreAdded() {
        Collection<TwigPath> namespaces = new BundleTwigNamespaceExtension()
            .getNamespaces(new TwigNamespaceExtensionParameter(getProject()));

        assertNotNull(ContainerUtil.find(namespaces, twigPath ->
            "FooBundle".equals(twigPath.getNamespace()) && "/src/Resources/views".equals(twigPath.getPath()))
        );

        assertNotNull(ContainerUtil.find(namespaces, twigPath ->
            "Foo".equals(twigPath.getNamespace()) && "/src/Resources/views".equals(twigPath.getPath()))
        );
    }
}