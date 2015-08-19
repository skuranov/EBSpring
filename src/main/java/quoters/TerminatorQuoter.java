package main.java.quoters;

import javax.annotation.PostConstruct;

/**
 * Created by zivert on 14.08.2015.
 */
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min  = 2, max = 7)
    private int repeat;
    private String message;

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
    }

    public TerminatorQuoter(){
        System.out.println("Phase 1");
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3" );
        for (int i = 0; i < repeat; i++){
            System.out.println("message = " + message);
        }
    }
}
