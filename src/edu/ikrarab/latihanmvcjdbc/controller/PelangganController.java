/*
NIM   : 10118033
NAMA  : IKRAR ANUGRAH BASTARY
KELAS : IF-1
*/

package edu.ikrarab.latihanmvcjdbc.controller;

import edu.ikrarab.latihanmvcjdbc.model.PelangganModel;
import edu.ikrarab.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

public class PelangganController {
    
    private PelangganModel model;
    
    public void setModel(PelangganModel model){
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan();
    }
    
    public void insertPelanggan(PelangganView view){
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if(nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if(telepon.length()>12){
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if(!email.contains("@")||!email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else{
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try{
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil ditambahkan");
                model.resetPelanggan();
            } catch(Throwable throwable){
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
        }
    }
    
    public void updatePelanggan(PelangganView view){
        
        if(view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan diubah");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if(nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if(telepon.length()>12){
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if(!email.contains("@")||!email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else{
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try{
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil di Ubah");
                model.resetPelanggan();
            } catch(Throwable throwable){
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
        }
    }
    
    public void deletePelanggan(PelangganView view){
        if(view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan dihapus");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")==JOptionPane.OK_OPTION){
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try{
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil dihapus");
                model.resetPelanggan();
            }catch(Throwable throwable){
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
        }
    }
}
