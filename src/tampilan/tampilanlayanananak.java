/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import java.util.HashMap;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Locale;

/**
 *
 * @author farhatdk
 */
public class tampilanlayanananak extends javax.swing.JFrame {
    public String Id, nama, jk, tgl, usia, ayah, ibu, alamat, telepon ;
    public String id_timbang, no_timbang, id_anak, berat, tinggi, ket;
    public String id2, no_imunisasi, id_anak2, jenis_vitamin, id_imunisasi, jenis_imunisasi, ket2;
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;
    /**
     * Creates new form tampilanlayanananak
     */
    public tampilanlayanananak() {
        initComponents();
        kosongtimbanganak();
        kosongimunisasianak();
        datatabletimbang();
        datatableimunisasi();
        aktiftimbanganak();
        aktifimunisasianak();
        autonumbertimbang();
        autonumberimunisasi();
        Locale locale = new Locale ("id","ID");
        Locale.setDefault(locale);
        
    }
    private void kosongtimbanganak(){
        iddaftaranak.setText("");
        idanak1.setText("");
        namaanak.setText("");
        usiaanak.setText("");
        namaibu.setText("");
        beratanak.setText("");
        tinggianak.setText("");
        ketanak.setText("");
    }
    private void kosongimunisasianak(){
        iddaftarimunisasi.setText("");
        idanakimunisasi.setText("");
        namaanakimunisasi.setText("");
        usiaanakimunisasi.setText("");
        namaibuimunisasi.setText("");
        jenisvitaminimunisasi.setSelectedItem(null);
        idimunisasianak.setText("");
        jenisimunisasi.setText("");
        ketimunisasi.setText("");
    }
    
    private void aktiftimbanganak(){
        beratanak.requestFocus();
    }
    
    private void aktifimunisasianak(){
        jenisvitaminimunisasi.requestFocus();
    }
    
