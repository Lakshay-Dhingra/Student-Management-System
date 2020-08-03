package crud;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DBSetup extends BasicFrame
{
private static final long serialVersionUID = 1L;
	
	public DBSetup()
	{
		makeVisible();
	}

	public void addMainSection()
	{
		JPanel main_section=new JPanel();
		main_section.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		main_section.setLayout(new BoxLayout(main_section,BoxLayout.Y_AXIS));
				
				//Main Heading
				JPanel main_heading_panel=new JPanel();
				main_heading_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
					JTextField main_heading=new JTextField("SET UP DATABASE");
					main_heading.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
					main_heading.setForeground(Color.DARK_GRAY);
					main_heading.setBackground(main_section.getBackground());
					main_heading.setBorder(BorderFactory.createEmptyBorder());
					main_heading_panel.add(main_heading);
				main_heading_panel.setVisible(true);
				main_section.add(main_heading_panel);
				//Main Heading End
				
				//Main Para
				JPanel main_para_panel=new JPanel();
				main_para_panel.setLayout(new BoxLayout(main_para_panel,BoxLayout.Y_AXIS));
				
					JPanel mysqlun_panel=new JPanel();
					mysqlun_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel mysqlun=new JLabel("MySQL Username: ");
						mysqlun.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						mysqlun.setForeground(Color.GRAY);
						mysqlun_panel.add(mysqlun);
						JTextField mysqlun_input=new JTextField(20);
						mysqlun_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						mysqlun_input.setForeground(Color.GRAY);
						mysqlun_panel.add(mysqlun_input);
					mysqlun_panel.setVisible(true);
					main_para_panel.add(mysqlun_panel);
					
					JPanel mysqlpw_panel=new JPanel();
					mysqlpw_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel mysqlpw=new JLabel("MySQL Password: ");
						mysqlpw.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						mysqlpw.setForeground(Color.GRAY);
						mysqlpw_panel.add(mysqlpw);
						JPasswordField mysqlpw_input=new JPasswordField(20);
						mysqlpw_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						mysqlpw_input.setForeground(Color.GRAY);
						mysqlpw_panel.add(mysqlpw_input);
					mysqlpw_panel.setVisible(true);
					main_para_panel.add(mysqlpw_panel);
					
					JPanel dbname_panel=new JPanel();
					dbname_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel dbname=new JLabel("Database Name (dbname): ");
						dbname.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						dbname.setForeground(Color.GRAY);
						dbname_panel.add(dbname);
						JTextField dbname_input=new JTextField(20);
						dbname_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						dbname_input.setForeground(Color.GRAY);
						dbname_panel.add(dbname_input);
					dbname_panel.setVisible(true);
					main_para_panel.add(dbname_panel);
					
					JPanel adminun_panel=new JPanel();
					adminun_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel adminun=new JLabel("Set Admin Username: ");
						adminun.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						adminun.setForeground(Color.GRAY);
						adminun_panel.add(adminun);
						JTextField adminun_input=new JTextField(20);
						adminun_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						adminun_input.setForeground(Color.GRAY);
						adminun_panel.add(adminun_input);
					adminun_panel.setVisible(true);
					main_para_panel.add(adminun_panel);
					
					JPanel adminpw_panel=new JPanel();
					adminpw_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel adminpw=new JLabel("Set Admin Password: ");
						adminpw.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						adminpw.setForeground(Color.GRAY);
						adminpw_panel.add(adminpw);
						JPasswordField adminpw_input=new JPasswordField(20);
						adminpw_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						adminpw_input.setForeground(Color.GRAY);
						adminpw_panel.add(adminpw_input);
					adminpw_panel.setVisible(true);
					main_para_panel.add(adminpw_panel);
					
					JPanel button_panel=new JPanel();
					button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
						JButton main_button=new JButton("Update Details");
						main_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
						main_button.setForeground(main_heading.getForeground());
							
							//When Button is Pressed
							main_button.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
											
											String mysql_username=mysqlun_input.getText();
											String mysql_password=String.valueOf(mysqlpw_input.getPassword());
											String admin_username=adminun_input.getText();
											String admin_password=String.valueOf(adminpw_input.getPassword());
											String databasename=dbname_input.getText();
											
											if(admin_username.length()<5 && admin_username.length()>20 && admin_password.length()<5 && admin_password.length()>20)
											{
												JOptionPane.showMessageDialog(main_section,"Admin Username and Password must of 5 to 20 characters long.");
												return;
											}
											
											if(StoreDetails.setUpDB(admin_username, admin_password, databasename, mysql_username, mysql_password))
											{
												JOptionPane.showMessageDialog(main_section,"Database Created Successfully!");
												new AddUser();
												dispose();
											}
											else
											{
												JOptionPane.showMessageDialog(main_section,"Couldn't add database!");
											}
										}
									});
						
					button_panel.add(main_button);
					button_panel.setVisible(true);
					main_para_panel.add(button_panel);
				main_para_panel.setVisible(true);
				main_section.add(main_para_panel);
				//Main Para End
				
				//Footer Button
				JPanel footer_button_panel=new JPanel();
				footer_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
					JButton footer_button=new JButton("Select Operation");
					footer_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
					footer_button.setBackground(Color.WHITE);
					footer_button.setForeground(main_heading.getForeground());
						
						//When Button is Pressed
						footer_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										new AdminDashboard();
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
