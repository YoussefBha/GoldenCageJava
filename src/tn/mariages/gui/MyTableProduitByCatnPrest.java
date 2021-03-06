/*
 * Copyright (C) 2014 Youssef
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package tn.mariages.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tn.mariages.dao.PrestataireDAO;
import tn.mariages.dao.ProduitDAO;
import tn.mariages.entities.Prestataire;
import tn.mariages.entities.Produit;

/**
 *
 * @author Youssef
 */
public class MyTableProduitByCatnPrest extends AbstractTableModel{
     public List<Produit> mylist = new ArrayList<>();
    String [] headers  = {"Nom Produit ","Nom Prestataire","Categorie","Date d'ajout","Prix"};

    public MyTableProduitByCatnPrest(String a,int id) {
        mylist = new ProduitDAO().DisplayProdByCategorieAndPrest(a,id);
    }
    
    
    

    @Override
    public int getRowCount() {
        return mylist.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prestataire p = new Prestataire() ;
        PrestataireDAO pdao= new PrestataireDAO();
        p=pdao.findPrestById(mylist.get(rowIndex).getIdPrest());
        
        switch(columnIndex){
            case 0 : 
                return mylist.get(rowIndex).getNomProd();
            case 1 :
                return p.getNomPrest();
            case 2 :
                return mylist.get(rowIndex).getCategorieProd();
            case 3 :
                return mylist.get(rowIndex).getDateAjoutProd();
            case 4 :
                return mylist.get(rowIndex).getPrixProd();
            default :
        return null;
        }
    }
    
    
    @Override
    public String getColumnName(int column) {
        return headers[column];//To change body of generated methods, choose Tools | Templates.
    }
    
}
