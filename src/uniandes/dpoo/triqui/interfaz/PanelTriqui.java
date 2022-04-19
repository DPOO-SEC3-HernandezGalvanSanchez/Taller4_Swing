package uniandes.dpoo.triqui.interfaz;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import uniandes.dpoo.triqui.mundo.Triqui;

@SuppressWarnings("serial")
public class PanelTriqui extends JPanel implements MouseListener
{
	private VentanaTriqui padre;	
	
	private int X_origin;
	private int Y_origin;
	private int triquiLength;
	
	
	public PanelTriqui(VentanaTriqui ventanaTriqui)
	{
		this.padre = ventanaTriqui;
		setLayout(new BorderLayout());
	
	}

	public void actualizarTablero(Triqui triqui)
	{
		repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		int width = this.getWidth();
		int height = this.getHeight();
		
		if (width>height)
		{
			this.triquiLength = (int) Math.round(0.8*height);
			this.X_origin = (int) Math.round((width/2) - (triquiLength/2));
			this.Y_origin = (int) Math.round(0.1*height);
		}
		
		else if (width<height)
		{
			this.Y_origin = (int) Math.round((height/2) - (triquiLength/2));
			this.X_origin = (int) Math.round(0.1*width);
			this.triquiLength = (int) Math.round(0.8*width);
		}
		
		Graphics2D g2d = (Graphics2D) g;

		pintarLineas(g2d);
		pintarJugadas(g2d);
	}

	private void pintarJugadas(Graphics2D g2d)
	{

	}

	private void pintarLineas(Graphics2D g2d)
	{
		g2d.setStroke(new BasicStroke(5));

		//Verticales
		g2d.drawLine(X_origin+(triquiLength/3), Y_origin, X_origin+(triquiLength/3), Y_origin+triquiLength);
		g2d.drawLine(X_origin+(2*triquiLength/3), Y_origin, X_origin+(2*triquiLength/3), Y_origin+triquiLength);
		
		//Horizontales
		g2d.drawLine(X_origin, Y_origin+(triquiLength/3), X_origin+triquiLength, Y_origin+(triquiLength/3));
		g2d.drawLine(X_origin, Y_origin+(2*triquiLength/3), X_origin+triquiLength, Y_origin+(2*triquiLength/3));
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
