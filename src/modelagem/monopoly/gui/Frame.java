package modelagem.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame  extends JFrame{
	private static final long serialVersionUID = -1179915038060884669L;

	//	Defino a dimensão da minha janela
	private final int LARGURA=780; 
	private final int ALTURA=800;
	
	
	public Frame(){ //Defino o a posição de inicialização da janela na tela
		Toolkit tk=Toolkit.getDefaultToolkit(); 
		setLayout(new BorderLayout());
		Dimension resolucao=tk.getScreenSize();
		int larguraTela=resolucao.width; 
		int alturaTela=resolucao.height;
		int x=larguraTela/2-LARGURA/2; 
		int y=alturaTela/2-ALTURA/2;
		setBounds(x,y,LARGURA,ALTURA); 
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//		this.addMenu();
//		this.addStatusBar();
	}
	
	public Frame(int wid, int hei){ //Defino o a posição de inicialização da janela na tela
		Toolkit tk=Toolkit.getDefaultToolkit(); 
		setLayout(new BorderLayout());
		Dimension resolucao=tk.getScreenSize();
		int larguraTela=resolucao.width; 
		int alturaTela=resolucao.height;
		int x=larguraTela/2-wid/2+780/2+wid/2; 
		int y=alturaTela/2-hei/2;
		setBounds(x,y,wid,hei); 
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//		this.addMenu();
//		this.addStatusBar();
	}
	
	
	
	/**
	 * teste apenas
	 */
	public static void main(String[] args) {

	}

}
