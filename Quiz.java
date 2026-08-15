
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Quiz implements ActionListener {
   public String s1, s2;
   public int marks = 0;
   public int totalque = 0;
   ArrayList<String> questions;

   ArrayList<String[]> options;

   ArrayList<String> answers;
   ArrayList<String> userAnswers;
   JFrame f;
   JButton bex, bst;
   JLabel l1, l2, l3, l4;
   JTextField t1, t2;

   Quiz() {
      f = new JFrame("Quiz Application");
      // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
      f.setSize(500, 470);
      f.setLayout(null);
      l1 = new JLabel("Welcome to Quiz Application");
      l1.setBounds(60, 40, 400, 20);
      l1.setFont(new Font("Arial", Font.BOLD, 24));
      f.add(l1);

      l2 = new JLabel("Enter Name:");
      l2.setBounds(50, 115, 150, 20);
      l2.setFont(new Font("Arial", Font.BOLD, 20));
      f.add(l2);

      t1 = new JTextField();
      t1.setBounds(180, 100, 200, 50);
      t1.setBackground(Color.LIGHT_GRAY);
      t1.setFont(new Font("Arial", Font.BOLD, 15));
      f.add(t1);

      l3 = new JLabel("Roll No. :");
      l3.setBounds(50, 180, 150, 20);
      l3.setFont(new Font("Arial", Font.BOLD, 20));
      f.add(l3);

      t2 = new JTextField();
      t2.setBounds(180, 170, 200, 50);
      t2.setBackground(Color.LIGHT_GRAY);
      t2.setFont(new Font("Arial", Font.BOLD, 15));
      f.add(t2);

      l4 = new JLabel("!! ready to give quiz !!");
      l4.setBounds(100, 270, 300, 30);
      l4.setFont(new Font("Arial", Font.BOLD, 25));
      f.add(l4);

      bex = new JButton("Instruction");
      bex.setBounds(50, 320, 100, 50);
      bex.setBackground(Color.GRAY);
      bex.addActionListener(this);
      f.add(bex);

      bst = new JButton("START");
      bst.setBounds(300, 320, 100, 50);
      bst.setBackground(Color.GRAY);
      bst.addActionListener(this);
      f.add(bst);

      f.setResizable(false);
      f.getContentPane().setBackground(Color.LIGHT_GRAY);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == bex) {
         new Instruction();
      }
      if (e.getSource() == bst) {
         s1 = t1.getText();
         s2 = t2.getText();
         if (s1.length() == 0 || s2.length() == 0) {
            new Warning();
         } else {
            new StartQuiz();
         }
      }
   }

   class Instruction extends JFrame implements ActionListener {

      JLabel l1, l2, l3;
      JButton b;

      Instruction() {
         setTitle("Instruction");
         setSize(500, 500);
         setLayout(null);

         l1 = new JLabel("Instructions:");
         l1.setBounds(50, 30, 300, 30);
         l1.setFont(new Font("Arial", Font.BOLD, 22));
         add(l1);

         l2 = new JLabel("1. Each question carries 1 mark.");
         l2.setBounds(50, 80, 400, 30);
         l2.setFont(new Font("Arial", Font.PLAIN, 18));
         add(l2);

         l3 = new JLabel("2.Only marked option consider.");
         l3.setBounds(50, 130, 400, 30);
         l3.setFont(new Font("Arial", Font.PLAIN, 18));
         add(l3);

         b = new JButton("OK");
         b.setBounds(180, 380, 100, 40);
         b.addActionListener(this);
         add(b);
         setResizable(false);
         getContentPane().setBackground(Color.LIGHT_GRAY);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setVisible(true);
      }

      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == b) {
            dispose();
         }
      }
   }

   class Warning extends JFrame implements ActionListener {
      JLabel l;
      JButton b;

      Warning() {
         setTitle("Warning");
         setSize(300, 200);
         setLayout(null);
         l = new JLabel("Name and Roll NO. must be written.");
         l.setBounds(30, 20, 300, 20);
         add(l);

         b = new JButton("OK");
         b.setBounds(80, 70, 100, 40);
         b.setBackground(Color.GRAY);
         b.addActionListener(this);
         add(b);

         setResizable(false);
         getContentPane().setBackground(Color.LIGHT_GRAY);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setVisible(true);

      }

      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == b) {
            dispose();
         }
      }

   }

   class StartQuiz extends JFrame implements ActionListener {

      int j = 1;
      int k = 0;

      JLabel l;
      JRadioButton r1, r2, r3, r4;
      ButtonGroup bg;
      JButton bn, bp, bsub;

      StartQuiz() {
         setTitle("Quiz Started");
         setLayout(null);
         setExtendedState(JFrame.MAXIMIZED_BOTH);

         questions = new ArrayList<>();

         questions.add("Ques 1: What is Java?");
         questions.add("Ques 2: For what Constructor is used?");
         questions.add("Ques 3: what is inhertance?");
         questions.add("Ques 4: which one is the Access Modifier?");

         options = new ArrayList<>();
         options.add(new String[] { "1.Animal", "2.Language", "3.Bird", "4.Human" });
         options.add(new String[] { "1.Noting", "2.Do whatever", "3.Used to initilize objects", "4.All" });
         options.add(new String[] { "1.taking properties", "2.Language", "3.Bird", "4.Human" });
         options.add(new String[] { "1.private", "2.public", "3.protected", "4.all" });

         answers = new ArrayList<>();
         answers.add("2.Language");
         answers.add("3.Used to initilize objects");
         answers.add("1.taking properties");
         answers.add("4.all");
         userAnswers = new ArrayList<>();

         // initialize with empty answers
         for (int x = 0; x < questions.size(); x++) {
            userAnswers.add("");

         }

         l = new JLabel();
         l.setText(questions.get(0));
         l.setBounds(300, 100, 1000, 60);
         l.setFont(new Font("Arial", Font.PLAIN, 25));
         add(l);

         r1 = new JRadioButton(options.get(0)[0]);
         r1.setBounds(300, 180, 300, 40);
         r1.setFont(new Font("Arial", Font.PLAIN, 20));
         r1.setBackground(Color.LIGHT_GRAY);
         add(r1);

         r2 = new JRadioButton(options.get(0)[1]);
         r2.setBounds(300, 240, 300, 40);
         r2.setFont(new Font("Arial", Font.PLAIN, 20));
         r2.setBackground(Color.LIGHT_GRAY);
         add(r2);

         r3 = new JRadioButton(options.get(0)[2]);
         r3.setBounds(300, 300, 300, 40);
         r3.setFont(new Font("Arial", Font.PLAIN, 20));
         r3.setBackground(Color.LIGHT_GRAY);
         add(r3);

         r4 = new JRadioButton(options.get(0)[3]);
         r4.setBounds(300, 360, 300, 40);
         r4.setFont(new Font("Arial", Font.PLAIN, 20));
         r4.setBackground(Color.LIGHT_GRAY);
         add(r4);

         bg = new ButtonGroup();
         bg.add(r1);
         bg.add(r2);
         bg.add(r3);
         bg.add(r4);
         bp = new JButton("PREVIOUS");
         bp.setBounds(300, 550, 200, 50);
         bp.setBackground(Color.GRAY);
         bp.addActionListener(this);
         add(bp);

         bn = new JButton("NEXT");
         bn.setBounds(900, 550, 200, 50);
         bn.setBackground(Color.GRAY);
         bn.addActionListener(this);
         add(bn);

         getContentPane().setBackground(Color.LIGHT_GRAY);
         setResizable(false);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);

         totalque = questions.size();
      }

      String getSelectedOption() {
         if (r1.isSelected())
            return r1.getText();
         if (r2.isSelected())
            return r2.getText();
         if (r3.isSelected())
            return r3.getText();
         if (r4.isSelected())
            return r4.getText();
         return "";
      }

      public void actionPerformed(ActionEvent e) {
         try {
            if (e.getSource() == bn) {
               
               userAnswers.set(j - 1, getSelectedOption());

               int p = j;
               p++;

               if (j < questions.size()) {
                  bg.clearSelection();
                  l.setText(questions.get(j));
                  r1.setText(options.get(j)[0]);
                  r2.setText(options.get(j)[1]);
                  r3.setText(options.get(j)[2]);
                  r4.setText(options.get(j)[3]);
                  j++;

               }
               if (p > questions.size()) {
                  new Submit();
               }

            }
            if (e.getSource() == bp) {
               if (j > 1) {
                  j--;

                  l.setText(questions.get(j - 1));
                  r1.setText(options.get(j - 1)[0]);
                  r2.setText(options.get(j - 1)[1]);
                  r3.setText(options.get(j - 1)[2]);
                  r4.setText(options.get(j - 1)[3]);

                  bg.clearSelection();

                  // restore previous selection
                  String prevAns = userAnswers.get(j - 1);
                  if (prevAns.equals(r1.getText()))
                     r1.setSelected(true);
                  if (prevAns.equals(r2.getText()))
                     r2.setSelected(true);
                  if (prevAns.equals(r3.getText()))
                     r3.setSelected(true);
                  if (prevAns.equals(r4.getText()))
                     r4.setSelected(true);
               }

            }
         } catch (Exception i) {
         }
      }

   }

   class Submit extends JFrame implements ActionListener {

      JButton bsub,bexit;
      JLabel l1, l2, l3;
      
      Submit() {
         setTitle("Submit Window");
         setLayout(null);
         setExtendedState(JFrame.MAXIMIZED_BOTH);

         bsub = new JButton("SUBMIT");
         bsub.setBounds(550, 100, 200, 50);
         bsub.setBackground(Color.GRAY);
         bsub.addActionListener(this);
         add(bsub);
         bexit = new JButton("EXIT");
         bexit.setBounds(800, 100, 200, 50);
         bexit.setBackground(Color.GRAY);
         bexit.addActionListener(this);
          add(bexit);

         l1 = new JLabel("Name: " + s1);
         l1.setBounds(400, 200, 700, 50);
         l1.setBackground(Color.GRAY);
         l1.setFont(new Font("Arial", Font.BOLD, 30));
         add(l1);

         l2 = new JLabel("Roll no: " + s2);
         l2.setBounds(400, 270, 700, 50);
         l2.setBackground(Color.GRAY);
         l2.setFont(new Font("Arial", Font.BOLD, 30));
         add(l2);

         l3 = new JLabel();
         l3.setBounds(500, 400, 1000, 50);
         l3.setBackground(Color.GRAY);
         l3.setForeground(Color.DARK_GRAY);
         l3.setFont(new Font("Arial", Font.BOLD, 30));
         add(l3);

         getContentPane().setBackground(Color.LIGHT_GRAY);
         setResizable(false);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);

      }

      public void actionPerformed(ActionEvent e) {

    if (e.getSource() == bsub) {
        marks = 0;

        for (int i = 0; i < answers.size(); i++) {
            if (userAnswers.get(i).equals(answers.get(i))) {
                marks++;
            }
        }

        l3.setText("Your marks is " + marks + " out of " + totalque);
    }

    if (e.getSource() == bexit) {
        System.exit(0);
    }
}

   }

   public static void main(String[] args) {
      new Quiz();
   }
}
