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
package umich.ms.batmass.gui.nodes.actions.files.lcms;

import javax.swing.Action;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import umich.ms.batmass.filesupport.core.spi.nodes.NodeInfo;
import umich.ms.batmass.nbputils.nodes.NodeSubmenu;

/**
 *
 * @author Dmitry Avtonomov
 */
@ActionID(
        category = "BatMass/Nodes",
        id = "umich.ms.batmass.gui.nodes.actions.files.lcms.SubmenuView")
@ActionRegistration(
        displayName = "#CTL_SubmenuView",
        lazy = false
)
@ActionReferences({
    @ActionReference(
            path = NodeInfo.ACTIONS_LAYER_PATH_BASE + "/batmass-project-any/batmass-type-any/lcms",
            position = 100
    )
})
@NbBundle.Messages("CTL_SubmenuView=View")
public class SubmenuView extends NodeSubmenu {
    @StaticResource
    private static final String ICON_PATH = "umich/ms/batmass/gui/resources/eye_16.png";
    public static final ImageIcon ICON = ImageUtilities.loadImageIcon(ICON_PATH, false);

    public SubmenuView() {
        putValue(Action.SMALL_ICON, ICON);
    }


    @Override
    public String getDisplayName() {
        return Bundle.CTL_SubmenuView();
    }

    @Override
    public String getLayerPath() {
        return NodeInfo.ACTIONS_LAYER_PATH_BASE + "/batmass-project-any/batmass-type-any/lcms/view";
    }

}
