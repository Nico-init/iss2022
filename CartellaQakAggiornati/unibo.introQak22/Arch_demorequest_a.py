from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
with Diagram('demorequest_aArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
     with Cluster('ctxcallers', graph_attr=nodeattr):
          callerqa1=Custom('callerqa1','./qakicons/symActorSmall.png')
          callerqa2=Custom('callerqa2','./qakicons/symActorSmall.png')
     with Cluster('ctxcalled', graph_attr=nodeattr):
          qacalled=Custom('qacalled','./qakicons/symActorSmall.png')
     callerqa1 >> Edge(color='magenta', style='solid', xlabel='r1', fontcolor='magenta') >> qacalled
     callerqa2 >> Edge(color='magenta', style='solid', xlabel='r1', fontcolor='magenta') >> qacalled
diag
