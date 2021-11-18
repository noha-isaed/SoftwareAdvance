package edu.najah.cap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class Editor extends JFrame implements ActionListener, DocumentListener {
	
	private JEditorPane textPanel;
	private JMenuBar menu;
	private boolean changeStatus = false;
	private File file;
	
	private MenuBar menuBar  = new MenuBar()  ;

	public Editor() {
		super(Variable.APP_NAME);
		setTextPanel(new JEditorPane());
		
		JScrollPane scrollPanel = new JScrollPane(getTextPanel()) ;
		add(scrollPanel , Variable.MIDDILE_OF_CONTAINER);
		getTextPanel().getDocument().addDocumentListener(this);
		
		setMenu(new JMenuBar());
		setJMenuBar(getMenu());
		BuildMenu();

		setSize(Variable.WIDTH_OF_TEXT_PANEL, Variable.HEIGHT_OF_TEXT_PANEL);
		
		setVisible(Variable.VISIABLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setTextPanel(JEditorPane textPanel) {
		this.textPanel = textPanel ; 
	}
	
	public JEditorPane getTextPanel() {
		return textPanel;
	}
	
	public void setMenu(JMenuBar menu) {
		this.menu = menu ; 
	}
	
	public JMenuBar getMenu() {
		return menu;
	}

	public void setChangeStatus(boolean changeStatus) {
		this.changeStatus = changeStatus ; 
	}
	
	public boolean getChangeStatus() {
		return changeStatus;
	}
	
	public void setFile(File file) {
		this.file = file ; 
	}
	
	public File getFile() {
		return file;
	}
	
	private void BuildMenu() {
		menuBar.buildFileMenu(this);
		menuBar.buildEditMenu(this);
	}
	
	public void createException() {
			
			String text = textPanel.getText();
			System.out.println(text);
			
			try (PrintWriter writer = new PrintWriter(getFile());){
				if (!getFile().canWrite())
					throw new Exception("Cannot write file!");
				writer.write(text);
				setChangeStatus(false);
				
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	
	public void saveFile() {

		if (getChangeStatus()) {
			
			Variable.SELECT_OPTION = JOptionPane.showConfirmDialog(null, Variable.WARNING_MESSAGE , 
					Variable.ADDRESS_OF_CONFIRM_DIALOG, 
					Variable.YES_AND_NO_OPTIONS, 
					Variable.ID_FOR_CONFIRM_DIALOG);
		}
		
		if (Variable.SELECT_OPTION != Variable.NO_IS_CHOSEN && getFile() == null) {
				saveAs(Variable.SAVE_Menu_ITEM);
				
		} else if(Variable.SELECT_OPTION  != Variable.NO_IS_CHOSEN){
			createException();
			
			}
	}
	
	
	public void newFile() {
		
		if (getChangeStatus()) {
			
			Variable.SELECT_OPTION = JOptionPane.showConfirmDialog(null, Variable.WARNING_MESSAGE , 
					Variable.ADDRESS_OF_CONFIRM_DIALOG, 
					Variable.YES_AND_NO_OPTIONS, 
					Variable.ID_FOR_CONFIRM_DIALOG);

			if (Variable.SELECT_OPTION  == Variable.NO_IS_CHOSEN) {
				return;
			}
			
			if (getFile() == null) {
				saveAs(Variable.SAVE_Menu_ITEM);
				return;
			}
			
			createException();
		}
		
		setFile(null);
		textPanel.setText("");
		setChangeStatus(false);
		setTitle("Editor");
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		String action = event.getActionCommand();
		
		if (action.equals("Quit")) {
			System.exit(0);
		} else if (action.equals(Variable.OPEN_Menu_ITEM)) {
			loadFile();
		} else if (action.equals(Variable.SAVE_Menu_ITEM)) {
			saveFile();
		} else if (action.equals(Variable.NEW_Menu_ITEM)) {
			newFile();
		} else if (action.equals(Variable.SAVE_AS_Menu_ITEM)) {
			saveAs("Save as...");
		} else if (action.equals(Variable.SELECT_ALL_Menu_ITEM)) {
			textPanel.selectAll();
		} else if (action.equals(Variable.COPY_Menu_ITEM)) {
			textPanel.copy();
		} else if (action.equals(Variable.CUT_Menu_ITEM)) {
			textPanel.cut();
		} else if (action.equals(Variable.PASTE_Menu_ITEM)) {
			textPanel.paste();
		} else if (action.equals(Variable.FIND_Menu_ITEM)) {
			FindDialog find = new FindDialog(this, true);
			find.showDialog();
		}
	}
	private void loadFile() {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		
		dialog.setMultiSelectionEnabled(false);
		try {
			Variable.SELECT_OPTION = dialog.showOpenDialog(this);
			
			if (Variable.SELECT_OPTION == Variable.CANCEL_IS_CHOSEN)
				return;
			
			if (Variable.SELECT_OPTION == Variable.APPROVE_IS_CHOSEN) {
                newFile();
				setFile(dialog.getSelectedFile());
				//Read file
				StringBuilder readString = new StringBuilder();
				try (FileReader fileReader = new FileReader(getFile());	
						BufferedReader reader = new BufferedReader(fileReader);) {
					String line;
					while ((line = reader.readLine()) != null) {
						readString.append(line + "\n");
					}
				} catch (IOException exception) {
					exception.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cannot read file !", "Error !", Variable.ID_FOR_ERROE_DIALOG);//0 means show Error Dialog
				}
				
				textPanel.setText(readString.toString());
				setChangeStatus(false);
				setTitle("Editor - " + file.getName());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			//0 means show Error Dialog
			JOptionPane.showMessageDialog(null, exception, "Error",  Variable.ID_FOR_ERROE_DIALOG);
		}
	}
	
	private void chooseSaveAs(String title , String dialogTitle) {
		
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		dialog.setDialogTitle(dialogTitle);
		
		Variable.SELECT_OPTION = dialog.showSaveDialog(this);
		if (Variable.SELECT_OPTION != Variable.APPROVE_IS_CHOSEN)
			return;
		
		setFile(dialog.getSelectedFile());
		
		try (PrintWriter writer = new PrintWriter(getFile());){
			writer.write(textPanel.getText());
			setChangeStatus(false);
			
			if(title == "Editor - ") {
				setTitle(title + file.getName());
			}else if(title == "Save as Text Editor - ") {
				setTitle(title + file.getName());
			}
			
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
	}
	
	private void saveAs(String dialogTitle) {
		
		chooseSaveAs("Editor - " , dialogTitle);
	}
	
	private void saveAsText(String dialogTitle) {
		
		chooseSaveAs("Save as Text Editor - " , dialogTitle);

	}
	
	@Override
	public void insertUpdate(DocumentEvent event) {
		setChangeStatus(true);
	}
	@Override
	public void removeUpdate(DocumentEvent event) {
		setChangeStatus(true);
	}
	@Override
	public void changedUpdate(DocumentEvent event) {
		setChangeStatus(true);
	}
}