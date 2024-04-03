package pkgJICQ.client.frame;
import java.awt.*;
import javax.swing.*;

public class MessageWindow extends JWindow {
	JPanel contentPane;

	BorderLayout borderLayout1 = new BorderLayout();

	JScrollPane jScrollPane1 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JTextPane jTextPane1 = new JTextPane();

	double x, y;

	// Construct the frame
	public MessageWindow(double x, double y) {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.x = x;
		this.y = y;
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setMaxValue() {
		this.jScrollPane1.getVerticalScrollBar().setValue(
				jScrollPane1.getVerticalScrollBar().getMaximum());
	}

	private void jbInit() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);

		jScrollPane1.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextPane1.setText("jTextPane1");
		jTextPane1.setEditable(false);
		contentPane.add(jScrollPane1, BorderLayout.CENTER);
		jScrollPane1.getViewport().add(jTextPane1, null);
		this.setBounds((int) x, (int) y, 471, 120);
		this.setVisible(true);

	}

}