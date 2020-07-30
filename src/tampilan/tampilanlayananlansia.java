/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.koneksi;
import java.util.HashMap;
import java.util.Locale;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Locale;
/**
 *
 * @author farhatdk
 */
public class tampilanlayananlansia extends javax.swing.JFrame {
    public String id_lansia, nama_lansia, jenis_kelamin, tgl_lahir, usia_lansia, alamat_lansia, telepon_lansia ;
    public String id, no_layanan, id_lansia2, berat, tensi, ket;
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form tampilanlayananlansia
     */
    public tampilanlayananlansia() {
        initComponents();
        kosong();
        aktif();
        datatablelansia();
        autonumber();
        Locale locale = new Locale ("id","ID");
        Locale.setDefault(locale);
    }

    private void kosong(){
        iddaftarlansia.setText("");
        nolayananlansia.setText("");
        idpelayananlansia.setText("");
        namalansia.setText("");
        usialansia.setText("");
        beratlansia.setText("");
        tensilansia.setText("");
        keteranganlansia.setText("");
    }
    
    private void aktif(){
        beratlansia.requestFocus();
    }
    
    public void cetaklansia() {
        try {
            String path = "./src/report/lansia.jasper"; // letakpenyimpanan report
            HashMap parameter = new HashMap();
            parameter.put("parameterId", iddaftarlansia.getText());
            JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "DokumenTidak Ada " + ex);
        }
    }
    
    protected void datatablelansia(){
        Object[] Baris ={"Id","No Layanan","Id Lansia","Nama Lansia","Usia","Berat Badan","Tensi","Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem=carilansiabutton.getText();

        try {
            String sql = "SELECT pelayananlansia.id, pelayananlansia.no_layanan, lansia.id, lansia.nama, lansia.usia, pelayananlansia.berat, pelayananlansia.tensi, pelayananlansia.ket FROM pelayananlansia INNER JOIN lansia ON pelayananlansia.id_lansia = lansia.id where lansia.id like '%"+cariitem+"%' or lansia.nama like '%"+cariitem+"%' order by lansia.id asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7),
                    hasil.getString(8),
                });
            }
            tabellansia.setModel(tabmode);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
    }
    
    private void autonumber(){
        try {
            String sql = "SELECT id FROM pelayananlansia order by id asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            iddaftarlansia.setText("1");
            while (rs.next()) {
                String id_transaksi = rs.getString("id");
                int AN = Integer.parseInt(id_transaksi) + 1;
                String ANS = Integer.toString(AN);
                iddaftarlansia.setText(ANS);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
        }
    }
    
    public void IdLansia() {
        tampilanpopuplansia pl = new tampilanpopuplansia();
        pl.lynnlansia = this;
        idpelayananlansia.setText(id_lansia);
        namalansia.setText(nama_lansia);
        usialansia.setText(usia_lansia);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        simpanlansia = new javax.swing.JButton();
        ubahlansia = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        batallansia = new javax.swing.JButton();
        nolayananlansia = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        iddaftarlansia = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        idpelayananlansia = new javax.swing.JTextField();
        carilansia = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        namalansia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        usialansia = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        beratlansia = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tensilansia = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keteranganlansia = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabellansia = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        carilansiabutton = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        cariimunisasi = new javax.swing.JTextField();
        cetakimunisasi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 105));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 105));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel5.setText("Pelayanan Lansia");

        jButton7.setBackground(new java.awt.Color(153, 153, 255));
        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton7.setText("Kembali");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(153, 153, 255));
        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton8.setText("Beranda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 635, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel1.setText("No. Layanan");

        simpanlansia.setBackground(new java.awt.Color(153, 153, 255));
        simpanlansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        simpanlansia.setText("Simpan");
        simpanlansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanlansiaActionPerformed(evt);
            }
        });

        ubahlansia.setBackground(new java.awt.Color(153, 153, 255));
        ubahlansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ubahlansia.setText("Ubah");
        ubahlansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahlansiaActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(153, 153, 255));
        jButton13.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton13.setText("Hapus");

        batallansia.setBackground(new java.awt.Color(153, 153, 255));
        batallansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        batallansia.setText("Batal");
        batallansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batallansiaActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel22.setText("ID Daftar");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel23.setText("ID Lansia");

        carilansia.setBackground(new java.awt.Color(153, 153, 255));
        carilansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        carilansia.setText("Cari");
        carilansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carilansiaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel24.setText("Nama");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel25.setText("Usia");

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel26.setText("Berat");

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel28.setText("Tensi");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel29.setText("Tahun");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel30.setText("Kg");

        keteranganlansia.setColumns(20);
        keteranganlansia.setRows(5);
        jScrollPane1.setViewportView(keteranganlansia);

        jLabel2.setText("Ket.");

        tabellansia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabellansia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellansiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabellansia);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel3.setText("Layanan Lansia");

        jButton15.setBackground(new java.awt.Color(153, 153, 255));
        jButton15.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton15.setText("Cari");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel32.setText("ID Lansia");

        cetakimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        cetakimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        cetakimunisasi.setText("Cetak");
        cetakimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakimunisasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nolayananlansia)
                            .addComponent(iddaftarlansia))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(namalansia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(idpelayananlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(carilansia))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(usialansia)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel29))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(beratlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel30))
                                                    .addComponent(tensilansia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addGap(18, 18, 18)
                            .addComponent(cariimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cetakimunisasi))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carilansiabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton15))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ubahlansia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batallansia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanlansia)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(iddaftarlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(carilansiabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nolayananlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idpelayananlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carilansia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namalansia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usialansia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel25)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(beratlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel26))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cetakimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cariimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(simpanlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ubahlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batallansia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tensilansia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1))))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void carilansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carilansiaActionPerformed
        tampilanpopuplansia pl = new tampilanpopuplansia();
        pl.lynnlansia = this;
        pl.setVisible(true);
        pl.setResizable(false);    
    }//GEN-LAST:event_carilansiaActionPerformed

    private void cetakimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakimunisasiActionPerformed
        cetaklansia();
    }//GEN-LAST:event_cetakimunisasiActionPerformed

    private void batallansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batallansiaActionPerformed
        kosong();
    }//GEN-LAST:event_batallansiaActionPerformed

    private void simpanlansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanlansiaActionPerformed
        String sql = "insert into pelayananlansia values (?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, iddaftarlansia.getText());
            stat.setString(2, nolayananlansia.getText());
            stat.setString(3, idpelayananlansia.getText());
            stat.setString(4, beratlansia.getText());
            stat.setString(5, tensilansia.getText());
            stat.setString(6, keteranganlansia.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            iddaftarlansia.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatablelansia();
    }//GEN-LAST:event_simpanlansiaActionPerformed

    private void tabellansiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellansiaMouseClicked
        int bar = tabellansia.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        iddaftarlansia.setEditable(false);
        nolayananlansia.setEditable(false);
        idpelayananlansia.setEditable(false);
        namalansia.setEditable(false);
        usialansia.setEditable(false);
        iddaftarlansia.setText(a);
        nolayananlansia.setText(b);
        idpelayananlansia.setText(c);
        namalansia.setText(d);
        usialansia.setText(e);
        beratlansia.setText(f);
        tensilansia.setText(g);
        keteranganlansia.setText(h);
    }//GEN-LAST:event_tabellansiaMouseClicked

    private void ubahlansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahlansiaActionPerformed
        iddaftarlansia.setEditable(true);
        namalansia.setEditable(true);
        usialansia.setEditable(true);
        try {
            String sql = "update pelayananlansia set berat =?,tensi=?,ket=? where id ='" + iddaftarlansia.getText() + "'  ";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, beratlansia.getText());
            stat.setString(2, tensilansia.getText());
            stat.setString(3, keteranganlansia.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            iddaftarlansia.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah" + e);
        }
        datatablelansia();
    }//GEN-LAST:event_ubahlansiaActionPerformed

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
            java.util.logging.Logger.getLogger(tampilanlayananlansia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilanlayananlansia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilanlayananlansia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilanlayananlansia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilanlayananlansia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batallansia;
    private javax.swing.JTextField beratlansia;
    private javax.swing.JTextField cariimunisasi;
    private javax.swing.JButton carilansia;
    private javax.swing.JTextField carilansiabutton;
    private javax.swing.JButton cetakimunisasi;
    private javax.swing.JTextField iddaftarlansia;
    private javax.swing.JTextField idpelayananlansia;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea keteranganlansia;
    private javax.swing.JTextField namalansia;
    private javax.swing.JTextField nolayananlansia;
    private javax.swing.JButton simpanlansia;
    private javax.swing.JTable tabellansia;
    private javax.swing.JTextField tensilansia;
    private javax.swing.JButton ubahlansia;
    private javax.swing.JTextField usialansia;
    // End of variables declaration//GEN-END:variables
}
