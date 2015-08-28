/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umich.ms.batmass.filesupport.testing.custommimeresolver.pepxml;

import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.NbBundle.Messages;

@Messages({
    "LBL_PepXML_LOADER=Files of PepXML"
})
//@MIMEResolver.ExtensionRegistration(
//        displayName = "#LBL_PepXML_LOADER",
//        mimeType = "application/x-pep-xml",
//        extension = {"asd"}
//)
@DataObject.Registration(
        mimeType = "application/x-pep-xml",
        iconBase = "umich/ms/batmass/filesupport/testing/custommimeresolver/pepxml/msfile_open_spectrum_view_icon.gif",
        displayName = "#LBL_PepXML_LOADER",
        position = 300
)
@ActionReferences({
    @ActionReference(
            path = "Loaders/application/x-pep-xml/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300
    ),
    @ActionReference(
            path = "Loaders/application/x-pep-xml/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500
    ),
    @ActionReference(
            path = "Loaders/application/x-pep-xml/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600
    ),
    @ActionReference(
            path = "Loaders/application/x-pep-xml/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400
    )
})
public class PepXMLDataObject extends MultiDataObject {

    public PepXMLDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("application/x-pep-xml", false);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

}
