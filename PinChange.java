package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JButton back,change;
    JPasswordField repin,pin;

    String pinnumber;
    PinChange (String pinnumber){
          this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
          image.add(text);


        JLabel pintext=new JLabel("New Pin");
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.WHITE);
        image.add(pintext);

           pin= new JPasswordField();
          pin.setFont(new Font("System",Font.BOLD,25));
          pin.setBounds(330,320,180,25);
            image.add(pin);

        JLabel repintext=new JLabel("Re-Enter New Pin");
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.WHITE);
        image.add(repintext);

         repin= new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

         change=new JButton("Change");
        change.setBounds(355,485,150,30);
          change.addActionListener(this);
        image.add(change);

         back=new JButton("Back");
        back.setBounds(355,520,150,30);
          back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
      public void actionPerformed(ActionEvent ae) {
          if (ae.getSource() == change) {
              try {
                  String npin = pin.getText();
                  String rpin = repin.getText();
                  if (!npin.equals(rpin)) {
                      JOptionPane.showMessageDialog(null, "Entered PIN  doesnot match");
                      return;
                  }
                    if(npin.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter the Pin");
                        return;
                    }
                      if(rpin.equals("")){
                          JOptionPane.showMessageDialog(null, "Please re-enter the pin");
                          return;
                      }

                       Conn c=new Conn();
                        String query1="update bank set pin ='" +rpin+ "'  where pin = '"+pinnumber+"'";
                  String query2="update login set pin ='" +rpin+ "'  where pin = '"+pinnumber+"'";
                  String query3="update signupthree set pinNumber ='" +rpin+ "'  where pinNumber = '"+pinnumber+"'";
                   c.s.executeUpdate(query1);
                  c.s.executeUpdate(query2);
                  c.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null,"PIN changed successfully");

                     setVisible(false);
                      new Transcations(rpin).setVisible(true);

              } catch (Exception e) {
                  System.out.println(e);
              }
          }
           else{
                   setVisible(false);
               new Transcations(pinnumber).setVisible(true);
          }
      }


    public static void main(String[] args) {
         new PinChange("").setVisible(true);

    }

}
