import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mine extends JFrame {
	protected static int level;
	JButton b1 = new JButton("1"); // 레벨 선택 버튼
	JButton b2 = new JButton("2"); // 레벨 선택 버튼
	JButton b3 = new JButton("3"); // 레벨 선택 버튼
	JPanel jp = new JPanel(); // 패널 1
	JPanel jp2 = new JPanel(); // 패널 2
	JLabel jb = new JLabel("난이도 선택"); // 레이블 텍스트 설정

public mine() {
	super("지뢰찾기"); // 타이틀
	
	jp.add(jb); 
	this.setLayout(new BorderLayout());
	jp2.add(b1);
	jp2.add(b2);
	jp2.add(b3);
	add(jp, "North");
	add(jp2);
	
	b1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	JOptionPane.showMessageDialog(null, "1단계"); // ※추후 삭제 할것
	    }
	});
	b2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	JOptionPane.showMessageDialog(null, "2단계"); // ※추후 삭제 할것
	    }
	});
	b3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	JOptionPane.showMessageDialog(null, "3단계"); // ※추후 삭제 할것
	    }
	});
	
	setVisible(true); // 프레임 보이기
	setSize(500, 500); // 프레임 사이즈 설정
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X 누르면 닫기
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	new mine(); // 프레임 불러오기
}
}