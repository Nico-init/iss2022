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
with Diagram('democodedqactorArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
     with Cluster('ctxdemocodedqactor', graph_attr=nodeattr):
          datahandler=Custom('datahandler','./qakicons/symActorSmall.png')
          sonargen=Custom('sonargen(coded)','./qakicons/codedQActor.png')
     datahandler >> Edge(color='blue', style='solid', xlabel='start', fontcolor='blue') >> sonargen
     sys >> Edge(color='red', style='dashed', xlabel='sonarrobot', fontcolor='red') >> datahandler
diag
