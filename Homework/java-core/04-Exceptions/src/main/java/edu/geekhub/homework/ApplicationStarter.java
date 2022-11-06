package edu.geekhub.homework;

import edu.geekhub.controller.Controller;
import edu.geekhub.models.request.Request;
import edu.geekhub.models.request.Response;
import edu.geekhub.utils.RandomRequestDataGenerator;
import edu.geekhub.utils.RequestDataGenerator;

// Don't move this class
public class ApplicationStarter {

    private static final Controller controller = new UserController();

    private static final RequestDataGenerator generator = new RandomRequestDataGenerator();

    public static void main(String[] args) {
        while(true) {
            Request request = generator.generate();

            Response response = controller.process(request);

            System.out.println(response);
        }
    }
}