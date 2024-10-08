package OOP.ec29906.A7.contributions;// File Candidate_ec22543.java
//
// Machine generated stub for Assignment 2
import java.util.Random;
import java.util.Scanner;

class Candidate_ec22543 extends Candidate {


    public static String inputString(String message) {
         String input;
         Scanner scanner = new Scanner(System.in);

         System.out.println(message);
         input = scanner.nextLine();

         return input;
    }

     public static void main(String[] args) {
         Candidate[] aCandidates = A3.getCandidateArray();
         Candidate[] candidatesElection = new Candidate[0];
         System.out.println("= Running Repeated Elections =");
         printMenu(aCandidates, candidatesElection);
     }

     public static void printMenu(Candidate[] aCandidates, Candidate[] candidatesElection) {

         System.out.println("Candidates are the following");
         if (aCandidates.length==0) {
             System.out.println("None");
         }
         else {
             for (int i=0; i<aCandidates.length; i++) {
                 System.out.println(aCandidates[i].getName());
             }
         }

         String Choice;
         do {
             //input which allows user to pick options using if and else statement to run the code after 
             Choice = inputString("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
             if (Choice.equals("a")) {
                 Candidate[] newCandidatesElection = addSpecificCandidate(aCandidates, candidatesElection);
                 printMenu(aCandidates, newCandidatesElection);
             }
             else if (Choice.equals("b")) {
                 Candidate[] newCandidatesElection = RandomCandidate(aCandidates, candidatesElection);
                 printMenu(aCandidates, newCandidatesElection);
             }
             else if (Choice.equals("c")) {
                 String voteCounter = inputString("Who should count the votes?");
                 int ManyElections = Integer.parseInt(inputString("How many times shall we run the election?"));
                 runElection(aCandidates, candidatesElection, voteCounter, ManyElections);
             }//indicates to users they must choice lower case a b or c
             else {
                 System.out.println("enter a,b or c");
             }
         }

         while (Choice!="a" && Choice!="b" && Choice!="c");
     }

     public static Candidate[] addSpecificCandidate(Candidate[] aCandidates, Candidate[] candidatesElection) {
         String specificName = inputString("Which specific user would you like to include?");
         Candidate specificCandidate = A3.getByUsername(specificName, aCandidates);
         if (specificCandidate == null) {
              specificCandidate = new Candidate_ec221207();
         }
         Candidate[] newCandidatesElection = addCandidateToArray(candidatesElection, specificCandidate);
         return newCandidatesElection;
     }

     public static Candidate[] RandomCandidate(Candidate[] aCandidates, Candidate[] candidatesElection) {

         Random r = new Random();
         int c = r.nextInt(aCandidates.length);
         Candidate[] newCandidatesElection = addCandidateToArray(candidatesElection, aCandidates[c]);
         return newCandidatesElection;
     }

     public static Candidate[] addCandidateToArray(Candidate[] candidatesElection, Candidate candidateToAdd) {

         Candidate[] newCandidatesElection = new Candidate[candidatesElection.length+1];
         for (int i=0; i<candidatesElection.length; i++) {
             newCandidatesElection[i] = candidatesElection[i];
         }
         newCandidatesElection[candidatesElection.length+1] = candidateToAdd;
         return newCandidatesElection;
     }

     public static void runElection(Candidate[] aCandidates, Candidate[] candidatesElection, String counterName, int ManyElections) {

         Candidate[] votes = new Candidate[candidatesElection.length];
         Candidate[] winners = new Candidate[ManyElections];
         Candidate voteCounter = A3.getByUsername(counterName, aCandidates);

         for (int i=0; i<ManyElections; i++) {
             for (int j=0; j<aCandidates.length; j++) {
                 votes[j] = aCandidates[j].vote(candidatesElection);
             }
             winners[i] = voteCounter.selectWinner(votes);
         }

         Candidate overallWinner = voteCounter.selectWinner(winners);
         System.out.println("Most common winner is " + overallWinner.getName());
         System.out.println("Their slogan is " + overallWinner.getSlogan());
    }
    
    public String getName() {
        return "Jabz)";
    }
    
    public String getSlogan() {
        return "Go Jim";
    }
    
    public Candidate vote(Candidate[] candidates) {
        if (candidates.length == 0) {
            return new Candidate_ec22543();
        }
        for (int i=0 ; i<candidates.length; i++) {
            if (candidates[i].getSlogan().equals("Go Jim")) {
                return candidates[i];
            }
        }
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        if (votes.length == 0) {
            return new Candidate_ec22658();
        }
        Candidate currentWinner = votes[0];
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
