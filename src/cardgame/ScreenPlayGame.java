/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Linh
 */
public class ScreenPlayGame extends javax.swing.JFrame {

    /**
     * Creates new form ScreenPlayGame
     */
    public String gameMode;
    public int numberOfPlayers;

    //số bài cần chia cho 1 ng
    private int numberCard = 0;
    private List<CardObj> lstCard = new ArrayList<>(); // khởi tạo List quân bài

    public ScreenPlayGame() {
        initComponents();// tạo giao diện
        fullScreen();//gọi full màn hình
    }

    public ScreenPlayGame(String gameMode, int numberOfPlayers) {
        initComponents();
        fullScreen();//gọi full màn hình
        this.gameMode = gameMode;
        this.numberOfPlayers = numberOfPlayers;
        cardList();
        numberCardNeed();
        //shareCardPer(numberCard);
        shareEry();
    }

    //đưa 52 quân bài vào List 
    private void cardList() {
        int i=1;
        int j=1;
        while(i<5){
            String Url= i+ "-" + j + ".png";
          CardObj obj= new CardObj(i, j, Url);
            lstCard.add(obj);
            j++;
            if(j>13){
                i++;
                j=1;
            }
        }
    }

    //bài chia cho 1 người
    private void shareCardPer(int numberCard) {
        Random random = new Random();//biến random
        //lấy bài
        List<CardObj> lstCardPer = new ArrayList<>(); // khởi tạo List bài của 1 ng

        //chia
        for (int i = 1; i <= numberCard; i++) {
            int index = random.nextInt(lstCard.size());//lấy chỉ số ngẫu nhiên
            CardObj obj = lstCard.get(index);//lấy giá trị tại chỉ số
            lstCardPer.add(obj);// cho vào ds quân bài của ng đó
            lstCard.remove(index);//xóa khỏi List quân bài
        }
        //hiển thị bài
        String path="D:\\JAVA\\CardGame\\src\\Game\\HinhAnh52LaBai\\";
        int x=0;
        int y=0;
        for(CardObj obj: lstCardPer){
            JLabel labCard = new JLabel();//tạo Label
            //labCard.setLocation(labCard.getWidth(),labCard.getHeight()+ 100);
//            x+=labCard.getWidth()+100;
//            y+=labCard.getHeight()+40;
//            labCard.setLocation(x,0);
//            labCard.setLocation(0,y);
            labCard.setSize(new Dimension(50,82));//đặt kích thước
            ImageIcon iconCard = new ImageIcon(new ImageIcon(path+ obj.getUrl()).getImage().getScaledInstance(labCard.getWidth(),labCard.getHeight(), Image.SCALE_SMOOTH));//đặt Icon
            labCard.setIcon(iconCard);
            
            p1.add(labCard);//thêm Label vào Panel
            p1.repaint();
        }
    }
        private CardObj A[][] = new CardObj[numberOfPlayers][numberCard];
        
        public void shareEry(){
            for(int i=1;i<=numberOfPlayers;i++){
                
                for(int j=1;j<=numberCard;j++){
                    Random random = new Random();
                    int index = random.nextInt(lstCard.size());
                    CardObj obj = lstCard.get(index);
                    A[i][j] = obj;
                    lstCard.remove(index);
                }
            }
            String path="D:\\JAVA\\CardGame\\src\\Game\\HinhAnh52LaBai\\";
            int x=0;
            int y=0;
             for(int i=1;i<=numberOfPlayers;i++){  
                  JLabel labCard = new JLabel();
                  labCard.setSize(new Dimension(50,82));
                 for(int j=1;j<=numberCard;j++){
                    
                     //labCard.setLocation(0,y);
                     
                     ImageIcon iconCard = new ImageIcon(new ImageIcon(path+ A[i][j].getUrl()).getImage().getScaledInstance(labCard.getWidth(),labCard.getHeight(), Image.SCALE_SMOOTH));
                     labCard.setIcon(iconCard);
                     p1.add(labCard);//thêm Label vào Panel
                    p1.repaint();
                    
                 }
                 x+=labCard.getWidth()+100;
                 labCard.setLocation(0,y);
             }

        }
    //số bài cần chia cho 1 ng
    private void numberCardNeed() {
        switch (gameMode) {
            case "Tiến lên miền Bắc":
                numberCard = 52 / numberOfPlayers;
                break;
            case "Tiến lên miền Nam":
                numberCard = 13;
                break;
            case "Phỏm":
                numberCard = 9;
                break;
            case "3 cây":
                numberCard = 3;
                break;
        }
    }

    //hàm gọi full màn hình
    private void fullScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        this.setSize(xSize, ySize);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1 = new javax.swing.JPanel();
        p2 = new javax.swing.JPanel();
        p4 = new javax.swing.JPanel();
        p3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout p4Layout = new javax.swing.GroupLayout(p4);
        p4.setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addComponent(p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScreenPlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenPlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenPlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenPlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenPlayGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    // End of variables declaration//GEN-END:variables
}
