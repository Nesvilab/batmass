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
package umich.ms.batmass.gui.examples.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 * It is important to register actions not in Actions/CookieClass/SubMenu,
 * but in CookieClass/SubMenu - a .shadow file is automatically generated by
 * NetBeans in Actions/CookieClass/SubMenu then.
 * @author dmitriya
 */
//@ActionID(
//    category = "LCMSFileDesc/View",
//    id = "umich.ms.batmass.gui.lcmsfileactions.ViewChromatogramAction")
//@ActionRegistration(
//    displayName = "#CTL_ViewChromatogramAction",
//    iconBase = "umich/ms/batmass/gui/resources/view_chromatogram_16.png"
//)
//@ActionReference(
//    path = "BatMass/Actions/Files/Categories/" + NodeFactoryLCMSFiles.TYPE,
//    position=50)
//@Messages("CTL_ViewChromatogramAction=Chromatogram")
public class ViewChromatogramAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String msg = "should launch chromatogram view";
        NotifyDescriptor d = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }

}
