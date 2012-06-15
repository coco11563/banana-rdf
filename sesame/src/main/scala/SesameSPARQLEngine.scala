package org.w3.banana.sesame

import org.w3.banana._

import org.openrdf.model.{ Graph => SesameGraph, BNode => SesameBNode }
import org.openrdf.repository._
import SesameUtil.{ withConnection, toIterable, toPartialFunction }
import org.openrdf.query.QueryLanguage

trait SesameSPARQLEngine extends SPARQLEngine[Sesame, SesameSPARQL] {

  def store: Repository
  
  val TODO = "http://w3.org/TODO#"

  def executeSelect(query: SesameSPARQL#SelectQuery): Iterable[PartialFunction[String, Sesame#Node]] = withConnection(store) { conn =>
    val tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, query, TODO)
    toIterable(tupleQuery.evaluate()) map toPartialFunction
  }

  def executeConstruct(query: SesameSPARQL#ConstructQuery): SesameGraph = withConnection(store) { conn =>
    val graphQuery = conn.prepareGraphQuery(QueryLanguage.SPARQL, query, TODO)
    val triples = toIterable(graphQuery.evaluate())
    SesameOperations.Graph(triples)
  }
  
  def executeAsk(query: SesameSPARQL#AskQuery): Boolean =  withConnection(store) { conn =>
    val booleanQuery = conn.prepareBooleanQuery(QueryLanguage.SPARQL, query, TODO)
    booleanQuery.evaluate()
  }

}
