package com.play.main;

import com.play.calculator.Calculator;
import com.play.game.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JButton calculatorButton, ticTacToeButton;

    Main() {
        this.setTitle("Game Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new FlowLayout());

        calculatorButton = new JButton("Calculator");
        ticTacToeButton = new JButton("Tic-Tac-Toe");

        calculatorButton.addActionListener(this);
        ticTacToeButton.addActionListener(this);

        this.add(calculatorButton);
        this.add(ticTacToeButton);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculatorButton) {
            new Calculator();
        } else if (e.getSource() == ticTacToeButton) {
            new TicTacToe();
        }
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}