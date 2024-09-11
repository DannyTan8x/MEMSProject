package control.UIComponents;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class JFoodterBar extends JToolBar {
	public static JLabel LoginAcc = new JLabel();
	public JFoodterBar() throws FileNotFoundException {
		super();
		JClockLabel clock = new JClockLabel();
		JHostStatus hostStatus = new JHostStatus();
		hostStatus.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel pContainer = new JPanel();

		pContainer.setLayout(new GridLayout(0, 3, 0, 0));
		JPanel pLeft = new JPanel();
		pLeft.add(hostStatus);
		FlowLayout fl_pLeft = (FlowLayout) pLeft.getLayout();
		fl_pLeft.setAlignment(FlowLayout.LEFT);

		JPanel pCenter = new JPanel();
		pCenter.add(LoginAcc);
		FlowLayout fl_pCenter = (FlowLayout) pCenter.getLayout();
		fl_pCenter.setAlignment(FlowLayout.CENTER);

		JPanel pRight = new JPanel();
		pRight.add(clock);
		FlowLayout fl_pRight = (FlowLayout) pRight.getLayout();
		fl_pRight.setAlignment(FlowLayout.RIGHT);

		pContainer.add(pLeft);

		pContainer.add(pCenter);

		pContainer.add(pRight);
		this.add(pContainer);
		this.setFloatable(false);
	}

}
