package downloadManager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MainEntry extends JFrame {

	private JPanel contentPane;
	private JTextField urlTextField;
	private JTable table;
	private JFileChooser chooser;
	private DefaultTableModel model;
	private DownloadManager downloadManager;
	private TableRefresher tableRefresher;

	private float[] columnWidthPer = { 30.0f, 60.0f, 10.0f };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainEntry frame = new MainEntry();
					frame.init();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainEntry() {
		setResizable(false);
		downloadManager = new DownloadManager();
		tableRefresher = new TableRefresher();
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	private void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(19, 22, 36, 16);
		contentPane.add(lblUrl);

		urlTextField = new JTextField();
		urlTextField.setBounds(56, 17, 388, 26);
		contentPane.add(urlTextField);
		urlTextField.setColumns(10);

		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (null == urlTextField.getText() || urlTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter URL", "Error", JOptionPane.ERROR_MESSAGE);
					urlTextField.requestFocus();
					return;
				}

				chooser = new JFileChooser();
				chooser.setDialogTitle("Select destination directory");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					String url = urlTextField.getText().trim();
					String dest = chooser.getSelectedFile().getAbsolutePath();

					Vector rowData = new Vector<>();
					rowData.addElement(Utility.getFileNameFromURL(url));
					rowData.addElement(dest);
					rowData.addElement("0%");
					downloadManager.startDownload(url, dest, rowData, tableRefresher);
					model.addRow(rowData);
				} else {
					JOptionPane.showMessageDialog(null, "No Selection. Download won't start", "Error",
							JOptionPane.ERROR_MESSAGE);
					btnDownload.requestFocus();
					return;
				}
				urlTextField.setText("");
			}
		});
		btnDownload.setBounds(327, 42, 117, 29);
		contentPane.add(btnDownload);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 71, 426, 189);
		contentPane.add(scrollPane);

		model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Filename");
		model.addColumn("Location");
		model.addColumn("Status");

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		int tW = scrollPane.getWidth();
		TableColumn column;
		TableColumnModel jTableColumnModel = table.getColumnModel();
		int cantCols = jTableColumnModel.getColumnCount();
		for (int i = 0; i < cantCols; i++) {
			column = jTableColumnModel.getColumn(i);
			int pWidth = Math.round(columnWidthPer[i] * tW);
			column.setPreferredWidth(pWidth);
		}

	}

	class TableRefresher {

		public void refreshTable() {
			model.fireTableDataChanged();
		}

	}

}
