import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class slangWords {
    private static HashMap<String, ArrayList<String>> slangWord;
    private ArrayList<String> historyList;
    private HashMap<String, ArrayList<String>> historyAdd;
    private HashMap<String, ArrayList<String>> historyDelete;


    public slangWords() {
        this.slangWord = new HashMap<String, ArrayList<String>>();
        this.historyList = new ArrayList<String>();
        this.historyAdd = new HashMap<String, ArrayList<String>>();
        this.historyDelete = new HashMap<String, ArrayList<String>>();

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

    public void findSlangWord(String slangKey) {
        historyList.add(slangKey);
        if (slangWord.containsKey(slangKey)) {
            System.out.println("The Value is: " + slangWord.get(slangKey) + " of key " + slangKey);
        }
    }

    public void findWithDef(String slangDef) {
        historyList.add(slangDef);
        getKeys(slangDef);
    }

    public void takeHistoryList() {
        if (historyList == null)
            return;
        for (String i : historyList) {
            System.out.println(i);
        }
    }

    public void addNewSlang(String newSlangWordKey, ArrayList<String> newSlangWordValue) {
        int num;
        String str;
        Scanner sc = new Scanner(System.in);
        if (slangWord.containsKey(newSlangWordKey)) {
            System.out.println("This slang word is exists in dictionary!!!");
            System.out.println("You want overwrite or duplicate for new slang word ....?");
            System.out.print("Choose 1 (overwrite) or 2 (duplicate): ");
            num = sc.nextInt();
            if (num == 1) {
                slangWord.replace(newSlangWordKey, newSlangWordValue);
            } else {
                slangWord.put(newSlangWordKey, newSlangWordValue);
                historyAdd.put(newSlangWordKey, newSlangWordValue);
            }
        } else {
            slangWord.put(newSlangWordKey, newSlangWordValue);
            historyAdd.put(newSlangWordKey, newSlangWordValue);
        }

    }

    public void editSlang(String newSlangWordKey, ArrayList<String> newSlangWordValue) {
        if (slangWord.containsKey(newSlangWordKey))
            slangWord.replace(newSlangWordKey, newSlangWordValue);

    }

    public void deleteSlang(String newSlangWordKey, ArrayList<String> newSlangWordValue, Boolean isConfirm) {
        if (slangWord.containsKey(newSlangWordKey))
            if (isConfirm == true) {
                slangWord.remove(newSlangWordKey, newSlangWordValue);
                historyDelete.put(newSlangWordKey, newSlangWordValue);
                for (String i : slangWord.keySet()) {
                    System.out.println("key: " + i + " value: " + slangWord.get(i));
                }
            } else {
                return;
            }
    }

    public void resetList() {
        for (String i : historyAdd.keySet()) {
            if (slangWord.containsKey(i)) {
                slangWord.remove(i, historyAdd.get(i));
            }
        }

        for (String i : historyDelete.keySet()) {
            slangWord.put(i, historyDelete.get(i));

        }

    }

    public Object randomSlangWord() {
        Object[] slang = slangWord.keySet().toArray();
        String key = slang[new Random().nextInt(slang.length)].toString();
        System.out.println("************ Random Key ************ \n" + key);
        return key;
    }

    public Object randomSlangDef() {
        Object[] slang = slangWord.keySet().toArray();
        String key = slang[new Random().nextInt(slang.length)].toString();
        System.out.println("************ Random Value ************ \n" + slangWord.get(key));
        return slangWord.get(key);
    }

    public void quizSlangWord(String ques, String ans) {
        if (slangWord.get(ques).contains(ans)) {
            System.out.println("That's right!!!");
        } else {
            System.out.println("Wrong...");
        }
    }
}


