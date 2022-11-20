import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class actionLis implements ActionListener {
    private gui Gui;
    public actionLis (gui Gui) {
        this.Gui = Gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Button pressed!");
        slangWords sl = new slangWords();
        try {
            sl.readFile();
            String src = e.getActionCommand();
            if(src.equals("Search by word")){
                Gui.searchSlangWord(sl);
            }
            else if (src.equals("Search by definition")) {
                Gui.searchSlangDef(sl);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

}