    private void autonumbertimbang(){
        try {
            String sql = "SELECT id FROM timbanganak order by id asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            iddaftaranak.setText("1");
            while (rs.next()) {
                String id_transaksi = rs.getString("id");
                int AN = Integer.parseInt(id_transaksi) + 1;
                String ANS = Integer.toString(AN);
                iddaftaranak.setText(ANS);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
        }
    }
    
    private void autonumberimunisasi(){
        try {
            String sql = "SELECT id FROM imunisasianak order by id asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            iddaftarimunisasi.setText("1");
            while (rs.next()) {
                String id_transaksi = rs.getString("id");
                int AN = Integer.parseInt(id_transaksi) + 1;
                String ANS = Integer.toString(AN);
                iddaftarimunisasi.setText(ANS);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
        }
    }
    
    public void IdAnak() {
        tampilanpopupanak pa = new tampilanpopupanak();
        pa.lynn = this;
        idanak1.setText(Id);
        namaanak.setText(nama);
        usiaanak.setText(usia);
        namaibu.setText(ibu);
    }
    public void IdAnak2() {
        tampilanpopupanak pa = new tampilanpopupanak();
        pa.lynn = this;
        idanakimunisasi.setText(Id);
        namaanakimunisasi.setText(nama);
        usiaanakimunisasi.setText(usia);
        namaibuimunisasi.setText(ibu);
    }
    protected void datatabletimbang(){
        Object[] Baris ={"No Timbang","Id Anak","Nama Anak","Usia","Nama Ibu","Berat Badan","Tinggi Badan","Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem=caricetaktimbang.getText();

        try {
            String sql = "SELECT timbanganak.no_timbang, anak.id, anak.nama, anak.usia, anak.ibu, timbanganak.berat, timbanganak.tinggi, timbanganak.ket FROM timbanganak INNER JOIN anak ON timbanganak.id_anak = anak.id where anak.id like '%"+cariitem+"%' or anak.nama like '%"+cariitem+"%' order by anak.id asc";
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
                    hasil.getString(8)
                });
            }
            tabeltimbang.setModel(tabmode);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
    }
    
    protected void datatableimunisasi(){
        Object[] Baris ={"No Imunisasi","Id Anak","Nama Anak","Usia","Nama Ibu","Jenis Vitamin","Id Imunisasi","Jenis Imunisasi","Ket."};
        tabmode2 = new DefaultTableModel(null, Baris);
        String cariitem=caricetaktimbang.getText();

        try {
            String sql = "SELECT imunisasianak.no_imunisasi, anak.id, anak.nama, anak.usia, anak.ibu, imunisasianak.jenis_vitamin, imunisasianak.id_imunisasi, imunisasianak.jenis_imunisasi, imunisasianak.ket FROM imunisasianak INNER JOIN anak ON imunisasianak.id_anak = anak.id where anak.id like '%"+cariitem+"%' or anak.nama like '%"+cariitem+"%' order by anak.id asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode2.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7),
                    hasil.getString(8),
                    hasil.getString(9),
                });
            }
            tabelimunisasi.setModel(tabmode2);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        iddaftaranak = new javax.swing.JTextField();
        idanak1 = new javax.swing.JTextField();
        namaanak = new javax.swing.JTextField();
        usiaanak = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namaibu = new javax.swing.JTextField();
        beratanak = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        simpananak = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ketanak = new javax.swing.JTextArea();
        batalanak = new javax.swing.JButton();
        hapusanak = new javax.swing.JButton();
        ubahanak = new javax.swing.JButton();
        cariidanak = new javax.swing.JButton();
        tinggianak = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabeltimbang = new javax.swing.JTable();
        caricetaktimbang = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cetaktimbang = new javax.swing.JButton();
        caritimbanganak = new javax.swing.JTextField();
        caributtontimbang = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        iddaftarimunisasi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        idanakimunisasi = new javax.swing.JTextField();
        namaanakimunisasi = new javax.swing.JTextField();
        usiaanakimunisasi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        namaibuimunisasi = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cariidanakimunisasi = new javax.swing.JButton();
        simpanimunisasi = new javax.swing.JButton();
        ubahimunisasi = new javax.swing.JButton();
        batalimunisasi = new javax.swing.JButton();
        jenisvitaminimunisasi = new javax.swing.JComboBox();
        idimunisasianak = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        hapusimunisasi = new javax.swing.JButton();
        jenisimunisasi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelimunisasi = new javax.swing.JTable();
        imunisasicari = new javax.swing.JTextField();
        caridataimunisasi = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cariimunisasi = new javax.swing.JTextField();
        cetakimunisasi = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ketimunisasi = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 105));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 105));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel5.setText("Pelayanan Anak");

        jButton8.setBackground(new java.awt.Color(153, 153, 255));
        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jButton8.setText("Beranda");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39))
        );

        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel1.setText("No. Timbang");

        idanak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idanak1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Bln");

        jLabel3.setText("Kg");

        jLabel4.setText("Cm");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel8.setText("ID Anak");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel9.setText("Nama Anak");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel10.setText("Usia");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel11.setText("Nama Ibu");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel12.setText("Berat Badan");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel13.setText("Tinggi Badan");

        simpananak.setBackground(new java.awt.Color(153, 153, 255));
        simpananak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        simpananak.setText("Simpan");
        simpananak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpananakActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel15.setText("Ket.");

        ketanak.setColumns(20);
        ketanak.setRows(5);
        jScrollPane1.setViewportView(ketanak);

        batalanak.setBackground(new java.awt.Color(153, 153, 255));
        batalanak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        batalanak.setText("Batal");
        batalanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalanakActionPerformed(evt);
            }
        });

        hapusanak.setBackground(new java.awt.Color(153, 153, 255));
        hapusanak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        hapusanak.setText("Hapus");
        hapusanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusanakActionPerformed(evt);
            }
        });

        ubahanak.setBackground(new java.awt.Color(153, 153, 255));
        ubahanak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ubahanak.setText("Ubah");
        ubahanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahanakActionPerformed(evt);
            }
        });

        cariidanak.setBackground(new java.awt.Color(153, 153, 255));
        cariidanak.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        cariidanak.setText("Cari");
        cariidanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariidanakActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel28.setText("Layanan Timbang Anak");

        tabeltimbang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeltimbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltimbangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabeltimbang);

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel30.setText("ID Anak");

        cetaktimbang.setBackground(new java.awt.Color(153, 153, 255));
        cetaktimbang.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        cetaktimbang.setText("Cetak");
        cetaktimbang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetaktimbangActionPerformed(evt);
            }
        });

        caributtontimbang.setBackground(new java.awt.Color(153, 153, 255));
        caributtontimbang.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        caributtontimbang.setText("Cari");
        caributtontimbang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caributtontimbangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tinggianak, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(usiaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2))
                                .addComponent(namaibu, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(beratanak)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addGap(48, 48, 48)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hapusanak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(simpananak, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ubahanak, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(batalanak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(idanak1)
                                    .addGap(23, 23, 23)
                                    .addComponent(cariidanak))
                                .addComponent(iddaftaranak, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(caricetaktimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cetaktimbang))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caritimbanganak, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(caributtontimbang))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caritimbanganak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caributtontimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(iddaftaranak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(caricetaktimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cetaktimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idanak1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cariidanak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(usiaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namaibu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(beratanak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinggianak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simpananak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubahanak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hapusanak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batalanak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Timbang Anak", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel16.setText("No Imunisasi");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel17.setText("ID Anak");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel18.setText("Bln");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel19.setText("Nama Anak");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel20.setText("Usia");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel21.setText("Nama Ibu");

        cariidanakimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        cariidanakimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        cariidanakimunisasi.setText("Cari");
        cariidanakimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariidanakimunisasiActionPerformed(evt);
            }
        });

        simpanimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        simpanimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 9)); // NOI18N
        simpanimunisasi.setText("Simpan");
        simpanimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanimunisasiActionPerformed(evt);
            }
        });

        ubahimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        ubahimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ubahimunisasi.setText("Ubah");
        ubahimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahimunisasiActionPerformed(evt);
            }
        });

        batalimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        batalimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        batalimunisasi.setText("Batal");
        batalimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalimunisasiActionPerformed(evt);
            }
        });

        jenisvitaminimunisasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vitamin A Kapsul Merah", "Vitamin B Kapsul Biru" }));
        jenisvitaminimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisvitaminimunisasiActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 9)); // NOI18N
        jLabel29.setText("Jenis Vitamin");

        hapusimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        hapusimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        hapusimunisasi.setText("Hapus");
        hapusimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusimunisasiActionPerformed(evt);
            }
        });

        jenisimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisimunisasiActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel22.setText("Layanan Imunisasi Anak");

        tabelimunisasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelimunisasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelimunisasiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelimunisasi);

        caridataimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        caridataimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        caridataimunisasi.setText("Cari");
        caridataimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caridataimunisasiActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel23.setText("ID Anak");

        cetakimunisasi.setBackground(new java.awt.Color(153, 153, 255));
        cetakimunisasi.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        cetakimunisasi.setText("Cetak");
        cetakimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakimunisasiActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel26.setText("Ket.");

        ketimunisasi.setColumns(20);
        ketimunisasi.setRows(5);
        jScrollPane2.setViewportView(ketimunisasi);

        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 9)); // NOI18N
        jLabel31.setText("ID Imunisasi");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 9)); // NOI18N
        jLabel32.setText("Jenis Imunisasi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(48, 48, 48))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel26))
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(usiaanakimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaibuimunisasi)
                                    .addComponent(iddaftarimunisasi)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(idanakimunisasi)
                                        .addGap(25, 25, 25)
                                        .addComponent(cariidanakimunisasi))
                                    .addComponent(namaanakimunisasi)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(batalimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jenisvitaminimunisasi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(idimunisasianak, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jenisimunisasi, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                                .addComponent(ubahimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(simpanimunisasi, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(hapusimunisasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imunisasicari, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(caridataimunisasi))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(cariimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cetakimunisasi)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(imunisasicari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caridataimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iddaftarimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idanakimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariidanakimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaanakimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usiaanakimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaibuimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cariimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cetakimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisvitaminimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idimunisasianak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenisimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel26)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ubahimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(hapusimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(batalimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Imunisasi Anak", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cariidanakimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariidanakimunisasiActionPerformed
        tampilanpopupanak2 pa = new tampilanpopupanak2();
        pa.lynn2 = this;
        pa.setVisible(true);
        pa.setResizable(false);
    }//GEN-LAST:event_cariidanakimunisasiActionPerformed

    private void idanak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idanak1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idanak1ActionPerformed

    private void caridataimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridataimunisasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caridataimunisasiActionPerformed

    private void cetakimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakimunisasiActionPerformed
        cetakimunisasi();
    }//GEN-LAST:event_cetakimunisasiActionPerformed

    private void cetaktimbangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetaktimbangActionPerformed
        cetaktimbang();
    }//GEN-LAST:event_cetaktimbangActionPerformed

    private void caributtontimbangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caributtontimbangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caributtontimbangActionPerformed

    private void jenisimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisimunisasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisimunisasiActionPerformed

    private void cariidanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariidanakActionPerformed
        tampilanpopupanak pa = new tampilanpopupanak();
        pa.lynn = this;
        pa.setVisible(true);
        pa.setResizable(false);                      
    }//GEN-LAST:event_cariidanakActionPerformed

    private void simpananakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpananakActionPerformed
       String sql = "insert into timbanganak values (?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, iddaftaranak.getText());
            stat.setString(2, iddaftaranak.getText());
            stat.setString(3, idanak1.getText());
            stat.setString(4, beratanak.getText());
            stat.setString(5, tinggianak.getText());
            stat.setString(6, ketanak.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosongtimbanganak();
            autonumberimunisasi();
            iddaftaranak.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatabletimbang();
    }//GEN-LAST:event_simpananakActionPerformed

    private void tabeltimbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltimbangMouseClicked
        int bar = tabeltimbang.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        iddaftaranak.setEditable(false);
        namaanak.setEditable(false);
        usiaanak.setEditable(false);
        namaibu.setEditable(false);
        idanak1.setEditable(false);
        iddaftaranak.setText(a);
        idanak1.setText(b);
        namaanak.setText(c);
        usiaanak.setText(d);
        namaibu.setText(e);
        beratanak.setText(f);
        tinggianak.setText(g);
        ketanak.setText(h);
    }//GEN-LAST:event_tabeltimbangMouseClicked

    private void batalanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalanakActionPerformed
        kosongtimbanganak();
    }//GEN-LAST:event_batalanakActionPerformed

    private void batalimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalimunisasiActionPerformed
        kosongimunisasianak();
    }//GEN-LAST:event_batalimunisasiActionPerformed

    private void hapusanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusanakActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from timbanganak where id='" + idanak1.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosongtimbanganak();
                idanak1.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatabletimbang();
        }
        idanak1.setEditable(true);
    }//GEN-LAST:event_hapusanakActionPerformed

    private void hapusimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusimunisasiActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from imunisasianak where id='" + idanakimunisasi.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosongimunisasianak();
                idanakimunisasi.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatableimunisasi();
        }
        idanakimunisasi.setEditable(true);
    }//GEN-LAST:event_hapusimunisasiActionPerformed

    private void simpanimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanimunisasiActionPerformed
        String sql = "insert into imunisasianak values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, iddaftarimunisasi.getText());
            stat.setString(2, iddaftarimunisasi.getText());
            stat.setString(3, idanakimunisasi.getText());
            stat.setString(4, jenisvitaminimunisasi.getSelectedItem().toString());
            stat.setString(5, idimunisasianak.getText());
            stat.setString(6, jenisimunisasi.getText());
            stat.setString(7, ketimunisasi.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosongimunisasianak();
            autonumberimunisasi();
            iddaftarimunisasi.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatableimunisasi();
    }//GEN-LAST:event_simpanimunisasiActionPerformed

    private void ubahanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahanakActionPerformed
        iddaftaranak.setEditable(true);
        namaanak.setEditable(true);
        usiaanak.setEditable(true);
        namaibu.setEditable(true);
        idanak1.setEditable(true);
        try {
            String sql = "update timbanganak set berat=?,tinggi=?,ket=? where id ='" + iddaftaranak.getText() + "'  ";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, beratanak.getText());
            stat.setString(2, tinggianak.getText());
            stat.setString(3, ketanak.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosongtimbanganak();
            autonumbertimbang();
            iddaftaranak.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah" + e);
        }
        datatabletimbang();
    }//GEN-LAST:event_ubahanakActionPerformed
    public void cetaktimbang() {
        try {
            String path = "./src/report/anaktimbang.jasper"; // letakpenyimpanan report
            HashMap parameter = new HashMap();
            parameter.put("parameterId", iddaftaranak.getText());
            JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "DokumenTidak Ada " + ex);
        }
    }
    public void cetakimunisasi() {
        try {
            String path = "./src/report/anakimunisasi.jasper"; // letakpenyimpanan report
            HashMap parameter = new HashMap();
            parameter.put("parameterId", iddaftaranak.getText());
            JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Dokumen Tidak Ada " + ex);
        }
    }
    private void ubahimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahimunisasiActionPerformed
        iddaftarimunisasi.setEditable(true);
        namaanak.setEditable(true);
        usiaanak.setEditable(true);
        namaibu.setEditable(true);
        idanak1.setEditable(true);
        try {
            String sql = "update imunisasianak set jenis_vitamin=?,jenis_imunisasi=?,ket=? where id ='" + iddaftarimunisasi.getText() + "'  ";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, beratanak.getText());
            stat.setString(2, tinggianak.getText());
            stat.setString(3, ketanak.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosongtimbanganak();
            autonumberimunisasi();
            iddaftaranak.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah" + e);
        }
        datatableimunisasi();
    }//GEN-LAST:event_ubahimunisasiActionPerformed

    private void tabelimunisasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelimunisasiMouseClicked
        int bar = tabelimunisasi.getSelectedRow();
        String a = tabmode2.getValueAt(bar, 0).toString();
        String b = tabmode2.getValueAt(bar, 1).toString();
        String c = tabmode2.getValueAt(bar, 2).toString();
        String d = tabmode2.getValueAt(bar, 3).toString();
        String e = tabmode2.getValueAt(bar, 4).toString();
        String f = tabmode2.getValueAt(bar, 5).toString();
        String g = tabmode2.getValueAt(bar, 6).toString();
        String h = tabmode2.getValueAt(bar, 7).toString();
        String i = tabmode2.getValueAt(bar, 8).toString();
        String j = tabmode2.getValueAt(bar, 9).toString();
        iddaftarimunisasi.setEditable(false);
        iddaftarimunisasi.setEditable(false);
        idanakimunisasi.setEditable(false);
        namaibu.setEditable(false);
        namaanakimunisasi.setEditable(false);
        idimunisasianak.setEditable(false);
        iddaftarimunisasi.setText(a);
        iddaftarimunisasi.setText(b);
        idanakimunisasi.setText(c);
        namaanakimunisasi.setText(d);
        usiaanakimunisasi.setText(e);
        namaibuimunisasi.setText(f);
        jenisvitaminimunisasi.setSelectedItem(g);
        idimunisasianak.setText(h);
        jenisimunisasi.setText(i);
        ketimunisasi.setText(j);
    }//GEN-LAST:event_tabelimunisasiMouseClicked

    private void jenisvitaminimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisvitaminimunisasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisvitaminimunisasiActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        this.dispose();
        tampilanutama dashboard = new tampilanutama();
        dashboard.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(tampilanlayanananak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilanlayanananak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilanlayanananak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilanlayanananak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilanlayanananak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalanak;
    private javax.swing.JButton batalimunisasi;
    private javax.swing.JTextField beratanak;
    private javax.swing.JButton caributtontimbang;
    private javax.swing.JTextField caricetaktimbang;
    private javax.swing.JButton caridataimunisasi;
    private javax.swing.JButton cariidanak;
    private javax.swing.JButton cariidanakimunisasi;
    private javax.swing.JTextField cariimunisasi;
    private javax.swing.JTextField caritimbanganak;
    private javax.swing.JButton cetakimunisasi;
    private javax.swing.JButton cetaktimbang;
    private javax.swing.JButton hapusanak;
    private javax.swing.JButton hapusimunisasi;
    private javax.swing.JTextField idanak1;
    private javax.swing.JTextField idanakimunisasi;
    private javax.swing.JTextField iddaftaranak;
    private javax.swing.JTextField iddaftarimunisasi;
    private javax.swing.JTextField idimunisasianak;
    private javax.swing.JTextField imunisasicari;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jenisimunisasi;
    private javax.swing.JComboBox jenisvitaminimunisasi;
    private javax.swing.JTextArea ketanak;
    private javax.swing.JTextArea ketimunisasi;
    private javax.swing.JTextField namaanak;
    private javax.swing.JTextField namaanakimunisasi;
    private javax.swing.JTextField namaibu;
    private javax.swing.JTextField namaibuimunisasi;
    private javax.swing.JButton simpananak;
    private javax.swing.JButton simpanimunisasi;
    private javax.swing.JTable tabelimunisasi;
    private javax.swing.JTable tabeltimbang;
    private javax.swing.JTextField tinggianak;
    private javax.swing.JButton ubahanak;
    private javax.swing.JButton ubahimunisasi;
    private javax.swing.JTextField usiaanak;
    private javax.swing.JTextField usiaanakimunisasi;
    // End of variables declaration//GEN-END:variables
}
