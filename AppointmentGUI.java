package ProjectOOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentGUI extends JFrame implements ActionListener {
    private JTextField idField;
    private JTextField patientNameField;
    private JTextField doctorNameField;
    private JTextField dateTimeField;
    private JButton submitButton;

    public AppointmentGUI() {
    	
    	try {
    		UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	}
    	catch (Exception e) {
    		System.out.println("Look and Feel not set");
    	}
    	
        setTitle("Appointment");
        setSize(500, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel title = new JLabel("Appointment");
        title.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        title.setSize(200, 20);
        title.setLocation(200, 10);
        panel.add(title);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        idLabel.setSize(200, 40);
        idLabel.setLocation(30, 60);
        idField = new JTextField();
        idField.setSize(200, 30);
        idField.setLocation(250, 65);
        panel.add(idLabel);
        panel.add(idField);

        JLabel patientNameLabel = new JLabel("Patient's Name:");
        patientNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
        patientNameLabel.setSize(200, 40);
        patientNameLabel.setLocation(30, 100);
        patientNameField = new JTextField();
        patientNameField.setSize(200, 30);
        patientNameField.setLocation(250, 105);
        panel.add(patientNameLabel);
        panel.add(patientNameField);

        JLabel doctorNameLabel = new JLabel("Doctor's Name:");
        doctorNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        doctorNameLabel.setSize(200, 40);
        doctorNameLabel.setLocation(30, 140);
        doctorNameField = new JTextField();
        doctorNameField.setSize(200, 30);
        doctorNameField.setLocation(250, 145);
        panel.add(doctorNameLabel);
        panel.add(doctorNameField);

        JLabel dateTimeLabel = new JLabel("<html>Date and Time <br/> (YYYY-MM-DD HH:MM AM/PM)</html>");
        dateTimeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        dateTimeLabel.setSize(230, 50);
        dateTimeLabel.setLocation(30, 178);
        dateTimeField = new JTextField();
        dateTimeField.setSize(200, 30);
        dateTimeField.setLocation(250, 190);
        panel.add(dateTimeLabel);
        panel.add(dateTimeField);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        submitButton.setSize(100, 40);
        submitButton.setLocation(200, 240);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String id = idField.getText();
        String patientName = patientNameField.getText();
        String doctorName = doctorNameField.getText();
        String dateTime = dateTimeField.getText();

        Appointment appointment = new Appointment();
        appointment.setID(id);
        appointment.setPatientName(patientName);
        appointment.setDoctorName(doctorName);
        appointment.setDateTime(LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")));

        LocalDateTime currentDateTime = LocalDateTime.now();
        if (appointment.getDateTime().isAfter(currentDateTime)) {
            JOptionPane.showMessageDialog(this, "This appointment is scheduled!");

            int choice = JOptionPane.showConfirmDialog(this, "Do you want to cancel the appointment?", "Cancel Appointment", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "This appointment has been cancelled. Thank You...");
            } else {
                JOptionPane.showMessageDialog(this, "This appointment has not been cancelled.");
                
                String message = "Appointment Details:\n" +
                        "ID: " + appointment.getID() + "\n" +
                        "Patient Name: " + appointment.getPatientName() + "\n" +
                        "Doctor Name: " + appointment.getDoctorName() + "\n" +
                        "Date: " + appointment.getDateTime().toLocalDate() + "\n" +
                        "Time: " + appointment.getDateTime().toLocalTime();
                JOptionPane.showMessageDialog(this, message);
            }
        } 
        else if (appointment.getDateTime().isBefore(currentDateTime)) {

            JOptionPane.showMessageDialog(this, "This appointment has been finished!");
            
            String userInput = JOptionPane.showInputDialog(null, "Duration(Minutes): ");

            String message = "Appointment Details:\n" +
                    "ID: " + appointment.getID() + "\n" +
                    "Patient Name: " + appointment.getPatientName() + "\n" +
                    "Doctor Name: " + appointment.getDoctorName() + "\n" +
                    "Date: " + appointment.getDateTime().toLocalDate() + "\n" +
                    "Time: " + appointment.getDateTime().toLocalTime() + "\n" +
                    "Duration: " + userInput + " minutes.";
            JOptionPane.showMessageDialog(this, message);
        } 
        else {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    public static void main(String[] args) {
        new AppointmentGUI();
    }
}

class Appointment {
    private String ID;
    private String patientName;
    private String doctorName;
    private LocalDateTime dateTime;

    public Appointment() {
        this.ID = "";
        this.patientName = "";
        this.doctorName = "";
        this.dateTime = null;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}