package application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import entities.telaSecundaria;

public class Program extends JFrame {
	
	public void montarTela() {
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Tela Principal com Menu:");
	
	
	setLayout(null);
	JButton btSecundaria = new JButton("Carrega Tela Secundaria");
	btSecundaria.setBounds(50, 50, 150, 60);
	
	btSecundaria.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent ae) {
			telaSecundaria ts = new telaSecundaria();
			ts.montarTela();
			ts.setVisible(true);
		}
	});
	getContentPane().add(btSecundaria);
	
	}
	
	public void montarMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Opcoes");
		JMenu menuAjuda = new JMenu("Ajuda");
		JMenuItem itemTrocarCor = new JMenuItem("Trocar Cor");
		JMenuItem itemSair = new JMenuItem("Sair");
		
		JMenuItem itemSobre = new JMenuItem("Sobre");
		
		menuOpcoes.add(itemTrocarCor);
		menuOpcoes.add(itemSair);
		
		menuAjuda.add(itemSobre);
		mb.add(menuOpcoes);
		mb.add(menuAjuda);
		
		itemSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				mostraSobre();
			}
		});
		
		
		itemTrocarCor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				trocaCorFundo();
			}
		});
		
		itemSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				System.exit(0);
			}
		});
		
		setJMenuBar(mb);
	}
	
	public void mostraSobre() {
		String msg = "BEM EUROPEU";
		JOptionPane.showMessageDialog(this, msg, "AJUDA", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void trocaCorFundo() {
		
		Integer r, g, b;
		r = (int)(Math.random()*255);
		g = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
		
		getContentPane().setBackground(new Color(r, g, b));
	}

	public static void main(String[] args){
		
		Program tp = new Program();
		tp.montarTela();
		tp.montarMenu();
		tp.setVisible(true);
	}

}
