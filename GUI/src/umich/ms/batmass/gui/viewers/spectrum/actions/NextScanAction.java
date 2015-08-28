/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umich.ms.batmass.gui.viewers.spectrum.actions;

import java.awt.event.ActionEvent;
import java.lang.ref.WeakReference;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import org.netbeans.api.annotations.common.StaticResource;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import umich.ms.batmass.gui.viewers.spectrum.components.SpectraViewerComponent;
import umich.ms.batmass.nbputils.OutputWndPrinter;
import umich.ms.datatypes.scan.IScan;
import umich.ms.datatypes.scancollection.IScanCollection;

/**
 *
 * @author dmitriya
 */
public class NextScanAction extends AbstractAction {
    @StaticResource
    final static String ICON_PATH = "umich/ms/batmass/gui/viewers/spectrum/icons/icon_next_scan.png";
    final static String ACTION_ID = "NEXT_SCAN_ACTION";
    final static KeyStroke ACCELERATOR = Utilities.stringToKey("RIGHT");

    /**
     * This is a WeakRef because this action does not make any sense without
     * a viewer anyway.
     * So in case the viewer has been garbage collected and the
     * action is still in place, we'd better get NPE in actionPerformed() for debugging
     * purposes.
     */
    private final WeakReference<SpectraViewerComponent> viewerRef;

    public NextScanAction(SpectraViewerComponent viewer) {
        super(null);
        viewerRef = new WeakReference<>(viewer);

        KeyStroke accelKey = ACCELERATOR;
        putValue(Action.ACCELERATOR_KEY, accelKey);
        StringBuilder tooltip = new StringBuilder();
        tooltip.append(NbBundle.getMessage(NextScanAction.class, "NextScanAction.tooltip")); // NOI18N)
        tooltip.append(" (");
        tooltip.append(Utilities.keyToString(accelKey));
        tooltip.append(")");
        putValue(Action.SHORT_DESCRIPTION, tooltip.toString());
        ImageIcon icon = ImageUtilities.loadImageIcon(ICON_PATH, false);
        putValue(Action.LARGE_ICON_KEY, icon);
        putValue(Action.SMALL_ICON, icon);
        putValue(Action.ACCELERATOR_KEY, Utilities.stringToKey("RIGHT"));
    }

    private SpectraViewerComponent getViewer() {
        return viewerRef.get();
    }

    /**
     * @return the value corresponding to {@link Action#SMALL_ICON} property of Action.
     */
    public static String getIconPath() {
        return ICON_PATH;
    }

    /**
     * @return the value, corresponding to {@link Action#NAME} property of Action.
     */
    public static String getActionID() {
        return ACTION_ID;
    }

    public static KeyStroke getAcceleratorKey() {
        return ACCELERATOR;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SpectraViewerComponent viewer = getViewer();

        IScan curScan = viewer.getScans().getScanByNum(viewer.getViewport().getScanNum());
        IScan nextScan;

        IScanCollection scans = viewer.getScans();
        int msLevelMaxAllowed = viewer.getMsLevelMaxAllowed();

        if (msLevelMaxAllowed == 1) {
            // this is a special case (MS1 limited view) just for speed
            nextScan = scans.getNextScanAtMsLevel(curScan.getNum(), 1);
        } else {
            do {
                nextScan = scans.getNextScan(curScan.getNum());
            } while (nextScan != null && nextScan.getMsLevel() > msLevelMaxAllowed);
        }

        if (nextScan == null) {
            OutputWndPrinter.printOut("DEBUG", "No further (next) scans available.");
            return;
        }

        int nextScanNum = nextScan.getNum();
        viewer.showSpectrum(nextScanNum);
    }
}
