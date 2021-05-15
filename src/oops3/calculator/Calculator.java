package oops3.calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;

import java.awt.*;

public class Calculator extends JFrame implements AncestorListener{
    private static final long serialVersionUID = 1L;
    JPanel[] row = JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString  = {"7","8","9","+",
                              "4","5","6","-",
                              "1","2","3","*",
                              ".","/","C","?",
                              "+/-","=","0"};

    int dimW = {430,70,150,140};
    int dimH = {50,60};

    Dimension displayDimension = new Dimension(dimW[0],dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1],dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2],dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3],dimH[1]);
    boolean[] function = new boolean[4];
    double[] temporary={0,0};

    JTextArea display = new JTextArea(2,25);

    Font font = new Font("Times new Roman", Font.BOLD,20);

    Calculator(){
        super("Calculator"); //title of the Jframe 
        setDesign();
        setSize(500,350);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);

        for(int i=0;i<4;i++){
            function[i]=false;
        }

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);

        for(int i=0;i<5;i++){
            row[i] = new JPanel();
        }
        row[0].setLayout(f2);
        for(int i=0;i<5;i++){
            row[i].setLayout(f2);
        }

        for(int i=0;i<19;i++){
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].setBackground(Color.white);
            button[i].addActionListener(this);
        }

        display.setFont(font);
        display.setEditable(true);

        dusplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);

        for(int i=0;i<14;i++){
            button[i].setPreferredSize(regularDimension);
        }

        for(int i=0;i<18;i++){
            button[i].setPreferredSize(rColumnDimension);
        }

        button[18].setPreferredSize(zeroButDimension);

        row[0].add(display);
        add(row[0]);

        for(int i = 0;i<4;i++){
            row[1].add(button[i]);
        }
        row[1].add(button[14]);
        add(row[3]);

        setVisible(true);
    }

    public void clear(){
        try{
            display.setText("");
            for(int i=0;i<4;i++){
                function[i] = false;
            }
            for(int i=0;i<2;i++){
                function[i] = false;
            }
        }catch(NullPointerException e){
            
        }
    }

    public void getSqrt(){
        try{
            double value = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(double.toString(value));
        }catch(NumberFormatException e){}
    }

    public void getPosNeg(){
        try{
            double vlaue  = Double.parseDouble(display.getText());
            if(value!=0){
                value = value * (-1);
                display.setText(Double.toString(value));
            }else{
                
            }
        }
    }
}
