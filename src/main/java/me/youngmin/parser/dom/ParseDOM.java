package me.youngmin.parser.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ParseDOM {
    HashMap<String, Integer> elementMap = new HashMap<String, Integer>();
    private StringBuffer returnData = new StringBuffer();
    public void parseDOM(String XMLName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(XMLName);
            Node rootNode = document.getChildNodes().item(0);
            addNode(rootNode.getNodeName());
            readNodes(rootNode);
            setNodeCountData();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void readNodes(Node node) {
        NodeList childs = node.getChildNodes();
        int childCount = childs.getLength();
        for(int loop=0; loop < childCount; loop++){
            Node tempNode = childs.item(loop);
            if(tempNode.hasChildNodes()) {
                readNodes(tempNode);
            }
            String nodeName = tempNode.getNodeName();
            if(!nodeName.equals("#comment") && !nodeName.equals("#test")) {
                addNode(nodeName);
            }
        }
    }

    public void addNode(String nodeName) {
        if(!elementMap.containsKey(nodeName)) {
            elementMap.put(nodeName, 1);
        } else {
            elementMap.put(nodeName, elementMap.get(nodeName)+1);
        }
    }

    public void setNodeCountData() {
        Set keySet = elementMap.keySet();
        Object[] keyArray = keySet.toArray();
        Arrays.sort(keyArray);
        for(Object tempkey : keyArray) {
            returnData.append("Element=")
                    .append(tempkey)
                    .append(" Count=")
                    .append(elementMap.get(tempkey.toString()))
                    .append("<BR>");
        }
    }

    public String getData() {
        return returnData.toString();
    }
}
