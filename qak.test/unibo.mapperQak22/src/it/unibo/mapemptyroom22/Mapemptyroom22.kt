/* Generated by AN DISI Unibo */ 
package it.unibo.mapemptyroom22

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Mapemptyroom22 ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		 var StepTime = 345
			   var NumStep   = 0 
			   val MapName   = "mapEmpty2019"
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						println("mapperbuilder starts")
						unibo.kotlin.planner22Util.initAI(  )
						unibo.kotlin.planner22Util.showMap(  )
					}
					 transition( edgeName="goto",targetState="doAheadMove", cond=doswitch() )
				}	 
				state("doAheadMove") { //this:State
					action { //it:State
						request("step", "step($StepTime)" ,"basicrobot" )  
					}
					 transition(edgeName="t00",targetState="continue",cond=whenReply("stepdone"))
					transition(edgeName="t01",targetState="turn",cond=whenReply("stepfail"))
				}	 
				state("continue") { //this:State
					action { //it:State
						 unibo.kotlin.planner22Util.updateMap(  "w", "" )  
					}
					 transition( edgeName="goto",targetState="doAheadMove", cond=doswitch() )
				}	 
				state("turn") { //this:State
					action { //it:State
						 NumStep = NumStep + 1  
						forward("cmd", "cmd(l)" ,"basicrobot" ) 
						  unibo.kotlin.planner22Util.updateMap(  "l", "" ) 
									unibo.kotlin.planner22Util.showMap()		 
					}
					 transition( edgeName="goto",targetState="doAheadMove", cond=doswitchGuarded({ NumStep < 4  
					}) )
					transition( edgeName="goto",targetState="endwork", cond=doswitchGuarded({! ( NumStep < 4  
					) }) )
				}	 
				state("endwork") { //this:State
					action { //it:State
						 	unibo.kotlin.planner22Util.showMap();
						 			unibo.kotlin.planner22Util.saveRoomMap("$MapName");
						println("mapperbuilder BYE")
						terminate(1)
					}
				}	 
			}
		}
}
