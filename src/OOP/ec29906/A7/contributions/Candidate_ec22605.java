package OOP.ec29906.A7.contributions;// File Candidate_ec22605.java
//
// Machine generated stub for Assignment 2

class Candidate_ec22605 extends Candidate {
    public String getName() {
        return "Nikhel";
    }

    public String getSlogan() {
        return "Real eyes, realize, real lies";
    }

    public Candidate vote(Candidate[] candidates) {
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0)
            return new Candidate_ec22605();

        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("Real eyes, realize, real lies"))
                return c;

        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Jedi"))
                return c;

        // Otherwise, default to last candidate on list.
        return candidates[candidates.length - 1];
    }

    public Candidate selectWinner(Candidate[] votes) {

        // If array is empty, return instance of friend's class.
        if (votes.length == 0)
            return new Candidate_ec22424();

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
            if (count > highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }

        return currentWinner;
    }
}
