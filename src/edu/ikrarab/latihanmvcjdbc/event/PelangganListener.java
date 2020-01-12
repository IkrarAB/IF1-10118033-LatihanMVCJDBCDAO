/*
NIM   : 10118033
NAMA  : IKRAR ANUGRAH BASTARY
KELAS : IF-1
*/

package edu.ikrarab.latihanmvcjdbc.event;

import edu.ikrarab.latihanmvcjdbc.entity.Pelanggan;
import edu.ikrarab.latihanmvcjdbc.model.PelangganModel;

public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    public void onInsert(Pelanggan pelanggan);
    public void onDelete();
    public void onUpdate(Pelanggan pelanggan);
    
}
