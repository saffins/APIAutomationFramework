package api.serializeDeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class deserialization {

    public static void main(String[] args) throws JsonProcessingException {

        String jsonObj = "{\n" +
                "  \"empName\" : \"saffin\",\n" +
                "  \"empId\" : \"123sd\"\n" +
                "}";

        ObjectMapper om = new ObjectMapper();
        Employee employee = om.readValue(jsonObj,Employee.class);
        System.out.println(employee.getEmpId());
        System.out.println(employee.getEmpName());

    }

}
