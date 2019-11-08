package fr.adrienbrault.idea.symfonyplugin.config.xml;

import com.intellij.psi.PsiElement;
import fr.adrienbrault.idea.symfonyplugin.dic.AbstractServiceReference;
import org.jetbrains.annotations.NotNull;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 */
public class ServiceXmlReference extends AbstractServiceReference {

    public ServiceXmlReference(@NotNull PsiElement element, String serviceId) {
        super(element);
        this.serviceId = serviceId;
    }


    @NotNull
    public Object[] getVariants() {
        // dont support in xml
        return new Object[0];
    }
}
