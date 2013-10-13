package jobs;

import play.jobs.*;
import models.StatefulModel;

@OnApplicationStart(async = true)
public class Startup extends Job {
    public void doJob() throws InterruptedException {
        int i = 0;

        while (true) {
            i++;
            Thread.sleep(100);
            StatefulModel.instance.event.publish(""+Math.round(Math.random()*10));
        }
    }
}