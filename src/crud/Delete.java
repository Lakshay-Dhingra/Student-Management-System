package crud;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import databases.StudentOperations;

import java.awt.event.*;

public class Delete extends BasicFrame
{
private static final long serialVersionUID = 1L;
	
	public Delete()
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
					JTextField main_heading=new JTextField("DELETE DATA");
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
					
					JPanel studroll_panel=new JPanel();
					studroll_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel studroll=new JLabel("Student RollNo: ");
						studroll.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						studroll.setForeground(Color.GRAY);
						studroll_panel.add(studroll);
						JTextField roll_input=new JTextField(20);
						roll_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						roll_input.setForeground(Color.GRAY);
						studroll_panel.add(roll_input);
					studroll_panel.setVisible(true);
					main_para_panel.add(studroll_panel);
				
					
					JPanel button_panel=new JPanel();
					button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
						JButton main_button=new JButton("Delete Student");
						main_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
						main_button.setForeground(main_heading.getForeground());
							
							//When Button is Pressed
							main_button.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
											
											String rn=roll_input.getText();
											long rollno=0;
											try
											{
												rollno=Long.parseLong(rn);
											}
											catch(Exception ex)
											{
												JOptionPane.showMessageDialog(main_section,"Student RollNo must be numeric.");
												return;
											}
											if(rn.length()<5 && rn.length()>15)
											{
												JOptionPane.showMessageDialog(main_section,"Student RollNo must be of 5 to 15 Digits.");
												return;
											}
											
											if(StudentOperations.deleteStudent(rollno))
											{
												JOptionPane.showMessageDialog(main_section,"Student with RollNo: "+rollno+" deleted Successfully!");
												new Delete();
												dispose();
											}
											else
											{
												JOptionPane.showMessageDialog(main_section,"Couldn't delete the student records!");
											}
										}
									});
						
					button_panel.add(main_button);
					button_panel.setVisible(true);
					main_para_panel.add(button_panel);
					
					JPanel all_button_panel=new JPanel();
					all_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
						JButton all_main_button=new JButton("All Students Details");
						all_main_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
						all_main_button.setForeground(main_heading.getForeground());
							
							//When Button is Pressed
							all_main_button.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
											String[][] ans=StudentOperations.allStudents();
											if(ans==null)
											{
												JOptionPane.showMessageDialog(main_section,"Couldn't fetch student data!");
											}
											else if(ans.length==0)
											{
												JOptionPane.showMessageDialog(main_section,"No Student Found!");
											}
											else
											{												
												JFrame search_frame=new JFrame();
												Container c=search_frame.getContentPane();
												c.setBackground(Color.WHITE);
												search_frame.setLayout(new CardLayout(40,35));
												search_frame.setSize(750,450);
													String colname[]= {"RollNo","Name","Degree","GPA"};
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
						
					all_button_panel.add(all_main_button);
					all_button_panel.setVisible(true);
					main_para_panel.add(all_button_panel);
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
										new SelectOperation();
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
