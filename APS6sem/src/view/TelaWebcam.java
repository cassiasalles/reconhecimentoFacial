package view;

import javax.swing.*;

public class TelaWebcam{
	
	public boolean identificacaoUsuario(){
		String[] opcoes = {"Sim", "N�o"};
		int resposta = JOptionPane.showOptionDialog(null, "Usu�rio n�o indentificado, deseja retornar a tela de Login?", "Menu Identifica��o", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		return (resposta == 0? true : false);
	}
}
