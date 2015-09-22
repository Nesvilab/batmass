/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umich.ms.batmass.projects.core.annotations.processors;

import java.util.Set;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import org.openide.filesystems.annotations.LayerBuilder;
import org.openide.filesystems.annotations.LayerGeneratingProcessor;
import org.openide.filesystems.annotations.LayerGenerationException;
import org.openide.util.lookup.ServiceProvider;
import umich.ms.batmass.nbputils.LayerUtils;
import umich.ms.batmass.projects.core.annotations.LayerInstance;
import umich.ms.batmass.projects.core.annotations.LayerRegistration;

/**
 * @deprecated use {@link LayerRegistration} annotation, for which
 * {@link LayerRegistrationProcessor} will be used. These annotations are
 * exactly similar.
 * @author dmitriya
 */
@ServiceProvider(service = Processor.class)
@SupportedAnnotationTypes("umich.ms.batmass.projects.core.annotations.LayerInstance.Registration")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@Deprecated
public class LayerInstanceRegistrationProcessor extends LayerGeneratingProcessor {

    @Override
    protected boolean handleProcess(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) throws LayerGenerationException {
        
        Elements elements = processingEnv.getElementUtils();
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(LayerInstance.Registration.class);
        for (Element e : elementsAnnotatedWith) {
            TypeElement clazz = (TypeElement) e;
            LayerInstance.Registration annotation = clazz.getAnnotation(LayerInstance.Registration.class);
            String teName = elements.getBinaryName(clazz).toString();

            String[] paths = annotation.paths();
            for (String path : paths) {
                String fileName = LayerUtils.getLayerFriendlyInstanceName(teName);
                path = LayerUtils.getLayerPath(path, fileName);
                
                LayerBuilder.File f = layer(e)
                    .file(path)
                    .position(annotation.position());
                f.write();
            }
        }
        return true;
    }

}