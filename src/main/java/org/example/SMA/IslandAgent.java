package org.example.SMA;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import org.example.Qlearning;

public class IslandAgent extends Agent {
    Qlearning qlearning;

@Override
    protected void setup() {
        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();
            sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
                @Override
                public void action() {
                          qlearning =new Qlearning();
                          qlearning.runQlearning();
                }
            });

            sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
                @Override
                public void action() {
                    DFAgentDescription dfAgentDescription = new DFAgentDescription();
                    ServiceDescription serviceDescription = new ServiceDescription();
                    serviceDescription.setType("ga");
                    dfAgentDescription.addServices(serviceDescription);
                    DFAgentDescription[] dfAgentDescriptions;
                    try {
                        dfAgentDescriptions = DFService.search(getAgent(),dfAgentDescription);
                    } catch (FIPAException e) {
                        throw new RuntimeException(e);
                    }
                    ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
                    aclMessage.addReceiver(dfAgentDescriptions[0].getName());
                    aclMessage.setContent(qlearning.getIoptimalWayListe().toString());
                    send(aclMessage);
                }
            });
        addBehaviour(sequentialBehaviour);
    }

}
