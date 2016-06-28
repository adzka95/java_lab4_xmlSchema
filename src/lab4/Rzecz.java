//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.07 at 08:20:16 PM CEST 
//


package lab4;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rzecz complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rzecz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="nazwaPr" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cejaPr" use="required" type="{http://www.eti.pg.gda.pl/kask/pt/catalog}cena2" />
 *       &lt;attribute name="walutaPr" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rzecz")
public class Rzecz {

    @XmlAttribute(name = "nazwaPr", required = true)
    protected String nazwaPr;
    @XmlAttribute(name = "cenaPr", required = true)
    protected BigDecimal cenaPr;
    @XmlAttribute(name = "walutaPr", required = true)
    protected String walutaPr;

    
    public Rzecz(){}
    public Rzecz(String nazwa, BigDecimal cena, String waluta){
        nazwaPr=nazwa;
        cenaPr=cena;
        walutaPr=waluta;
    
    }
    
    /**
     * Gets the value of the nazwaPr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazwaPr() {
        return nazwaPr;
    }

    /**
     * Sets the value of the nazwaPr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazwaPr(String value) {
        this.nazwaPr = value;
    }

    /**
     * Gets the value of the cejaPr property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCenaPr() {
        return cenaPr;
    }

    /**
     * Sets the value of the cejaPr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCenaPr(BigDecimal value) {
        this.cenaPr = value;
    }

    /**
     * Gets the value of the walutaPr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWalutaPr() {
        return walutaPr;
    }

    /**
     * Sets the value of the walutaPr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWalutaPr(String value) {
        this.walutaPr = value;
    }

    
}
