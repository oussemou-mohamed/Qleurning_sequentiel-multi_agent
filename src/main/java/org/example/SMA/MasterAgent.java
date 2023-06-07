package org.example.SMA;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

public class MasterAgent extends Agent {
    @Override
    protected void setup() {
        DFAgentDescription dfAgentDescription  = new DFAgentDescription();
        dfAgentDescription.setName((getAID()));
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setName("master");
        serviceDescription.setType("ga");
        dfAgentDescription.addServices(serviceDescription);
        try {
            DFService.register(this,dfAgentDescription);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
         addBehaviour(new CyclicBehaviour() {
             @Override
             public void action() {
                 ACLMessage receive = receive();
                 if (receive!=null)
                 {
                     System.out.println("****************** Optimal way ******************");
                     System.out.println(receive.getSender().getName());
                     String content = receive.getContent();
                     System.out.println(content);
                 }
                 else {
                     block();
                 }
             }
         });
    }
    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {

        }
    }
}
