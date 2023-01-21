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
with Diagram('streamsdemoArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
     with Cluster('ctxstreamsdemo', graph_attr=nodeattr):
          qasink=Custom('qasink','./qakicons/symActorSmall.png')
          sonarsimulator=Custom('sonarsimulator(coded)','./qakicons/codedQActor.png')
          datalogger=Custom('datalogger(coded)','./qakicons/codedQActor.png')
          datacleaner=Custom('datacleaner(coded)','./qakicons/codedQActor.png')
          distancefilter=Custom('distancefilter(coded)','./qakicons/codedQActor.png')
     qasink >> Edge(color='blue', style='solid', xlabel='start', fontcolor='blue') >> sonarsimulator
     sys >> Edge(color='red', style='dashed', xlabel='sonarRobot', fontcolor='red') >> qasink
     sys >> Edge(color='red', style='dashed', xlabel='obstacle', fontcolor='red') >> qasink
diag
