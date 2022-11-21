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
    private static ArrayList<String> getKeys(String value) {
        ArrayList<String> arr = new ArrayList<String>();
        for (HashMap.Entry<String, ArrayList<String>> entry : slangWord.entrySet()) {

                for(String i: entry.getValue()){
                    if(i.contains(value))
                        arr.add(entry.getKey());
                }
            }

        return arr;

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

    public ArrayList<String> findSlangWord(String slangKey) {
        historyList.add(slangKey);
        if (slangWord.containsKey(slangKey)) {
            //System.out.println("The Value is: " + slangWord.get(slangKey) + " of key " + slangKey);
            return slangWord.get(slangKey);
        }
        return null;
    }
    public ArrayList<String> findWithDef(String slangDef) {
        historyList.add(slangDef);
        return getKeys(slangDef);
    }
    public ArrayList<String> takeHistoryList() {
        if (historyList == null) {
            return null;
        }
        return historyList;
    }
    public void addNewSlang(String newSlangWordKey, ArrayList<String> newSlangWordValue,String num) {
        String str;
        if (slangWord.containsKey(newSlangWordKey)) {
            if (num.equals("1")) {
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
    public void deleteSlang(String newSlangWordKey, ArrayList<String> newSlangWordValue, String isConfirm) {
        if (slangWord.containsKey(newSlangWordKey))
            if (isConfirm.equals("yes")) {
                slangWord.remove(newSlangWordKey, newSlangWordValue);
                historyDelete.put(newSlangWordKey, newSlangWordValue);
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


