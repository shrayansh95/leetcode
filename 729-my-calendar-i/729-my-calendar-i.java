class MyCalendar {
    List<int[]> bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int it[] : bookings) 
            if (!(start >= it[1] || end <= it[0])) return false;
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */