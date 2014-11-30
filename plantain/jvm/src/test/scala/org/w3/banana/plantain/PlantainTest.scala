package org.w3.banana.plantain

import org.w3.banana._
import org.w3.banana.io.{NTriplesTestSuite, TurtleTestSuite}
import org.w3.banana.isomorphism._
import scala.util.Try
import org.w3.banana.util.tryInstances._

class PlantainTurtleTest extends TurtleTestSuite[Plantain, Try]

class PlantainNTripleTestSuite extends NTriplesTestSuite[Plantain]

class PlantainPointedGraphTest extends PointedGraphTester[Plantain]

import org.w3.banana.diesel._

class PlantainDieselGraphConstructTest extends DieselGraphConstructTest[Plantain]

class PlantainDieselGraphExplorationTest extends DieselGraphExplorationTest[Plantain]

import org.w3.banana.binder._

class PlantainCommonBindersTest extends CommonBindersTest[Plantain]

class PlantainRecordBinderTest extends RecordBinderTest[Plantain]

import org.w3.banana.syntax._

class PlantainUriSyntaxTest extends UriSyntaxTest[Plantain]

class PlantainSimpleClassifyTest() extends SimpleClassifyTest[Plantain](
  new SimpleMappingGenerator[Plantain](_))

class PlantainIsoGraphTest extends GraphIsomorphismTest[Plantain](
  (vtg: () => VerticeCBuilder[Plantain]) =>
  new GraphIsomorphism[Plantain](new SimpleMappingGenerator[Plantain](vtg))
)


// New shared tests

object PlantainGraphTest extends GraphTest[Plantain]

object PlantainMGraphTest extends MGraphTest[Plantain]

object PlantainGraphUnionTest extends GraphUnionTest[Plantain]

object PlantainIsomorphismsTest extends IsomorphismTest[Plantain]
