import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton []numButtons = new JButton[10];
    JButton []funButton = new JButton[9];
    JButton add,sub,mul,div;
    JButton dec, eql, del, clr, neg;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        eql = new JButton("=");
        del = new JButton("delete");
        clr = new JButton("clear");
        neg = new JButton("(-)");

        funButton[0] = add;
        funButton[1] = sub;
        funButton[2] = mul;
        funButton[3] = div;
        funButton[4] = dec;
        funButton[5] = eql;
        funButton[6] = del;
        funButton[7] = clr;
        funButton[8] = neg;
        for(int i=0;i<9;i++){
            funButton[i].addActionListener(this);
            funButton[i].setFont(myFont);
            funButton[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numButtons[i] = new JButton(String .valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }
        neg.setBounds(50,430,100,50);
        del.setBounds(150,430,100,50);
        clr.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(add);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(sub);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numButtons[0]);
        panel.add(eql);
        panel.add(div);

        frame.add(panel);
        frame.add(del);
        frame.add(clr);
        frame.add(neg);
        frame.add(textfield);
        frame.setVisible(true);
    }
    @Override 
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10;i++){
            if(e.getSource() == numButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == dec){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == add){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == sub){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mul){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == div){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource() == eql){
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clr){
            textfield.setText("");
        }
        if(e.getSource()==del){
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0; i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==neg){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}