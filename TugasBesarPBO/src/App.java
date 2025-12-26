import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import view.MainFrame;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(MainFrame::new);
    }
}
