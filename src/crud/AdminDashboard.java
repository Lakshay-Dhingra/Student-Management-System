package crud;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;


import java.awt.event.*;
public class AdminDashboard extends BasicFrame
{
	private static final long serialVersionUID = 1L;
	AdminDashboard()
	{
		makeVisible();
	}
	
	public void addMainSection()
	{
		JPanel main_section=new JPanel();
		main_section.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		main_section.setLayout(new BorderLayout(0,0));
			
			//Main Heading
			JPanel main_heading_panel=new JPanel();
			main_heading_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
				JTextField main_heading=new JTextField("Admin Dashboard");
				main_heading.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
				main_heading.setForeground(Color.DARK_GRAY);
				main_heading.setBackground(main_section.getBackground());
				main_heading.setBorder(BorderFactory.createEmptyBorder());
				main_heading_panel.add(main_heading);
			main_heading_panel.setVisible(true);
			main_section.add(main_heading_panel,BorderLayout.NORTH);
			//Main Heading End
			
			//Main Para
			JPanel main_para_panel=new JPanel();
			main_para_panel.setLayout(new CardLayout(30,15));
				JPanel main_para_grid=new JPanel();
				main_para_grid.setLayout(new GridLayout(2,2,15,20));
					JButton create_btn=new JButton("Add New User");
						create_btn.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								new AddUser();
								disposeWindow();
							}
						});	
					main_para_grid.add(create_btn);
					create_btn.setFont(new Font(Font.MONOSPACED,Font.BOLD,32));
					create_btn.setBackground(new Color(255,239,213));
					create_btn.setForeground(main_heading.getForeground());
					create_btn.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
					
					JButton read_btn=new JButton("See All Users");
						read_btn.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								String[][] ans=databases.UserOperations.allUsers();
								if(ans==null)
								{
									JOptionPane.showMessageDialog(main_section,"Couldn't fetch user data!");
								}
								else if(ans.length==0)
								{
									JOptionPane.showMessageDialog(main_section,"No User Found!");
								}
								else
								{												
									JFrame search_frame=new JFrame();
									Container c=search_frame.getContentPane();
									c.setBackground(Color.WHITE);
									search_frame.setLayout(new CardLayout(40,35));
									search_frame.setSize(750,450);
										String colname[]= {"Username","Password"};
										JTable jt=new JTable(ans,colname);
											jt.setEnabled(false);
											jt.setRowHeight(30);
											jt.setFont(new Font(Font.MONOSPACED,Font.PLAIN,18));
											jt.setForeground(Color.DARK_GRAY);
											JTableHeader jthead = jt.getTableHeader();
											jthead.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
											jthead.setForeground(Color.BLACK);
											
										JScrollPane jtsp=new JScrollPane(jt);
											jtsp.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
										search_frame.add(jtsp);
									search_frame.setVisible(true);
									setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								}
							}
						});	
					main_para_grid.add(read_btn);
					read_btn.setFont(create_btn.getFont());
					read_btn.setBackground(new Color(224,255,255));
					read_btn.setForeground(create_btn.getForeground());
					read_btn.setBorder(create_btn.getBorder());
					
					JButton update_btn=new JButton("Remove A User");
						update_btn.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								new DeleteUser();
								disposeWindow();
							}
						});
					main_para_grid.add(update_btn);
					update_btn.setFont(create_btn.getFont());
					update_btn.setBackground(new Color(255,165,0));
					update_btn.setForeground(create_btn.getForeground());
					update_btn.setBorder(create_btn.getBorder());
					
					JButton delete_btn=new JButton("Set Up Database");
						delete_btn.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								new DBSetup();
								disposeWindow();
							}
						});	
					main_para_grid.add(delete_btn);
					delete_btn.setFont(create_btn.getFont());
					delete_btn.setBackground(new Color(255,105,180));
					delete_btn.setForeground(create_btn.getForeground());
					delete_btn.setBorder(create_btn.getBorder());
					
				main_para_grid.setVisible(true);
				main_para_panel.add(main_para_grid);
			main_para_panel.setVisible(true);
			main_section.add(main_para_panel,BorderLayout.CENTER);
			//Main Para End
			
			//Footer Button
			JPanel footer_button_panel=new JPanel();
			footer_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
				JButton footer_button=new JButton("Admin Page");
				footer_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
				footer_button.setBackground(Color.WHITE);
				footer_button.setForeground(main_heading.getForeground());
					
					//When Button is Pressed
					footer_button.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									new AdminPage();
									disposeWindow();
								}
							});
				
			footer_button_panel.add(footer_button);
			footer_button_panel.setVisible(true);
			main_section.add(footer_button_panel,BorderLayout.SOUTH);
			//Footer Button End	

		main_section.setVisible(true);
		main_panel.add(main_section);
	}
	
}
