package crud;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class AdminPage extends BasicFrame
{
	private static final long serialVersionUID = 1L;
	public AdminPage()
	{
		makeVisible();
	}
	public void addMainSection()
	{
		JPanel main_section=new JPanel();
		main_section.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		main_section.setLayout(new BoxLayout(main_section,BoxLayout.Y_AXIS));
				JPanel main_heading_panel=new JPanel();
				main_heading_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
					JTextField main_heading=new JTextField("Student Management Application - Admin Page");
					main_heading.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
					main_heading.setForeground(Color.DARK_GRAY);
					main_heading.setBackground(main_section.getBackground());
					main_heading.setBorder(BorderFactory.createEmptyBorder());
					main_heading_panel.add(main_heading);
				main_heading_panel.setVisible(true);
				main_section.add(main_heading_panel);
				
				JPanel main_para_panel=new JPanel();
				main_para_panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
					String para="<HTML>"
							+ "If you are running this application first time: <BR><UL>"
							+ "<LI> JRE 1.8 or above must be installed on your system.</LI>"
							+ "<LI> You need to install MySQL Client (v5.0 or above) and set its Username and Password.</LI>"
							+ "<LI> Open MySQL Client, and write 'create database dbname'.You can use any name instead of 'dbname'.</LI>"
							+ "<LI> Click on 'Set Up Database' button to add database to this application.</LI>"
							+ "</UL></HTML>";
					JLabel main_para=new JLabel(para);
					main_para.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
					main_para.setForeground(Color.GRAY);
					main_para_panel.add(main_para);
				main_para_panel.setVisible(true);
				main_section.add(main_para_panel);
				
				JPanel button_panel=new JPanel();
				button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
					JButton main_button=new JButton("Set Up Database");
					main_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
					main_button.setForeground(main_heading.getForeground());
						
						//When Button is Pressed
						main_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										new DBSetup();
										dispose();
									}
								});
					
					button_panel.add(main_button);
				button_panel.setVisible(true);
				main_section.add(button_panel);
				
				JPanel dashboard_button_panel=new JPanel();
				dashboard_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
					JButton dashboard_main_button=new JButton("Go To Admin Dashboard");
					dashboard_main_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
					dashboard_main_button.setForeground(main_heading.getForeground());
						
						//When Button is Pressed
						dashboard_main_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										new AdminDashboard();
										disposeWindow();
									}
								});
					
				dashboard_button_panel.add(dashboard_main_button);
				dashboard_button_panel.setVisible(true);
				main_section.add(dashboard_button_panel);
				
				//Footer Button
				JPanel footer_button_panel=new JPanel();
				footer_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
					JButton footer_button=new JButton("Logout");
					footer_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
					footer_button.setBackground(Color.WHITE);
					footer_button.setForeground(main_heading.getForeground());
						
						//When Button is Pressed
						footer_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										new Login();
										disposeWindow();
									}
								});
					
				footer_button_panel.add(footer_button);
				footer_button_panel.setVisible(true);
				main_section.add(footer_button_panel);
				//Footer Button End
				
		main_section.setVisible(true);
		main_panel.add(main_section);
	}
}
