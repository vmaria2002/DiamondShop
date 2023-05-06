package com.maria.ass1.raport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maria.ass1.model.user.User;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonReport extends  Report{

    public JsonReport(User user, String name) {
        super(user, name);
    }

    @Override
    public void generateReport() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Draga, ", user.getName());
        jsonObject.put("Multumim pentru comanda efectuata", "");
        jsonObject.put("Detaliile rapoartelor  de pana acum sunt:","");

        for(int i=0; i<user.getProduse().size(); i++) {
            jsonObject.put("\n+user.getProduse().get(i)", user.getUsername());
        }
        jsonObject.put("\nTotal Price"+user.getProduse().get(0)+"\n", "");
        jsonObject.put("\nVa multumim pentru comanda\n", "");


        ObjectMapper mapper = new ObjectMapper();
        try {
            Files.write(Path.of(nameFile+".json"),
                    mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(mapper.readTree(jsonObject.toJSONString())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
