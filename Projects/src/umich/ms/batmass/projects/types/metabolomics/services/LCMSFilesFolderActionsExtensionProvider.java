/* 
 * Copyright 2016 Dmitry Avtonomov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package umich.ms.batmass.projects.types.metabolomics.services;

import umich.ms.batmass.projects.core.services.spi.ProjectSubfolderActionPathsProvider;
import umich.ms.batmass.projects.services.folderproviders.FolderProviderLCMSFiles;

/**
 * TODO: WARNINIG: ACHTUNG: Delete this class! Was here for testing.
 * @author Dmitry Avtonomov
 */
//@ProjectServiceProvider(
//        service = ProjectSubfolderActionPathsProvider.class,
//        projectType = {MetabolomicsProject.TYPE}
//)
public class LCMSFilesFolderActionsExtensionProvider implements ProjectSubfolderActionPathsProvider {

    @Override
    public Class<?> getClassType() {
        return FolderProviderLCMSFiles.class;
    }

    @Override
    public String[] getPaths() {
        return new String[]{"Some/Fake/Path1", "Some/Fake/Path2",};
    }
    
}