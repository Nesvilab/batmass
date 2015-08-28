/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umich.ms.batmass.gui.viewers.treetable.components;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import umich.ms.batmass.gui.core.api.comm.dnd.DnDButton;
import umich.ms.batmass.gui.core.api.comm.eventbus.ViewerLinkSupport;
import umich.ms.batmass.gui.core.api.swing.BMToolBar;

/**
 *
 * @author Dmitry Avtonomov
 */
public class TreeTableToolbar extends BMToolBar {

    protected ViewerLinkSupport linkSupport;
    protected DnDButton btnLinkDnD;
    protected JButton btnUnlink;

    protected static final int toolbarBtnHSpacing = 3;

    @SuppressWarnings({"unchecked"})
    public TreeTableToolbar(ViewerLinkSupport linkSupport) {
        this.linkSupport = linkSupport;

        // Creating the toolbar
        setBorder(new EmptyBorder(0, toolbarBtnHSpacing, toolbarBtnHSpacing, toolbarBtnHSpacing));
        setFloatable(false);
        // make sure the toolbar can't get focus by itself
        setFocusable(false);
        setRollover(true);

        // Link button
        btnLinkDnD = linkSupport.getBtnLinkDnD();
        add(btnLinkDnD);
        add(Box.createHorizontalStrut(toolbarBtnHSpacing));


        // Unlink button
        btnUnlink = linkSupport.getBtnUnlink();
        add(btnUnlink);
        add(Box.createHorizontalStrut(toolbarBtnHSpacing));

        setActivated(false);
    }
}
