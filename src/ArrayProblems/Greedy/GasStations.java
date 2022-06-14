package ArrayProblems.Greedy;

public class GasStations {
    public static void main(String[] args) {
//gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        int[]gas={1,2,3,4,5};
        int []cost={3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, surplus = 0, start = 0;
        for (int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return sum >= 0 ? start : -1;

    }
}
