package main.java.quoters;

/**
 * Created by zivert on 15.08.2015.
 */
public class ProfilingController implements ProfilingControllerMBean {
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean enabled=true;

}
