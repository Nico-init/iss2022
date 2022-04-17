package unibo.actor22.common;

import it.unibo.kactor.IApplMessage;
import it.unibo.kactor.MsgUtil;
import it.unibo.radarSystem22.domain.DeviceFactory;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import unibo.actor22.QakActor22;
import unibo.actor22comm.utils.ColorsOut;
import unibo.actor22comm.utils.CommUtils;

public class SonarActorMy extends QakActor22 {
	private ISonar sonar;
	
	public SonarActorMy(String name) {
		super(name);
		sonar = DeviceFactory.createSonar();
	}

	@Override
	protected void handleMsg(IApplMessage msg) {
		CommUtils.aboutThreads(getName()  + " |  Before doJob - ");
		ColorsOut.out( getName()  + " | doJob " + msg, ColorsOut.CYAN);
		if( msg.isRequest() ) elabRequest(msg);
		else elabCmd(msg);

	}

	protected void elabRequest(IApplMessage msg) {
		String msgCmd = msg.msgContent();
 		switch( msgCmd ) {
			case ApplData.cmdActivate  : sonar.activate();break;
			case ApplData.cmdDectivate : sonar.deactivate();break;
			default: ColorsOut.outerr(getName()  + " | unknown " + msgCmd);		
 		}
	}

	protected void elabCmd(IApplMessage msg) {
		String msgReq = msg.msgContent();
		
		switch(msgReq) {
			case ApplData.reqDistance:{
				int dist = sonar.getDistance().getVal();
				IApplMessage reply = MsgUtil.buildReply(getName(), ApplData.reqDistance, ""+dist, msg.msgSender());
				ColorsOut.out( getName()  + " | reply= " + reply, ColorsOut.CYAN);
 				sendReply(msg, reply );				
				break;
			}
			case "isActive":{
				boolean state = sonar.isActive();
				IApplMessage reply = MsgUtil.buildReply(getName(), "sonarState", ""+state, msg.msgSender());
				ColorsOut.out( getName()  + " | reply= " + reply, ColorsOut.CYAN);
 				sendReply(msg, reply );				
				break;
			}
			default: ColorsOut.outerr(getName()  + " | unknown " + msgReq);
		}

	}
}
