package OOP.ec29906.A7.contributions;// File Candidate_ec221148.java
//
// Machine generated stub for Assignment 2


class Candidate_ec221148 extends Candidate {
    
    public String getName() {
        return "Melek";
    }
    
    public String getSlogan() {
        return "In to Win";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        if (candidates.length == 0) {
            return new Candidate_ec221148();
        }

        for (Candidate c : candidates) {
            if (c.getSlogan().equals("In to win")) {
                return c;
            }
        }
        
        for (Candidate c : candidates) {
            if (c.getName().equals("Melek")) {
                return c;
            }
        }
        
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        if (votes.length == 0) {
            return new Candidate_ec221148();
        }

        Candidate currentWinner = votes[0];
        int highestCount = 0;

        for (Candidate c : votes) {
            int count = 0;
            for (Candidate x : votes) {
                if (x == c) {
                    count +=1;
                }
            }
            if (count > highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }

        return currentWinner;
    }
    
}
