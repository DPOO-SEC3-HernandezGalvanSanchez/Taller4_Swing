package uniandes.dpoo.triqui.interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
	private VentanaTriqui padre;
	private JLabel cantidadJugadas;
	
	private final String REINICIAR = "reiniciar";
	
	
	public PanelBotones(VentanaTriqui padre)
	{
		this.padre = padre;
		setLayout(new FlowLayout());
		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.addActionListener(this);
		botonReiniciar.setActionCommand(REINICIAR);
		add(botonReiniciar);
		
		cantidadJugadas = new JLabel("0 jugadas");
		add(cantidadJugadas);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		
		if (comando.equals(REINICIAR))
		{
			padre.reiniciar();
		}

	}

	public void actualizarCantidadJugadas(int numero)
	{
		String mensaje = Integer.toString(numero) + " jugadas";
		cantidadJugadas.setText(mensaje);
	}
}
