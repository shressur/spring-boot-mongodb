package learn.springboot.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//@Document or
@Document(collection = "wrestlers")
public class Wrestler {
    @Id
    //use BigInteger or String or ObjectId because long or int won't work:
    //https://docs.spring.io/spring-data/data-mongo/docs/1.4.0.M1/reference/html/mapping-chapter.html#d0e5192
    //if "id" is declared to be of type BigInteger then the "_id" in MongoDB (ObjectId type) and "id" returned by
    //Postman (String type) might look different
    private String id;
    private String name;
    private String finisher;
    private String gender;
    private boolean isActive;

}
