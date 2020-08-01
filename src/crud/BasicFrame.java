package crud;
import java.awt.*;
import javax.swing.*;


public class BasicFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	public Container content;
	public JPanel title_panel;
	public JPanel main_panel;
	public BasicFrame()
	{
		super("Student Managment System");
		setSize(1350,850);
		setLocation(280,115);
		content=this.getContentPane();
		content.setLayout(new BorderLayout());
			title_panel=new JPanel();
			title_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
				addTitle("Student Managment System");
			title_panel.setVisible(true);
			
			main_panel=new JPanel();
			main_panel.setLayout(new CardLayout(180,120));
				addMainSection();
			main_panel.setVisible(true);
			
			baseStyling();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void makeVisible()
	{
		content.add(title_panel,BorderLayout.NORTH);
		content.add(main_panel,BorderLayout.CENTER);
		setVisible(true);
	}
	public void addTitle(String title_text)
	{
		JTextField title=new JTextField(title_text);
		title.setFont(new Font(Font.MONOSPACED,Font.BOLD,42));
		title.setBackground(Color.CYAN);
		title.setForeground(Color.BLACK);
		title.setBorder(BorderFactory.createEmptyBorder());
		title.setEditable(false);
		
		title_panel.add(title);
	}
	public void addMainSection()
	{}
	public void baseStyling()
	{
		title_panel.setBackground(Color.CYAN);
		title_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		main_panel.setBackground(Color.WHITE);
		main_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
	}
	public void disposeWindow()
	{
		super.dispose();
	}
}
