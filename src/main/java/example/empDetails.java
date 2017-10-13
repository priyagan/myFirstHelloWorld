package example;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;



/**
 * Created by ganes on 7/20/2017.
 */
public class empDetails  implements RequestHandler<empDetails.RequestClass,empDetails.ResponseClass> {

    public ResponseClass handleRequest(RequestClass request, Context context) {
        String greetingString = String.format("Hello %s, %s.", request.firstName, request.lastName);
        if(request.age > 15)
            
            greetingString = greetingString.concat(" Im an adult");
        else
            greetingString = greetingString.concat(" Im a youth");
        return new ResponseClass(greetingString);
    }



public static class ResponseClass {
    String greetings;

    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }

    public ResponseClass(String greetings) {
        this.greetings = greetings;
    }

    public ResponseClass() {
    }

}

    public static class RequestClass {
        String firstName;
        String lastName;
        float age;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public float getAge() {
            return age;
        }

        public void setAge(float age) {
            this.age = age;
        }

        public RequestClass(String firstName, String lastName, float age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public RequestClass() {
        }
    }
}