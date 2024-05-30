import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main implements ActionListener {
    String left_value;
    String right_value;
    int flag = 0;
    Frame f;
    Panel p;
    Button b0, b1,b2, b3, b4, b5, b6, b7, b8, b9,badd, bsub, bmul, bdiv, beq, bclr;
    TextField t;
    GridLayout g;
    Main(){
        f = new Frame("Calculator");
        p = new Panel();
        f.setLayout(new FlowLayout());
        b0 = new Button("0");
        b0.addActionListener(this);

        b1 = new Button("1");
        b1.addActionListener(this);

        b2 = new Button("2");
        b2.addActionListener(this);

        b3 = new Button("3");
        b3.addActionListener(this);

        b4 = new Button("4");
        b4.addActionListener(this);

        b5 = new Button("5");
        b5.addActionListener(this);

        b6 = new Button("6");
        b6.addActionListener(this);

        b7 = new Button("7");
        b7.addActionListener(this);

        b8 = new Button("8");
        b8.addActionListener(this);

        b9 = new Button("9");
        b9.addActionListener(this);

        badd = new Button("+");
        badd.addActionListener(this);

        bsub = new Button("-");
        bsub.addActionListener(this);

        bmul = new Button("*");
        bmul.addActionListener(this);

        bdiv = new Button("/");
        bdiv.addActionListener(this);

        beq = new Button("=");
        beq.addActionListener(this);

        bclr = new Button("Clear");
        bclr.addActionListener(this);

        t = new TextField(20);
        f.add(t);

        g = new GridLayout(4,4);
        p.setLayout(g);

        p.add(b0);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(badd);
        p.add(bsub);
        p.add(bmul);
        p.add(bdiv);
        p.add(beq);
        p.add(bclr);

        f.add(p);
        f.setSize(300, 200);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        Main a = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b0){
            String s = t.getText();
            t.setText(s+"0");
        }
        if(e.getSource() == b1){
            String s = t.getText();
            t.setText(s+"1");
        }
        if(e.getSource() == b2){
            String s = t.getText();
            t.setText(s+"2");
        }
        if(e.getSource() == b3){
            String s = t.getText();
            t.setText(s+"3");
        }
        if(e.getSource() == b4){
            String s = t.getText();
            t.setText(s+"4");
        }
        if(e.getSource() == b5){
            String s = t.getText();
            t.setText(s+"5");
        }
        if(e.getSource() == b6){
            String s = t.getText();
            t.setText(s+"6");
        }
        if(e.getSource() == b7){
            String s = t.getText();
            t.setText(s+"7");
        }
        if(e.getSource() == b8){
            String s = t.getText();
            t.setText(s+"8");
        }
        if(e.getSource() == b9){
            String s = t.getText();
            t.setText(s+"9");
        }
        if(e.getSource() == badd){
            left_value = t.getText();
            t.setText("");
            flag = 1;
        }
        if(e.getSource() == bsub){
            left_value = t.getText();
            t.setText("");
            flag = 2;
        }
        if(e.getSource() == bmul){
            left_value = t.getText();
            t.setText("");
            flag = 3;
        }
        if(e.getSource() == bdiv){
            left_value = t.getText();
            t.setText("");
            flag = 4;
        }
        if(e.getSource() == bclr){
            left_value = t.getText();
            t.setText("");
            flag = 5;
        }
        if(e.getSource() == beq){
            right_value = t.getText();
            if(flag == 1){
                int a = Integer.parseInt(left_value);
                int b = Integer.parseInt(right_value);
                t.setText(a+b+"");
            }
            if(flag == 2){
                int a = Integer.parseInt(left_value);
                int b = Integer.parseInt(right_value);
                t.setText(a-b+"");
            }
            if(flag == 3){
                int a = Integer.parseInt(left_value);
                int b = Integer.parseInt(right_value);
                t.setText(a*b+"");
            }
            if(flag == 4){
                double a = Integer.parseInt(left_value);
                double b = Integer.parseInt(right_value);
                t.setText(a/b+"");
            }
            if(flag == 5){
                t.setText("");
            }
        }
    }
}
