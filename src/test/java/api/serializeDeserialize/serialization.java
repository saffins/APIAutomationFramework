package api.serializeDeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class serialization {

    public static void main(String[] args) throws JsonProcessingException {
        Employee employee = new Employee();
        employee.setEmpId("123sd");
        employee.setEmpName("saffin");
        ObjectMapper om = new ObjectMapper();
        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(json);
    }

}
