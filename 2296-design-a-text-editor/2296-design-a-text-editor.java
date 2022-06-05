class TextEditor {
    StringBuilder str;
    int cur;
    public TextEditor() {
        str = new StringBuilder();
        cur = 0;
    }
    
    public void addText(String text) {
        str.insert(cur, text);
        cur += text.length();
    }
    
    public int deleteText(int k) {
        int start = Math.max(cur - k, 0);
        str.delete(start, cur);
        int deleted = cur <= k ? cur : k;
        cur -= deleted;
        return deleted;
    }
    
    public String cursorLeft(int k) {
        cur = Math.max(0, cur - k);
        int idx = Math.max(0, cur - 10);
        return str.substring(idx, cur).toString();
    }
    
    public String cursorRight(int k) {
        cur = Math.min(str.length(), cur + k);
        int idx = Math.max(0, cur - 10);
        return str.substring(idx, cur).toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */