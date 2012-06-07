package org.w3.banana.sesame

import org.w3.banana._

class SesameDieselGraphConstructTest extends DieselGraphConstructTest[Sesame](SesameOperations, SesameDiesel, SesameGraphIsomorphism)

class SesameDieselGraphExplorationTest extends DieselGraphExplorationTest[Sesame](SesameOperations, SesameDiesel, SesameGraphIsomorphism)
