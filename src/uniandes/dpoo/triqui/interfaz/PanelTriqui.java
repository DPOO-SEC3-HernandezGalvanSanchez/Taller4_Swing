package uniandes.dpoo.triqui.interfaz;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import uniandes.dpoo.triqui.mundo.Triqui;

@SuppressWarnings("serial")
public class PanelTriqui extends JPanel implements MouseListener
{
	private VentanaTriqui padre;
	
	private int X_origin;
	private int Y_origin;
	private int triquiLength;
	
	private int[][] copiaTablero;
	
	
	public PanelTriqui(VentanaTriqui ventanaTriqui)
	{
		this.padre = ventanaTriqui;
		setLayout(new BorderLayout());
		this.addMouseListener(this);
	
	}

	public void actualizarTablero(Triqui triqui)
	{
		copiaTablero = triqui.darCasillas();
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
		
		else
		{
			this.triquiLength = (int) Math.round(0.8*width);
			this.Y_origin = (int) Math.round((height/2) - (triquiLength/2));
			this.X_origin = (int) Math.round(0.1*width);
		}
		g.clearRect(0, 0, getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D) g;
		

		pintarLineas(g2d);
		pintarJugadas(g2d);
	}

	private void pintarJugadas(Graphics2D g2d)
	{
		for(int i=0; i<3;i++)
		{
			for(int j =0; j<3;j++)
			{
				if (copiaTablero[i][j]==1) pintarElipse(g2d,i,j);
				else if (copiaTablero[i][j]==2) pintarEquis(g2d,i,j);
			}
		}

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

	
	private void pintarElipse(Graphics2D g2d, int fila, int columna)
	{
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.RED);
		double x = X_origin + ((triquiLength/3)*0.1)+(fila*(triquiLength/3));
		double y = Y_origin + ((triquiLength/3)*0.1)+(columna*(triquiLength/3));
		double L = (triquiLength/3)*0.8;
		Ellipse2D.Double rectangle = new Ellipse2D.Double(x,y,L,L);
		g2d.draw(rectangle);
	}
	
	private void pintarEquis(Graphics2D g2d, int fila, int columna)
	{
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.BLUE);
		int x = (int) Math.round((X_origin + ((triquiLength/3)*0.1)+(fila*(triquiLength/3))));
		int y = (int) Math.round(Y_origin + ((triquiLength/3)*0.1)+(columna*(triquiLength/3)));
		int L = (int) Math.round((triquiLength/3)*0.8);
		g2d.drawLine(x,y,x+L,y+L);
		g2d.drawLine(x+L, y, x, y+L);	
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		int fila=-1;
		int columna=-1;
		
		int x = e.getX();
		int y = e.getY();
		
		if ((X_origin<=x) && (x<X_origin+triquiLength/3)) fila=0;
		else if ((X_origin+triquiLength/3<=x)&&(x<X_origin+triquiLength*2/3)) fila=1;
		else if ((X_origin+triquiLength*2/3<=x)&&(x<X_origin+triquiLength)) fila=2;
		
		
		if ((Y_origin<=y) && (y<Y_origin+triquiLength/3)) columna=0;
		else if ((Y_origin+triquiLength/3<=y)&&(y<Y_origin+triquiLength*2/3)) columna=1;
		else if ((Y_origin+triquiLength*2/3<=y)&&(y<Y_origin+triquiLength)) columna=2;
		
		if(fila!=-1 && columna!=-1) padre.jugar(fila, columna);
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
