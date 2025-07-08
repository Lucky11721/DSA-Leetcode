class NumArray {
public:
     vector<int> ans;
     vector <int> num;
    NumArray(vector<int>& nums) {
        int size=nums.size();
        ans.resize(size);
        ans[0]=nums[0];
        for (int i=1;i<size;i++){
            ans[i]=ans[i-1]+nums[i];
        }
        num=nums;
    }
    
    void update(int index, int val) {
            int diff=val-num[index];
            num[index]=val;
            int size=ans.size();
            for (int i =index;i<size;i++){
                ans[i]+=diff;
            }
           
    }
    
    int sumRange(int left, int right) {
        if (left==0){
            return ans[right];
        }else {
            return ans[right]-ans[left-1];
        }
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */