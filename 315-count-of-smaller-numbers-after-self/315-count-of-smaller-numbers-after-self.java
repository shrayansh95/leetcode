class ArrayValueWithOriginalIndex {
    int val, idx;
    public ArrayValueWithOriginalIndex(int _val, int _idx) {
        this.val = _val;
        this.idx = _idx;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        
        ArrayValueWithOriginalIndex newNums[] = new 
            ArrayValueWithOriginalIndex[n];
        
        for (int i = 0; i < n; ++i) 
            newNums[i] = new ArrayValueWithOriginalIndex(nums[i], i);
        
        mergeSort(newNums, 0, n - 1, result);
        
        List<Integer> ans = new ArrayList<>();
        for (int it : result)
            ans.add(it);
        
        return ans;
    }
    
    private void mergeSort(ArrayValueWithOriginalIndex nums[], int start,
                          int end, int result[]) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        
        mergeSort(nums, start, mid, result);
        mergeSort(nums, mid + 1, end, result);
        
        merge(nums, start, mid, end, result);
    }
    
    private void merge(ArrayValueWithOriginalIndex nums[], int start,
                      int mid, int end, int result[]) {
        int i = start;
        int j = mid + 1;
        List<ArrayValueWithOriginalIndex> temp = new ArrayList<>();
        int cnt = 0;
        while (i <= mid && j <= end) {
            if (nums[i].val > nums[j].val) {
                temp.add(nums[j]);
                ++j;
                ++cnt;
            } else {
                result[nums[i].idx] += cnt;
                temp.add(nums[i]);
                ++i;
            }
        }
        
        while (i <= mid) {
            result[nums[i].idx] += cnt;
            temp.add(nums[i]);
            ++i;
        }
        
        while (j <= end) {
            temp.add(nums[j]);
            ++j;
        }
        
        int k = start;
        for (ArrayValueWithOriginalIndex it : temp)
            nums[start++] = it;
    }
}