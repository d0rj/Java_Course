package com.d0rj;

import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {

    private final Match match;
    private Team lastScorer = null;


    private String getScoreLabel() {
        return "Result: " + match.getFirstGoals() + " : " + match.getSecondGoals();
    }


    private String getLastScorerLabel() {
        return "Last Scorer: " + (lastScorer == null ? "N/A" : lastScorer.getName());
    }


    private String getWinnerLabel() {
        return "Winner: " + (match.getWinner() == null ? "N/A" : match.getWinner().getName());
    }


    public MainWindow() {
        super("Football match");
        match = new Match(
                new Team("AC Milan"),
                new Team("Real Madrid")
        );

        construct();

        setSize(new Dimension(400, 200));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void construct() {
        var scoreTitle = new JLabel(getScoreLabel());
        scoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
        var lastScorerLabel = new JLabel(getLastScorerLabel());
        lastScorerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        var winnerScorer = new JLabel(getWinnerLabel());
        winnerScorer.setHorizontalAlignment(SwingConstants.CENTER);

        var firstButton = new JButton(match.getFirst().getName());
        firstButton.setHorizontalAlignment(SwingConstants.CENTER);
        firstButton.addActionListener(e -> {
            match.firstGoal();
            lastScorer = match.getFirst();
            scoreTitle.setText(getScoreLabel());
            lastScorerLabel.setText(getLastScorerLabel());
            winnerScorer.setText(getWinnerLabel());
        });
        var secondButton = new JButton(match.getSecond().getName());
        secondButton.setHorizontalAlignment(SwingConstants.CENTER);
        secondButton.addActionListener(e -> {
            match.secondGoal();
            lastScorer = match.getSecond();
            scoreTitle.setText(getScoreLabel());
            lastScorerLabel.setText(getLastScorerLabel());
            winnerScorer.setText(getWinnerLabel());
        });

        add(winnerScorer, BorderLayout.NORTH);
        add(lastScorerLabel, BorderLayout.SOUTH);
        add(scoreTitle, BorderLayout.CENTER);
        add(firstButton, BorderLayout.WEST);
        add(secondButton, BorderLayout.EAST);
    }
}
