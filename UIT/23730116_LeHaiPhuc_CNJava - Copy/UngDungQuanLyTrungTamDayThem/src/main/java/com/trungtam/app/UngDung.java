package com.trungtam.app;
import com.formdev.flatlaf.FlatLightLaf;
import com.trungtam.ui.DangNhapForm;
import javax.swing.*;

public class UngDung {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(new FlatLightLaf()); } catch (Exception ignored){}
            new DangNhapForm().setVisible(true);
        });
    }
}
