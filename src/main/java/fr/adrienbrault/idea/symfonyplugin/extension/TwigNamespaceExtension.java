package fr.adrienbrault.idea.symfonyplugin.extension;

import fr.adrienbrault.idea.symfonyplugin.templating.path.TwigPath;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 */
public interface TwigNamespaceExtension {
    @NotNull
    Collection<TwigPath> getNamespaces(@NotNull TwigNamespaceExtensionParameter parameter);
}
