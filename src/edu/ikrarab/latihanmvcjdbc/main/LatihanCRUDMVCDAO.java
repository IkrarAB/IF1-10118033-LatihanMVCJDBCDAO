/*
NIM   : 10118033
NAMA  : IKRAR ANUGRAH BASTARY
KELAS : IF-1
*/

package edu.ikrarab.latihanmvcjdbc.main;

import edu.ikrarab.latihanmvcjdbc.database.KingBarbershopDatabase;
import edu.ikrarab.latihanmvcjdbc.entity.Pelanggan;
import edu.ikrarab.latihanmvcjdbc.error.PelangganException;
import edu.ikrarab.latihanmvcjdbc.service.PelangganDao;
import edu.ikrarab.latihanmvcjdbc.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class LatihanCRUDMVCDAO {

    public static void main(String[] args) throws SQLException, PelangganException{
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    MainViewPelanggan pelanggan = new MainViewPelanggan();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e){
                    
                } catch (PelangganException ex) {
                    Logger.getLogger(LatihanCRUDMVCDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
