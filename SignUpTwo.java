package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  import java.sql.*;


public class SignUpTwo extends JFrame implements ActionListener {
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    String formno;

    JComboBox category, religion, income, oc, edu;

    SignUpTwo(String formno) {
        this.formno = formno;

        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 2:+ Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valR[] = {"Hindu", "Muslim", "sikh", "Christian", "Others"};
        religion = new JComboBox(valR);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname = new JLabel("Category :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String ValC[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(ValC);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,000,00", "upto 10,000,00"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Education :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);


        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String eduV[] = {"Non Graduate", " Graduate", "Post Graduate", "Doctrate", "Others"};
        edu = new JComboBox(eduV);
        edu.setBounds(300, 315, 400, 30);
        edu.setBackground(Color.WHITE);
        add(edu);


        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);


        String OccupationVal[] = {"Salaried", "Self Employed", "Bussiness", "Student", "Retired", "Others"};
        oc = new JComboBox(OccupationVal);
        oc.setBounds(300, 390, 400, 30);
        oc.setBackground(Color.WHITE);
        add(oc);

        JLabel panN = new JLabel("PAN Number  :");
        panN.setFont(new Font("Raleway", Font.BOLD, 20));
        panN.setBounds(100, 440, 200, 30);
        add(panN);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel saadhar = new JLabel("Aadhar Number :");
        saadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        saadhar.setBounds(100, 490, 200, 30);
        add(saadhar);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen  :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(400, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);


        ButtonGroup SC = new ButtonGroup();
        SC.add(syes);
        SC.add(sno);


        JLabel pin = new JLabel("Existing Account  :");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(400, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);


        ButtonGroup EA = new ButtonGroup();
        EA.add(eyes);
        EA.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);

        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String Sreligion = (String) religion.getSelectedItem();
        String Category = (String) category.getSelectedItem();
        String Sincome = (String) income.getSelectedItem();
        String Seducation = (String) edu.getSelectedItem();
        String Socc = (String) oc.getSelectedItem();
        String seniorCitizen = "null";
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else {
            seniorCitizen = "No";
        }

        String existingAccount = "null";
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();


        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values( '" + formno + "', '" + Sreligion + "','" + Category + "','" + Sincome + "','" + Seducation + "','" + Socc + "','" + span + "','" + saadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new  SignUpThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);

        }
    }



        public static void main (String args[]){

           SignUpTwo s1= new SignUpTwo("");
        }


    }


