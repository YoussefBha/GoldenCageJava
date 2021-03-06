/*
 * Copyright (C) 2014 Karim
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
import tn.mariages.dao.ToDoDAO;

import tn.mariages.entities.ToDo;


/**
 *
 * @author Karim
 */
public class TableListeToDoModel extends AbstractTableModel{
    ToDoDAO todoDAO=new ToDoDAO();
  
   
    ToDo todo=new ToDo();
    
    List<ToDo> listToDo = new ArrayList<ToDo>();
    String [] header={"ID ToDo","Titre","Description","Date","Supprimer"};
    //List<Boolean> rowList=new ArrayList<Boolean>(getRowCount());
    Boolean rowlist[][] = new Boolean[50][50];
    public TableListeToDoModel(){
    listToDo=new ToDoDAO().DisplayAllToDo();
    for (int i = 0; i < getRowCount(); i++) {
        rowlist[i][5]=Boolean.FALSE;
      
            }
}

    @Override
    public int getRowCount() {
        return listToDo.size();   
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        todo=todoDAO.findToDoById(listToDo.get(rowIndex).getIdToDo());
switch(columnIndex){
            case 0:return listToDo.get(rowIndex).getIdToDo();
            
            case 1:return listToDo.get(rowIndex).getTitreToDo();
            case 2:return listToDo.get(rowIndex).getDescToDo();
            case 3:return listToDo.get(rowIndex).getDateToDo();
          
            case 4:return rowlist[rowIndex][8];
            
                
                default:return null;
                
        }
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         
         
        boolean b = (Boolean) aValue;
            if(columnIndex==4)
                rowlist[rowIndex][4]=b;
            
        fireTableCellUpdated(rowIndex, columnIndex);
    
    }
    
    
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==4 ){
            return Boolean.class;
        }
        
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public boolean isCellEditable(int row, int column) {
    return (column > 3);
  }
    
    
    
}

