// Fancy Sequence 
class Fancy {
    private static final int mod = 1000000007;
    private ArrayList<Long> val;
    private long a,b;
   
    public Fancy() {
        val = new ArrayList<>();
        a = 1;
        b = 0;
    }

    private long modPow(long x , long y , long  mod) {
        long res = 1;
        x = x % mod;
        while(y > 0) {
            if(y % 2 == 1) {
                res = (res * x) % mod;
            }
            y = y / 2;
            x = (x * x) % mod;
        }
        return res;
    }

    public void append(int val) {
        long x = (val - b + mod) % mod;
        this.val.add((x * modPow(a , mod - 2 , mod)) % mod);
    }

    public void addAll(int inc) {
        b = (b + inc) % mod;
    }

    public void multAll(int m) {
        a = (a * m) % mod;
        b = (b * m) % mod;
    }
    
    public int getIndex(int idx) {
        if(idx >= val.size())
        return -1;
        return (int)((a * val.get(idx) + b) % mod);
    }
}
    

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */