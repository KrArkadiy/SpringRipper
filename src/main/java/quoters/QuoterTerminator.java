package quoters;

import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
@Profiling
public class QuoterTerminator implements quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public QuoterTerminator(){
        System.out.println("Phase 1");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
