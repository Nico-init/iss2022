%====================================================================================
% mymapperqak22 description   
%====================================================================================
context(ctxmapperqak22, "localhost",  "TCP", "8019").
context(ctxbasicrobot, "127.0.0.1",  "TCP", "8020").
 qactor( basicrobot, ctxbasicrobot, "external").
