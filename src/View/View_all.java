package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Bean.DanhMuc;
import Bean.SanPham;
import Model.Connect_Model;
import Model.DanhMuc_Model;
import Model.SanPham_Model;

public class View_all extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtProId;
	private JTextField txtProName;
	private JTextField txtProPrice;
	private JTextField txtProQuan;
	static JList Jlist ;
	static Object obj  ;
	int index ;
	static JComboBox comboBox ;
	static SanPham_Model spModel = new SanPham_Model();
	static DanhMuc_Model dmModel = new DanhMuc_Model();
	static DefaultListModel dl = new DefaultListModel(); 
	static DefaultTableModel tableItem = new DefaultTableModel();
	private JTextField txtProDes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		View_all view_all = new View_all();
		ArrayList<DanhMuc> arrDM = dmModel.getAllDM();
		
		for (DanhMuc dm : arrDM) {
			dl.addElement(dm);
			comboBox.addItem(dm.getTenDanhMuc()+"-"+dm.getMaDanhMuc());
		}
		Jlist.setModel(dl);
		tableItem.addColumn("Product ID");
		tableItem.addColumn("Product Name");
		tableItem.addColumn("UnitPrice");
		tableItem.addColumn("Quantity");
		tableItem.addColumn("Description");
		view_all.setVisible(true);
		view_all.addEvent();
		
	}
	public void refresh() {
		
	}
	public void addEvent() {
		
		Jlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				obj = Jlist.getSelectedValue();
				DanhMuc danhMuc = (DanhMuc)obj;
				int index2 = Jlist.getSelectedIndex();
				
				if (index2 != -1) {
					 ArrayList<SanPham> listSp = spModel.getAllSP(danhMuc.getMaDanhMuc());
					tableItem.setRowCount(0);
					for (SanPham sanPham : listSp) {
						Object[] arr = {sanPham.getIdSP(),sanPham.getTenSP(),sanPham.getDonGia(),
								sanPham.getSoLuong(),sanPham.getMoTa()};
						tableItem.addRow(arr);
				}
				}
					
			}
		});
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				txtProId.setText(model.getValueAt(row, 0).toString());
				txtProName.setText(model.getValueAt(row, 1).toString());
				txtProPrice.setText(model.getValueAt(row, 2).toString());
				txtProQuan.setText(model.getValueAt(row, 3).toString());
				txtProDes.setText(model.getValueAt(row, 4).toString());
				
			
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_all() {
		setTitle("Quản lí sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 723);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem(" Print");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhMuc dm = (DanhMuc)obj;  
				MessageFormat header = new MessageFormat(dm.getTenDanhMuc());
				MessageFormat footer = new MessageFormat("page");
				
				
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog(null, "không thể print");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respone =JOptionPane.showConfirmDialog(View_all.this,
						"bạn có chắc chắn muốn thoát không ?",
						"Thông báo",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (respone==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢNG LÍ SẢN PHẨM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(198, 11, 250, 24);
		contentPane.add(lblNewLabel);
		
		table = new JTable(tableItem);
		
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(269, 59, 426, 315);
		contentPane.add(scrollPane);
		
		Jlist = new JList();
		Jlist.setBounds(10, 59, 255, 449);
		contentPane.add(Jlist);
		
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(316, 407, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(414, 404, 168, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Productid");
		lblNewLabel_2.setBounds(316, 432, 88, 14);
		contentPane.add(lblNewLabel_2);
		
		txtProId = new JTextField();
		txtProId.setBounds(414, 429, 168, 20);
		contentPane.add(txtProId);
		txtProId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Product Name ");
		lblNewLabel_3.setBounds(316, 457, 88, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Unit Price ");
		lblNewLabel_4.setBounds(316, 483, 88, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setBounds(316, 508, 88, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Description");
		lblNewLabel_6.setBounds(316, 533, 88, 14);
		contentPane.add(lblNewLabel_6);
		
		txtProName = new JTextField();
		txtProName.setBounds(414, 454, 168, 20);
		contentPane.add(txtProName);
		txtProName.setColumns(10);
		
		txtProPrice = new JTextField();
		txtProPrice.setBounds(414, 480, 168, 20);
		contentPane.add(txtProPrice);
		txtProPrice.setColumns(10);
		
		txtProQuan = new JTextField();
		txtProQuan.setBounds(414, 505, 168, 20);
		contentPane.add(txtProQuan);
		txtProQuan.setColumns(10);
		
		JButton JlistNew = new JButton("New");
		JlistNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThongTinDanhMuc frame = new ThongTinDanhMuc();
				frame.setVisible(true);
				frame.btnOk.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Connect_Model coModel = new Connect_Model();
						if (coModel.Validate_DanhMuc(frame.txtCateID, frame.txtCateName)) {
							// TODO Auto-generated method stub
							String id = frame.txtCateID.getText().toString();
							String name = frame.txtCateName.getText().toString();
							DanhMuc danhMuc = new DanhMuc(id,name);
							if (dmModel.addDanhMuc(danhMuc)) {
								JOptionPane.showMessageDialog(null, "thêm thành công", "OKe", JOptionPane.INFORMATION_MESSAGE);
								
								frame.setVisible(false);
								dl.addElement(danhMuc);
								Jlist.setModel(dl);
								
								
							}
							else {
								JOptionPane.showMessageDialog(null, "somethings was wrong", "fail", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "kiểm tra lại thông tin", "fail", JOptionPane.INFORMATION_MESSAGE);
						}
						
						
						
					}
					
				});
				
			}
		});
		JlistNew.setBounds(10, 529, 70, 23);
		contentPane.add(JlistNew);
		
		JButton JlistUpdate = new JButton("Update");
		JlistUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhMuc dm = (DanhMuc)obj ;
				UpdateDanhMuc frame = new UpdateDanhMuc();
				frame.setVisible(true);
				frame.txtCateID.setText(dm.getMaDanhMuc());
				frame.txtCateName.setText(dm.getTenDanhMuc());
				frame.btnOk.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Connect_Model coModel = new Connect_Model();
						if (coModel.Validate_DanhMuc(frame.txtCateID,frame.txtCateName)) {
							String id = frame.txtCateID.getText();
							String name = frame.txtCateName.getText();
							DanhMuc danhMuc= new DanhMuc(id,name);
							if (dmModel.updateDanhMuc(danhMuc)) {
								JOptionPane.showMessageDialog(null, "update thành công", "OKe", JOptionPane.INFORMATION_MESSAGE);
								int select = Jlist.getSelectedIndex() ;
								System.out.println(select);
								dl.remove(select);
								dl.add(select, danhMuc);
								Jlist.setModel(dl);
								frame.setVisible(false);
							}
							else {
								JOptionPane.showMessageDialog(null, "somethings was wrong", "fail", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Kiểm tra lại thông tin", "fail", JOptionPane.INFORMATION_MESSAGE);
						}
						
						
						
					}
				});
				
			}
		});
		JlistUpdate.setBounds(83, 529, 88, 23);
		contentPane.add(JlistUpdate);
		
		JButton JlistRemove = new JButton("Remove");
		JlistRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DanhMuc danhMuc = (DanhMuc) obj ;
				if (spModel.checkBeforRemove(danhMuc.getMaDanhMuc())) {
					if (dmModel.deleteDanhMuc(danhMuc)) {
						JOptionPane.showMessageDialog(null, "Xóa thành công", "OKe", JOptionPane.INFORMATION_MESSAGE);
						ArrayList<DanhMuc> arrDM = dmModel.getAllDM();
						dl.clear();
						for (DanhMuc dm : arrDM) {
							dl.addElement(dm);
							comboBox.addItem(dm.getTenDanhMuc());
						}
						Jlist.setModel(dl);
					
					}else {
						JOptionPane.showMessageDialog(null, "somethings was wrong", "OKe", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					int respone =JOptionPane.showConfirmDialog(View_all.this,
							"danh mục này có dữ liệu bạn có chắc chắn xóa không ?",
							"Thông báo",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (respone==JOptionPane.YES_OPTION) {
						if (dmModel.deleteDanhMuc(danhMuc)) {
							JOptionPane.showMessageDialog(null, "Xóa thành công", "OKe", JOptionPane.INFORMATION_MESSAGE);
							ArrayList<DanhMuc> arrDM = dmModel.getAllDM();
							dl.clear();
							for (DanhMuc dm : arrDM) {
								dl.addElement(dm);
								comboBox.addItem(dm.getTenDanhMuc());
							}
							Jlist.setModel(dl);
						
						}else {
							JOptionPane.showMessageDialog(null, "somethings was wrong", "OKe", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				
			
			}
		});
		JlistRemove.setBounds(177, 529, 88, 23);
		contentPane.add(JlistRemove);
		
		JButton proNew = new JButton("New");
		proNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProId.setText("");
				txtProName.setText("");
				txtProPrice.setText("");
				txtProQuan.setText("");
				txtProDes.setText("");
			}
		});
		proNew.setBounds(292, 612, 89, 23);
		contentPane.add(proNew);
		
		JButton proSave = new JButton("Save");
		proSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect_Model coModel = new Connect_Model();
				if (coModel.Validate_SP(txtProId, txtProName, txtProPrice, txtProQuan, txtProDes)) {
					String tenDanhMuc=comboBox.getSelectedItem().toString();
					String [] tenDm = tenDanhMuc.split("-");
					String idDanhMuc = tenDm[1];
					String id = txtProId.getText().toString() ;
					String name = txtProName.getText().toString();
					Double gia= Double.parseDouble(txtProPrice.getText().toString());
					int soLuong = Integer.parseInt(txtProQuan.getText().toString());
					String moTa = txtProDes.getText().toString();
					SanPham sanPham = new SanPham(id,name,gia,soLuong,moTa,idDanhMuc);
					String message = spModel.checkAndChane(sanPham);
					DanhMuc danhMuc = (DanhMuc)obj;
					 ArrayList<SanPham> listSp = spModel.getAllSP(danhMuc.getMaDanhMuc());
						tableItem.setRowCount(0);
						for (SanPham sanPham1 : listSp) {
							Object[] arr = {sanPham1.getIdSP(),sanPham1.getTenSP(),sanPham1.getDonGia(),
									sanPham1.getSoLuong(),sanPham1.getMoTa()};
							tableItem.addRow(arr);
						}
					
					JOptionPane.showMessageDialog(null, message, "OKe", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Kiểm tra lại thông tin", "OKe", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		proSave.setBounds(391, 612, 89, 23);
		contentPane.add(proSave);
		
		JButton proRemove = new JButton("Remove");
		proRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtProId.getText().toString();
				if (spModel.delete(id)) {
					JOptionPane.showMessageDialog(null, "xóa thành công", "OKe", JOptionPane.INFORMATION_MESSAGE);
					tableItem.fireTableDataChanged();
				}else {
					JOptionPane.showMessageDialog(null, "xóa không thành công", "fail", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		proRemove.setBounds(493, 612, 89, 23);
		contentPane.add(proRemove);
		
		txtProDes = new JTextField();
		txtProDes.setBounds(414, 530, 168, 71);
		contentPane.add(txtProDes);
		txtProDes.setColumns(10);
	}
}
