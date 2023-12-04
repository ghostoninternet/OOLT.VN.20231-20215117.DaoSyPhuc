package hust.soict.hedspi.aims.screen.manager;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends JFrame{
	private Store store;
	private JTextField id;
	private JTextField title;
	private JTextField category;
	private JTextField cost;
	private JTextField authors;
	private JButton btnSubmit;
	private JButton btnBack;

	public AddBookToStoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(6,6));
		
		cp.add(new JLabel("Enter id"));
		id = new JTextField(20);
		cp.add(id);
		
		cp.add(new JLabel("Enter title"));
		title = new JTextField(20);
		cp.add(title);
		
		cp.add(new JLabel("Enter authors ( separated by space )"));
		authors = new JTextField(20);
		cp.add(authors);
		
		cp.add(new JLabel("Enter category"));
		category = new JTextField(20);
		cp.add(category);
		
		cp.add(new JLabel("Enter cost"));
		cost = new JTextField(20);
		cp.add(cost);
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreManagerScreen(store);
				dispose();
				
			}
			
		});
		btnSubmit = new JButton("Enter");
		
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titleString = title.getText();
				String categoryString = category.getText();
				int idString = Integer.parseInt(id.getText());
				float costFloat = Float.parseFloat(cost.getText());
				Book book = new Book(idString, titleString, categoryString, costFloat);
				List<String> authorsList = new ArrayList<String>();
				String[] authorsArray = authors.getText().split(" ");
				for (String author: authorsArray) {
					authorsList.add(author);
				}
				store.addMedia(book);
				new StoreManagerScreen(store);
				dispose();
			}
			
		});
		cp.add(btnBack);
		cp.add(btnSubmit);

		setTitle("Add DVD");
		setSize(600,240);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
