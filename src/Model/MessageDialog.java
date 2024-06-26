
package Model;


import Gui.Glass;
import java.awt.Color;
import java.awt.TrayIcon.MessageType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import javaswingdev.swing.Glass;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MessageDialog extends javax.swing.JDialog {
    
    
    private final JFrame fram;
    private Animator animator;
    private Glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;
    
    public MessageDialog(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
        init();
    }

       private void init() {
        setBackground(new Color(0, 0, 0, 0));
        StyledDocument doc = txt.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        txt.setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeMessage();
            }
        });
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                glass.setAlpha(f - f * 0.3f);
                setOpacity(f);
            }

            @Override
            public void end() {
                if (show == false) {
                    dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);
        glass = new Glass();
    }

    private void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
       
    }
    
    public void showMessage(String title, String message) {
          
        fram.setGlassPane(glass);
        glass.setVisible(true);
        lbTitle.setText(title);
        txt.setText(message);
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
           
    }
  
     public void closeMessage() {
        startAnimator(false);
    }
     
    public MessageType getMessageType() {
        return messageType;
    }
    
      public static enum MessageType {
        CANCEL, OK
    }

     
     
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCostum1 = new Gui.ButtonCostum();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        background1 = new Model.Background();
        btno = new Gui.ButtonCostum();
        btnyes = new Gui.ButtonCostum();
        jLabel1 = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextPane();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        buttonCostum1.setText("buttonCostum1");
        buttonCostum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCostum1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(131, 105, 83));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(188, 158, 130));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(131, 105, 83));

        background1.setBackground(new java.awt.Color(30, 20, 18));
        background1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        background1.setForeground(new java.awt.Color(188, 158, 130));
        background1.setToolTipText("");
        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btno.setBackground(new java.awt.Color(92, 62, 42));
        btno.setText("NO");
        btno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoActionPerformed(evt);
            }
        });
        background1.add(btno, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 307, 250, 57));

        btnyes.setBackground(new java.awt.Color(92, 62, 42));
        btnyes.setText("YES");
        btnyes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnyesActionPerformed(evt);
            }
        });
        background1.add(btnyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 307, 240, 57));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/iconrinai (1).png"))); // NOI18N
        background1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 140, 70));

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Do You Want To Exit?");
        background1.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        txt.setEditable(false);
        txt.setText("Thanks For Coming!\n");
        txt.setFocusable(false);
        jScrollPane1.setViewportView(txt);

        background1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 245, 75, 0));
        background1.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 254, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCostum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCostum1ActionPerformed
        
    }//GEN-LAST:event_buttonCostum1ActionPerformed

    private void btnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoActionPerformed
        closeMessage();
    }//GEN-LAST:event_btnoActionPerformed

    private void btnyesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnyesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnyesActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Model.Background background1;
    private Gui.ButtonCostum btno;
    private Gui.ButtonCostum btnyes;
    private Gui.ButtonCostum buttonCostum1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextPane txt;
    // End of variables declaration//GEN-END:variables

   
}
