class Bank {
    int N;
    long[] bank_account;
    public Bank(long[] balance) {
        N = balance.length +1;
        bank_account = new long[N];
        for(int i = 1 ; i < N; i++){
            bank_account[i]  = balance[i-1];
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 >= N  || account2 >= N) return false;
        if(money > bank_account[account1]) return false;

        if(money <= bank_account[account1]){
            bank_account[account1] = bank_account[account1] - money;
         bank_account[account2] = bank_account[account2] + money;
         return true;
        }

         return false;

    }
    
    public boolean deposit(int account, long money) {
        if(account >= N) return false;

        bank_account[account] += money;

        return true;
    }
    
    public boolean withdraw(int account, long money) {
          if(account >= N) return false;
          if(money > bank_account[account]) return false;

           bank_account[account] -= money;

           return true;
          
     }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */