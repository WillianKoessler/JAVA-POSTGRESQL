package Utils;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class DocFilter extends javax.swing.text.DocumentFilter {
    int limit;
    public DocFilter(){
        super();
        this.limit = 10;
    }
    
    public DocFilter(int limit){
        super();
        this.limit = limit;
    }
    
    @Override
    public void insertString(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, String string,AttributeSet attr) throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.insert(offset, string);

      if (test(sb.toString()) && doc.getLength() < limit) {
         super.insertString(fb, offset, string, attr);
      } else {
         JOptionPane.showMessageDialog(null, "This field only accepts numbers.");
      }
   }
   private boolean test(String text) {
      try {
         Integer.parseInt(text);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
   @Override
   public void replace(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length, String text,AttributeSet attrs) throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);

      if (test(sb.toString()) && doc.getLength() < limit) {
         super.replace(fb, offset, length, text, attrs);
      }
   }
   @Override
   public void remove(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.delete(offset + 1, offset + length);

      if (test(sb.toString())) {
         super.remove(fb, offset, length);
      }
   }
}
