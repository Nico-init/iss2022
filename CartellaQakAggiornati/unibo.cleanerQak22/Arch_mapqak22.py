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
with Diagram('mapqak22Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
     with Cluster('ctxbasicrobot', graph_attr=nodeattr):
          basicrobot=Custom('basicrobot(ext)','./qakicons/externalQActor.png')
     with Cluster('ctxmapqak22', graph_attr=nodeattr):
          mapqak22=Custom('mapqak22','./qakicons/symActorSmall.png')
     mapqak22 >> Edge(color='magenta', style='solid', xlabel='step', fontcolor='magenta') >> basicrobot
     mapqak22 >> Edge(color='blue', style='solid', xlabel='cmd', fontcolor='blue') >> basicrobot
diag
