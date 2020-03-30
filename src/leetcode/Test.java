package leetcode;
import java.util.*;
import java.util.Collection;
//https://www.qualified.io/assess/5d8382f2b2cb9a0010d9d966/challenges/5d8398ea19ba5300194cd980
public class Test {
    public static void main(String[] args) {
        SimpleTcpFiniteStateMachine o=new SimpleTcpFiniteStateMachine();
        String est=o.traverseTcpStates(Arrays.asList("APP_PASSIVE_OPEN", "APP_SEND", "RCV_SYN_ACK"));
        String synsent=o.traverseTcpStates(Arrays.asList("APP_ACTIVE_OPEN"));
        String err=o.traverseTcpStates(Arrays.asList("APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_FIN_ACK", "RCV_ACK"));

    }
}

//import java.util.Collections;

 class SimpleTcpFiniteStateMachine {
    public String traverseTcpStates(Collection<String> actions) {
        String state = "CLOSED";
        Map<StateEvent, String> map=new HashMap<>();
        map.put(new StateEvent("CLOSED", "APP_PASSIVE_OPEN"), "LISTEN");
        map.put(new StateEvent("LISTEN", "RCV_SYN"), "SYN_RCVD");
        map.put(new StateEvent("LISTEN", "APP_SEND"), "SYN_SENT");
        map.put(new StateEvent("LISTEN", "APP_CLOSE"), "CLOSED");
        map.put(new StateEvent("SYN_RCVD", "APP_CLOSE"), "FIN_WAIT_1");
        map.put(new StateEvent("SYN_RCVD", "RCV_ACK"), "ESTABLISHED");
        map.put(new StateEvent("SYN_SENT", "RCV_SYN"), "SYN_RCVD");
        map.put(new StateEvent("SYN_SENT", "RCV_SYN_ACK"), "ESTABLISHED");
        map.put(new StateEvent("SYN_SENT", "APP_CLOSE"), "CLOSED");
        map.put(new StateEvent("ESTABLISHED", "APP_CLOSE"), "FIN_WAIT_1");
        map.put(new StateEvent("ESTABLISHED", "RCV_FIN"), "CLOSE_WAIT");
        map.put(new StateEvent("FIN_WAIT_1", "RCV_FIN"), "CLOSING");
        map.put(new StateEvent("FIN_WAIT_1", "RCV_FIN_ACK"), "TIME_WAIT");
        map.put(new StateEvent("FIN_WAIT_1", "RCV_ACK"), "FIN_WAIT_2");
        map.put(new StateEvent("CLOSING", "RCV_ACK"), "TIME_WAIT");
        map.put(new StateEvent("FIN_WAIT_2", "RCV_FIN"), "TIME_WAIT");
        map.put(new StateEvent("TIME_WAIT", "APP_TIMEOUT"), "CLOSED");
        map.put(new StateEvent("CLOSE_WAIT", "APP_CLOSE"), "LAST_ACK");
        map.put(new StateEvent("LAST_ACK", "RCV_ACK"), "CLOSED");
        StringBuilder oldState=new StringBuilder("CLOSED");
        StringBuilder newState=new StringBuilder("");
        Iterator<String> itr=actions.iterator();
        while(itr.hasNext()){
            StateEvent se=new StateEvent(oldState.toString(), itr.next());
            if(map.containsKey(se)){
                newState=new StringBuilder(map.get(se));
                oldState=newState;
            }
            else
                return "ERROR";
        }
        return newState.toString();
    }

    class StateEvent{
        String state;
        String event;
        public StateEvent(){}
        public StateEvent(String state, String event){
            this.state=state;
            this.event=event;
        }
        @Override
        public boolean equals(Object o){
            StateEvent se= (StateEvent) o;
            return se.state.equals(this.state) && se.event.equals(this.event);
        }

        @Override
        public int hashCode(){
            return (this.state+this.event).hashCode();
        }
    }
}
