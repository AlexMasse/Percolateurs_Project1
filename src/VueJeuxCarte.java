import javax.swing.*;

/**
 * Created by Alexandre on 2014-10-06.
 */
public class VueJeuxCarte {

    private JPanel jPanel;

    public VueJeuxCarte(int i, int j) {
        jPanel = new JPanel();
        jPanel.setSize(i, j);
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
