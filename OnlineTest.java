import java.io.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OnlineTest extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int current=0,x=1,y=1,now=0,k=0;
    float rating = 0,count=0;
    int m[]=new int[10];
    OnlineTest(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Flag");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,60,700,20);
        jb[0].setBounds(50,100,100,20);
        jb[1].setBounds(50,130,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(500,350);

        Icon imgIcon = new ImageIcon(this.getClass().getResource("111.gif"));
        JLabel label = new JLabel(imgIcon);
        label.setBounds(7, 0, 450, 50);
        getContentPane().add(label);

        getContentPane().setBackground(Color.CYAN);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Submit");
            }
        }
        if(e.getActionCommand().equals("Flag"))
        {
            JButton bk=new JButton("Flag"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Submit");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
        if(e.getActionCommand().equals("Flag"+y))
        {
            if(check())
                count=count+1;
            now=current;
            current=m[y];
            set();
            ((JButton)e.getSource()).setEnabled(false);
            current=now;
        }
        }

        if(e.getActionCommand().equals("Submit"))
        {
            if(check())
                if (current == 9)
                {
                  k = 2;
                }
                else
                {
                  k = 1;
                }
                count = count + k;
            current++;


            rating = (5*count)/11;
            double roundOff = Math.round(rating*100)/100D;
            if (count<=2)
            {
              JOptionPane.showMessageDialog(this,"Sorry for your inconvinience, we will improve this course. Your Rating: "+rating);
              try
              {
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:/Users/praneeth/Desktop/Java Shared Folder/191000034.txt")));
                writer.write("The Rating given by User - 191000035 out of 5 is " +rating);
                writer.write("\n");
                writer.write("The User was not satisfied. The course needs to be improved");
                writer.close();
              }
              catch (Exception e1)
              {
                System.err.println("Error: " + e1.getMessage());
              }
              System.exit(0);

            }
            else
            {
              JOptionPane.showMessageDialog(this,"Thanks for your Feedback. Your Rating: "+rating);

              try
              {
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:/Users/praneeth/Desktop/Java Shared Folder/191000034.txt")));
                writer.write("The Rating given by User - 191000035 out of 5 is " +rating);
                writer.write("\n");
                writer.close();
              }
              catch (Exception e1)
              {
                System.err.println("Error: " + e1.getMessage());
              }
              System.exit(0);
            }


        }
    }
    void set()
    {

        jb[4].setSelected(true);
        if(current==0)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 15));
            l.setText("Q1: The instructor was well prepared for the class. Yes/No?");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==1)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 15));
            l.setText("Q2: The instructor showed an interest in helping students learn.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==2)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 15));
            l.setText("Q3: I received useful feedback on my performance on tests, papers, etc.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==3)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 15));
            l.setText("Q4: The lectures, tests, and assignments complemented each other. ");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==4)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 15));
            l.setText("Q5: The instructional materials increased my knowledge and skills.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Absolutely");jb[1].setText("I don't think so");
        }
        if(current==5)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 15));
            l.setText("Q6: The course was organized in a beautiful manner.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Yes");jb[1].setText("Not at all");
        }
        if(current==6)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 13));
            l.setText("Q7: The examinations, projects measured my knowledge of the course material.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Definitely");jb[1].setText("Not at all");
        }
        if(current==7)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 13));
            l.setText("Q8: The course gave me the confidence to do advanced work in the subject.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Definitely");jb[1].setText("Not at all");
        }
        if(current==8)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 15));
            l.setText("Q9: I would highly recommend this course to other students.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Definitely");jb[1].setText("Not at all");
        }
        if(current==9)
        {
            l.setFont(new Font("Calibri", Font.BOLD, 13));
            l.setText("Q10: Overall, this course met my expectations for the quality of the course.");
            l.setBounds(30,60,700,20);
            jb[0].setBounds(50,100,100,20);
            jb[1].setBounds(50,130,100,20);
            jb[0].setText("Definitely");jb[1].setText("Not at all");
        }

        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=30;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[0].isSelected());
        if(current==1)
            return(jb[0].isSelected());
        if(current==2)
            return(jb[0].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[0].isSelected());
        if(current==5)
            return(jb[0].isSelected());
        if(current==6)
            return(jb[0].isSelected());
        if(current==7)
            return(jb[0].isSelected());
        if(current==8)
            return(jb[0].isSelected());
        if(current==9)
            return(jb[0].isSelected());
        return false;
    }
    public void print()
    {

    }
    public static void main(String s[])
    {
        new OnlineTest("Online Survey System of IIIT Naya Raipur");


    }
}
