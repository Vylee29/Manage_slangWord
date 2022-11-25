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
        this.setSize(1315,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionLis ac = new actionLis(this,sl);

        jText1 = new JTextField("Searching anything at here =)))",30);
        jText2 = new JTextField(30);
        jText2.setText("        \uD835\uDCD7\uD835\uDCEA\uD835\uDCFF\uD835\uDCEE \uD835\uDCEA \uD835\uDCF0\uD835\uDCF8\uD835\uDCF8\uD835\uDCED \uD835\uDCED\uD835\uDCEA\uD835\uDD02 ⋆ ˚｡⋆\uD83D\uDC8C⋆ ˚⋆˶ᵔ ᵕ ᵔ˶ ა");
        jText2.setFont(new Font( "SansSerif", Font.BOLD,25));
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
        JButton jButton_Edit = new JButton("Edit");
        JButton jButton_Random = new JButton("Random For A Day");
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

        jButton_Edit.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_Edit.setBackground(new Color(0x2dce98));
        jButton_Edit.setForeground(Color.white);
        jButton_Edit.addActionListener(ac);

        jButton_Random.setFont(new Font("Lato", Font.PLAIN, 14));
        jButton_Random.setBackground(new Color(0x2dce98));
        jButton_Random.setForeground(Color.white);
        jButton_Random.addActionListener(ac);

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
        jPanel_footer.setLayout(new GridLayout(2,4,1,1));
        jPanel_footer.add(jButton_Add);
        jPanel_footer.add(jButton_Delete);
        jPanel_footer.add(jButton_History);
        jPanel_footer.add(jButton_Reset);
        jPanel_footer.add(jButton_Edit);
        jPanel_footer.add(jButton_Random);
        jPanel_footer.add(jButton_QuizWord);
        jPanel_footer.add(jButton_QuizDef);
        jPanel_footer.setPreferredSize(new Dimension(650,0));
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
                str += i + " ";
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
    public void reset(slangWords sl) throws IOException {
        sl.resetList();
    }
    public void edit(slangWords sl){
        String newSlangWordKey = new String();
        String newSlangWordVal = new String();
        String[] key;
        String val = jText3.getText();
        ArrayList<String> newVal = new ArrayList<String>();
        if (val.length() > 1) {
            if (val.contains(" ")) {
                key = val.split(" ");
                newSlangWordKey = key[0];
                newSlangWordVal = key[1];
                newVal.add(newSlangWordVal);
            }
            sl.editSlang(newSlangWordKey, newVal);
        }
    }
    public void random(slangWords sl){
        Object key = sl.randomSlangWord();
        String newRand = "On this day slang word is:(˵ •̀ ᴗ - ˵ )˚*" +" "+ key.toString() +" "+sl.getSlangWord().get(key).toString();
        jText2.setFont(new Font( "Arial", Font.ITALIC,19));
        jText2.setHorizontalAlignment(JTextField.CENTER);
        jText2.setText(newRand);
    }
    public void setBackGrond (JButton j1,JButton j2,JButton j3,JButton j4 ){
        j1.setBackground(Color.blue);
        j1.setForeground(Color.YELLOW);
        j2.setBackground(Color.blue);
        j2.setForeground(Color.YELLOW);
        j3.setBackground(Color.blue);
        j3.setForeground(Color.YELLOW);
        j4.setBackground(Color.blue);
        j4.setForeground(Color.YELLOW);
    }
    public void quizKeyWord (slangWords sl)
    {   JButton ans1 = new JButton();
        JButton ans2= new JButton();
        JButton ans3= new JButton();
        JButton ans4= new JButton();
        Object key = sl.randomSlangWord();
        String ques = key.toString();
        JTextField quesText = new JTextField();
        quesText.setText(ques);
        quesText.setHorizontalAlignment(JTextField.CENTER);
        quesText.setForeground(Color.RED);
        quesText.setFont(new Font("Arial",3,40));

        Random generator = new Random();
        int value = generator.nextInt(4) + 1;
        System.out.println(value);
        JFrame frame = new JFrame();
        frame.setTitle("Quizzie Slang Words");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setSize(700,500);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel ans = new JPanel(new GridLayout(2,2));
        if(value==1) {
            ans1.setText(sl.getSlangWord().get(key).toString());
            ans2.setText(sl.randomSlangDef().toString());
            ans3.setText(sl.randomSlangDef().toString());
            ans4.setText(sl.randomSlangDef().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }
        else if (value==2) {
            ans2.setText(sl.getSlangWord().get(key).toString());
            ans1.setText(sl.randomSlangDef().toString());
            ans3.setText(sl.randomSlangDef().toString());
            ans4.setText(sl.randomSlangDef().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }
        else if (value==3) {
            ans3.setText(sl.getSlangWord().get(key).toString());
            ans1.setText(sl.randomSlangDef().toString());
            ans2.setText(sl.randomSlangDef().toString());
            ans4.setText(sl.randomSlangDef().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }
        else if (value==4) {
            ans4.setText(sl.getSlangWord().get(key).toString());
            ans1.setText(sl.randomSlangDef().toString());
            ans2.setText(sl.randomSlangDef().toString());
            ans3.setText(sl.randomSlangDef().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }

        if(value==1) {
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }
        else if (value==2) {
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }
        else if (value==3) {
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }
        else if (value==4) {
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }

        panel.add(quesText,BorderLayout.CENTER);
        panel.add(ans, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }
    public void quizDefWord(slangWords sl){
        JButton ans1 = new JButton();
        JButton ans2= new JButton();
        JButton ans3= new JButton();
        JButton ans4= new JButton();
        Object val = sl.randomSlangDef();
        String ques = val.toString();
        JTextField quesText = new JTextField();
        quesText.setText(ques);
        quesText.setHorizontalAlignment(JTextField.CENTER);
        quesText.setForeground(Color.RED);
        quesText.setFont(new Font("Arial",3,40));

        Random generator = new Random();
        int value = generator.nextInt(4) + 1;
        System.out.println(value);
        JFrame frame = new JFrame();
        frame.setTitle("Quizzie Slang Words");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setSize(700,500);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel ans = new JPanel(new GridLayout(2,2));
        String res = new String();
        for(String key : sl.getSlangWord().keySet()){
            if(sl.getSlangWord().get(key).equals(val)){
                res=key;
            }
        }
        if(value==1) {
            ans1.setText(res);
            ans2.setText(sl.randomSlangWord().toString());
            ans3.setText(sl.randomSlangWord().toString());
            ans4.setText(sl.randomSlangWord().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }
        else if (value==2) {
            ans2.setText(res);
            ans1.setText(sl.randomSlangWord().toString());
            ans3.setText(sl.randomSlangWord().toString());
            ans4.setText(sl.randomSlangWord().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }
        else if (value==3) {
            ans3.setText(res);
            ans1.setText(sl.randomSlangWord().toString());
            ans2.setText(sl.randomSlangWord().toString());
            ans4.setText(sl.randomSlangWord().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }
        else if (value==4) {
            ans4.setText(res);
            ans1.setText(sl.randomSlangWord().toString());
            ans2.setText(sl.randomSlangWord().toString());
            ans3.setText(sl.randomSlangWord().toString());
            setBackGrond(ans1,ans2,ans3,ans4);
            ans.add(ans1);
            ans.add(ans2);
            ans.add(ans3);
            ans.add(ans4);
        }

        if(value==1) {
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();               }
            });
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }
        else if (value==2) {
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();
                   }
            });
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }
        else if (value==3) {
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }
        else if (value==4) {
            ans4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Congratulations \uD83C\uDF89. You're right!!");
                    frame.setVisible(false);
                    frame.dispose();       }
            });
            ans2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
            ans1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Wrong \uD83D\uDE22...");
                }
            });
        }

        panel.add(quesText,BorderLayout.CENTER);
        panel.add(ans, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void createAndShowGui() throws IOException {
        new gui();
    }

}
