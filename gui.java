import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class gui extends JFrame {
    private  JTextField jText2;
    private JTextField jText1;
    private  JTextField jText3;
    private slangWords sl ;
    public gui() throws HeadlessException, IOException {
         this.sl = new slangWords();
        this.sl.readFile();

        this.init();
    }
    private void init(){
        this.setTitle("Slang Words Dictionary");
        this.setSize(770,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionLis ac = new actionLis(this,sl);

        jText1 = new JTextField("Searching anything at here =)))",30);
        jText2 = new JTextField(30);
        jText2.setText(" \uD835\uDCD7\uD835\uDCEA\uD835\uDCFF\uD835\uDCEE \uD835\uDCEA \uD835\uDCF0\uD835\uDCF8\uD835\uDCF8\uD835\uDCED \uD835\uDCED\uD835\uDCEA\uD835\uDD02 ⋆ ˚｡⋆\uD83D\uDC8C⋆ ˚⋆˶ᵔ ᵕ ᵔ˶ ა");
        jText2.setFont(new Font( "SansSerif", Font.BOLD,20));
        jText2.setEditable(false);
        jText3 = new JTextField("Input some elements in here and choose utility you want :* <3 ",50);


        jText1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(jText1.getText().equals("Searching anything at here =)))"))
                {
                    jText1.setText("");
                    repaint();
                    revalidate();
                }
            }
        });
        jText3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(jText3.getText().equals("Input some elements in here and choose utility you want :* <3 "))
                {
                    jText3.setText("");
                    repaint();
                    revalidate();
                }
            }
        });
        JPanel jText = new JPanel(new BorderLayout());
        jText.add(jText2,BorderLayout.CENTER);
        jText.add(jText3,BorderLayout.SOUTH);
        JButton jButton_Word = new JButton("Search by word");
        JButton jButton_Definition = new JButton("Search by definition");
        JButton jButton_Add = new JButton("Add");
        JButton jButton_Delete = new JButton("Delete");
        JButton jButton_History = new JButton("History");
        JButton jButton_Reset = new JButton("Reset List");
        JButton jButton_QuizWord = new JButton("Quiz word");
        JButton jButton_QuizDef = new JButton("Quiz definition");
        jButton_Word.setFont(new Font("Lato", Font.BOLD, 14));
        jButton_Word.setBackground(new Color(0x032d83));
        jButton_Word.setForeground(Color.yellow);
        jButton_Word.addActionListener(ac);

        jButton_Definition.setFont(new Font("Lato", Font.BOLD, 14));
        jButton_Definition.setBackground(new Color(0x032d83));
        jButton_Definition.setForeground(Color.yellow);
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
        jPanel_center.add(jText,BorderLayout.CENTER);
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
                    "Can not find",
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
                    "Can not find",
                    "ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            resetPage();
        }
        else {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] name = {"Definition"};
            String[] arr = res.toArray(new String[res.size()]);
            String[][]result= new String[arr.length][arr.length];
            for(int i=0;i< arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    result[i][j]=arr[i];
                }
            }
            JTable table = new JTable(result,name);
            JPanel panel = new JPanel(new BorderLayout());
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
            frame.add(panel);
            frame.setLocationByPlatform(true);
            frame.setSize(700,500);
            frame.setVisible(true);
        }

    }
    public void showHistoryList(slangWords sl){
        String str="Your history list: ";
        sl.takeHistoryList();
        ArrayList<String> arr = sl.takeHistoryList();
        for(String i:arr) {
            str += i + " ";
        }
        //this.jText2.setText(str);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] name = {"History List"};
        String[] res = arr.toArray(new String[arr.size()]);
        String[][]result= new String[res.length][res.length];
        for(int i=0;i< res.length;i++){
            for(int j=0;j<res.length;j++){
                result[i][j]=res[i];
            }
        }
        JTable table = new JTable(result,name);
        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel);
        frame.setLocationByPlatform(true);
        frame.setSize(700,500);
        frame.setVisible(true);
    }
    public void addNewSlang (slangWords sl) {
        JFrame j = new JFrame();
        String option = JOptionPane.showInputDialog(j, "You choose 1 (overwrite) or 2 (duplicate) ");
        System.out.println(option);
        String newSlangWordKey = new String();
        String newSlangWordVal = new String();
        String val = jText3.getText();
        String[] key;
        ArrayList<String> newVal = new ArrayList<String>();
        if (val.length() > 1) {
            if (val.contains(" ")) {
                key = val.split(" ");
                newSlangWordKey = key[0];
                newSlangWordVal = key[1];
                newVal.add(newSlangWordVal);
            }
            sl.addNewSlang(newSlangWordKey, newVal, option);
        }
    }
    public void deleteSlang(slangWords sl){
        JFrame j = new JFrame();
        String option = JOptionPane.showInputDialog(j, "You choose Yes (Delete) or No (Cancel) ");
        System.out.println(option);
        String delSlangWordKey = new String();
        String delSlangWordVal = new String();
        String val = jText3.getText();
        String[] key;
        ArrayList<String> delVal = new ArrayList<String>();
        if (val.length() > 1) {
            if (val.contains(" ")) {
                key = val.split(" ");
                delSlangWordKey = key[0];
                delSlangWordVal = key[1];
                delVal.add(delSlangWordVal);
            }
            sl.deleteSlang(delSlangWordKey, delVal, option);
        }
    }
    public void reset(slangWords sl)
    {
        sl.resetList();
    }


    public static void createAndShowGui() throws IOException {
        new gui();
    }
    public static void main(String[] args) throws IOException {
        createAndShowGui();
    }
}
