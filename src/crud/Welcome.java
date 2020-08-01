package crud;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Welcome extends BasicFrame
{
	private static final long serialVersionUID = 1L;
	
	public Welcome()
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
					JTextField main_heading=new JTextField("Welcome to the Student Management Application");
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
							+ "This is an application where a user can : <BR><UL>"
							+ "<LI> Add or Insert new student in the database.</LI>"
							+ "<LI> Delete student data from the database.</LI>"
							+ "<LI> Update or Change student data in the database.</LI>"
							+ "<LI> Read or Search for Student data present in the database.</LI>"
							+ "</UL></HTML>";
					JLabel main_para=new JLabel(para);
					main_para.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
					main_para.setForeground(Color.GRAY);
					main_para_panel.add(main_para);
				main_para_panel.setVisible(true);
				main_section.add(main_para_panel);
				
				JPanel button_panel=new JPanel();
				button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
					JButton main_button=new JButton("Enter Application");
					main_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
					main_button.setForeground(main_heading.getForeground());
						
						//When Button is Pressed
						main_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										new Login();
										disposeWindow();
									}
								});
					
					button_panel.add(main_button);
				button_panel.setVisible(true);
				main_section.add(button_panel);
//				main_heading_panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
//				main_para_panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
				
				//Footer Button
				JPanel footer_button_panel=new JPanel();
				footer_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
					JButton footer_button=new JButton("Close Application");
					footer_button.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
					footer_button.setBackground(Color.WHITE);
					footer_button.setForeground(main_heading.getForeground());
						
						//When Button is Pressed
						footer_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
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
	
	public static void main(String[] args)
	{
		new Welcome();
	}

}
