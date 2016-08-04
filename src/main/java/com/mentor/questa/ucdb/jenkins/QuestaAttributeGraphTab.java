/*
 * The MIT License
 *
 * Copyright 2016 JenkinsQuestaVrmPlugin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mentor.questa.ucdb.jenkins;


import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;

/**
 *
 * 
 */
public class QuestaAttributeGraphTab {
    private String graphName;
    private String yLabel;
    private List<String> attributes;
    
    public QuestaAttributeGraphTab(String graphName, String attribute) {
        this.graphName = graphName;
        setAttributesString(attribute);
        
    }
    
    public QuestaAttributeGraphTab(String graphName, JSONArray array) {
        this.graphName = graphName;
        this.attributes = new LinkedList<String>();
        for (int i=0; i< array.size(); i++){
            this.attributes.add(array.getString(i));
        }
        
    }
        
    public QuestaAttributeGraphTab(String graphName, String yLabel,String attribute) {
        this.graphName = graphName;
        this.yLabel = yLabel;
        setAttributesString(attribute);
    }

   
   public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }
    
    public String getSafeName(){
         return graphName.replace(' ', '_').replace('/', '_').replace('\\', '_').replace(':', '_').replace('?', '_').replace('#', '_').replace('%', '_');
    }
    
    
    private void setAttributesString(String attribute) {
        StringTokenizer st = new StringTokenizer(attribute);
        this.attributes = new LinkedList<String>();
        while(st.hasMoreTokens()){
            this.attributes.add(st.nextToken());
        }
        
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public String getGraphName() {
        return graphName;
    }

    public String getyLabel() {
        return yLabel;
    }

    public boolean hasAttr(String attr){
        return attributes.contains(attr);
                
    }
     public String getAttributesValue() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(attributes.get(0));
        for(String s: attributes.subList(1, attributes.size())){
            sb.append(",");
            sb.append(s);
           
        }
        sb.append("]");
        return sb.toString();
    }
    
    public String getAttributesString() {
        StringBuilder sb = new StringBuilder();
        for(String s: attributes){
            sb.append(s);
             sb.append(" ");
        }
        return sb.toString().trim();
    }
}
