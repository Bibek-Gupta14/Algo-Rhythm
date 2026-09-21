class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current_gas = 0;
        int current_cost = 0;
        int count = 0;

        for(int i=0; i<gas.length; i++) {
            //sum of both the arrays
            current_gas += gas[i];
            current_cost += cost[i];
        }

        if(current_gas < current_cost) return -1;

        int fuel = 0; // track the fuel at ith index
        for(int i=0; i<gas.length; i++) {
            // fuel + remaining (gas - cost)
            fuel += (gas[i] - cost[i]);
            if(fuel < 0) {
                //reset the fuel from zero and inc. the count
                fuel = 0;
                count = i+1;
            }
        }
        return count;

    }
}