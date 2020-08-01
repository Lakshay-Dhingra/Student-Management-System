package crud;
import java.awt.*;
import javax.swing.*;

import databases.StudentOperations;

import java.awt.event.*;

public class Update extends BasicFrame
{
private static final long serialVersionUID = 1L;
	
	public Update()
	{
		makeVisible();
	}
	private boolean isAlpha(String str)
	{
	    for (char c:str.toCharArray())
	    {
	        if(!Character.isLetter(c))
	        {
	            if((int)c!=32)	//Checking for space
	            {
	            	return false;
	            }
	        }
	    }
	    return true;
	}
	
	public void addMainSection()
	{
		JPanel main_section=new JPanel();
		main_section.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		main_section.setLayout(new BoxLayout(main_section,BoxLayout.Y_AXIS));
				
				//Main Heading
				JPanel main_heading_panel=new JPanel();
				main_heading_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
					JTextField main_heading=new JTextField("UPDATE DATA");
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
				
					JPanel studname_panel=new JPanel();
					studname_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel studname=new JLabel("Student Name: ");
						studname.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						studname.setForeground(Color.GRAY);
						studname_panel.add(studname);
						JTextField stud_input=new JTextField(20);
						stud_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						stud_input.setForeground(Color.GRAY);
						studname_panel.add(stud_input);
					studname_panel.setVisible(true);
					main_para_panel.add(studname_panel);
					
					JPanel degree_panel=new JPanel();
					degree_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel degree=new JLabel("Degree: ");
						degree.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						degree.setForeground(Color.GRAY);
						degree_panel.add(degree);
						JTextField degree_input=new JTextField(20);
						degree_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						degree_input.setForeground(Color.GRAY);
						degree_panel.add(degree_input);
					degree_panel.setVisible(true);
					main_para_panel.add(degree_panel);
					
					JPanel score_panel=new JPanel();
					score_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,0));
						JLabel score=new JLabel("Aggregate GPA (Out of 10): ");
						score.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						score.setForeground(Color.GRAY);
						score_panel.add(score);
						JTextField score_input=new JTextField(20);
						score_input.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
						score_input.setForeground(Color.GRAY);
						score_panel.add(score_input);
					score_panel.setVisible(true);
					main_para_panel.add(score_panel);
					
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
											
											String name=stud_input.getText();
											if(!isAlpha(name))
											{
												JOptionPane.showMessageDialog(main_section,"Student Name must not contain numbers or special characters.");
												return;
											}
											if(name.length()<2 && name.length()>30)
											{
												JOptionPane.showMessageDialog(main_section,"Student Name must be of 2 to 30 Characters.");
												return;
											}
											
											String deg=degree_input.getText();
											if(!isAlpha(deg))
											{
												JOptionPane.showMessageDialog(main_section,"Degree must not contain numbers or special characters.");
												return;
											}
											if(deg.length()<2 && deg.length()>30)
											{
												JOptionPane.showMessageDialog(main_section,"Degree must be of 2 to 30 Characters.");
												return;
											}
											
											String sc=score_input.getText();
											float marks=0;
											try
											{
												marks=(float)Double.parseDouble(sc);
											}
											catch(Exception ex)
											{
												JOptionPane.showMessageDialog(main_section,"GPA must be a valid number.");
												return;
											}
											if(sc.length()<1 && sc.length()>5)
											{
												JOptionPane.showMessageDialog(main_section,"GPA must be of 1 to 5 characters long.");
												return;
											}
											
											if(StudentOperations.updateStudent(rollno, name, deg, marks))
											{
												JOptionPane.showMessageDialog(main_section,"Details Updated Successfully!");
												new Update();
												dispose();
											}
											else
											{
												JOptionPane.showMessageDialog(main_section,"Couldn't update details of the student!");
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
