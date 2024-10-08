package OOP.ec29906.A7.contributions;// If your code uses libraries, be sure to include the necessary
// import lines in your file Candidate_/un/.java
import java.util.Random;

class Candidate_ec21494 extends Candidate {
    
    public String getName() {
        return "Hussam Khan";
    }
    
    public String getSlogan() {
        return "BlackPink in your area!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // First search for self on the list of candidates.
        for (Candidate c : candidates)
            if (c.getName().equals("Hussam Khan"))
                return c;
        
        // Otherwise, default to ramdom candidate on list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of this class.
        if (votes.length == 0) 
            return new Candidate_ec21494();
        
        // Default to first vote, but this will be over-written.
        Candidate currentWinner = votes[0];
        
        // Count the votes for each object in the array,
        // selecting one with the most.
        int highestCount = 0;
        for (Candidate c : votes) {
            
            int count = 0;
            for (Candidate x : votes)
                if (x == c)
                    count++;
            if (count >= highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }
        
        return currentWinner;
    }
    
}
