/* Generated by AN DISI Unibo */ 
package it.unibo.ctxmapqak22
import it.unibo.kactor.QakContext
import it.unibo.kactor.sysUtil
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
	QakContext.createContexts(
	        "localhost", this, "mapqak22.pl", "sysRules.pl","ctxmapqak22"
	)
}

