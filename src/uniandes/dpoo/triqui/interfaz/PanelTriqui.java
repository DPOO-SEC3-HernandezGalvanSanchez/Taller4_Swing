package uniandes.dpoo.triqui.interfaz;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import uniandes.dpoo.triqui.mundo.Triqui;

@SuppressWarnings("serial")
public class PanelTriqui extends JPanel implements MouseListener
{

	public PanelTriqui(VentanaTriqui ventanaTriqui)
	{
	}

	public void actualizarTablero(Triqui triqui)
	{
		repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		pintarLineas(g2d);
		pintarJugadas(g2d);
	}

	private void pintarJugadas(Graphics2D g2d)
	{

	}

	private void pintarLineas(Graphics2D g2d)
	{
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

}
