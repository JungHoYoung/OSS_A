import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mine extends JFrame {
	protected static int level;
	JButton b1 = new JButton("1"); // ���� ���� ��ư
	JButton b2 = new JButton("2"); // ���� ���� ��ư
	JButton b3 = new JButton("3"); // ���� ���� ��ư
	JPanel jp = new JPanel(); // �г� 1
	JPanel jp2 = new JPanel(); // �г� 2
	JLabel jb = new JLabel("���̵� ����"); // ���̺� �ؽ�Ʈ ����

public mine() {
	super("����ã��"); // Ÿ��Ʋ
	
	jp.add(jb); 
	this.setLayout(new BorderLayout());
	jp2.add(b1);
	jp2.add(b2);
	jp2.add(b3);
	add(jp, "North");
	add(jp2);
	
	b1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	JOptionPane.showMessageDialog(null, "1�ܰ�"); // ������ ���� �Ұ�
	    }
	});
	b2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	JOptionPane.showMessageDialog(null, "2�ܰ�"); // ������ ���� �Ұ�
	    }
	});
	b3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	JOptionPane.showMessageDialog(null, "3�ܰ�"); // ������ ���� �Ұ�
	    }
	});
	
	setVisible(true); // ������ ���̱�
	setSize(500, 500); // ������ ������ ����
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X ������ �ݱ�
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	new mine(); // ������ �ҷ�����
}
}