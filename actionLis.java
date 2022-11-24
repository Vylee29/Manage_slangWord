import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class actionLis implements ActionListener {
    private gui Gui;
    private slangWords sl ;
    public actionLis (gui Gui,slangWords sl ) {
        this.Gui = Gui;
        this.sl=sl;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Button pressed!");
            String src = e.getActionCommand();
            if(src.equals("Search by word")){
                Gui.searchSlangWord(sl);
            }
            else if (src.equals("Search by definition")) {
                Gui.searchSlangDef(sl);
            }
            else if (src.equals("History")) {
                Gui.showHistoryList(sl);
            }
            else if (src.equals("Add")) {
                Gui.addNewSlang(sl);
            }
            else if (src.equals("Delete")) {
                Gui.deleteSlang(sl);
            }
            else if (src.equals("Reset List")) {
                Gui.reset(sl);
            }
            else if (src.equals("Quiz word")) {
                Gui.quizKeyWord(sl);
            }

    }

}
