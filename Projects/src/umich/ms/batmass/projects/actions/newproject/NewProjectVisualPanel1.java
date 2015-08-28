/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umich.ms.batmass.projects.actions.newproject;

import java.awt.Component;
import java.util.Collection;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.openide.util.Lookup;
import umich.ms.batmass.projects.core.type.BMProjectFactory;

public final class NewProjectVisualPanel1 extends JPanel {
    private final ListModel<BMProjectFactory> projectListModel;

    /**
     * Creates new form NewProjectVisualPanel1
     */
    public NewProjectVisualPanel1() {
        initComponents();
        listProjectTypes.setLayoutOrientation(JList.VERTICAL_WRAP);
        projectListModel = getProjectListModel();
        listProjectTypes.setModel(projectListModel);
        listProjectTypes.setVisibleRowCount(-1);
        listProjectTypes.setCellRenderer(new ProjectCellRenderer());
        listProjectTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLblText(listProjectTypes.getSelectedValue());
        listProjectTypes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                BMProjectFactory pf = listProjectTypes.getSelectedValue();
                setLblText(pf);
            }
        });
    }

    private void setLblText(BMProjectFactory pf) {
        if (pf != null) {
            lblProjectTypeDescription.setText(pf.getProjectTypeDescription());
        } else {
            lblProjectTypeDescription.setText("");
        }
    }

    @Override
    public String getName() {
        return "Choose project type";
    }

    private ListModel<BMProjectFactory> getProjectListModel() {
        DefaultListModel<BMProjectFactory> listModel = new DefaultListModel<>();

        Collection<? extends BMProjectFactory> factories = Lookup.getDefault().lookupAll(BMProjectFactory.class);
        for (BMProjectFactory factory : factories) {
            listModel.addElement(factory);
        }

        return listModel;
    }

    private static class ProjectCellRenderer implements ListCellRenderer<BMProjectFactory> {

        @Override
        public Component getListCellRendererComponent(JList<? extends BMProjectFactory> list, BMProjectFactory value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof BMProjectFactory) {
                BMProjectFactory pf = value;
                JLabel lbl = new JLabel();
                lbl.setOpaque(true);
                if (isSelected) {
                    lbl.setBackground(list.getSelectionBackground());
                    lbl.setForeground(list.getSelectionForeground());
                } else {
                    lbl.setBackground(list.getBackground());
                    lbl.setForeground(list.getForeground());
                }
                lbl.setHorizontalAlignment(SwingConstants.LEFT);
                lbl.setIcon(pf.getIcon());
                lbl.setText(pf.getProjectTypeName());
                lbl.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

                return lbl;
            }
            return new JLabel(value.toString());
        }
    }

    public JList<BMProjectFactory> getListProjectTypes() {
        return listProjectTypes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listProjectTypes = new javax.swing.JList<BMProjectFactory>();
        lblProjectTypeDescription = new javax.swing.JLabel();

        listProjectTypes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listProjectTypes);

        org.openide.awt.Mnemonics.setLocalizedText(lblProjectTypeDescription, org.openide.util.NbBundle.getMessage(NewProjectVisualPanel1.class, "NewProjectVisualPanel1.lblProjectTypeDescription.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProjectTypeDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProjectTypeDescription)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProjectTypeDescription;
    private javax.swing.JList<BMProjectFactory> listProjectTypes;
    // End of variables declaration//GEN-END:variables
}
