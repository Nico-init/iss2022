/* Generated by AN DISI Unibo */ 
package it.unibo.ctxdemocodedqactor
import it.unibo.kactor.QakContext
import it.unibo.kactor.sysUtil
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
	QakContext.createContexts(
	        "localhost", this, "democodedqactor.pl", "sysRules.pl","ctxdemocodedqactor"
	)
}
