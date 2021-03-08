import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args) {
        int dialogOptionYesNo = JOptionPane.YES_NO_OPTION;
        int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket","Warning", dialogOptionYesNo);
        JOptionPane.showMessageDialog(null, "You've chosen: "
        +(option == JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}
