import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class gui extends JFrame {
    private  JTextField jText2;
    private slangWords slangWords;
    private JTextField jText1;

    public gui() throws HeadlessException {
        this.slangWords = new slangWords();
        this.init();
    }
    private void init(){
        this.setTitle("Slang Words Dictionary");
        this.setSize(770,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionLis ac = new actionLis(this);

        jText1 = new JTextField(30);
        jText2 = new JTextField(50);
        jText2.setHorizontalAlignment(JTextField.CENTER);

        JButton jButton_Word = new JButton("Search by word");
        JButton jButton_Definition = new JButton("Search by definition");
        JButton jButton_Add = new JButton("Add");
        JButton jButton_Delete = new JButton("Delete");
        JButton jButton_History = new JButton("History");
        JButton jButton_Reset = new JButton("Reset List");
        JButton jButton_QuizWord = new JButton("Quiz word");
        JButton jButton_QuizDef = new JButton("Quiz definition");
        jButton_Word.setFont(new Font("Lato", Font.ITALIC, 14));
        jButton_Word.setBackground(new Color(0xf935ae));
        jButton_Word.setForeground(Color.black);
        jButton_Word.addActionListener(ac);

        jButton_Definition.setFont(new Font("Lato", Font.ITALIC, 14));
        jButton_Definition.setBackground(new Color(0xf935ae));
        jButton_Definition.setForeground(Color.black);
        jButton_Definition.addActionListener(ac);



        jButton_Add.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_Add.setBackground(new Color(0x2dce98));
        jButton_Add.setForeground(Color.white);
        jButton_Add.addActionListener(ac);

        jButton_Delete.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_Delete.setBackground(new Color(0x2dce98));
        jButton_Delete.setForeground(Color.white);
        jButton_Delete.addActionListener(ac);

        jButton_History.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_History.setBackground(new Color(0x2dce98));
        jButton_History.setForeground(Color.white);
        jButton_History.addActionListener(ac);

        jButton_Reset.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_Reset.setBackground(new Color(0x2dce98));
        jButton_Reset.setForeground(Color.white);
        jButton_Reset.addActionListener(ac);

        jButton_QuizWord.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_QuizWord.setBackground(new Color(0x2dce98));
        jButton_QuizWord.setForeground(Color.white);
        jButton_QuizWord.addActionListener(ac);

        jButton_QuizDef.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_QuizDef.setBackground(new Color(0x2dce98));
        jButton_QuizDef.setForeground(Color.white);
        jButton_QuizDef.addActionListener(ac);

        JPanel jPanel_head2 = new JPanel();
        jPanel_head2.setLayout(new GridLayout(0,2));
        jPanel_head2.add(jButton_Word);
        jPanel_head2.add(jButton_Definition);
        JPanel jPanel_head = new JPanel();
        jPanel_head.setLayout(new BorderLayout());
        jPanel_head.add(jText1,BorderLayout.CENTER);
        jPanel_head.add(jPanel_head2,BorderLayout.SOUTH);


        JPanel jPanel_footer = new JPanel();
        jPanel_footer.setLayout(new GridLayout(0,3,1,1));
        jPanel_footer.add(jButton_Add);
        jPanel_footer.add(jButton_Delete);
        jPanel_footer.add(jButton_History);
        jPanel_footer.add(jButton_Reset);
        jPanel_footer.add(jButton_QuizWord);
        jPanel_footer.add(jButton_QuizDef);
        jPanel_footer.setPreferredSize(new Dimension(375,0));
        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());
        jPanel_center.add(jText2,BorderLayout.CENTER);
        jPanel_center.add(jPanel_footer,BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(jPanel_head,BorderLayout.NORTH);
        this.add(jPanel_center,BorderLayout.CENTER);

        this.setVisible(true);
    }
    public void resetPage(){
        this.jText1.setText("");
    }
    public void searchSlangWord (slangWords sl)  {
        //sl.readFile();
        String str="Its definition is:";
        String val = jText1.getText();
        ArrayList<String> res = sl.findSlangWord(val);
        if(res==null){
            JOptionPane.showMessageDialog(this,
                    "Can not find this slang word",
                    "ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            resetPage();
        }
        else {
            for (String i : res) {
                str += i + ", ";
            }
            //this.jText1.setText(str + "with key " + val);
            JOptionPane.showMessageDialog(this,
                    str + "with key " + val,
                    "Check & Confirm", JOptionPane.QUESTION_MESSAGE);
            resetPage();
        }
    }

    public void searchSlangDef (slangWords sl)  {
        //sl.readFile();
        String str="Its key is:";
        String val = jText1.getText();
        ArrayList<String> res = sl.findWithDef(val);
        if(res==null){
            JOptionPane.showMessageDialog(this,
                    "Can not find this slang word",
                    "ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            resetPage();
        }
        else {
            for (String i : res) {
                str += i + " ";
            }
            //this.jText1.setText(str + "with definition " + val);
            JOptionPane.showMessageDialog(this,
                    str + "with definition " + val,
                    "Check & Confirm", JOptionPane.QUESTION_MESSAGE);
            resetPage();
        }

    }
    public static void createAndShowGui() {
        new gui();
    }
    public static void main(String[] args)  {
        createAndShowGui();


    }
}
