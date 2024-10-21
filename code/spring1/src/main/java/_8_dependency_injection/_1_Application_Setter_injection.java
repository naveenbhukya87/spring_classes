package _8_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
// import java.util.*;

@Component
class TopBean {
    Dependency_1 dependency_1;
    Dependency_2 dependency_2;

    @Autowired
    public void setDependency1(Dependency_1 dependency_1){
        this.dependency_1 = dependency_1;
    }
    @Autowired
    public void setDependency2(Dependency_2 dependency_2){
        this.dependency_2 = dependency_2;
    }

    public String toString() {
        return "Setter Beans used are " + dependency_1 + " && " + dependency_2;
    }
}

@Component
class Dependency_1 {
}

@Component
class Dependency_2 {
}

@Configuration
@ComponentScan
public class _1_Application_Setter_injection {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(_1_Application_Setter_injection.class);
        System.out.println("===================================");
        System.out.println(context.getBean(TopBean.class));
        System.out.println("===================================");
        context.close();
    }

}
