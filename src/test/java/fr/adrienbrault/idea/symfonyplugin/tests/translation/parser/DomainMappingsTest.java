package fr.adrienbrault.idea.symfonyplugin.tests.translation.parser;

import fr.adrienbrault.idea.symfonyplugin.translation.dict.DomainFileMap;
import fr.adrienbrault.idea.symfonyplugin.translation.parser.DomainMappings;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


public class DomainMappingsTest extends Assert {

    @Test
    public void testParser() throws FileNotFoundException {
        File testFile = new File("src/test/java/fr/adrienbrault/idea/symfonyplugin/tests/translation/parser/appDevDebugProjectContainer.xml");

        DomainMappings bla = new DomainMappings();
        bla.parser(new FileInputStream(testFile));
        List<DomainFileMap> map = bla.getDomainFileMaps();

        assertEquals(10, map.size());

        DomainFileMap firstDomain = map.iterator().next();

        assertEquals("CraueFormFlowBundle", firstDomain.getDomain());
        assertEquals("de", firstDomain.getLanguageKey());
        assertEquals("yml", firstDomain.getLoader());
        assertTrue(firstDomain.getPath().endsWith("CraueFormFlowBundle.de.yml"));

    }

}
