package edu.najah.cap;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar {
	

	 private JMenuItem createMenuItem(String menuItemName , char mnemonicType , JMenu menuBarItem , Editor editor) {
			
			JMenuItem newMenuItem = new JMenuItem(menuItemName);
			newMenuItem.setMnemonic(mnemonicType);
			newMenuItem.addActionListener(editor);
			menuBarItem.add(newMenuItem);
			
			return newMenuItem ;
		}
		public void buildFileMenu( Editor editor) {
			
			JMenu file = new JMenu(Variable.File_Menu_Bar);
			file.setMnemonic('F');
			editor.getMenu().add(file);
			
			JMenuItem newMenuItem ;
			
			newMenuItem = createMenuItem(Variable.NEW_Menu_ITEM , 'N' , file , editor);
			newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			
			newMenuItem = createMenuItem(Variable.OPEN_Menu_ITEM , 'O' , file ,editor);
			newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
			
			newMenuItem = createMenuItem(Variable.SAVE_Menu_ITEM , 'S' , file, editor);
			newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
			
			newMenuItem = createMenuItem(Variable.SAVE_AS_Menu_ITEM , 'S' , file , editor);
			newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
			
			newMenuItem = createMenuItem(Variable.QUIT_Menu_ITEM , 'Q' , file , editor);
			newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		}
		public void buildEditMenu( Editor editor) {
			
			JMenu edit = new JMenu(Variable.Edit_Menu_Bar);
			edit.setMnemonic('E');
			editor.getMenu().add(edit);
			
			
			JMenuItem newItem ;
			// cut
			newItem = createMenuItem(Variable.CUT_Menu_ITEM , 'X' , edit , editor);
			newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
			// copy
			newItem = createMenuItem(Variable.COPY_Menu_ITEM, 'C' , edit , editor);
			newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
			// paste
			newItem = createMenuItem(Variable.PASTE_Menu_ITEM , 'P' , edit ,editor);
			newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
			// find
			newItem = createMenuItem(Variable.FIND_Menu_ITEM , 'F' , edit , editor);
			newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
			// select all
			newItem = createMenuItem(Variable.SELECT_ALL_Menu_ITEM , 'A' , edit ,editor);
			newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		}
}
