package project.bye;


import project.common.utils.MessageUtils;

// @EntityScan("project.common.entity.*")
// @ComponentScan(basePackages = {"project.common.repository"})
public class App {
    public String getGreeting() {
        return MessageUtils.getFarewell() + " world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
