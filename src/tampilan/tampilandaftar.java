/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.sql.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import koneksi.koneksi;

/**
 *
 * @author farhatdk
 */
public class tampilandaftar extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;

    /**
     * Creates new form tampilandaftar
     */
    public tampilandaftar() {
        initComponents();
        kosonganak();
        kosongibuhamil();
        kosonglansia();
        aktifanak();
        aktiflansia();
        aktifibuhamil();
        datatablelansia();
        datatableanak();
        datatableibuhamil();
    }

    private void kosonganak() {
        idanak.setText("");
        namaanak.setText("");
        buttonGroup1.clearSelection();
        tglanak.setDate(LocalDate.of(1998, 8, 13));
        usiaanak.setText("");
        ayahanak.setText("");
        ibuanak.setText("");
        alamatanak.setText("");
        telponanak.setText("");
    }

    private void kosongibuhamil() {
        idhamil.setText("");
        namaibuhamil.setText("");
        tgllahiribuhamil.setDate(LocalDate.of(1960, 8, 13));
        usiaibuhamil.setText("");
        alamatibuhamil.setText("");
        telponibuhamil.setText("");
        namasuami.setText("");
    }

    private void kosonglansia() {
        idlansia.setText("");
        namalansia.setText("");
        buttonGroup2.clearSelection();
        tglahirlansia.setDate(LocalDate.of(1920, 8, 13));
        usialansia.setText("");
        alamatlansia.setText("");
        teleponlansia.setText("");
    }

    private void aktifanak() {
        idanak.requestFocus();
    }

    private void aktiflansia() {
        idlansia.requestFocus();
    }

    private void aktifibuhamil() {
        idhamil.requestFocus();
    }

    private void datatableanak() {
        Object[] Baris = {"Id", "Nama", "Jenis Kelamin", "Tgl Lahir", "Usia", "Ayah", "Ibu", "Alamat", "Telepon"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = carianak.getText();
        tabelanak.setModel(tabmode);
        try {
            String sql = "SELECT * FROM anak where id like '%" + cariitem + "%' or nama like '%" + cariitem + "%' order by id asc ";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7),
                    hasil.getString(8),
                    hasil.getString(9)
                });
            }
            tabelanak.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }

    private void datatablelansia() {
        Object[] Baris = {"Id", "Nama", "Jenis Kelamin", "Tgl Lahir", "Usia", "Alamat", "Telepon"};
        tabmode = new DefaultTableModel(null, Baris);
        tabellansia.setModel(tabmode);
        String cariitem = carilansia.getText();
        try {
            String sql = "SELECT * FROM anak where id like '%" + cariitem + "%' or nama like '%" + cariitem + "%' order by id asc ";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7)
                });
            }
            tabellansia.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }

    private void datatableibuhamil() {
        Object[] Baris = {"Id", "Nama", "Tgl Lahir", "Usia", "Alamat", "Telepon", "Nama Suami"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelibuhamil.setModel(tabmode);
        String cariitem = cariibuhamil.getText();
        try {
            String sql = "SELECT * FROM ibuhamil where id like '%" + cariitem + "%' or nama like '%" + cariitem + "%' order by id asc ";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7)
                });
            }
            tabelibuhamil.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idlansia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        namalansia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lansialaki = new javax.swing.JRadioButton();
        lansiaperempuan = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        daftarlansia = new javax.swing.JButton();
        usialansia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        hapuslansia = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatlansia = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        teleponlansia = new javax.swing.JTextField();
        batallansia = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        tglahirlansia = new com.github.lgooddatepicker.components.DatePicker();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabellansia = new javax.swing.JTable();
        ubahlansia = new javax.swing.JButton();
        carilansia = new javax.swing.JTextField();
        carilansiabutton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        idanak = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        namaanak = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        anaklaki = new javax.swing.JRadioButton();
        anakperempuan = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        usiaanak = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        daftaranak = new javax.swing.JButton();
        hapusanak = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        ayahanak = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        ibuanak = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamatanak = new javax.swing.JTextArea();
        batalanak = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        telponanak = new javax.swing.JTextField();
        tglanak = new com.github.lgooddatepicker.components.DatePicker();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelanak = new javax.swing.JTable();
        ubahanak = new javax.swing.JButton();
        carianak = new javax.swing.JTextField();
        carianakbutton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        idhamil = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        namaibuhamil = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        usiaibuhamil = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        daftaribuhamil = new javax.swing.JButton();
        batalibuhamil = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alamatibuhamil = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        telponibuhamil = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        namasuami = new javax.swing.JTextField();
        tgllahiribuhamil = new com.github.lgooddatepicker.components.DatePicker();
        hapusibuhamil = new javax.swing.JButton();
        ubahibuhamil = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabelibuhamil = new javax.swing.JTable();
        cariibuhamil = new javax.swing.JTextField();
        cariibuhamilbutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable2);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 505));
        setMinimumSize(new java.awt.Dimension(900, 505));

        jPanel1.setMaximumSize(new java.awt.Dimension(900, 505));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 505));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 505));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setText("ID  Daftar");
        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jButton10.setText("Buat");
        jButton10.setBackground(new java.awt.Color(153, 153, 255));
        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        jLabel33.setText("Jenis Pelayanan");
        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jButton11.setText("Ok");
        jButton11.setBackground(new java.awt.Color(153, 153, 255));
        jButton11.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        jButton12.setText("Batal");
        jButton12.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jTextField18)
                                            .addGap(34, 34, 34)
                                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jLabel1.setText("Daftar Layanan");
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jLabel2.setText("Ambil Nomor Antrian");
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N

        jLabel3.setText("Data Lengkap");
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jTabbedPane1.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Isi Data yang Lengkap");
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        jLabel5.setText("ID Lansia");
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        idlansia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idlansiaKeyTyped(evt);
            }
        });

        jLabel6.setText("Nama Lengkap");
        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel7.setText("Jenis Kelamin");
        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        lansialaki.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(lansialaki);
        lansialaki.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lansialaki.setText("Laki - Laki");

        lansiaperempuan.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(lansiaperempuan);
        lansiaperempuan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lansiaperempuan.setText("Perempuan");
        lansiaperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lansiaperempuanActionPerformed(evt);
            }
        });

        jLabel8.setText("Usia");
        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        daftarlansia.setText("Daftar");
        daftarlansia.setBackground(new java.awt.Color(153, 153, 255));
        daftarlansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        daftarlansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarlansiaActionPerformed(evt);
            }
        });

        usialansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usialansiaActionPerformed(evt);
            }
        });

        jLabel9.setText("Tahun");
        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        hapuslansia.setText("Hapus");
        hapuslansia.setBackground(new java.awt.Color(153, 153, 255));
        hapuslansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        hapuslansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapuslansiaActionPerformed(evt);
            }
        });

        jLabel10.setText("Alamat");
        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        alamatlansia.setColumns(20);
        alamatlansia.setRows(5);
        jScrollPane1.setViewportView(alamatlansia);

        jLabel11.setText("Telepon");
        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        batallansia.setText("Batal");
        batallansia.setBackground(new java.awt.Color(153, 153, 255));
        batallansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        batallansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batallansiaActionPerformed(evt);
            }
        });

        jLabel38.setText("Tanggal Lahir");
        jLabel38.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

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
        jScrollPane6.setViewportView(tabellansia);

        ubahlansia.setText("Ubah");
        ubahlansia.setBackground(new java.awt.Color(153, 153, 255));
        ubahlansia.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ubahlansia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahlansiaActionPerformed(evt);
            }
        });

        carilansia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                carilansiaKeyPressed(evt);
            }
        });

        carilansiabutton.setText("Cari");
        carilansiabutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carilansiabuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(519, 519, 519))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(65, 65, 65)
                                        .addComponent(idlansia))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(namalansia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lansialaki)
                                        .addGap(8, 8, 8)
                                        .addComponent(lansiaperempuan))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addGap(40, 40, 40)
                                        .addComponent(tglahirlansia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(daftarlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(ubahlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hapuslansia, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(batallansia, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(usialansia, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(teleponlansia, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(carilansia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(carilansiabutton)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(usialansia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(namalansia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lansialaki)
                            .addComponent(jLabel7)
                            .addComponent(lansiaperempuan)))
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tglahirlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel11)
                    .addComponent(teleponlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daftarlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubahlansia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapuslansia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batallansia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carilansia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carilansiabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Pendaftaran Lansia", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Isi Data yang Lengkap");
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        jLabel13.setText("ID Anak");
        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        idanak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idanakKeyTyped(evt);
            }
        });

        jLabel14.setText("Nama Lengkap");
        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel15.setText("Jenis Kelamin");
        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        buttonGroup1.add(anaklaki);
        anaklaki.setText("Laki - Laki");
        anaklaki.setBackground(new java.awt.Color(255, 255, 255));
        anaklaki.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        buttonGroup1.add(anakperempuan);
        anakperempuan.setText("Perempuan");
        anakperempuan.setBackground(new java.awt.Color(255, 255, 255));
        anakperempuan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel16.setText("Tanggal Lahir");
        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel17.setText("Usia");
        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel18.setText("Tahun");
        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        daftaranak.setText("Daftar");
        daftaranak.setBackground(new java.awt.Color(153, 153, 255));
        daftaranak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        daftaranak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftaranakActionPerformed(evt);
            }
        });

        hapusanak.setText("Hapus");
        hapusanak.setBackground(new java.awt.Color(153, 153, 255));
        hapusanak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        hapusanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusanakActionPerformed(evt);
            }
        });

        jLabel19.setText("Nama Ayah");
        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel20.setText("Nama Ibu");
        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel21.setText("Alamat");
        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        alamatanak.setColumns(20);
        alamatanak.setRows(5);
        jScrollPane2.setViewportView(alamatanak);

        batalanak.setText("Batal");
        batalanak.setBackground(new java.awt.Color(153, 153, 255));
        batalanak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        batalanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalanakActionPerformed(evt);
            }
        });

        jLabel23.setText("Telepon");
        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        telponanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telponanakActionPerformed(evt);
            }
        });

        tabelanak.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelanak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelanakMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelanak);

        ubahanak.setText("Ubah");
        ubahanak.setBackground(new java.awt.Color(153, 153, 255));
        ubahanak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ubahanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahanakActionPerformed(evt);
            }
        });

        carianak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                carianakKeyPressed(evt);
            }
        });

        carianakbutton.setText("Cari");
        carianakbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carianakbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(carianak, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(carianakbutton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(idanak)
                                                    .addComponent(namaanak, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel23)))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel16)
                                                            .addComponent(jLabel17))
                                                        .addGap(34, 34, 34)
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(usiaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel18))
                                                            .addComponent(tglanak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                        .addComponent(jLabel15)
                                                        .addGap(34, 34, 34)
                                                        .addComponent(anaklaki)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(anakperempuan))
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(daftaranak, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(ubahanak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(hapusanak, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ibuanak)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                                .addComponent(telponanak, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(ayahanak, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(batalanak, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(52, 52, 52))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(ayahanak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(idanak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ibuanak, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(namaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(anaklaki)
                            .addComponent(anakperempuan)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tglanak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(usiaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23)
                    .addComponent(telponanak, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daftaranak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusanak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batalanak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubahanak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carianak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carianakbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Pendaftaran Anak", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setText("Isi Data yang Lengkap ");
        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        jLabel24.setText("ID Ibu Hamil");
        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        idhamil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idhamilKeyTyped(evt);
            }
        });

        jLabel25.setText("Nama Lengkap");
        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel26.setText("Tanggal Lahir");
        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel27.setText("Usia");
        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel28.setText("Tahun");
        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        daftaribuhamil.setText("Daftar");
        daftaribuhamil.setBackground(new java.awt.Color(153, 153, 255));
        daftaribuhamil.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        daftaribuhamil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftaribuhamilActionPerformed(evt);
            }
        });

        batalibuhamil.setText("Batal");
        batalibuhamil.setBackground(new java.awt.Color(153, 153, 255));
        batalibuhamil.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        batalibuhamil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalibuhamilActionPerformed(evt);
            }
        });

        jLabel29.setText("Alamat");
        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        alamatibuhamil.setColumns(20);
        alamatibuhamil.setRows(5);
        jScrollPane3.setViewportView(alamatibuhamil);

        jLabel30.setText("Telepon");
        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel31.setText("Nama Suami");
        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        hapusibuhamil.setText("Hapus");
        hapusibuhamil.setBackground(new java.awt.Color(153, 153, 255));
        hapusibuhamil.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        hapusibuhamil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusibuhamilActionPerformed(evt);
            }
        });

        ubahibuhamil.setText("Ubah");
        ubahibuhamil.setBackground(new java.awt.Color(153, 153, 255));
        ubahibuhamil.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ubahibuhamil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahibuhamilActionPerformed(evt);
            }
        });

        tabelibuhamil.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelibuhamil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelibuhamilMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tabelibuhamil);

        cariibuhamil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariibuhamilKeyPressed(evt);
            }
        });

        cariibuhamilbutton.setText("Cari");
        cariibuhamilbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariibuhamilbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telponibuhamil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(namasuami, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cariibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(cariibuhamilbutton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26)
                                    .addComponent(daftaribuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idhamil)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(usiaibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel28))
                                            .addComponent(namaibuhamil)
                                            .addComponent(tgllahiribuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(ubahibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(hapusibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(batalibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telponibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(namasuami, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(idhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(namaibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgllahiribuhamil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(usiaibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daftaribuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubahibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batalibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariibuhamilbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Pendaftaran Ibu Hamil", jPanel6);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 105));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 105));

        jLabel34.setText("Daftar Posyandu Gurame II");
        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N

        jButton13.setText("Kembali");
        jButton13.setBackground(new java.awt.Color(153, 153, 255));
        jButton13.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Beranda");
        jButton14.setBackground(new java.awt.Color(153, 153, 255));
        jButton14.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        jLabel35.setText("Jl. Kemiri Jaya RT. 001 RW. 001");
        jLabel35.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lansiaperempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lansiaperempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lansiaperempuanActionPerformed

    private void telponanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telponanakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telponanakActionPerformed

    private void usialansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usialansiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usialansiaActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void batalibuhamilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalibuhamilActionPerformed
        // TODO add your handling code here:
        kosongibuhamil();
        datatableibuhamil();
    }//GEN-LAST:event_batalibuhamilActionPerformed

    private void daftarlansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarlansiaActionPerformed
        // TODO add your handling code here:
        String jeniskelaminlansia = null;

        if (lansialaki.isSelected()) {
            jeniskelaminlansia = "Laki-Laki";
        } else if (lansiaperempuan.isSelected()) {
            jeniskelaminlansia = "Perempuan";
        }

        String sql = "insert into lansia values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idlansia.getText());
            stat.setString(2, namalansia.getText());
            stat.setString(3, jeniskelaminlansia);
            stat.setString(4, tglahirlansia.getDateStringOrEmptyString());
            stat.setString(5, usialansia.getText());
            stat.setString(6, alamatlansia.getText());
            stat.setString(7, teleponlansia.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosonglansia();
            idlansia.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatablelansia();
    }//GEN-LAST:event_daftarlansiaActionPerformed

    private void ubahlansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahlansiaActionPerformed
        // TODO add your handling code here:
        idlansia.setEditable(true);
        String jeniskelaminlansia = null;

        if (lansialaki.isSelected()) {
            jeniskelaminlansia = "Laki-Laki";
        } else if (lansiaperempuan.isSelected()) {
            jeniskelaminlansia = "Perempuan";
        }
        try {
            String sql = "update lansia set nama=?,jk=?,tgl=?,usia=?,ayah=?,ibu=?,alamat=?,telepon=? where id ='" + idlansia.getText() + "'  ";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namalansia.getText());
            stat.setString(2, jeniskelaminlansia);
            stat.setString(3, tglahirlansia.getDateStringOrEmptyString());
            stat.setString(4, usialansia.getText());
            stat.setString(5, alamatlansia.getText());
            stat.setString(6, teleponlansia.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosonglansia();
            idlansia.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah" + e);
        }
        datatablelansia();
    }//GEN-LAST:event_ubahlansiaActionPerformed

    private void hapuslansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapuslansiaActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from lansia where id='" + idlansia.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosonglansia();
                idlansia.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatablelansia();
        }
        idlansia.setEditable(true);
    }//GEN-LAST:event_hapuslansiaActionPerformed

    private void batallansiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batallansiaActionPerformed
        // TODO add your handling code here:
        kosonglansia();
        datatablelansia();
    }//GEN-LAST:event_batallansiaActionPerformed

    private void tabellansiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellansiaMouseClicked
        // TODO add your handling code here:
        int bar = tabellansia.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        idlansia.setEditable(false);
        idlansia.setText(a);
        namalansia.setText(b);
        if ("Laki-Laki".equals(c)) {
            lansialaki.setSelected(true);
        } else {
            lansiaperempuan.setSelected(true);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(d, formatter);
        tglahirlansia.setDate(dateTime);
        usialansia.setText(e);
        alamatlansia.setText(f);
        teleponlansia.setText(g);
    }//GEN-LAST:event_tabellansiaMouseClicked

    private void daftaranakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftaranakActionPerformed
        // TODO add your handling code here:
        String jeniskelaminanak = null;

        if (anaklaki.isSelected()) {
            jeniskelaminanak = "Laki-Laki";
        } else if (anakperempuan.isSelected()) {
            jeniskelaminanak = "Perempuan";
        }

        String sql = "insert into anak values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idanak.getText());
            stat.setString(2, namaanak.getText());
            stat.setString(3, jeniskelaminanak);
            stat.setString(4, tglanak.getDateStringOrEmptyString());
            stat.setString(5, usiaanak.getText());
            stat.setString(6, ayahanak.getText());
            stat.setString(7, ibuanak.getText());
            stat.setString(8, alamatanak.getText());
            stat.setString(9, telponanak.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosonganak();
            idanak.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatableanak();
    }//GEN-LAST:event_daftaranakActionPerformed

    private void ubahanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahanakActionPerformed
        // TODO add your handling code here:
        idanak.setEditable(true);
        String jeniskelaminanak = null;

        if (anaklaki.isSelected()) {
            jeniskelaminanak = "Laki-Laki";
        } else if (anakperempuan.isSelected()) {
            jeniskelaminanak = "Perempuan";
        }
        try {
            String sql = "update anak set nama=?,jk=?,tgl=?,usia=?,ayah=?,ibu=?,alamat=?,telepon=? where id ='" + idanak.getText() + "'  ";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaanak.getText());
            stat.setString(2, jeniskelaminanak);
            stat.setString(3, tglanak.getDateStringOrEmptyString());
            stat.setString(4, usiaanak.getText());
            stat.setString(5, ayahanak.getText());
            stat.setString(6, ibuanak.getText());
            stat.setString(7, alamatanak.getText());
            stat.setString(8, telponanak.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosonganak();
            idanak.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah" + e);
        }
        datatableanak();
    }//GEN-LAST:event_ubahanakActionPerformed

    private void hapusanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusanakActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from anak where id='" + idanak.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosonganak();
                idanak.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatableanak();
        }
        idanak.setEditable(true);
    }//GEN-LAST:event_hapusanakActionPerformed

    private void batalanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalanakActionPerformed
        // TODO add your handling code here:
        kosonganak();
        datatableanak();
    }//GEN-LAST:event_batalanakActionPerformed

    private void tabelanakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelanakMouseClicked
        // TODO add your handling code here:
        int bar = tabelanak.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
        idanak.setEditable(false);
        idanak.setText(a);
        namaanak.setText(b);
        if ("Laki-Laki".equals(c)) {
            anaklaki.setSelected(true);
        } else {
            anakperempuan.setSelected(true);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(d, formatter);
        tglanak.setDate(dateTime);
        usiaanak.setText(e);
        ayahanak.setText(f);
        ibuanak.setText(g);
        alamatanak.setText(h);
        telponanak.setText(i);
    }//GEN-LAST:event_tabelanakMouseClicked

    private void daftaribuhamilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftaribuhamilActionPerformed
        // TODO add your handling code here:

        String sql = "insert into ibuhamil values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idhamil.getText());
            stat.setString(2, namaibuhamil.getText());
            stat.setString(3, tgllahiribuhamil.getDateStringOrEmptyString());
            stat.setString(4, usiaibuhamil.getText());
            stat.setString(5, alamatibuhamil.getText());
            stat.setString(6, telponibuhamil.getText());
            stat.setString(7, namasuami.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosonganak();
            idhamil.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatableibuhamil();
    }//GEN-LAST:event_daftaribuhamilActionPerformed

    private void ubahibuhamilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahibuhamilActionPerformed
        // TODO add your handling code here:
        idhamil.setEditable(true);
        try {
            String sql = "update ibuhamil set nama=?,jk=?,tgl=?,usia=?,ayah=?,ibu=?,alamat=?,telepon=? where id ='" + idhamil.getText() + "'  ";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idhamil.getText());
            stat.setString(2, namaibuhamil.getText());
            stat.setString(3, tgllahiribuhamil.getDateStringOrEmptyString());
            stat.setString(4, usiaibuhamil.getText());
            stat.setString(5, alamatibuhamil.getText());
            stat.setString(6, telponibuhamil.getText());
            stat.setString(7, namasuami.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosongibuhamil();
            idhamil.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah" + e);
        }
        datatableibuhamil();
    }//GEN-LAST:event_ubahibuhamilActionPerformed

    private void hapusibuhamilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusibuhamilActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from ibuhamil where id='" + idhamil.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosongibuhamil();
                idhamil.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatableibuhamil();
        }
        idanak.setEditable(true);
    }//GEN-LAST:event_hapusibuhamilActionPerformed

    private void tabelibuhamilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelibuhamilMouseClicked
        // TODO add your handling code here:
        int bar = tabelibuhamil.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        idhamil.setEditable(false);
        idhamil.setText(a);
        namaibuhamil.setText(b);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(c, formatter);
        tgllahiribuhamil.setDate(dateTime);
        alamatibuhamil.setText(d);
        telponibuhamil.setText(f);
        namasuami.setText(g);
    }//GEN-LAST:event_tabelibuhamilMouseClicked
    private void idlansiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idlansiaKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_idlansiaKeyTyped

    private void idanakKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idanakKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_idanakKeyTyped

    private void idhamilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idhamilKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_idhamilKeyTyped

    private void carianakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carianakKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatableanak();
        }
    }//GEN-LAST:event_carianakKeyPressed

    private void carilansiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carilansiaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatablelansia();
        }
    }//GEN-LAST:event_carilansiaKeyPressed

    private void cariibuhamilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariibuhamilKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatableibuhamil();
        }
    }//GEN-LAST:event_cariibuhamilKeyPressed

    private void cariibuhamilbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariibuhamilbuttonActionPerformed
        // TODO add your handling code here:
        datatableibuhamil();
    }//GEN-LAST:event_cariibuhamilbuttonActionPerformed

    private void carianakbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carianakbuttonActionPerformed
        // TODO add your handling code here:
        datatableanak();
    }//GEN-LAST:event_carianakbuttonActionPerformed

    private void carilansiabuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carilansiabuttonActionPerformed
        // TODO add your handling code here:
        datatablelansia();
    }//GEN-LAST:event_carilansiabuttonActionPerformed

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
            java.util.logging.Logger.getLogger(tampilandaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilandaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilandaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilandaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilandaftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatanak;
    private javax.swing.JTextArea alamatibuhamil;
    private javax.swing.JTextArea alamatlansia;
    private javax.swing.JRadioButton anaklaki;
    private javax.swing.JRadioButton anakperempuan;
    private javax.swing.JTextField ayahanak;
    private javax.swing.JButton batalanak;
    private javax.swing.JButton batalibuhamil;
    private javax.swing.JButton batallansia;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField carianak;
    private javax.swing.JButton carianakbutton;
    private javax.swing.JTextField cariibuhamil;
    private javax.swing.JButton cariibuhamilbutton;
    private javax.swing.JTextField carilansia;
    private javax.swing.JButton carilansiabutton;
    private javax.swing.JButton daftaranak;
    private javax.swing.JButton daftaribuhamil;
    private javax.swing.JButton daftarlansia;
    private javax.swing.JButton hapusanak;
    private javax.swing.JButton hapusibuhamil;
    private javax.swing.JButton hapuslansia;
    private javax.swing.JTextField ibuanak;
    private javax.swing.JTextField idanak;
    private javax.swing.JTextField idhamil;
    private javax.swing.JTextField idlansia;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JRadioButton lansialaki;
    private javax.swing.JRadioButton lansiaperempuan;
    private javax.swing.JTextField namaanak;
    private javax.swing.JTextField namaibuhamil;
    private javax.swing.JTextField namalansia;
    private javax.swing.JTextField namasuami;
    private javax.swing.JTable tabelanak;
    private javax.swing.JTable tabelibuhamil;
    private javax.swing.JTable tabellansia;
    private javax.swing.JTextField teleponlansia;
    private javax.swing.JTextField telponanak;
    private javax.swing.JTextField telponibuhamil;
    private com.github.lgooddatepicker.components.DatePicker tglahirlansia;
    private com.github.lgooddatepicker.components.DatePicker tglanak;
    private com.github.lgooddatepicker.components.DatePicker tgllahiribuhamil;
    private javax.swing.JButton ubahanak;
    private javax.swing.JButton ubahibuhamil;
    private javax.swing.JButton ubahlansia;
    private javax.swing.JTextField usiaanak;
    private javax.swing.JTextField usiaibuhamil;
    private javax.swing.JTextField usialansia;
    // End of variables declaration//GEN-END:variables
}
