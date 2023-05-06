package com.maria.ass1.raport;

import com.maria.ass1.model.user.User;

import java.io.IOException;

public class TxtReport extends Report{
    public TxtReport(User user, String name) {
        super(user, name);
    }

    @Override
    public void generateReport() {
        try {
            java.io.FileWriter fw = new java.io.FileWriter(this.nameFile+".txt");
            fw.write("Draga, : "+ user.getName()+"\n\n");
            fw.write("Multumim pentru comanda efectuata."+"\n");
            fw.write("Detaliile rapoartelor  de pana acum sunt:"+"\n");
           for(int i=0; i<user.getProduse().size(); i++) {
               fw.write("\n"+user.getProduse().get(i));
           }
            fw.write("\nTotal Price"+user.getProduse().get(0)+"\n");
            fw.write("\n"+"Va multumim pentru comanda"+"\n");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
