%====================================================================================
% basicrobot description   
%====================================================================================
context(ctxbasicrobot, "localhost",  "TCP", "8020").
context(ctxconsolemock, "127.0.0.1",  "TCP", "8021").
 qactor( basicrobot, ctxbasicrobot, "it.unibo.basicrobot.Basicrobot").
  qactor( consolemock, ctxconsolemock, "it.unibo.consolemock.Consolemock").
