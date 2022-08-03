class MyCalendar {
    TreeMap<Integer, Integer> bookings;
    public MyCalendar() {
        bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer low = bookings.lowerKey(start);
        if (low != null && bookings.get(low) > start) return false;
        Integer high = bookings.ceilingKey(start);
        if (high != null && high < end) return false;
        bookings.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */