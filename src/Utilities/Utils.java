package Utilities;

import java.awt.Window;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public enum pop {INFO, WARN, ERRO};
    public static void pop(String msg, pop severity){
        System.out.println(severity + " -> " + msg);
        switch(severity){
            case INFO: javax.swing.JOptionPane.showMessageDialog(null, msg,"", javax.swing.JOptionPane.INFORMATION_MESSAGE); break;
            case WARN: javax.swing.JOptionPane.showMessageDialog(null, msg,"", javax.swing.JOptionPane.WARNING_MESSAGE); break;
            case ERRO: javax.swing.JOptionPane.showMessageDialog(null, msg,"", javax.swing.JOptionPane.ERROR_MESSAGE); break;
        }
    }

    public static javax.swing.JPanel JTabbedPaneGetTabByTitle(javax.swing.JTabbedPane pane, String title) {
        for (int i = 0; i < pane.getTabCount(); i++) {
            if (title.equals(pane.getTitleAt(i))) {
                return (javax.swing.JPanel)pane.getTabComponentAt(i);
            }
        }
        return null;
    }

    public static <T extends java.awt.Component> T getAncestor(java.awt.Component obj, Class<T> target) {
        if (obj.getParent() != null) {
            if (target.equals(obj.getParent().getClass())) {
                return (T) obj.getParent();
            } else {
                return getAncestor(obj.getParent(), target);
            }
        }
        return null;
    }

    public static java.awt.Component getAncestor(java.awt.Component obj) {
        if (obj.getParent() != null) {
            return getAncestor(obj.getParent());
        }
        return obj;
    }

    public static void CloseWindow(javax.swing.JPanel panel) {
        if (panel != null) {
            ((Window) Utils.getAncestor(panel)).dispose();
        }
    }

    public static boolean isNull(String str) {
        return str == null || str.equals("");
    }

    public static boolean isNull(javax.swing.text.JTextComponent txtField) {
        return txtField == null || txtField.getText() == null || txtField.getText().equals("");
    }

    public static void Announce(String msg, javax.swing.JLabel announcement) {
        Announce(msg, announcement, getAncestor(announcement).getSize().width, getAncestor(announcement).getSize().height);
    }

    public static void Announce(String msg, javax.swing.JLabel announcement, int x, int y) {
        if (isNull(msg)) {
            return;
        }
        System.out.println(msg);
        String out = msg;
        msg = "<html><div align=center>" + out.replaceAll("\n", "<br>") + "<br>" + "</div></html>";
        Pattern pattern = Pattern.compile("<br>");
        Matcher matcher = pattern.matcher(msg);
        int count = 1;
        while (matcher.find()) {
            count++;
        }
        
        String noEnter = out.replaceAll("\n", " ");
        StringBuilder sb = new StringBuilder();
        int last, next = 0, word = 0, total = 0;
        for (int i = 0; i < noEnter.length(); i++) {
            int now = noEnter.indexOf(' ', i);
            now = now > 0 ? now : noEnter.length();
            if (now != next) {
                last = next;
                next = now;
                word = next - last + (last == 0 ? 0 : -1);
                total += word;
            }
            int nextWord = noEnter.indexOf(' ', i + 1) - now;
            if (total + nextWord > 20) {
                total = 0;
                sb.append('\n');
            }
            sb.append(noEnter.charAt(i));
        }

        pattern = Pattern.compile("<br>");
        matcher = pattern.matcher(msg);
        while (matcher.find()) {
            count++;
        }


        java.awt.Component root = getAncestor(announcement, javax.swing.JDialog.class);
        if (root != null) {
            root.setSize(x, y + (count * 15));
        }
        announcement.setText(msg);
        announcement.setVisible(true);
    }
}
