import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatLightLaf;
import view.LoginFrame;

public class App {

    public static void main(String[] args) {

        // Set Look and Feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Jalankan aplikasi dari LOGIN (2-TIER)
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}