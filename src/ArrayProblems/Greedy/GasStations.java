package ArrayProblems.Greedy;

public class GasStations {
    public static void main(String[] args) {

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentPetrol=0,prevPetrol=0,result=0;
        for(int i=0;i<gas.length;i++){

            currentPetrol += (gas[i]-cost[i]);
            //check whether at any point our petrol reached a negative value

            if(currentPetrol <0){ // if it does
                result = i+1;
                // then all previous index will not yield result as our petrol reaches negative value hence //result will be atleast greater than index at which petrol is negative
                prevPetrol+=currentPetrol;  // our current petrol is added to previous petrol
                currentPetrol = 0; // current petrol becomes zero
            }
        }
        return (currentPetrol+prevPetrol) >= 0 ? result : -1; // here if current petrol and all previous sum of pterol yields atleast 0 we return index

    }
}
