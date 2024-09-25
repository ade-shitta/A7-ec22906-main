package OOP.ec29906.A7.Swing;
import OOP.ec29906.A7.contributions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class A7_ec22906 extends JFrame implements ActionListener {
    private final JButton addRandomCandidate;
    private final JButton askForSpecificCandidates;
    private final JButton numberOfTimesButton;
    private final JButton randomElectionButton;
    private final JButton exitButton;
    private final JTextArea resultTextArea;
    static Candidate [] allCandidates = A3.getCandidateArray();
    static Candidate [] inElection = new Candidate[allCandidates.length];
    static int count = 0;

    public A7_ec22906() {
        // Set up the frame
        setTitle("Election App");
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null); // Use absolute positioning
        panel.setBackground(Color.LIGHT_GRAY);

        addRandomCandidate = new JButton("Add a random candidate");
        addRandomCandidate.addActionListener(this);
        addRandomCandidate.setForeground(Color.BLACK);
        addRandomCandidate.setBackground(Color.GREEN);
        addRandomCandidate.setBounds(5, 40, 200, 30);
        panel.add(addRandomCandidate);


        numberOfTimesButton = new JButton("Election for your candidates");
        numberOfTimesButton.addActionListener(this);
        numberOfTimesButton.setForeground(Color.BLACK);
        numberOfTimesButton.setBackground(Color.GREEN);
        numberOfTimesButton.setBounds(205, 10, 200, 30);
        panel.add(numberOfTimesButton);

        askForSpecificCandidates = new JButton("Add a specific candidate");
        askForSpecificCandidates.addActionListener(this);
        askForSpecificCandidates.setForeground(Color.BLACK);
        askForSpecificCandidates.setBackground(Color.GREEN);
        askForSpecificCandidates.setBounds(205, 40, 200, 30);
        panel.add(askForSpecificCandidates);

        randomElectionButton = new JButton("Run a random election");
        randomElectionButton.addActionListener(this);
        randomElectionButton.setForeground(Color.BLACK);
        randomElectionButton.setBackground(Color.GREEN);
        randomElectionButton.setBounds(5, 10, 200, 30); // Set button location and size
        panel.add(randomElectionButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.RED);
        exitButton.setBounds(105, 330, 200, 50); // Set button location and size
        panel.add(exitButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setForeground(Color.WHITE);
        resultTextArea.setBackground(Color.DARK_GRAY);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setBounds(5, 70, 400, 250); // Set scroll pane location and size
        panel.add(scrollPane);
    }

    public void specificCandidates() {

        int numCandidates;
        try{
            try {

                numCandidates = Integer.parseInt(JOptionPane.showInputDialog("How many candidates in the election?"));


                for (int i = 0; i < numCandidates; i++) {
                    String candidateName = JOptionPane.showInputDialog("Enter a username");
                    Candidate candidate = A3.getByUsername(candidateName, A3.getCandidateArray());
                    inElection[count] = candidate;
                    count = count + 1;
                }

                String message = "Selected candidates:\n";
                for (int i = 0; i < count; i++) {
                    message = message +  inElection[i].getName() + "\n";
                }
                JOptionPane.showMessageDialog(null, message);
            } catch (NullPointerException npe){
                JOptionPane.showMessageDialog(null,"Null Candidate");
            }
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,"You must enter the amount of times you would like to run the election here");
        }

    }

    public static void addRandom(){
        Random rand = new Random();
        Candidate c = allCandidates[rand.nextInt(allCandidates.length)];
        inElection[count] = c;
        count = count + 1;
        JOptionPane.showMessageDialog(null, c.getName() + " was added to the election");

    }

    public static void runElection(){
        try{
            Random rand = new Random();
            String winnerMessage = "";
            int runCount = Integer.parseInt(JOptionPane.showInputDialog("How many times would you like to run the election"));
            Candidate [] winners = new Candidate[runCount];
            for (int i = 0; i < runCount; i++){
                winners[i] = inElection[rand.nextInt(count)];
                winnerMessage = (winnerMessage + (winners[i].getName()) + " won election " + (i + 1) +  "\n");
            }

            Candidate winner = Candidate_ec22771.popularWinner(winners);

            String message  ="Most common winner is: " + winner.getName();
            JOptionPane.showMessageDialog(null, winnerMessage);

            JOptionPane.showMessageDialog(null, message);

        } catch(Exception exception){
            JOptionPane.showMessageDialog(null, "There are currently no candidates in this election");
            JOptionPane.showMessageDialog(null, "You can either add a random candidate or add a specific candidate of your choice");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == randomElectionButton) {
            Candidate_ah21407 candidates = new Candidate_ah21407();
            final Candidate[] allCandidates = A3.getCandidateArray();
            Candidate winner = null;
            try {
                winner = candidates.selectWinner(allCandidates);
            } catch (Exception exception) {
                // Catch any exceptions thrown by Candidate methods
                resultTextArea.append("There was an error during the election run.\n");
            }
            if (winner != null) {
                resultTextArea.append("The winner of this election is: " + winner.getName() + "\n");
                resultTextArea.append(winner.getName()+"'s slogan is: "+winner.getSlogan()+"\n");
                resultTextArea.append("Click again to run a new random election. \n");
                resultTextArea.append("\n");
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
            
        } else if (e.getSource() == askForSpecificCandidates) {
            specificCandidates();

        } else if (e.getSource() == numberOfTimesButton) {
            runElection();

        } else if (e.getSource() == addRandomCandidate) {
            addRandom();
        }
    }

    public static void main(String[] args) {
        new A7_ec22906();
    }
}