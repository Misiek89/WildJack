package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Reprezentuje kontrolkê do zmiany parametrów gry.<br>
 * 
 * @author Misiek
 * @date 26.04.2013
 */
public class MySpinner extends JComponent implements ActionListener,
		MouseListener {
	private static final long serialVersionUID = 1L;
	private Font font, font2;
	private boolean editable = true, numeric;
	private String title;
	private String[] values;
	private JLabel LTitle, LValue;
	private int min, max, current, defaultValue, step, x, y;
	private JButton BPlus, BMinus;
	private Controller boss;

	// Constructor
	public MySpinner(int min_, int max_, int step_, int default_,
			String title_, Font font_, Font font2_) {
		if (min_ < max_ && step_ < (max_ - min_) && default_ >= min_
				&& default_ <= max_ && title_ != null && font_ != null
				&& font2_ != null) {
			max = max_;
			min = min_;
			defaultValue = default_;
			current = defaultValue;
			step = step_;
			title = title_;
			font = font_;
			font2 = font2_;

			numeric = true;
			this.setSize(200, 80);

			LTitle = new JLabel(title);
			LTitle.setBounds(0, 0, 200, 40);
			LTitle.setHorizontalAlignment(JTextField.CENTER);
			LTitle.setForeground(Color.BLACK);
			LTitle.setFont(font);
			this.add(LTitle);

			BMinus = new JButton("<<<");
			BMinus.setBounds(0, 40, 40, 40);
			BMinus.setActionCommand("BMinus");
			BMinus.setContentAreaFilled(false);
			BMinus.setForeground(Color.BLACK);
			BMinus.setFocusable(false);
			BMinus.setFont(font2);
			BMinus.setBorder(null);
			BMinus.addActionListener(this);
			BMinus.addMouseListener(this);
			this.add(BMinus);

			BPlus = new JButton(">>>");
			BPlus.setBounds(160, 40, 40, 40);
			BPlus.setActionCommand("BPlus");
			BPlus.setContentAreaFilled(false);
			BPlus.setForeground(Color.BLACK);
			BPlus.setFocusable(false);
			BPlus.setFont(font2);
			BPlus.setBorder(null);
			BPlus.addActionListener(this);
			BPlus.addMouseListener(this);
			this.add(BPlus);

			LValue = new JLabel(Integer.toString(defaultValue));
			LValue.setBounds(0, 40, 200, 30);
			LValue.setHorizontalAlignment(JTextField.CENTER);
			LValue.setForeground(Color.BLACK);
			LValue.setFont(font);
			this.add(LValue);

			this.repaint();
		} else
			System.err.println("Wrong arg - MySpinner(...)");
	}

	public MySpinner(String[] values_, int default_, String title_, Font font_,
			Font font2_) {
		if (values_ != null && default_ >= 0 && default_ <= values_.length
				&& title_ != null && font_ != null && font2_ != null) {
			values = values_;
			min = 0;
			max = values.length - 1;
			defaultValue = default_;
			current = defaultValue;
			font = font_;
			font2 = font2_;
			title = title_;

			numeric = false;
			this.setSize(200, 80);

			LTitle = new JLabel(title);
			LTitle.setBounds(0, 0, 200, 40);
			LTitle.setHorizontalAlignment(JTextField.CENTER);
			LTitle.setForeground(Color.BLACK);
			LTitle.setFont(font);
			this.add(LTitle);

			BMinus = new JButton("<<<");
			BMinus.setBounds(0, 40, 40, 40);
			BMinus.setActionCommand("BMinus");
			BMinus.setContentAreaFilled(false);
			BMinus.setForeground(Color.BLACK);
			BMinus.setFocusable(false);
			BMinus.setFont(font2);
			BMinus.setBorder(null);
			BMinus.addActionListener(this);
			BMinus.addMouseListener(this);
			this.add(BMinus);

			BPlus = new JButton(">>>");
			BPlus.setBounds(160, 40, 40, 40);
			BPlus.setActionCommand("BPlus");
			BPlus.setContentAreaFilled(false);
			BPlus.setForeground(Color.BLACK);
			BPlus.setFocusable(false);
			BPlus.setFont(font2);
			BPlus.setBorder(null);
			BPlus.addActionListener(this);
			BPlus.addMouseListener(this);
			this.add(BPlus);

			LValue = new JLabel(values[defaultValue]);
			LValue.setBounds(0, 40, 200, 30);
			LValue.setHorizontalAlignment(JTextField.CENTER);
			LValue.setForeground(Color.BLACK);
			LValue.setFont(font);
			this.add(LValue);

			this.repaint();
		}
	}

	// Getters
	public int getValue() {
		return current;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getStep() {
		return step;
	}

	public String getTitle() {
		return title;
	}

	public Font getFont() {
		return font;
	}

	public Controller getBoss() {
		return boss;
	}

	// Setters
	public void setEditable(boolean var_) {
		editable = var_;
		BPlus.setVisible(editable);
		BMinus.setVisible(editable);
	}

	public void setDefault() {
		current = defaultValue;
		if (numeric)
			LValue.setText(Integer.toString(current));
		else
			LValue.setText(values[current]);
	}

	public void setValue(int var_) {
		if (numeric) {
			if (var_ % step == 0 && var_ >= min && var_ <= max) {
				current = var_;
				LValue.setText(Integer.toString(current));
			}
		} else if (values != null && var_ >= 0 && var_ < values.length) {
			current = var_;
			LValue.setText(values[current]);
		}
	}

	public void setSpinnerSize(int x_, int y_) {
		if (x_ > 0 && y_ > 0 && LTitle != null && BMinus != null
				&& BPlus != null && LValue != null) {
			x = x_;
			y = y_;

			super.setSize(x, y);
			LTitle.setBounds(0, 0, x, y / 2);
			BMinus.setBounds(0, y / 2, x / 4, y / 2);
			BPlus.setBounds(3 * x / 4, y / 2, x / 4, y / 2);
			LValue.setBounds(x / 4, y / 2, x / 2, y / 2);
		} else
			System.err.println("Wrong arg - MySpinner.setSpinnerSize(x_, y_)");
	}

	public void setBoss(Controller boss_) {
		boss = boss_;
	}

	// Action Listener
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "BPlus" && editable) {
			if (numeric && current + step <= max) {
				current += step;
				LValue.setText(Integer.toString(current));
			} else if (!numeric && current < values.length - 1)
				LValue.setText(values[++current]);
			if (boss != null){}
				//boss.setGameSettings();
			//TODO zrobiæ coœ z t¹ metod¹
		} else if (e.getActionCommand() == "BMinus" && editable) {
			if (numeric && current - step >= min) {
				current -= step;
				LValue.setText(Integer.toString(current));
			} else if (!numeric && current > 0)
				LValue.setText(values[--current]);
			if (boss != null){}
				//boss.setGameSettings();
				//TODO jw.
		}
	}

	// Mouse listener
	public void mouseEntered(MouseEvent e) {
		((JButton) e.getSource()).setForeground(Color.GREEN);
	}

	public void mouseExited(MouseEvent e) {
		((JButton) e.getSource()).setForeground(Color.BLACK);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
