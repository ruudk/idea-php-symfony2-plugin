package fr.adrienbrault.idea.symfonyplugin.templating.variable.collector;

import fr.adrienbrault.idea.symfonyplugin.templating.variable.TwigFileVariableCollector;
import fr.adrienbrault.idea.symfonyplugin.templating.variable.TwigFileVariableCollectorParameter;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 */
public class StaticVariableCollector implements TwigFileVariableCollector {
    @Override
    public void collect(@NotNull TwigFileVariableCollectorParameter parameter, @NotNull Map<String, Set<String>> variables) {
        variables.put("app", new HashSet<>(Collections.singletonList("\\Symfony\\Bundle\\FrameworkBundle\\Templating\\GlobalVariables")));
    }
}
