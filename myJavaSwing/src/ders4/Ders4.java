package ders4;

import javax.swing.*;
import java.awt.event.*;

public class Ders4 extends JFrame {
	JButton buton1;
	String bilgilendirme = "";
	JList favoriFilmler, FavoriRenk;
	DefaultListModel defListModel = new DefaultListModel();
	JScrollPane scroller;

	public static void main(String[] args) {
		new Ders4();
	}

	public Ders4() {
		this.setSize(310, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Beşinci Frame");
		
		JPanel panelim = new JPanel();
		buton1 = new JButton("Bilgi");
		ListenForButtons butonL = new ListenForButtons();
		buton1.addActionListener(butonL);
		panelim.add(buton1);
		
		String[] filmler = { "Matix", "Yedi Bela Hüsnü", "Esaretin Bedeli" };
		favoriFilmler = new JList(filmler);
		favoriFilmler.setFixedCellHeight(30);
		favoriFilmler.setFixedCellWidth(150);
		favoriFilmler.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		
		String[] renkler = { "sari", "siyah", "beyaz", "pembe", "kırmızı" };
		for (String renk : renkler) {
			defListModel.addElement(renk);
		}
		defListModel.add(2, "kara");
		FavoriRenk = new JList(defListModel);
		FavoriRenk.setVisibleRowCount(4);
		scroller = new JScrollPane(FavoriRenk, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		FavoriRenk.setFixedCellHeight(30);
		FavoriRenk.setFixedCellWidth(150);
		
		
		panelim.add(favoriFilmler);
		panelim.add(scroller);
		this.add(panelim);
		this.setVisible(true);
	}

	private class ListenForButtons implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buton1) {
				if (defListModel.contains("siyah")) {
					bilgilendirme += "siyah burda" + " ";
				}
				if (!defListModel.isEmpty()) {
					bilgilendirme += "boş değil" + " ";
					bilgilendirme += "Listekide elemanlar: " + defListModel.size() + " ";
					bilgilendirme += "Son eleman " + defListModel.lastElement() + " ";
					bilgilendirme += "İlk eleman " + defListModel.firstElement() + " ";
					bilgilendirme += "index 1 " + defListModel.get(1) + " ";
					defListModel.remove(0);
					defListModel.removeElement("pembe");
					Object[] listArray = defListModel.toArray();
					for (Object renk : listArray) {
						bilgilendirme += renk + " ";
					}
				}
				JOptionPane.showMessageDialog(Ders4.this, bilgilendirme, "Açıklama",
						JOptionPane.INFORMATION_MESSAGE);
				bilgilendirme = "";
			}
		}
	}
}