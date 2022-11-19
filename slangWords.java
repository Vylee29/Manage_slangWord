import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class slangWords {
    private static HashMap<String, ArrayList<String>> slangWord;
    private ArrayList<String> historyList;

    public slangWords() {
        this.slangWord = new HashMap<String, ArrayList<String>>();
        this.historyList=new ArrayList<String>();
    }

    private static void getKeys(String value) {

        for (HashMap.Entry<String, ArrayList<String>> entry : slangWord.entrySet()) {
            if (entry.getValue().contains(value)) {
                System.out.println(entry.getKey());
            }
        }
    }

    public HashMap<String, ArrayList<String>> getSlangWord() {
        return slangWord;
    }

    public void setSlangWord(HashMap<String, ArrayList<String>> slangWord) {
        this.slangWord = slangWord;
    }

    public void readFile() throws IOException {
        String[] word;
        String[] def;
        BufferedReader br = new BufferedReader(new FileReader("slang.txt"));
        String str;
        while (true) {
            ArrayList<String> listSlang = new ArrayList<String>();
            str = br.readLine();
            if (str == null) {
                break;
            }
            word = str.split("`");
            if (word.length > 1) {
                if (word[1].contains("|")) {
                    def = word[1].split("\\| ");
                    for (String s : def) {
                        listSlang.add(s);
                    }
                    slangWord.put(word[0], listSlang);
                } else if (word[1].contains("\n")) {
                    def = word[1].split("\\r?\\n");
                    for (String s : def) {
                        listSlang.add(s);
                    }
                    slangWord.put(word[0], listSlang);
                } else {
                    listSlang.add(word[1]);
                    slangWord.put(word[0], listSlang);
                }
            }
        }
    }

    public void findSlangWord() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input slang word you want:");
        String slangKey = sc.nextLine();
        historyList.add(slangKey);
        if (slangWord.containsKey(slangKey)) {
            System.out.println("The Value is: " + slangWord.get(slangKey) + " of key " + slangKey);
        }
    }
    public void findWithDef() throws IOException {
        System.out.print("Input slang definition you want:");
        Scanner sc = new Scanner(System.in);
        String slangDef = sc.nextLine();
        historyList.add(slangDef);
        getKeys(slangDef);

    }
    public void takeHistoryList() {
        if(historyList==null)
            return;
        for(String i:historyList){
            System.out.println(i);
        }
    }
}


