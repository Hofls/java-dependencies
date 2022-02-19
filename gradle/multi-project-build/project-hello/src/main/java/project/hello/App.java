package project.hello;


import project.common.utils.MessageUtils;

// @EntityScan("project.common.entity.*")
// @ComponentScan(basePackages = {"project.common.repository"})
public class App {
    public String getGreeting() {
        return MessageUtils.getGreeting() + " world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
