package aandi.`3week`

import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import org.xml.sax.InputSource
import org.w3c.dom.Document
import org.w3c.dom.Node

sealed class XmlAstNode {
    data class Element(
        val name: String,
        val attributes: Map<String, String> = emptyMap(),
        val children: List<XmlAstNode> = emptyList()
    ) : XmlAstNode()

    data class Text(val content: String) : XmlAstNode()
}


fun parseXml(xml: String): Document {
    val factory = DocumentBuilderFactory.newInstance()
    val builder = factory.newDocumentBuilder()
    return builder.parse(InputSource(StringReader(xml)))
}

fun toAst(node: Node): XmlAstNode? {
    return when (node.nodeType) {
        Node.ELEMENT_NODE -> {
            val attrMap = mutableMapOf<String, String>()
            val attributes = node.attributes
            for (i in 0 until attributes.length) {
                val attr = attributes.item(i)
                attrMap[attr.nodeName] = attr.nodeValue
            }

            val children = mutableListOf<XmlAstNode>()
            val nodeList = node.childNodes
            for (i in 0 until nodeList.length) {
                val childNode = toAst(nodeList.item(i))
                if (childNode != null) children.add(childNode)
            }

            XmlAstNode.Element(node.nodeName, attrMap, children)
        }

        Node.TEXT_NODE -> {
            val text = node.textContent.trim()
            if (text.isNotEmpty()) XmlAstNode.Text(text) else null
        }

        else -> null
    }
}


fun astToJson(ast: XmlAstNode): String {
    return when (ast) {
        is XmlAstNode.Text -> "\"${ast.content}\""

        is XmlAstNode.Element -> {
            val content = mutableMapOf<String, Any>()

            // attributes
            for ((k, v) in ast.attributes) {
                content[k] = v
            }

            // group children by name
            val childrenGrouped = ast.children.groupBy {
                if (it is XmlAstNode.Element) it.name else "__text__"
            }

            for ((key, group) in childrenGrouped) {
                if (key == "__text__") {
                    content["text"] = (group.first() as XmlAstNode.Text).content
                } else {
                    val jsonValues = group.map { astToJson(it) }
                    content[key] = if (jsonValues.size == 1) {
                        jsonValues.first()
                    } else {
                        "[${jsonValues.joinToString(",")}]"
                    }
                }
            }

            val contentStr = content.entries.joinToString(",") {
                "\"${it.key}\":${if (it.value is String && !(it.value as String).startsWith("{") && !(it.value as String).startsWith("[")) "\"${it.value}\"" else it.value}"
            }

            "{ \"${
                ast.name
            }\": { $contentStr } }"
        }
    }
}


fun main() {
    val xml = """
        <order id="1023" date="2025-04-05">
            <customer name="Jisoo" email="jisoo@example.com"/>
            <items>
                <item id="A12" name="Keyboard" quantity="1" price="45.99"/>
                <item id="B34" name="Mouse" quantity="2" price="19.99"/>
            </items>
            <shipping method="Express">
                <address city="Seoul" zip="04524" country="South Korea"/>
            </shipping>
            <status>Shipped</status>
        </order>
    """.trimIndent()

    val doc = parseXml(xml)
    val ast = toAst(doc.documentElement)!!
    val json = astToJson(ast)
    println(json)
}

