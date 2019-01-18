
package com.interstellar.transport.system.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getShortestPathResponse", namespace = "http://soap.system.transport.interstellar.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getShortestPathResponse", namespace = "http://soap.system.transport.interstellar.com/")
public class GetShortestPathResponse {

    @XmlElement(name = "return", namespace = "")
    private com.interstellar.transport.system.model.ShortestPath _return;

    /**
     * 
     * @return
     *     returns ShortestPath
     */
    public com.interstellar.transport.system.model.ShortestPath getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.interstellar.transport.system.model.ShortestPath _return) {
        this._return = _return;
    }

}
