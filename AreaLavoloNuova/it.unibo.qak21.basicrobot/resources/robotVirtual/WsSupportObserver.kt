package robotVirtual
 
import kotlinx.coroutines.CoroutineScope
import org.json.JSONObject
//import it.unibo.supports.*
import it.unibo.kactor.*
import it.unibo.kactor.MsgUtil
import unibo.actor22comm.ws.WsConnSysObserver
import unibo.actor22comm.utils.ColorsOut
import unibo.actor22comm.SystemData
import unibo.actor22.Qak22Util
import kotlinx.coroutines.runBlocking
 
 
/*
  Oggetto che informa l'owner in caso di collisione
*/ 
class WsSupportObserver( val owner:String) : WsConnSysObserver( owner) {
 var stepok = MsgUtil.buildDispatch("wsobs","stepok","stepok(done)",owner )
 var stepko = MsgUtil.buildDispatch("wsobs","stepko","stepko(todo)",owner )

	
	override fun update( data : String ) {
 		ColorsOut.out("WsConnSysObserver update receives:$data $actionDuration", ColorsOut.BLUE);
        val msgJson = JSONObject(data)
        //println("       &&& WsSupportObserver  | update msgJson=$msgJson" ) //${ aboutThreads()}
		val ownerActor = sysUtil.getActor(owner)
		if( ownerActor == null ) {
			val ev = Qak22Util.buildEvent( "wsconn", SystemData.wsEventId, data  );
            println("       &&& WsSupportObserver  | ownerActor null ev=$ev" ) 
		}
		if( msgJson.has("collision")){
				runBlocking {
					ownerActor!!.emit("obstacle","obstacle(virtual)")
				}
		}
		/*		
 		if( msgJson.has("endmove") && msgJson.getBoolean("endmove") ) {
			if( msgJson.getString("move").equals("moveForward") ){
				println("WsSupportObserver update send $stepok")
				runBlocking {
					ownerActor.autoMsg(stepok)
				}
				//ownerActor.autoMsg(stepok)
			}else{
				//println("WsSupportObserver TODO ${msgJson.getBoolean("endmove") }" )
				
			}
		}
		*/

	}
	

}