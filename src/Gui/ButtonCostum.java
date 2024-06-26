
package Gui;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author audreynaila
 */
public class ButtonCostum extends JButton{
    
    private Color background = new Color (131, 105, 83);
    private Color colorHover = new Color(130, 102, 68);
    private Color colorPressed = new Color(130, 102, 68);
    private boolean mouseOver = false;
  
    public ButtonCostum() {
        init();
    }

private void init() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(background);
        setForeground(Color.WHITE);
        setOpaque(true);
        addMouseListener(new MouseAdapter() {
            
            private Object ButtonCustom;
            private Object  ButtonCostum;
            
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                ButtonCostum.super.setBackground(getColorHover());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                 ButtonCostum.super.setBackground(background);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                 ButtonCostum.super.setBackground(getColorPressed());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (mouseOver) {
                     ButtonCostum.super.setBackground(getColorHover());
                } else {
                     ButtonCostum.super.setBackground(background);
                }
            }
        });
    }

    @Override
    public void setBackground(Color bg) {
        background = bg;
        super.setBackground(bg);
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getColorPressed() {
        return colorPressed;
    }

    public void setColorPressed(Color colorPressed) {
        this.colorPressed = colorPressed;
    }  

   
}
