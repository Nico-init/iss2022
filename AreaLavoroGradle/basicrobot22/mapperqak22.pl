%====================================================================================
% mapperqak22 description   
%====================================================================================
context(ctxqak22, "127.0.0.1",  "TCP", "8020").
context(ctxbasicqak22, "localhost",  "TCP", "8021").
 qactor( basicqak, ctxbasicqak22, "external").
  qactor( mapperqak22, ctxbasicqak22, "it.unibo.mapperqak22.Mapperqak22").
