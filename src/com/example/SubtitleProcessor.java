package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SubtitleProcessor extends JFrame implements KeyListener {

	private JLabel label;
	private JLabel timeLabel;
	private Map<Long, Subtitle> map;

	public SubtitleProcessor(Map<Long, Subtitle> map) {
		this.map = map;
		label = new JLabel("",SwingConstants.CENTER);
		timeLabel = new JLabel();
		label.setForeground(Color.white);
		
		setUndecorated(true);
		
		addKeyListener(this);
		setAutoRequestFocus(true);
		setResizable(true);

		setDefaultLookAndFeelDecorated(true);
		add(label,BorderLayout.CENTER);
		setSize(300, 100);
		setLocationRelativeTo(null);
		setLocation(getLocation().x, getLocation().y+300);
//		setLayout(new BorderLayout());
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0.5f));

	}

	public void process() throws InterruptedException, Exception {
		for (long i = 0; true; i++) {
			long cur = -1;
			int key = -1;
			if (map.containsKey(i)) {
				cur = map.get(i).getEnd();
				key = map.get(i).getKey();
				String time = SrtParser.secondsToTime(i);
				timeLabel.setText(time);
				label.setText("<html><body>" + map.get(i).getSub() + "</body></html>");
			}
			if (map.size() == key) {
				break;
			}
			Thread.sleep(1000);

		}
	}

		@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Point point = getLocation();
		Dimension dimension = getSize();
		if (e.isControlDown()) {
			if (e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
				setSize(new Dimension(dimension.width, dimension.height - 10));
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setSize(new Dimension(dimension.width, dimension.height + 10));
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setSize(new Dimension(dimension.width - 10, dimension.height));
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setSize(new Dimension(dimension.width + 10, dimension.height));
			}
		} else {

			if (e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
				setLocation(point.x, point.y - 10);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setLocation(point.x, point.y + 10);
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setLocation(point.x - 10, point.y);
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setLocation(point.x + 10, point.y);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
