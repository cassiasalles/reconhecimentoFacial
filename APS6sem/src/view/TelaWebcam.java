package view;

import javax.swing.*;

public class TelaWebcam{
	
	public boolean identificacaoUsuario(){
		String[] opcoes = {"Sim", "Não"};
		int resposta = JOptionPane.showOptionDialog(null, "Usuário não indentificado, deseja retornar a tela de Login?", "Menu Identificação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		return (resposta == 0? true : false);
	}
}
