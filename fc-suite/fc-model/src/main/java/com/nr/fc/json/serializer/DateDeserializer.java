
package com.nr.fc.json.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Amith
 */
public class DateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String date = jp.getText();
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
