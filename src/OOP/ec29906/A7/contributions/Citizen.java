package OOP.ec29906.A7.contributions;

interface Citizen extends Person {
    Candidate vote(Candidate[] candidates);
    Candidate selectWinner(Candidate[] votes);
}
