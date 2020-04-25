package me.youngmin.parser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ParseSAX extends DefaultHandler {
    public HashMap<String, Integer> elementMap =
            new HashMap<String, Integer>();
    private StringBuffer returnData = new StringBuffer();

    public ParseSAX(){
    }

    public void startDocument(){
        returnData.append("### Start Document !!!<BR>");
    }

    public void endDocument() {
        returnData.append("### End Document !!!<BR>");
        setNodeCountData();
    }
    public void startElement(String uri, String local, String nodeName, Attributes attrs) throws SAXException {
        addNode(nodeName);
    }

    public void addNode(String nodeName) {
        if(!elementMap.containsKey(nodeName)) {
            elementMap.put(nodeName,1);
        } else {
            elementMap.put(nodeName, elementMap.get(nodeName) + 1);
        }
    }

    public void setNodeCountData() {
        Set<String> keySet = elementMap.keySet();
        Object[] keyArray = keySet.toArray();
        Arrays.sort(keyArray);
        for (Object tempKey : keyArray) {
            returnData.append("Element=").append(tempKey).append(" Count=")
                    .append(elementMap.get(tempKey.toString())).append("<BR>");
        }
    }

    public String getData() {
        return returnData.toString();
    }

    public void print(String data) {
        returnData.append(data).append("<BR>");
    }
}
